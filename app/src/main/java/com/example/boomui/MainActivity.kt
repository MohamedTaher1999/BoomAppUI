package com.example.boomui

import android.content.Context
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
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
        val menuView = bottomNav.getChildAt(0) as BottomNavigationMenuView
        val itemView = menuView.get(2) as BottomNavigationItemView
        if(!isTabletDevice()) {
            val screenWidth = resources.displayMetrics.widthPixels
            val iconSize = screenWidth / 10
            itemView.setIconSize(iconSize)
        }
        else{
            itemView.setIconSize(50)
        }
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
                R.id.navigation_feed -> {
//                    loadFragment(TestChartFragment())
                    true
                }
                else -> {
                    true
                }
            }
        }


    }
    fun isTabletDevice(): Boolean {
        var isTablet=false
        val metrics = DisplayMetrics()
        this.getWindowManager().getDefaultDisplay().getMetrics(metrics)

        val yInches = metrics.heightPixels / metrics.ydpi
        val xInches = metrics.widthPixels / metrics.xdpi
        val diagonalInches = Math.sqrt((xInches * xInches + yInches * yInches).toDouble())
        if (diagonalInches >= 6.5) {
            isTablet=true
        }
        return isTablet
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