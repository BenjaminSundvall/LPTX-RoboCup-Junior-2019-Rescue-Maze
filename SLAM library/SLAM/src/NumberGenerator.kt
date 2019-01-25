package com.lophtix.main

import com.lophtix.mapping.*

class Main{

    var dataSet : Array<Coordinate>? = null

    fun main(args: Array<String>){
        for (i in 1..32){
            dataSet!!.plus(Coordinate(0f,i.toFloat()))
            dataSet!!.plus(Coordinate(i.toFloat(),0f))
        }
        print(Math().lineSplitter(dataSet!!))
    }
}
