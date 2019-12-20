package jmapps.myprayerpro.ui.mvp.other

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.net.toUri
import jmapps.myprayerpro.R

class OtherPresenterImpl(
    private val otherView: OtherContract.OtherView?,
    private val context: Context) :
    OtherContract.OtherPresenter {

    override fun setTools() {
        otherView?.getTools()
    }

    override fun setNightMode(state: Boolean) {
        if (state) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
        otherView?.getNightMode(state)
    }

    override fun setAboutUs() {
        otherView?.getAboutUs()
    }

    override fun setRate() {
        val rateApp = Intent(Intent.ACTION_VIEW)
        rateApp.data = context.getString(R.string.app_link).toUri()
        context.startActivity(rateApp)
    }

    override fun setShare() {
        val shareAppLink = Intent(Intent.ACTION_SEND)
        shareAppLink.type = "text/plain"
        shareAppLink.putExtra(Intent.EXTRA_TEXT,
            context.getString(R.string.app_name) + "\n" + context.getString(R.string.app_link))
        context.startActivity(shareAppLink)
    }
}