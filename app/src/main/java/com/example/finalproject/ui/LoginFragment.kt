package com.example.finalproject.ui
import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import android.widget.*
import com.example.finalproject.R

class LoginFragment : DialogFragment(R.layout.fragment_login) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val donebtn : Button = view.findViewById(R.id.btnDone);
        val txtpass : EditText = view.findViewById(R.id.txtPassword);
        val txtname : EditText = view.findViewById(R.id.txtUsername);
        val txtaddress : EditText = view.findViewById(R.id.txtAddress);
        val txtphone : EditText = view.findViewById(R.id.txtPhone);

        donebtn.setOnClickListener {
        dismiss() 
        }
    }

    companion object {
        const val TAG = "loginDialog"
    }

}