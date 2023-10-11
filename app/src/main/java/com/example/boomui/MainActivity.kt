package com.example.boomui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    companion object {
        lateinit var bottomNav : BottomNavigationView
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(HomeFragment())
        bottomNav = findViewById(R.id.bottom_navigation) as BottomNavigationView
        bottomNav.setItemIconTintList(null)
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.navigation_explore -> {
                    loadFragment(ExploreFragment())
                    true
                }
                R.id.navigation_plus -> {
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.add(R.id.container,plusFragment())
                    transaction.commit()
                    bottomNav.visibility=View.GONE
                    true
                }

                else -> {
                    true
                }
            }
        }


    }

    override fun onResume() {
        super.onResume()
        bottomNav.visibility=View.VISIBLE
    }

    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }
}