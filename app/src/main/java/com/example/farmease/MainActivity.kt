package com.example.farmease

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView

class MainActivity : AppCompatActivity() {
    lateinit var tvDisplay: TextView
    lateinit var ltAnimation: LottieAnimationView
    lateinit var btnStart: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       tvDisplay = findViewById(R.id.mTvDisplay)
        btnStart = findViewById(R.id.mBtnStart)
        ltAnimation = findViewById<LottieAnimationView>(R.id.mLottie)
        ltAnimation.setAnimation(R.raw.farm)

        ltAnimation.playAnimation()
        btnStart.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

    }
    override fun onDestroy(){
        super.onDestroy()
        ltAnimation.cancelAnimation()
    }
}