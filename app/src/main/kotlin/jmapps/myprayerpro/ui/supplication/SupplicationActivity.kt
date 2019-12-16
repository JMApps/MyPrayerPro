package jmapps.myprayerpro.ui.supplication

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import jmapps.myprayerpro.R
import kotlinx.android.synthetic.main.activity_supplication.*

class SupplicationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_supplication)
        setSupportActionBar(toolbar)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val supplicationSectionPagerAdapter = SupplicationSectionPagerAdapter(supportFragmentManager)
        supplicationViewPager.adapter = supplicationSectionPagerAdapter
        supplicationIndicator.setViewPager(supplicationViewPager)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}