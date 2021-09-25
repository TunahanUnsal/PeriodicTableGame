package com.kekod.periodic_table.view.util

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.view.*
import android.widget.PopupWindow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.kekod.periodic_table.R
import com.kekod.periodic_table.model.ElementModel
import android.media.ToneGenerator
import android.media.AudioManager
import nl.dionsegijn.konfetti.KonfettiView
import nl.dionsegijn.konfetti.models.Size
import android.graphics.Movie
import java.io.InputStream

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
        fun hideSystemUI(window : Window,mainContainer : View) { //for bottom UI hide
            WindowCompat.setDecorFitsSystemWindows(window, false)
            WindowInsetsControllerCompat(window, mainContainer).let { controller ->
                controller.hide(WindowInsetsCompat.Type.systemBars())
                controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        }
        @JvmStatic
        fun applyDim(parent: ViewGroup, dimAmount: Float) {
            val dim: Drawable = ColorDrawable(Color.BLACK)
            dim.setBounds(0, 0, parent.width, parent.height)
            dim.alpha = (100 * dimAmount).toInt()
            val overlay = parent.overlay
            overlay.add(dim)
        }
        @JvmStatic
        private fun clearDim(parent: ViewGroup) {
            val overlay = parent.overlay
            overlay.clear()
        }
        @JvmStatic
        fun showPopup(itemView: View, elementModel: ElementModel, viewGroup: ViewGroup) {
            val inflater = itemView.context.getSystemService(AppCompatActivity.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val pw = PopupWindow(inflater.inflate(R.layout.element_detail_pop_up,viewGroup, false),ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true)
            pw.showAtLocation(itemView, Gravity.CENTER, 0, 0)

            val elementNameText = pw.contentView.findViewById<TextView>(R.id.elementName)
            val elementNumberText = pw.contentView.findViewById<TextView>(R.id.elementNumber)
            val elementSymbolText = pw.contentView.findViewById<TextView>(R.id.elementSymbol)

            elementNameText.text = elementModel.elementName
            elementNumberText.text = elementModel.elementNumber.toString()
            elementSymbolText.text = elementModel.elementSymbol

            pw.setOnDismissListener {
                clearDim(itemView.rootView as ViewGroup)
            }
        }
        @JvmStatic
        fun playSound(){
            val toneGen1 = ToneGenerator(AudioManager.STREAM_MUSIC, 100)
            toneGen1.startTone(ToneGenerator.TONE_CDMA_HIGH_SLS, 150)
        }
        @JvmStatic
        fun confetti(confettiView : KonfettiView){

            confettiView.build()
                .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
                .setDirection(0.0, 359.0)
                .setSpeed(1f, 5f)
                .setFadeOutEnabled(true)
                .setTimeToLive(500L)
                .addSizes(Size(12, 5f))
                .setPosition(-50f, confettiView.width + 50f, -50f, -50f)
                .streamFor(300, 5000L)
        }

        @JvmStatic
        fun getDuration(context: Context, id: Int): Int {
            val temp: InputStream = context.resources.openRawResource(id)
            val movie = Movie.decodeStream(temp)  //deprecation i know but i can not find new one in AnimationDrawable
            return movie.duration()
        }
    }
}