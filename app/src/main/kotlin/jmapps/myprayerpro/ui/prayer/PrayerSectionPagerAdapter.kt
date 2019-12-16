package jmapps.myprayerpro.ui.prayer

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PrayerSectionPagerAdapter(fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return PrayerFragment.newInstance(position + 1)
    }

    override fun getCount(): Int {
        return 3
    }
}