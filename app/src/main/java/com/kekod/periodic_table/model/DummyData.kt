package com.kekod.periodic_table.model;

//          Code with 🥂
//  ┌──────────────────────────┐
//  │ Created by Tuna UNSAL    │
//  │ ──────────────────────── │
//  │ tuna.maeglini@gmail.com  │            
//  │ ──────────────────────── │
//  │    15.09.2021  22:35     │
//  └──────────────────────────┘

object DummyData {

    fun generateElement() : List<ElementModel>{

        val elementList : MutableList<ElementModel> = mutableListOf()

        //0-invisible   1-red   2-blue   3-yellow    4-green

        //col 1
        val element1 = ElementModel(
            elementNumber = 1,
            elementName = "Hydrogen",
            elementSymbol = "H",
            elementType = 1,
        )
        val element2 = ElementModel(
            elementNumber = 3,
            elementName = "Lithium",
            elementSymbol = "Li",
            elementType = 1,
        )
        val element3 = ElementModel(
            elementNumber = 11,
            elementName = "Sodium",
            elementSymbol = "Na",
            elementType = 1,
        )
        val element4 = ElementModel(
            elementNumber = 19,
            elementName = "Potassium",
            elementSymbol = "K",
            elementType = 1,
        )
        val element5 = ElementModel(
            elementNumber = 37,
            elementName = "Rubidium",
            elementSymbol = "Rb",
            elementType = 1,
        )
        val element6 = ElementModel(
            elementNumber = 55,
            elementName = "Cesium",
            elementSymbol = "Cs",
            elementType = 1,
        )
        val element7 = ElementModel(
            elementNumber = 87,
            elementName = "Francium",
            elementSymbol = "Fr",
            elementType = 1,
        )
        val element8 = ElementModel(
            elementNumber = 0,
            elementName = "",
            elementSymbol = "",
            elementType = -1,
        )
        val element9 = ElementModel(
            elementNumber = 0,
            elementName = "",
            elementSymbol = "",
            elementType = -1,
        )
        //col 2
        val element10 = ElementModel(
            elementNumber = 0,
            elementName = "",
            elementSymbol = "",
            elementType = -1,
        )
        val element11 = ElementModel(
            elementNumber = 4,
            elementName = "Beryllium",
            elementSymbol = "Be",
            elementType = 1,
        )
        val element12 = ElementModel(
            elementNumber = 12,
            elementName = "Magnesium",
            elementSymbol = "Mg",
            elementType = 1,
        )
        val element13 = ElementModel(
            elementNumber = 20,
            elementName = "Aluminum",
            elementSymbol = "Ca",
            elementType = 1,
        )
        val element14 = ElementModel(
            elementNumber = 38,
            elementName = "Strontium",
            elementSymbol = "Sr",
            elementType = 1,
        )
        val element15 = ElementModel(
            elementNumber = 56,
            elementName = "Barium",
            elementSymbol = "Ba",
            elementType = 1,
        )
        val element16 = ElementModel(
            elementNumber = 88,
            elementName = "Radium",
            elementSymbol = "Ra",
            elementType = 1,
        )
        val element17 = ElementModel(
            elementNumber = 0,
            elementName = "",
            elementSymbol = "",
            elementType = -1,
        )
        val element18 = ElementModel(
            elementNumber = 0,
            elementName = "",
            elementSymbol = "",
            elementType = -1,
        )
        //col 3
        val element19 = ElementModel(
            elementNumber = 0,
            elementName = "",
            elementSymbol = "",
            elementType = -1,
        )
        val element20 = ElementModel(
            elementNumber = 0,
            elementName = "",
            elementSymbol = "",
            elementType = -1,
        )
        val element21 = ElementModel(
            elementNumber = 0,
            elementName = "",
            elementSymbol = "",
            elementType = -1,
        )
        val element22 = ElementModel(
            elementNumber = 21,
            elementName = "Scandium",
            elementSymbol = "Sc",
            elementType = 2,
        )
        val element23 = ElementModel(
            elementNumber = 39,
            elementName = "Yttrium",
            elementSymbol = "Y",
            elementType = 2,
        )
        val element24 = ElementModel(
            elementNumber = 71,
            elementName = "Lutetium",
            elementSymbol = "Lu",
            elementType = 2,
        )
        val element25 = ElementModel(
            elementNumber = 103,
            elementName = "Lawrencium",
            elementSymbol = "Lr",
            elementType = 2,
        )
        val element26 = ElementModel(
            elementNumber = 57,
            elementName = "Lanthanum",
            elementSymbol = "La",
            elementType = 4,
        )
        val element27 = ElementModel(
            elementNumber = 89,
            elementName = "Actinium",
            elementSymbol = "Ac",
            elementType = 4,
        )
        //col4
















        elementList.add(element1)
        elementList.add(element2)
        elementList.add(element3)
        elementList.add(element4)
        elementList.add(element5)
        elementList.add(element6)
        elementList.add(element7)
        elementList.add(element8)
        elementList.add(element9)
        elementList.add(element10)
        elementList.add(element11)
        elementList.add(element12)
        elementList.add(element13)
        elementList.add(element14)
        elementList.add(element15)
        elementList.add(element16)
        elementList.add(element17)
        elementList.add(element18)
        elementList.add(element19)
        elementList.add(element20)
        elementList.add(element21)
        elementList.add(element22)
        elementList.add(element23)
        elementList.add(element24)
        elementList.add(element25)
        elementList.add(element26)
        elementList.add(element27)


        return elementList
    }

}