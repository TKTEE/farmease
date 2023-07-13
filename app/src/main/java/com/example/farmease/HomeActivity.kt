package com.example.farmease

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.widget.GridLayout
import android.widget.ImageView

class HomeActivity : AppCompatActivity() {
    lateinit var imgConnect : View
    lateinit var imgLearn : View
    lateinit var imgStats : View
    lateinit var imgTrack : View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        imgConnect = findViewById(R.id.mImgConnect)
        imgLearn = findViewById(R.id.mImgLearn)
        imgStats = findViewById(R.id.mImgStat)
        imgTrack = findViewById(R.id.mImgTruck)

        imgConnect.setOnClickListener {
            val intent = Intent(this, ConnectActivity::class.java)
            startActivity(intent)
        }
        imgLearn.setOnClickListener {
            val intent = Intent(this, LearnActivity::class.java)
            startActivity(intent)
        }
        imgStats.setOnClickListener {
            val intent = Intent(this, StatsActivity::class.java)
            startActivity(intent)
        }
        imgTrack.setOnClickListener {
            val intent = Intent(this, TrackActivity::class.java)
            startActivity(intent)
        }

    }
}
