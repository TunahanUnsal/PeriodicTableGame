package com.kekod.periodic_table.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.kekod.periodic_table.R
import com.kekod.periodic_table.databinding.ActivityMainBinding
import com.kekod.periodic_table.model.DummyData
import com.kekod.periodic_table.view.util.UiUtil
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

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)
        UiUtil.hideNavigationBar(window)

        val adapter = ElementAdapter(DummyData.generateElement())
        binding.table.adapter = adapter
        binding.table.layoutManager = GridLayoutManager(applicationContext,9,GridLayoutManager.HORIZONTAL,false)
        binding.table.recycledViewPool.setMaxRecycledViews(0,0)

    }

}