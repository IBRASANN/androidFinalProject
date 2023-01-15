package com.example.finalproject

import android.content.*
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.finalproject.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)



    }



    fun setVisibility(){
        val btnreset : Button = findViewById(R.id.btnReset)
        val txtname2 : EditText = findViewById(R.id.edtxtName)
        val txtaddress2 : EditText = findViewById(R.id.edtxtAddress)
        val txtphone2 : EditText = findViewById(R.id.edtxtPhone)
        val tvname : TextView = findViewById(R.id.tvName)
        val tvaddress : TextView = findViewById(R.id.tvAddress)
        val tvphone : TextView = findViewById(R.id.tvPhone)
        val btnupdate : Button = findViewById(R.id.btnUpdate)

        txtname2.visibility = 1
        txtaddress2.visibility = 1
        txtphone2.visibility = 1
        tvname.visibility = 1
        tvaddress.visibility = 1
        tvphone.visibility = 1
        btnupdate.visibility = 1
        btnreset.visibility = 1

    }




    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu to use in the action bar
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_rate, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //RateFragment().show(supportFragmentManager,"Rate")
        val intent = Intent(this, RateActivity::class.java)
        startActivity(intent)
        return true;
    }

    fun onClickAddName(view: View
    ) {
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
        val uri = contentResolver.insert(
            UsersProvider.CONTENT_URI, values
        )
        Toast.makeText(baseContext, "success", Toast.LENGTH_SHORT).show()
    }


    fun onClickRetrieveUsers(view: View) {
        // Retrieve users records
        val URL = "content://com.example.finalproject.UsersProvider"
        val users = Uri.parse(URL)

        //\  val c = contentResolver!!.query(users,null,null,null,"name")
        var c = contentResolver.query(users, null, null, null,null)
        //val //c = managedQuery(users, null, null, null, "name")
        if (c != null) {
            c.moveToLast()
            (view.findViewById<View>(R.id.edtxtName) as EditText).setText(c.getString(c.getColumnIndex(UsersProvider.NAME)))
            (view.findViewById<View>(R.id.edtxtAddress) as EditText).setText(c.getString(c.getColumnIndex(UsersProvider.ADDRESS)))
            (view.findViewById<View>(R.id.edtxtPhone) as EditText).setText(c.getString(c.getColumnIndex(UsersProvider.PHONE)))
        }else{
            (view.findViewById<View>(R.id.edtxtName) as EditText).setText("")
            (view.findViewById<View>(R.id.edtxtAddress) as EditText).setText("")
            (view.findViewById<View>(R.id.edtxtPhone) as EditText).setText("")
        }
    }


    fun onClickResetTable(view: View){
        val URL = "content://com.example.finalproject.UsersProvider"
        val users = Uri.parse(URL)
        var count : Int = contentResolver.delete(users,null,null)

        (view.findViewById<View>(R.id.edtxtName) as EditText).setText("")
        (view.findViewById<View>(R.id.edtxtAddress) as EditText).setText("")
        (view.findViewById<View>(R.id.edtxtPhone) as EditText).setText("")
    }

    fun onClickUpdateRecord(view: View){
        val URL = "content://com.example.finalproject.UsersProvider"
        val users = Uri.parse(URL)

        val values = ContentValues()
        values.put(
            UsersProvider.NAME,
            (view.findViewById<View>(R.id.edtxtName) as EditText).text.toString()
        )
        values.put(
            UsersProvider.ADDRESS,
            (view.findViewById<View>(R.id.edtxtAddress) as EditText).text.toString()
        )
        values.put(
            UsersProvider.PHONE,
            (view.findViewById<View>(R.id.edtxtPhone) as EditText).text.toString()
        )

        var count : Int = contentResolver.update(users,values,"_id = (SELECT MAX(_id) FROM users)",null)
    }

    fun dbIsEmpty():Boolean{
        val URL = "content://com.example.finalproject.UsersProvider"
        val users = Uri.parse(URL)
        var c = contentResolver.query(users, null, null, null,null)
        return !(c!=null && c.count >0)

    }



}