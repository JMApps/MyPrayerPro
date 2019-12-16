package jmapps.myprayerpro.ui.supplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import jmapps.myprayerpro.R

class SupplicationFragment : Fragment() {

    private var sectionNumber: Int? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_supplication, container, false)
        sectionNumber = arguments?.getInt(ARG_SECTION_NUMBER)!!

        return root
    }

    companion object {

        private const val ARG_SECTION_NUMBER = "supplication_section_number"

        @JvmStatic
        fun newInstance(sectionNumber: Int): SupplicationFragment {
            return SupplicationFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}