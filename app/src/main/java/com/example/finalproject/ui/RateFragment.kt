package com.example.finalproject.ui

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.DialogFragment
import com.example.finalproject.R

class RateFragment : DialogFragment(R.layout.fragment_rate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val cancelbt : Button = view.findViewById(R.id.btnCancel);
        val submitbt : Button = view.findViewById(R.id.btnSubmit);
        val radioGroup = view.findViewById<RadioGroup>(R.id.RatingRadioGroup)
        cancelbt.setOnClickListener{
            dismiss()
        }

        submitbt.setOnClickListener {
            val selectedOption: Int = radioGroup.checkedRadioButtonId
            val radioButton = view.findViewById<RadioButton>(selectedOption)
            Toast.makeText(context,radioButton.text, Toast.LENGTH_SHORT).show()

            dismiss()
        }
    }
}