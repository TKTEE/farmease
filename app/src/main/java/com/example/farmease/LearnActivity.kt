package com.example.farmease

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool
import com.example.farmease.databinding.ActivityConnectBinding

class LearnActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConnectBinding
    private lateinit var learnRecyclerView: RecyclerView
    private lateinit var learnArrayList: ArrayList<Learn>
    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn)
        imageId = arrayOf(
            R.drawable.ic_farm1,
            R.drawable.ic_farm2,
            R.drawable.ic_farm3,
            R.drawable.ic_farm1,
            R.drawable.ic_farm2,
            R.drawable.ic_farm3
        )
        heading = arrayOf(
        "Precision Agriculture: Precision agriculture involves using technologies like GPS, sensors, and data analytics to optimize farming practices. It enables farmers to monitor and manage their crops more precisely, resulting in improved resource efficiency, reduced costs, and increased yields",

        "Vertical Farming: Vertical farming is a method of growing crops in vertically stacked layers or structures, often indoors or in urban areas. This approach allows for year-round cultivation, maximizes space utilization, minimizes water usage, and reduces the need for pesticides and herbicides",

        "Hydroponics: Hydroponics is a soil-less farming technique where plants are grown in nutrient-rich water solutions. This method conserves water, requires less space, enables faster growth rates, and provides precise control over nutrient delivery to plants",

        "Aquaponics: Aquaponics combines aquaculture (fish farming) with hydroponics. It involves the symbiotic relationship between fish and plants, where the fish waste provides nutrients for the plants, while the plants filter and purify the water for the fish. This integrated system can increase productivity and resource efficiency",

        "Controlled Environment Agriculture (CEA): CEA refers to the practice of growing crops within controlled environments, such as greenhouses or indoor facilities. By maintaining optimal conditions for plant growth, including temperature, humidity, light, and CO2 levels, CEA allows for year-round production, protection from pests and diseases, and reduced dependence on external factors"
        )
        learnRecyclerView = findViewById(R.id.mRecycleView)
        learnRecyclerView.layoutManager = LinearLayoutManager(this)
        learnRecyclerView.setHasFixedSize(true)

        learnArrayList = arrayListOf<Learn>()
        getUserData()
        binding = DataBindingUtil.setContentView(this,R.layout.activity_connect)
        initUi()
    }

    private fun getUserData() {
        for(i in imageId.indices){
            val learn = Learn(imageId[i],heading[i])
            learnArrayList.add(learn)
        }
        learnRecyclerView.adapter = MyAdapter(learnArrayList)
    }
    private fun initUi(){
        binding.mCustomToolBar.mBackArrow.setOnClickListener{
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.mCustomToolBar.mTvC.text = "Statistics"

    }
}