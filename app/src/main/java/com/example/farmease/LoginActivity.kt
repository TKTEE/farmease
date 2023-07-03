package com.example.farmease

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth


class LoginActivity : AppCompatActivity() {
    lateinit var edtEmail: EditText
    lateinit var edtPassword: EditText
    lateinit var tvLogin:TextView
    lateinit var tvForget:TextView
    lateinit var tvReg: TextView
    lateinit var btnLog: Button
    lateinit var btnGoogle: Button
    lateinit var btnFacebook: Button
    lateinit var progress: ProgressDialog
    lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        edtEmail = findViewById(R.id.mEdtEmail)
        edtPassword = findViewById(R.id.mEdtPassword)
        tvLogin = findViewById(R.id.mTvLogin)
        tvForget = findViewById(R.id.mTvForget)
        tvReg = findViewById(R.id.mTvReg)
        btnLog = findViewById(R.id.mBtnLog)
        btnFacebook = findViewById(R.id.mBtnFacebook)
        btnGoogle = findViewById(R.id.mBtnGoogle)

        tvForget.setOnClickListener {

        }
        tvReg.setOnClickListener {

        }
        btnLog.setOnClickListener {
            val email = edtEmail.text.toString().trim()
            val password = edtPassword.text.toString().trim()

            if (email.isEmpty()){
                edtEmail.error = "Please fill this input"
                edtEmail.requestFocus()
            }else if(password.isEmpty()){
                edtPassword.error = "Please fill the input"
                edtPassword.requestFocus()
            }else{
                // Proceed to register  the user
                progress.show()
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    progress.dismiss()
                    if (it.isSuccessful){
                        Toast.makeText(this, "Registration successful",
                            Toast.LENGTH_SHORT).show()
                        mAuth.signOut()
                        startActivity(Intent(this, HomeActivity::class.java))
                        finish()

                    }else{
                        displaymessage(this, "Error", it.exception!!.message.toString())

                    }
                }
            }


        }
        btnFacebook.setOnClickListener {

        }
        btnGoogle.setOnClickListener {

        }
    }
    fun displaymessage(context: Context, title: String, message: String) {
        val alertDialog = AlertDialog.Builder(context)
        alertDialog.setTitle(title)
        alertDialog.setMessage(message)
        alertDialog.setPositiveButton("Ok", null)
        alertDialog.create().show()
    }

}
