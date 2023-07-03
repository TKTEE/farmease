package com.example.farmease

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.airbnb.lottie.LottieAnimationView

class MainActivity : AppCompatActivity() {
    lateinit var tvDisplay: TextView
    lateinit var ltAnimation: LottieAnimationView
    lateinit var tvRegister: TextView
    lateinit var tvLogin : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       tvDisplay = findViewById(R.id.mTvDisplay)
        tvRegister = findViewById(R.id.mTvRegister)
        tvLogin = findViewById(R.id.mTvLogInm)
        ltAnimation = findViewById<LottieAnimationView>(R.id.mLottie)
        ltAnimation.setAnimation(R.raw.farm)

        ltAnimation.playAnimation()

        tvLogin.setOnClickListener {
            val hasAccount = checkUserHasAccount()
            if (hasAccount) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        tvRegister.setOnClickListener {
            // User clicked on the Register button, navigate to RegisterActivity
            val intent = Intent(this, RegisterActivity::class.java)
            Toast.makeText(this, "Welcome!", Toast.LENGTH_SHORT).show()
            startActivity(intent)
            finish()
        }
    }

    private fun checkUserHasAccount(): Boolean {
        // Implement this method to check if the user has an account
        // You can use shared preferences or any other method to store and retrieve this information
        // Return true if the user has an account, false otherwise
        // Example implementation:
        val hasAccount = // Your logic to check if the user has an account
            return true
    }
    override fun onDestroy(){
        super.onDestroy()
        ltAnimation.cancelAnimation()
    }


    }





