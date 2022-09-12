package com.example.tujweed.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(suFragmentManager: FragmentManager) : FragmentPagerAdapter(suFragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {


    private val mFragmentList = ArrayList<Fragment>()
    private val mFragmentTitle = ArrayList<String>()

    override fun getCount() = mFragmentList.size

    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitle[position]
    }

    fun addFragment(fragment: Fragment , title: String){
        mFragmentList.add(fragment)
        mFragmentTitle.add(title)
    }


}