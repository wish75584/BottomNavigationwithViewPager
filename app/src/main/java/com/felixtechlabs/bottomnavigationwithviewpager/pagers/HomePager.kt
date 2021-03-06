package com.felixtechlabs.felixstudentapp.pagers

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class HomePager(private val fragmentsArray: List<Fragment>, fm: FragmentManager, private var totalTabs: Int) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return fragmentsArray[position]
    }

    // this counts total number of tabs
    override fun getCount(): Int {
        return totalTabs
    }


}