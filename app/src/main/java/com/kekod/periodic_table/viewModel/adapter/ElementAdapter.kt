package com.kekod.periodic_table.viewModel.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.kekod.periodic_table.R
import com.kekod.periodic_table.model.ElementModel
import com.kekod.periodic_table.viewModel.holder.ElementViewHolder

//          Code with 🥂
//  ┌──────────────────────────┐
//  │ Created by Tuna UNSAL    │
//  │ ──────────────────────── │
//  │ tuna.maeglini@gmail.com  │            
//  │ ──────────────────────── │
//  │    13.09.2021  23:37     │
//  └──────────────────────────┘

class ElementAdapter(private val itemList : List<ElementModel>): RecyclerView.Adapter<ElementViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElementViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.card_view,parent,false)

        return ElementViewHolder(itemView)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: ElementViewHolder, position: Int) {
            val elementModel = itemList[position]
            holder.bind(elementModel)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}