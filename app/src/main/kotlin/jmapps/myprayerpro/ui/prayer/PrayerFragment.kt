package jmapps.myprayerpro.ui.prayer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import jmapps.myprayerpro.R

class PrayerFragment : Fragment() {

    private var sectionNumber: Int? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_prayer, container, false)
        sectionNumber = arguments?.getInt(ARG_SECTION_NUMBER)!!

        return root
    }

    companion object {

        private const val ARG_SECTION_NUMBER = "prayer_section_number"

        @JvmStatic
        fun newInstance(sectionNumber: Int): PrayerFragment {
            return PrayerFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}