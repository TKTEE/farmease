package com.example.farmease

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.farmease.databinding.ActivityConnectBinding

class ProduceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConnectBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produce)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_produce)
        initUi()
    }
    private fun initUi(){
        binding.mCustomToolBar.mBackArrow.setOnClickListener{
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.mCustomToolBar.mTvC.text = "Agroproducts"

    }
}