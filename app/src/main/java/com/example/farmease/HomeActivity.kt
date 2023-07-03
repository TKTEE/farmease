package com.example.farmease

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class HomeActivity : AppCompatActivity() {
    lateinit var cardConnect : ImageView
    lateinit var cardLearn : ImageView
    lateinit var cardStats : ImageView
    lateinit var cardTrack : ImageView
    lateinit var cardProduce : ImageView
    lateinit var cardCalc : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        cardConnect = findViewById(R.id.mCardConnect)
        cardLearn = findViewById(R.id.mCardLearn)
        cardStats = findViewById(R.id.mCardStat)
        cardTrack = findViewById(R.id.mCardTruck)
        cardProduce = findViewById(R.id.mCardProduce)
        cardCalc = findViewById(R.id.mCardCalc)

        cardConnect.setOnClickListener {
            val intent = Intent(this, ConnectActivity::class.java)
            startActivity(intent)
        }
        cardLearn.setOnClickListener {
            val intent = Intent(this, LearnActivity::class.java)
            startActivity(intent)
        }
        cardStats.setOnClickListener {
            val intent = Intent(this, StatsActivity::class.java)
            startActivity(intent)
        }
        cardTrack.setOnClickListener {
            val intent = Intent(this, TrackActivity::class.java)
            startActivity(intent)
        }
        cardProduce.setOnClickListener {
            val intent = Intent(this, ProduceActivity::class.java)
            startActivity(intent)
        }
        cardCalc.setOnClickListener {
            val intent = Intent(this, CalculateActivity::class.java)
            startActivity(intent)
        }
    }
}
