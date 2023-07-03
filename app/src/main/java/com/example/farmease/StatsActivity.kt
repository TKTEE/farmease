package com.example.farmease

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.farmease.databinding.ActivityConnectBinding
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.components.XAxis

class StatsActivity : AppCompatActivity() {
    private lateinit var chart: LineChart
    private lateinit var binding: ActivityConnectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_connect)
        initUi()

        chart = findViewById(R.id.chart)
        setupChart()

        val prices = listOf(100, 150, 120, 180, 200, 250)
        val months = arrayOf("Jan", "Feb", "Mar", "Apr", "May", "Jun")

        val entries = ArrayList<Entry>()
        for (i in prices.indices) {
            entries.add(Entry(i.toFloat(), prices[i].toFloat()))
        }

        val dataSet = LineData(LineDataSet(entries, "Price"))
        chart.data = dataSet

        val xAxis = chart.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.valueFormatter = object : ValueFormatter() {
            override fun getAxisLabel(value: Float, axis: AxisBase?): String {
                val index = value.toInt()
                return if (index >= 0 && index < months.size) months[index] else ""
            }
        }

        chart.invalidate()
    }

    private fun initUi() {
        binding.mCustomToolBar.mBackArrow.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.mCustomToolBar.mTvC.text = "Statistics"
    }

    private fun setupChart() {
        chart.setTouchEnabled(true)
        chart.setPinchZoom(true)
        chart.description.isEnabled = false
        chart.legend.isEnabled = false
        chart.axisRight.isEnabled = false
    }
}
