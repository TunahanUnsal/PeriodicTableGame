package com.kekod.periodic_table.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kekod.periodic_table.R
import com.kekod.periodic_table.view.util.UiUtil

class GameOverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)
        UiUtil.hideSystemUI(window,findViewById(R.id.container))
        val duration = UiUtil.getDuration(applicationContext, R.drawable.unsuccess)
        val background = object : Thread() {
            override fun run() {
                try {
                    sleep(duration.toLong()-500)
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
        // do nothing please
    }

    override fun onStop() {
        finish()
        super.onStop()
    }
}