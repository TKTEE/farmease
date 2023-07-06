package com.example.farmease

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.farmease.databinding.ActivityConnectBinding
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

class ConnectActivity : AppCompatActivity() {
    private lateinit var binding:ActivityConnectBinding
    private lateinit var radioGroup: RadioGroup
    private lateinit var radioButtonBuyer: RadioButton
    private lateinit var radioButtonSeller: RadioButton
    private lateinit var saveButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connect)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_connect)
        initUi()
        radioGroup = findViewById(R.id.mRadioGroup)
        radioButtonBuyer = findViewById(R.id.mRadioBuyer)
        radioButtonSeller = findViewById(R.id.mRadioSeller)
        saveButton = findViewById(R.id.mBtnSave)
        saveButton.setOnClickListener {
            saveProfile()
        }
    }
    private fun saveProfile() {
        val selectedOption = radioGroup.checkedRadioButtonId
        val profileType: String = when (selectedOption) {
            R.id.mRadioBuyer -> "Buyer"
            R.id.mRadioSeller -> "Seller"
            else -> ""
        }
        if (profileType.isNotEmpty()) {
            // Save the profile type to the database or perform any other necessary actions
            Toast.makeText(this, "Profile saved as $profileType", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Please select a profile type", Toast.LENGTH_SHORT).show()
        }
    }
    private fun initUi(){
        binding.mCustomToolBar.mBackArrow.setOnClickListener{
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.mCustomToolBar.mTvC.text = "Connect"
    }
}