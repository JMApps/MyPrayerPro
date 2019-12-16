package jmapps.myprayerpro.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import jmapps.myprayerpro.R
import jmapps.myprayerpro.ui.ablution.AblutionActivity
import jmapps.myprayerpro.ui.prayer.PrayerActivity
import jmapps.myprayerpro.ui.supplication.SupplicationActivity
import jmapps.myprayerpro.ui.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainFragment : Fragment(), View.OnClickListener {

    private lateinit var pageViewModel: MainViewModel
    private var sectionNumber: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProvider(this).get(MainViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 0)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_main, container, false)
        sectionNumber = arguments?.getInt(ARG_SECTION_NUMBER)!!

        pageViewModel.titles.observe(viewLifecycleOwner, Observer<String> {
            tvMainTitle.text = it
        })

        pageViewModel.pictures.observe(viewLifecycleOwner, Observer<String> {
            val icSource = context?.resources?.getIdentifier(
                it, "drawable", "jmapps.myprayerpro")
            icSource?.let { it1 -> ivMainPicture.setImageResource(it1) }
        })

        root.btnToContent.setOnClickListener(this)

        return root
    }

    companion object {

        private const val ARG_SECTION_NUMBER = "section_number"

        @JvmStatic
        fun newInstance(sectionNumber: Int): MainFragment {
            return MainFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

    override fun onClick(v: View?) {
        when (sectionNumber) {
            1 -> {
                val toAblution = Intent(context, AblutionActivity::class.java)
                context?.startActivity(toAblution)
            }

            2 -> {
                val toPrayer = Intent(context, PrayerActivity::class.java)
                context?.startActivity(toPrayer)
            }

            3 -> {
                val toSupplication = Intent(context, SupplicationActivity::class.java)
                context?.startActivity(toSupplication)
            }
        }
    }
}