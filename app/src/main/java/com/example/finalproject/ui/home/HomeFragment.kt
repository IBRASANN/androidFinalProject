package com.example.finalproject.ui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.finalproject.MainActivity
import com.example.finalproject.databinding.FragmentHomeBinding
import com.example.finalproject.ui.LoginFragment

class HomeFragment : Fragment(){

    private var _binding: FragmentHomeBinding? = null

    public var flag :Boolean = false

    public var user:String = ""
    public var address:String = ""
    public var phone:String = ""


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!





override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val m1:MainActivity = activity as MainActivity

        val btninfo : Button = binding.btnUserInfo

        val btnreset : Button = binding.btnReset
        val txtname2 : EditText = binding.edtxtName
        val txtaddress2 : EditText = binding.edtxtAddress
        val txtphone2 : EditText = binding.edtxtPhone
        val tvname : TextView = binding.tvName
        val tvaddress : TextView = binding.tvAddress
        val tvphone : TextView = binding.tvPhone
        val btnupdate : Button = binding.btnUpdate



        btnupdate.setOnClickListener {
            m1.onClickUpdateRecord(root)
            m1.onClickRetrieveUsers(root)
        }

        btnreset.setOnClickListener {
            m1.onClickResetTable(root)
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

            val frag : LoginFragment = LoginFragment()
            frag.show(childFragmentManager,"dialog")

            if (!m1.dbIsEmpty()){
                m1.setVisibility()
                m1.onClickRetrieveUsers(root)
            }
        }


        return root
    }


    fun putValues(){
        val m1:MainActivity = activity as MainActivity
        m1.onClickRetrieveUsers(binding.root)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}