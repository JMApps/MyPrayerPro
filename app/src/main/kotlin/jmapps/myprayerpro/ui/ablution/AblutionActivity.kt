package jmapps.myprayerpro.ui.ablution

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import jmapps.myprayerpro.R
import kotlinx.android.synthetic.main.activity_ablution.*

class AblutionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ablution)
        setSupportActionBar(toolbar)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val ablutionSectionPagerAdapter = AblutionSectionPagerAdapter(supportFragmentManager)
        ablutionViewPager.adapter = ablutionSectionPagerAdapter
        ablutionIndicator.setViewPager(ablutionViewPager)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}