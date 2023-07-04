package com.example.farmease

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.farmease.databinding.ActivityConnectBinding
import com.example.farmease.databinding.ActivityStatsBinding

class StatsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStatsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_stats)
        initUi()
        binding.apply {
            mBtnBar.setOnClickListener {

            }
            mBtnPie.setOnClickListener {

            }
            mBtnDonut.setOnClickListener {

            }
        }

    }

    private fun initUi() {
        binding.mCustomToolBar.mBackArrow.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.mCustomToolBar.mTvC.text = "Statistics"
    }

}
