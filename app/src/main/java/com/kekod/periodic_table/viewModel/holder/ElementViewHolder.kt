package com.kekod.periodic_table.viewModel.holder;

import android.content.Context
import android.graphics.Color
import android.graphics.Color.red
import android.os.Build
import android.transition.Slide
import android.transition.TransitionManager
import android.util.Log
import android.view.*
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import androidx.recyclerview.widget.RecyclerView
import com.kekod.periodic_table.R
import com.kekod.periodic_table.model.ElementModel
import com.kekod.periodic_table.view.activity.MainActivity
import com.kekod.periodic_table.view.util.UiUtil
import com.kekod.periodic_table.viewModel.Controller
import org.w3c.dom.Text
import android.content.DialogInterface




//          Code with 🥂
//  ┌──────────────────────────┐
//  │ Created by Tuna UNSAL    │
//  │ ──────────────────────── │
//  │ tuna.maeglini@gmail.com  │            
//  │ ──────────────────────── │
//  │    13.09.2021  23:37     │
//  └──────────────────────────┘

class ElementViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    @RequiresApi(Build.VERSION_CODES.M)
    fun bind(elementModel: ElementModel) {
        val elementSymbolText = itemView.findViewById<TextView>(R.id.elementSymbol)
        val elementNumberText = itemView.findViewById<TextView>(R.id.elementNumber)
        val elementNameText = itemView.findViewById<TextView>(R.id.elementName)
        if (elementModel.elementNumber != 0){
            elementNumberText.text = elementModel.elementNumber.toString()
        }
        if(elementModel.elementNumber != 0 && elementModel.knew==1){
            elementNameText.text = elementModel.elementName
            elementSymbolText.text = elementModel.elementSymbol
        }
        val elementColorImage = itemView.findViewById<FrameLayout>(R.id.colorFrame)

        when (elementModel.elementType) {
            1 -> elementColorImage.setBackgroundColor(itemView.context.getColor(R.color.red))
            2 -> elementColorImage.setBackgroundColor(itemView.context.getColor(R.color.blue))
            3 -> elementColorImage.setBackgroundColor(itemView.context.getColor(R.color.yellow))
            4 -> elementColorImage.setBackgroundColor(itemView.context.getColor(R.color.green))
            0 -> elementColorImage.setBackgroundColor(itemView.context.getColor(R.color.transparent))
        }
        itemView.setOnClickListener {
            Log.d("TAG", "click: ${elementModel.elementName}")
            if (elementModel == Controller.selectedElement){  //true
                showPopup(itemView,elementModel)
                UiUtil.applyDim(itemView.rootView as ViewGroup,1f)
                elementModel.knew = 1
                elementNameText.text = elementModel.elementName
                elementSymbolText.text = elementModel.elementSymbol
                MainActivity.nextQuestion()
            }
            else{
                Controller.count = Controller.count + 1
                Log.d("TAG", "count: " + Controller.count)
                MainActivity.falseAnswer(Controller.count,itemView.context)
            }
        }
    }
    private fun showPopup(view: View, elementModel: ElementModel) {
        val inflater = view.context.getSystemService(AppCompatActivity.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val pw = PopupWindow(inflater.inflate(R.layout.element_detail_pop_up, null, false), 1200, 900, true)
        pw.showAtLocation(view, Gravity.CENTER, 0, 0)

        val elementNameText = pw.contentView.findViewById<TextView>(R.id.elementName)
        val elementNumberText = pw.contentView.findViewById<TextView>(R.id.elementNumber)
        val elementSymbolText = pw.contentView.findViewById<TextView>(R.id.elementSymbol)

        elementNameText.text = elementModel.elementName
        elementNumberText.text = elementModel.elementNumber.toString()
        elementSymbolText.text = elementModel.elementSymbol

        pw.setOnDismissListener {
            UiUtil.clearDim(itemView.rootView as ViewGroup)
        }

    }
}