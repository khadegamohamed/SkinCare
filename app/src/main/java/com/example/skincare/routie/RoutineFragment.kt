package com.example.skincare.routie

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.skincare.R
import com.example.skincare.databinding.FragmentRoutienBinding
import com.google.android.material.tabs.TabLayout

class RoutineFragment : Fragment() {
    lateinit var binding: FragmentRoutienBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentRoutienBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
         setUpTabs()

    }

    private fun setUpTabs() {
        val adapter = RoutinePagerAdapter(requireActivity().supportFragmentManager)
        Log.e("TAG", "setUpTabs: ")
        adapter.addFragments(MorningRoutineFragment(),"DAY")
        adapter.addFragments(EveningRoutineFragment(),"NIGHT")
        binding.viewPagerId.adapter = adapter
        binding.tabLayoutId.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_wb_sunny_24)
        binding.tabLayoutId.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_nights_stay_24)

    }


}
