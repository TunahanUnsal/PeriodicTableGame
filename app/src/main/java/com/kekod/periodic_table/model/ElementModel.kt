package com.kekod.periodic_table.model;

//          Code with 🥂
//  ┌──────────────────────────┐
//  │ Created by Tuna UNSAL    │
//  │ ──────────────────────── │
//  │ tuna.maeglini@gmail.com  │            
//  │ ──────────────────────── │
//  │    13.09.2021  23:33     │
//  └──────────────────────────┘

data class ElementModel(
    val elementNumber : Int,
    val elementName: String,
    val elementSymbol : String,
    val elementType : Int,    //  (-1) invisible   (1) red   (2) blue   (3) yellow    (4) green
)
