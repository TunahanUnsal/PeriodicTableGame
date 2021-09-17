package com.kekod.periodic_table.viewModel;

import android.util.Log
import com.kekod.periodic_table.model.DummyData
import com.kekod.periodic_table.model.ElementModel

//          Code with 🥂
//  ┌──────────────────────────┐
//  │ Created by Tuna UNSAL    │
//  │ ──────────────────────── │
//  │ tuna.maeglini@gmail.com  │            
//  │ ──────────────────────── │
//  │    17.09.2021  19:16     │
//  └──────────────────────────┘

class Controller {

    companion object{

        private var elementList = listOf<ElementModel>()
        lateinit var selectedElement : ElementModel
        var count : Int = 0

        fun getElements(){

            elementList = DummyData.generateElement()

        }

        fun createAsk() : String {

            var random = (elementList.indices).random()
            Log.d("TAG", "createAsk: $random")
            if (elementList[random].elementType!=-1){
                val symbol = elementList[random].elementSymbol
                selectedElement = elementList[random]
                return symbol
            }
            while (elementList[random].elementSymbol == ""){
                 Log.d("TAG", "createAsk:girdi ")
                 random = (elementList.indices).random()
            }
            val symbol = elementList[random].elementSymbol
            selectedElement = elementList[random]
            return symbol
        }
        fun reset(){
            elementList = listOf<ElementModel>()
            count = 0
        }
    }

}