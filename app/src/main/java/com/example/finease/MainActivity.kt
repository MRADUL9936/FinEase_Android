package com.example.finease


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var settingFragment:Fragment
    private lateinit var homeFragment: Fragment
    private lateinit var messageFragment: Fragment
    private lateinit var aboutFragment: Fragment
    private lateinit var binFragment: Fragment
    private lateinit var feedbackFragment: Fragment
    private lateinit var ratingFragment: Fragment
    private lateinit var reportFragment: Fragment
    private lateinit var bottomNavigationView: BottomNavigationView

    lateinit var  drawer: DrawerLayout
    lateinit var navigationView: NavigationView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        var actionBarDrawerToggle = ActionBarDrawerToggle(this,drawer,toolbar,
            R.string.open,R.string.close)

        drawer.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()


 bottomNavigationView=findViewById(R.id.bottom_navbar)
        settingFragment=setting_bottom_fragment()
        homeFragment=fragment_home_bottom()
        messageFragment=fragment_messages_bottom()

        aboutFragment=Fragment_About()
        binFragment=Fragment_Bin()
        feedbackFragment=Fragment_Feedback()
        ratingFragment=Fragment_Rating()
        reportFragment=Fragment_Report()




        setCurrentFragment(homeFragment)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.setting_item -> setCurrentFragment(settingFragment)
                R.id.home_item -> setCurrentFragment(homeFragment)
                R.id.message_item -> setCurrentFragment(messageFragment) // Assuming messageFragment exists
            }
            true
        }


    }


    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.item_logout ->finish()
            R.id.item_about -> setCurrentFragment(aboutFragment)
            R.id.item_Sync ->Toast.makeText(this, "Service Currently Unavailable", Toast.LENGTH_SHORT).show()
            R.id.item_Rateus ->setCurrentFragment(ratingFragment)
            R.id.item_Report ->setCurrentFragment(reportFragment)
            R.id.item_Bin -> setCurrentFragment(binFragment)
            R.id.item_Feedback -> setCurrentFragment(feedbackFragment)
        }
        drawer.closeDrawer(GravityCompat.START)
        return true

    }

    private fun setCurrentFragment(fragment:Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fr_main,fragment)
            commit()
        }
    }
}