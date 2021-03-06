package com.felixtechlabs.bottomnavigationwithviewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.felixtechlabs.felixstudentapp.pagers.HomePager
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupHomePager()


    }

    private fun setupHomePager() {
        var fragmentsArray = listOf(HomeFragment(this@MainActivity), HomeSettingsFragment())

        val homeViewPager = findViewById<ViewPager>(R.id.homeViewPager)

        homeViewPager.adapter =
                HomePager(fragmentsArray, supportFragmentManager, fragmentsArray.size)

//        homeViewPager.offscreenPageLimit = 3

        homeViewPager?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
                bottom_navigation.menu.getItem(position).isChecked = true
            }
        })
        val home = HomeFragment(this@MainActivity)
        val settings = HomeSettingsFragment()
        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottom_navigation!!.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.page_1 -> {
                    homeViewPager.currentItem = 0
                }
                R.id.page_2 -> {
                    homeViewPager.currentItem = 1
                }
            }
            true
        }
    }
}
