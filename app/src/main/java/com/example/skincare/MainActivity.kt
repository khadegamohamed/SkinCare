package com.example.skincare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager.widget.ViewPager
import com.example.skincare.databinding.ActivityMainBinding
import com.example.skincare.routie.RoutineFragment
import com.example.skincare.ui.main.ClincsFragment
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout

import com.pageradepter

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayouyt: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var viewpager: ViewPager
    lateinit var tablayout: TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Toast.makeText(this, "welcome", Toast.LENGTH_LONG).show()
        initViews()
        openDrawer()
        setuptabs()


    }

    private fun openDrawer() {
        toggle = ActionBarDrawerToggle(this, drawerLayouyt, R.string.open, R.string.close)
        drawerLayouyt.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.logout_item ->
                    Toast.makeText(applicationContext, "Do you want exit?", Toast.LENGTH_LONG)
                        .show()
                R.id.setting_item ->
                    Toast.makeText(applicationContext, "Setting i", Toast.LENGTH_LONG).show()
            }
            true
        }

    }

    private fun initViews() {
        drawerLayouyt = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)
        tablayout = findViewById(R.id.tabs)
        viewpager = findViewById(R.id.viewpager)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setuptabs() {
        val adepter = pageradepter(supportFragmentManager)
        adepter.addfragments(ClincsFragment(), "Clincs")
        adepter.addfragments(RoutineFragment(), "Routien")
        adepter.addfragments(ToBuyFragment(), "Tobuy")
        viewpager.adapter = adepter
        tablayout.setupWithViewPager(viewpager)
        tablayout.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_calendar_today_24)
        tablayout.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_alarm_24)
        tablayout.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_filter_drama_24)

    }


}