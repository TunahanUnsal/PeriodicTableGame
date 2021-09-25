package com.kekod.periodic_table.viewModel.holder

import android.os.Build
import android.util.Log
import android.view.*
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.kekod.periodic_table.R
import com.kekod.periodic_table.model.ElementModel
import com.kekod.periodic_table.view.activity.MainActivity
import com.kekod.periodic_table.view.util.UiUtil
import com.kekod.periodic_table.view.util.UiUtil.Companion.showPopup
import com.kekod.periodic_table.viewModel.Controller

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
                showPopup(itemView,elementModel,itemView.rootView as ViewGroup)
                UiUtil.applyDim(itemView.rootView as ViewGroup,1f)
                elementModel.knew = 1
                elementNameText.text = elementModel.elementName
                elementSymbolText.text = elementModel.elementSymbol
                MainActivity.nextQuestion("hey")
            }
            else{
                Controller.count = Controller.count + 1
                Log.d("TAG", "count: " + Controller.count)
                MainActivity.falseAnswer(Controller.count,itemView.context)
            }
        }
    }

}