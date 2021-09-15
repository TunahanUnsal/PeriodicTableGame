package com.kekod.periodic_table.view.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.kekod.periodic_table.R
import com.kekod.periodic_table.databinding.ActivityMainBinding
import com.kekod.periodic_table.model.DummyData
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

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)

        val adapter = ElementAdapter(DummyData.generateElement())
        binding.table.adapter = adapter
        binding.table.layoutManager = GridLayoutManager(applicationContext,9,GridLayoutManager.HORIZONTAL,false)



    }
}