package com.example.farmease

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.farmease.databinding.ActivityLearnBinding

class LearnActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLearnBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var learnList: ArrayList<Learn>
    private lateinit var myAdapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_learn)
        initUi()
        recyclerView = findViewById(R.id.mRecyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        learnList = ArrayList()

        learnList.add(Learn(R.drawable.ic_farm1 , "Precision farming"))
        learnList.add(Learn(R.drawable.ic_farm2 , "Vertical farming"))
        learnList.add(Learn(R.drawable.ic_farm3 ,  "CEA"))
        learnList.add(Learn(R.drawable.ic_farm1 , "Aquaponics"))
        learnList.add(Learn(R.drawable.ic_farm2 ,  "Hydroponics"))
        learnList.add(Learn(R.drawable.ic_farm3 ,  "Precision farming"))

        myAdapter = MyAdapter(learnList)
        recyclerView.adapter = myAdapter

        myAdapter.onItemClick = {
            val intent = Intent(this, DetailedActivity::class.java)
            intent.putExtra("learn", it)
            startActivity(intent)
        }
    }

    private fun initUi(){
        binding.mCustomToolBar.mBackArrow.setOnClickListener{
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.mCustomToolBar.mTvC.text = "Learn"
    }
}
