package com.example.farmease

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import android.widget.ImageView

class HomeActivity : AppCompatActivity() {
    lateinit var imgConnect : ImageView
    lateinit var imgLearn : ImageView
    lateinit var imgStats : ImageView
    lateinit var imgTrack : ImageView
    lateinit var imgProduce : ImageView
    lateinit var imgCalc : ImageView
    lateinit var gridLayout: GridLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        imgConnect = findViewById(R.id.mCardConnect)
        imgLearn = findViewById(R.id.mCardLearn)
        imgStats = findViewById(R.id.mCardStat)
        imgTrack = findViewById(R.id.mCardTruck)
        imgProduce = findViewById(R.id.mCardProduce)
        imgCalc = findViewById(R.id.mCardCalc)
        gridLayout = findViewById(R.id.mGridLayout)

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
        imgProduce.setOnClickListener {
            val intent = Intent(this, ProduceActivity::class.java)
            startActivity(intent)
        }
        imgCalc.setOnClickListener {
            val intent = Intent(this, CalculateActivity::class.java)
            startActivity(intent)
        }
    }
}
