package com.example.finalproject

import android.content.*
import android.content.ContentValues
import android.os.Bundle
import android.provider.SyncStateContract.Helpers.insert
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.finalproject.databinding.ActivityMainBinding
import com.example.finalproject.ui.LoginFragment
import com.example.finalproject.ui.RateFragment
import com.example.finalproject.ui.UsersProvider



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

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
        val uri = ContentResolver.insert(
            UsersProvider.CONTENT_URI, values
        )
        Toast.makeText(baseContext, uri.toString(), Toast.LENGTH_LONG).show()
    }

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

       /* val btn : Button = findViewById(R.id.btnUserInfo)

        btn.setOnClickListener {
            LoginFragment().show(supportFragmentManager,"dialog")
        }
        */
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu to use in the action bar
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_rate, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        RateFragment().show(supportFragmentManager,"Rate")
        return true;
    }


}