package com.example.tujweed.ui.ahkam.ahkam_fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.tujweed.R
import com.example.tujweed.adapters.ViewPagerAdapter
import com.example.tujweed.databinding.FragmentAhkamBinding
import com.example.tujweed.ui.ahkam.learning_tujweed.LearningTujweedFragment
import com.example.tujweed.ui.ahkam.book.BookesFragment
import com.google.android.material.tabs.TabLayout

class AhkamFragment : Fragment(R.layout.fragment_ahkam) {

    lateinit var binding: FragmentAhkamBinding
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = FragmentAhkamBinding.inflate(inflater,container,false)

        tabLayout = binding.tabLayout
        viewPager = binding.viewPager

        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        setTab()
        return binding.root

    }


 fun setTab (){
     val adapter = fragmentManager?.let { ViewPagerAdapter(it) }
         adapter?.addFragment(LearningTujweedFragment(),"تعلم التجويد")
         adapter?.addFragment(BookesFragment(), " التجويد المصور")
     viewPager.adapter = adapter
     tabLayout.setupWithViewPager(viewPager)
 }

    override fun onResume() {
        super.onResume()
        setTab()
        Log.i("Tag","Resume")
    }

}