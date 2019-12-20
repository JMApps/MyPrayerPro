package jmapps.myprayerpro.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import jmapps.myprayerpro.R

class AboutUsBottomSheet : BottomSheetDialogFragment() {

    private lateinit var rootAboutUs: View

    override fun getTheme() = R.style.BottomSheetStyleFull

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootAboutUs = inflater.inflate(R.layout.bottom_sheet_about_us, container, false)

        return rootAboutUs
    }

    companion object {
        const val toolsAboutUs = "AboutUsBottomSheet"
    }
}