package com

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class  pageradepter (sfm:FragmentManager):FragmentPagerAdapter(sfm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val mfragmentlist=ArrayList<Fragment>()
    private val mfragmentTitlelist=ArrayList<String>()
    override fun getCount(): Int {
       return mfragmentlist.size
    }

    override fun getItem(position: Int): Fragment {
     return mfragmentlist[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mfragmentTitlelist[position]
    }

    fun addfragments(fragment:Fragment,title:String){
        mfragmentTitlelist.add(title)
        mfragmentlist.add(fragment)
    }


}