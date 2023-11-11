package com.kekod.periodic_table.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.kekod.periodic_table.databinding.ActivityMainBinding
import com.kekod.periodic_table.DummyData
import com.kekod.periodic_table.R
import com.kekod.periodic_table.view.util.UiUtil
import com.kekod.periodic_table.view.util.UiUtil.Companion.playSound
import com.kekod.periodic_table.viewModel.Controller
import com.kekod.periodic_table.viewModel.adapter.ElementAdapter


//          Code with 🥂
//  ┌──────────────────────────┐
//  │ Created by Tuna UNSAL    │
//  │ ──────────────────────── │
//  │ tuna.maeglini@gmail.com  │
//  │ ──────────────────────── │
//  │    13.09.2021  22:31     │
//  └──────────────────────────┘

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)
        UiUtil.hideSystemUI(window, binding.root)
        Controller.getElements()
        val adapter = ElementAdapter(DummyData.generateElement())
        binding.table.adapter = adapter
        binding.table.layoutManager = GridLayoutManager(applicationContext,9,GridLayoutManager.HORIZONTAL,false)
        binding.table.recycledViewPool.setMaxRecycledViews(0,0)
        Controller.getElements()
        nextQuestion()
    }

    override fun onBackPressed() {
        finishAffinity()
    }

    companion object {

        private const val TAG = "MainActivity"
        private lateinit var binding: ActivityMainBinding

        fun nextQuestion() {
            Log.d(TAG, "nextQuestion: " + Controller.createAsk())
            binding.element = Controller.createAsk()
        }
        fun nextQuestion(confetti : String) {
            Log.d(TAG, "nextQuestion: $confetti")
            binding.element = Controller.createAsk()
            UiUtil.confetti(binding.viewConfetti)
        }

        fun falseAnswer(time: Int, mContext: Context,view: View) {

            var animShake : Animation = AnimationUtils.loadAnimation(mContext, R.anim.shake);
            view.startAnimation(animShake);

            when (time) {
                1 -> {binding.health1.visibility = View.GONE;playSound()}
                2 -> {binding.health2.visibility = View.GONE;playSound()}
                3 -> {
                    Controller.reset()
                    val intent = Intent(mContext, GameOverActivity::class.java)
                    mContext.startActivity(intent)
                }
            }
        }
    }
}