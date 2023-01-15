package com.example.finalproject.ui
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.DialogFragment
import com.example.finalproject.MainActivity
import com.example.finalproject.R
import com.example.finalproject.ui.home.HomeFragment


class LoginFragment : DialogFragment(R.layout.fragment_login) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val btncancel : Button = view.findViewById(R.id.btnCancel2)
        val btnadd : Button = view.findViewById(R.id.btnAdd)
        val txtpass : EditText = view.findViewById(R.id.txtPassword)
        val txtname : EditText = view.findViewById(R.id.txtUsername)
        val txtaddress : EditText = view.findViewById(R.id.txtAddress)
        val txtphone : EditText = view.findViewById(R.id.txtPhone)

 btnadd.setOnClickListener {
    val m1:MainActivity = activity as MainActivity
     val m2:HomeFragment = parentFragment as HomeFragment
    m1.onClickAddName(view)

     if (!m1.dbIsEmpty()){
         m1.setVisibility()
         m2.putValues()
         dismiss()
     }

    dismiss()
 }

 btncancel.setOnClickListener {
     dismiss()
 }
}

companion object {
 const val TAG = "loginDialog"
}

}