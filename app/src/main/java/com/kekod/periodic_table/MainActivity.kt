package com.kekod.periodic_table

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

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
        setContentView(R.layout.activity_main)

        Log.e("MainActivity", "Hello world!!")

    }
}