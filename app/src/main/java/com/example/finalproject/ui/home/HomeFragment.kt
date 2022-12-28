package com.example.finalproject.ui.home


import android.content.ContentValues
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentHomeBinding
import com.example.finalproject.ui.LoginFragment
import com.example.finalproject.ui.UsersProvider

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null




    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    fun onClickRetrieveUsers(view: View?) {

        val txtname2 : EditText = binding.edtxtName
        val txtaddress2 : EditText = binding.edtxtAddress
        val txtphone2 : EditText = binding.edtxtPhone
        // Retrieve student records
        val URL = "content://com.example.MyApplication.StudentsProvider"
        val students = Uri.parse(URL)
        //\  val c = contentResolver!!.query(students,null,null,null,"name")
        var c = getActivity()!!.getContentResolver().query(students, null, null, null,null)
        //val //c = managedQuery(students, null, null, null, "name")
        if (c != null) {
            if (c.moveToFirst()) {
                do {
                        txtname2.setText(c.getString(c.getColumnIndex(UsersProvider.NAME)))
                        txtaddress2.setText(c.getString(c.getColumnIndex(UsersProvider.ADDRESS)))
                        txtphone2.setText(c.getString(c.getColumnIndex(UsersProvider.PHONE)))
                } while (c.moveToNext())
            }
    }
}



override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val btninfo : Button = binding.btnUserInfo

        val btnreset : Button = binding.btnReset
        val txtname2 : EditText = binding.edtxtName
        val txtaddress2 : EditText = binding.edtxtAddress
        val txtphone2 : EditText = binding.edtxtPhone
        val tvname : TextView = binding.tvName
        val tvaddress : TextView = binding.tvAddress
        val tvphone : TextView = binding.tvPhone
        val btnupdate : Button = binding.btnUpdate



        btnreset.setOnClickListener {
            txtname2.visibility = -1
            txtaddress2.visibility = -1
            txtphone2.visibility = -1
            tvname.visibility = -1
            tvaddress.visibility = -1
            tvphone.visibility = -1
            btnupdate.visibility = -1
            btnreset.visibility = -1
        }

        btninfo.setOnClickListener {

            LoginFragment().show(childFragmentManager,"dialog")
            txtname2.visibility = 1
            txtaddress2.visibility = 1
            txtphone2.visibility = 1
            tvname.visibility = 1
            tvaddress.visibility = 1
            tvphone.visibility = 1
            btnupdate.visibility = 1
            btnreset.visibility = 1
        }




        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}