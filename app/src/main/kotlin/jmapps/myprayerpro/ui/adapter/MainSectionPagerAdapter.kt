package jmapps.myprayerpro.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import jmapps.myprayerpro.ui.fragment.MainFragment

class MainSectionPagerAdapter(fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return MainFragment.newInstance(position + 1)
    }

    override fun getCount(): Int {
        return 3
    }
}