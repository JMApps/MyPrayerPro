package jmapps.myprayerpro.ui.ablution

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import jmapps.myprayerpro.R
import kotlinx.android.synthetic.main.fragment_ablution.*

class AblutionFragment : Fragment() {

    private lateinit var ablutionViewModel: AblutionViewModel
    private var sectionNumber: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ablutionViewModel = ViewModelProvider(this).get(AblutionViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 0)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_ablution, container, false)

        ablutionViewModel.pictures.observe(viewLifecycleOwner, Observer {
            val icSource = context?.resources?.getIdentifier(
                it, "drawable", "jmapps.myprayerpro")
            icSource?.let { it1 -> ivAblutionPicture.setImageResource(it1) }
        })

        return root
    }

    companion object {

        private const val ARG_SECTION_NUMBER = "ablution_section_number"

        @JvmStatic
        fun newInstance(sectionNumber: Int): AblutionFragment {
            return AblutionFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}