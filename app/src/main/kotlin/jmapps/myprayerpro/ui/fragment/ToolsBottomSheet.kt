package jmapps.myprayerpro.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import jmapps.myprayerpro.R

class ToolsBottomSheet : BottomSheetDialogFragment() {

    private lateinit var rootTools: View

    override fun getTheme() = R.style.BottomSheetStyleFull

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootTools = inflater.inflate(R.layout.bottom_sheet_tools, container, false)

        return rootTools
    }

    companion object {
        const val toolsTag = "ToolsBottomSheet"
    }
}