package com.kekod.periodic_table.view.util;

import android.graphics.Color
import android.view.View
import android.view.Window
import android.view.ViewGroupOverlay

import android.graphics.drawable.ColorDrawable

import android.graphics.drawable.Drawable

import android.view.ViewGroup

import androidx.annotation.NonNull




//          Code with 🥂
//  ┌──────────────────────────┐
//  │ Created by Tuna UNSAL    │
//  │ ──────────────────────── │
//  │ tuna.maeglini@gmail.com  │            
//  │ ──────────────────────── │
//  │    17.09.2021  00:55     │
//  └──────────────────────────┘

class UiUtil {
    companion object{
        @JvmStatic
        fun hideNavigationBar(window : Window) {
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        }
        fun applyDim(parent: ViewGroup, dimAmount: Float) {
            val dim: Drawable = ColorDrawable(Color.BLACK)
            dim.setBounds(0, 0, parent.width, parent.height)
            dim.alpha = (100 * dimAmount).toInt()
            val overlay = parent.overlay
            overlay.add(dim)
        }
        fun clearDim(parent: ViewGroup) {
            val overlay = parent.overlay
            overlay.clear()
        }
    }

}