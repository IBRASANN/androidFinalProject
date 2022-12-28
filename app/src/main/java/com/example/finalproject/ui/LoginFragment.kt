package com.example.finalproject.ui
import android.content.ContentValues
import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import android.widget.*
import com.example.finalproject.R
import com.example.finalproject.ui.home.HomeFragment


class LoginFragment : DialogFragment(R.layout.fragment_login) {

    fun onClickAddName(view: View) {
        // Add a new student record
        val values = ContentValues()
        values.put(
            UsersProvider.NAME,
            (view.findViewById<View>(R.id.txtUsername) as EditText).text.toString()
        )
        values.put(
            UsersProvider.ADDRESS,
            (view.findViewById<View>(R.id.txtAddress) as EditText).text.toString()
        )
        values.put(
            UsersProvider.PHONE,
            (view.findViewById<View>(R.id.txtPhone) as EditText).text.toString()
        )
        values.put(
            UsersProvider.PASSWORD,
            (view.findViewById<View>(R.id.txtPassword) as EditText).text.toString()
        )
        val uri = getActivity()!!.getContentResolver().insert(
            UsersProvider.CONTENT_URI, values
        )
        Toast.makeText(getActivity()!!.baseContext, uri.toString(), Toast.LENGTH_LONG).show()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val btncancel : Button = view.findViewById(R.id.btnCancel2)
        val btnadd : Button = view.findViewById(R.id.btnAdd)
        val txtpass : EditText = view.findViewById(R.id.txtPassword)
        val txtname : EditText = view.findViewById(R.id.txtUsername)
        val txtaddress : EditText = view.findViewById(R.id.txtAddress)
        val txtphone : EditText = view.findViewById(R.id.txtPhone)

        /*val txtname2 : EditText = view.findViewById(R.id.edtxtName)
        val txtaddress2 : EditText = view.findViewById(R.id.edtxtAddress)
        val txtphone2 : EditText = view.findViewById(R.id.edtxtPhone)
        val tvname : TextView = view.findViewById(R.id.tvName)
        val tvaddress : TextView = view.findViewById(R.id.tvAddress)
        val tvphone : TextView = view.findViewById(R.id.tvPhone)
        val btnupdate : Button = view.findViewById(R.id.btnUpdate)
        val btnreset : Button = view.findViewById(R.id.btnReset)*/

 btnadd.setOnClickListener {

    /* val m1: HomeFragment = getActivity() as HomeFragment;
     m1.recieveFeedback()*/

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