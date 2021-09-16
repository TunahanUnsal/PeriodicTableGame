package com.kekod.periodic_table.view.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kekod.periodic_table.R
import com.kekod.periodic_table.view.util.UiUtil

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        UiUtil.hideNavigationBar(window)

        val background = object : Thread() {
            override fun run() {
                try {
                    Thread.sleep(5000)
                    val intent = Intent(baseContext, MainActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }catch (e : Exception){
                    e.printStackTrace()
                }
            }
        }
        background.start()

    }
}