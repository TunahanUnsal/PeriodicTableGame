package com.kekod.periodic_table.view.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.kekod.periodic_table.view.util.UiUtil
import com.kekod.periodic_table.view.util.UiUtil.Companion.getDuration
import android.os.Build
import androidx.annotation.RequiresApi
import com.kekod.periodic_table.R


class SplashActivity : Activity() {

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        UiUtil.hideSystemUI(window,findViewById(R.id.container))

        val duration = getDuration(applicationContext,R.drawable.chemical_animation)
        val background = object : Thread() {
            override fun run() {
                try {
                    sleep(duration.toLong())
                    val intent = Intent(baseContext, MainActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                }catch (e : Exception){
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }

    override fun onBackPressed() {
        finishAffinity()
    }
}