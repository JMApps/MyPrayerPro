package jmapps.myprayerpro

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import android.view.MenuItem
import android.widget.Switch
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.preference.PreferenceManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import jmapps.myprayerpro.ui.adapter.MainSectionPagerAdapter
import jmapps.myprayerpro.ui.fragment.AboutUsBottomSheet
import jmapps.myprayerpro.ui.fragment.ToolsBottomSheet
import jmapps.myprayerpro.ui.mvp.other.OtherContract
import jmapps.myprayerpro.ui.mvp.other.OtherPresenterImpl
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener,
    BottomNavigationView.OnNavigationItemSelectedListener, OtherContract.OtherView {

    private lateinit var preferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    private lateinit var otherPresenterImpl: OtherPresenterImpl
    private lateinit var swNightMode: Switch

    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        preferences = PreferenceManager.getDefaultSharedPreferences(this)
        editor = preferences.edit()

        otherPresenterImpl = OtherPresenterImpl(this, this)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )

        val mainSectionPagerAdapter = MainSectionPagerAdapter(supportFragmentManager)
        mainViewPager.adapter = mainSectionPagerAdapter
        mainIndicator.setViewPager(mainViewPager)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navigationViewMain.setNavigationItemSelectedListener(this)

        navigationViewMain.menu.findItem(R.id.nav_night).actionView = Switch(this)
        swNightMode = navigationViewMain.menu.findItem(R.id.nav_night).actionView as Switch
        swNightMode.isClickable = false
        val nightModeState = preferences.getBoolean("key_night_mode", false)
        swNightMode.isChecked = nightModeState
        otherPresenterImpl.setNightMode(nightModeState)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.nav_tools -> otherPresenterImpl.setTools()

            R.id.nav_night -> {
                otherPresenterImpl.setNightMode(!swNightMode.isChecked)
                swNightMode.isChecked = !swNightMode.isChecked
                editor.putBoolean("key_night_mode", swNightMode.isChecked).apply()
            }

            R.id.nav_about -> otherPresenterImpl.setAboutUs()

            R.id.nav_rate -> otherPresenterImpl.setRate()

            R.id.nav_share -> otherPresenterImpl.setShare()
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun getTools() {
        val toolsBottomSheet = ToolsBottomSheet()
        toolsBottomSheet.show(supportFragmentManager, ToolsBottomSheet.toolsTag)
    }

    override fun getNightMode(state: Boolean) {
        if (state) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    override fun getAboutUs() {
        val aboutUsBottomSheet = AboutUsBottomSheet()
        aboutUsBottomSheet.show(supportFragmentManager, AboutUsBottomSheet.toolsAboutUs)
    }
}