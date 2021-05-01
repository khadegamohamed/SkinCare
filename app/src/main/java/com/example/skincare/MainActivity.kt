package com.example.skincare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayouyt: DrawerLayout
    lateinit var navigationView: NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this,"welcome",Toast.LENGTH_LONG).show()
        initViews()
        openDrawer()



    }

    private fun openDrawer() {
        toggle = ActionBarDrawerToggle(this,drawerLayouyt,R.string.open,R.string.close)
        drawerLayouyt.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.logout_item ->
                    Toast.makeText(applicationContext,"Do you want exit?",Toast.LENGTH_LONG).show()
                R.id.setting_item ->
                    Toast.makeText(applicationContext,"Setting i",Toast.LENGTH_LONG).show()
            }
            true
        }

    }

    private fun initViews() {
        drawerLayouyt = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            true
        }
        return super.onOptionsItemSelected(item)
    }

}