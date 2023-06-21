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

class RegisterActivity : AppCompatActivity() {
    lateinit var tvUser: TextView
    lateinit var edtName: EditText
    lateinit var edtEmail: EditText
    lateinit var edtPhone: EditText
    lateinit var edtPassword: EditText
    lateinit var edtConfirm: EditText
    lateinit var btnReg: Button
    lateinit var tvLogin: TextView
    lateinit var progress: ProgressDialog
    lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        tvUser = findViewById(R.id.mTvLog)
        edtName = findViewById(R.id.mEdtName)
        edtEmail = findViewById(R.id.mEdtEmail)
        edtPassword = findViewById(R.id.mEdtPassword)
        edtConfirm = findViewById(R.id.mEdtConfirm)
        btnReg = findViewById(R.id.mBtnLog)
        tvLogin = findViewById(R.id.mTvLogin)

        btnReg.setOnClickListener {
            var name = edtName.text.toString().trim()
            var phone = edtPhone.text.toString().trim()
            var email = edtEmail.text.toString().trim()
            var password = edtPassword.text.toString().trim()

            if(email.isEmpty()){
                edtEmail.setError("Please fill this input")
                edtEmail.requestFocus()
            }else if(password.isEmpty()){
                edtPassword.setError("Please fill this input")
                edtPassword.requestFocus()
            }else if(password.length < 6){
                edtPassword.setError("Password is too short")
                edtPassword.requestFocus()
            }else{
                progress.show()
                mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener{
                        progress.dismiss()
                        if(it.isSuccessful){
                            Toast.makeText(this,"Registration successful",
                                Toast.LENGTH_SHORT).show()
                            mAuth.signOut()
                            startActivity(Intent(this, LoginActivity::class.java))
                            finish()
                        }else{
                            displayMessage("ERROR", it.exception!!.message.toString())
                        }
                    }
            }
        }
        tvLogin.setOnClickListener {
          startActivity(Intent(this,LoginActivity::class.java))
        }
    }
    fun displayMessage(title:String, message:String){
        var alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle(title)
        alertDialog.setMessage(message)
        alertDialog.setPositiveButton("Ok", null)
        alertDialog.create().show()
    }
}
