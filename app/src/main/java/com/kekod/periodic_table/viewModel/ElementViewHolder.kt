package com.kekod.periodic_table.viewModel;

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kekod.periodic_table.R
import com.kekod.periodic_table.model.ElementModel

//          Code with 🥂
//  ┌──────────────────────────┐
//  │ Created by Tuna UNSAL    │
//  │ ──────────────────────── │
//  │ tuna.maeglini@gmail.com  │            
//  │ ──────────────────────── │
//  │    13.09.2021  23:37     │
//  └──────────────────────────┘

class ElementViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(elementModel: ElementModel) {
        val textView = itemView.findViewById<TextView>(R.id.deneme)
        textView.text = elementModel.elementName
    }
}