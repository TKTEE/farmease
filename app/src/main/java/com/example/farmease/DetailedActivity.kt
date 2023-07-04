package com.example.farmease

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        val learn = intent.getParcelableExtra<Learn>("learn")
        if (learn !=null){
            val textView : TextView = findViewById(R.id.mTvDetailed)
            val imageView : ImageView = findViewById(R.id.mImageDetailed)

            textView.text = learn.name
            imageView.setImageResource(learn.image)
        }
    }
}