package jmapps.myprayerpro

import android.app.Activity
import android.content.Intent
import android.os.Bundle

class SplashScreenActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startActivity(Intent(this@SplashScreenActivity, FirstActivity::class.java))
        finish()
    }
}