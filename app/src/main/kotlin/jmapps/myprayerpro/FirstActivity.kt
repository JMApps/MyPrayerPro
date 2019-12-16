package jmapps.myprayerpro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import jmapps.myprayerpro.ui.adapter.MainSectionPagerAdapter
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val mainSectionPagerAdapter = MainSectionPagerAdapter(supportFragmentManager)
        mainViewPager.adapter = mainSectionPagerAdapter
        mainIndicator.setViewPager(mainViewPager)
    }
}