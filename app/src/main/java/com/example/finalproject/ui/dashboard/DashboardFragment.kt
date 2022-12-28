package com.example.finalproject.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.finalproject.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val qty1 : EditText = binding.txtQty1
        var qty2 : EditText = binding.txtQty2
        var qty3 : EditText = binding.txtQty3

        val min1 : Button = binding.btnMin
        val min2 : Button = binding.btnMin2
        val min3 : Button = binding.btnMin3
        val plus1 : Button = binding.btnPlus
        val plus2 : Button = binding.btnPlus2
        val plus3 : Button = binding.btnPlus3
        val proceed : Button = binding.btnProceed

        var thanks : TextView = binding.tvThanks
        var tvtot : TextView = binding.tvTotal

        min1.setOnClickListener {
            var value = qty1.text.toString().toInt()
            if(value > 0)
                value = value-1
            qty1.setText(value.toString())
        }
        plus1.setOnClickListener {
            var value = qty1.text.toString().toInt()
            value = value + 1
            qty1.setText(value.toString())
        }


        min2.setOnClickListener {
            var value = qty2.text.toString().toInt()
            if(value > 0)
                value = value-1
            qty2.setText(value.toString())
        }
        plus2.setOnClickListener {
            var value = qty2.text.toString().toInt()
            value = value + 1
            qty2.setText(value.toString())
        }


        min3.setOnClickListener {
            var value = qty3.text.toString().toInt()
            if(value > 0)
                value = value-1
            qty3.setText(value.toString())
        }
        plus3.setOnClickListener {
            var value = qty3.text.toString().toInt()
            value = value + 1
            qty3.setText(value.toString())
        }

        proceed.setOnClickListener {
            val price : Int = 17
            val finalQty : Int = qty1.text.toString().toInt() + qty2.text.toString().toInt() + qty3.text.toString().toInt()
            val total : Int = finalQty*price
            thanks.visibility = 1
            tvtot.text = "Total is:" + total.toString()
            tvtot.visibility = 1
        }

       /* fun findSum(){

        }*/



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}