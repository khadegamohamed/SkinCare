package com.example.skincare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.get
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager.widget.ViewPager
import com.example.skincare.ui.main.ClincsFragment
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.pageradepter

class MainActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayouyt: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var viewPager: ViewPager
    lateinit var tabLayout: TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this,"welcome",Toast.LENGTH_LONG).show()
        initViews()
        openDrawer()
      setuptabs()


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
    private fun setuptabs(){
        val adepter = pageradepter(supportFragmentManager)
        adepter.addfragments(ClincsFragment(),"Clincs")
        adepter.addfragments(RoutienFragment(),"Routien")
        adepter.addfragments(ToBuyFragment(),"Tobuy")
        viewPager.adapter =adepter
        tabLayout.setupWithViewPager(viewPager)
        tabLayout.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_calendar_today_24)
        tabLayout.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_alarm_24)
        tabLayout.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_filter_drama_24)

    }



}