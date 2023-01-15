package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.finalproject.ui.home.HomeFragment

class RateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate)
        title = "Rate Us";
        val cancelbt : Button = findViewById(R.id.btnCancel3);
        val submitbt : Button = findViewById(R.id.btnSubmit2);
        val radioGroup = findViewById<RadioGroup>(R.id.RatingRadioGroup)
        cancelbt.setOnClickListener{
            finish()
        }

        submitbt.setOnClickListener {
            val selectedOption: Int = radioGroup.checkedRadioButtonId
            val radioButton = findViewById<RadioButton>(selectedOption)
            Toast.makeText(this,radioButton.text, Toast.LENGTH_SHORT).show()

            finish()
        }
    }
}