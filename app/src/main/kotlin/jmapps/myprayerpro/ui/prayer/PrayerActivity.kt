package jmapps.myprayerpro.ui.prayer

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import jmapps.myprayerpro.R
import kotlinx.android.synthetic.main.activity_prayer.*

class PrayerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prayer)
        setSupportActionBar(toolbar)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val prayerSectionPagerAdapter = PrayerSectionPagerAdapter(supportFragmentManager)
        prayerViewPager.adapter = prayerSectionPagerAdapter
        prayerIndicator.setViewPager(prayerViewPager)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}