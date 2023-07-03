package com.example.farmease

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase

class RegisterActivity : AppCompatActivity() {
    lateinit var tvUser: TextView
    lateinit var edtName: EditText
    lateinit var edtEmail: EditText
    lateinit var edtPhone: EditText
    lateinit var edtPassword: EditText
    lateinit var edtConfirm: EditText
    lateinit var btnLog: Button
    lateinit var tvLogin: TextView
    lateinit var progress: ProgressDialog
    lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        tvUser = findViewById(R.id.mTvLog)
        edtName = findViewById(R.id.mEdtName)
        edtPhone = findViewById(R.id.mEdtPhone)
        edtEmail = findViewById(R.id.mEdtEmail)
        edtPassword = findViewById(R.id.mEdtPassword)
        edtConfirm = findViewById(R.id.mEdtConfirm)
        btnLog = findViewById(R.id.mBtnLog)
        tvLogin = findViewById(R.id.mTvLogin)
        progress = ProgressDialog(this)
        mAuth = FirebaseAuth.getInstance()
        val database = FirebaseDatabase.getInstance().reference

        btnLog.setOnClickListener {
            val phone = edtPhone.text.toString().trim()
            val email = edtEmail.text.toString().trim()
            val password = edtPassword.text.toString().trim()
            val confirmPassword = edtConfirm.text.toString().trim()
            val mAuth: FirebaseAuth = FirebaseAuth.getInstance()


            if (phone.isEmpty()) {
                edtPhone.setError("Please fill this input")
                edtPhone.requestFocus()
            }

            if (email.isEmpty()) {
                edtEmail.setError("Please fill this input")
                edtEmail.requestFocus()
            } else if (password.isEmpty()) {
                edtPassword.setError("Please fill this input")
                edtPassword.requestFocus()
            } else if (password.length < 6) {
                edtPassword.setError("Password is too short")
                edtPassword.requestFocus()
            } else if (confirmPassword.isEmpty()) {
                edtConfirm.setError("Please fill this input")
                edtConfirm.requestFocus()
            } else if (password != confirmPassword) {
                edtConfirm.setError("Passwords do not match")
                edtConfirm.requestFocus()
            } else {
                progress.show()
                mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        progress.dismiss()
                        if (it.isSuccessful) {
                            val user: FirebaseUser? = mAuth.currentUser
                            val userId: String? = user?.uid

                            // Create a HashMap to store user data
                            val userData = HashMap<String, Any>()
                            userData["name"] = edtName.text.toString()
                            userData["phone"] = edtPhone.text.toString()
                            userData["email"] = email

                            // Store the user data in the Firebase Realtime Database
                            if (userId != null) {
                                database.child("users").child(userId).setValue(userData)
                                    .addOnSuccessListener {
                                        Toast.makeText(
                                            this, "Registration successful",
                                            Toast.LENGTH_SHORT
                                        ).show()

                                        mAuth.signOut()
                                        startActivity(Intent(this, LoginActivity::class.java))
                                        finish()
                                    }
                                    .addOnFailureListener {
                                        displayMessage("ERROR", it.message.toString())
                                    }
                            } else {
                                displayMessage("ERROR", it.exception!!.message.toString())
                            }
                        }
                    }
                val intent = Intent(this, HomeActivity::class.java)
                Toast.makeText(this, "Welcome!", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }
            tvLogin.setOnClickListener {
                val intent = Intent(this, LoginActivity::class.java)
                Toast.makeText(this, "Welcome Back!", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }


        }
    }
        fun displayMessage(title: String, message: String) {
            var alertDialog = AlertDialog.Builder(this)
            alertDialog.setTitle(title)
            alertDialog.setMessage(message)
            alertDialog.setPositiveButton("Ok", null)
            alertDialog.create().show()
        }
    }
