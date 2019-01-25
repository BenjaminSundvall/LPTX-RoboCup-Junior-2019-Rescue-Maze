package com.lophtix.mapping

import kotlin.math.pow

class Math{

    val threshHold = 1f
    val pointDensity = 2f

    fun lineSplitter(dataSet : Array<Coordinate>) : MutableList<Wall>{
        var counter = -1

        var wallCashe : Array<Wall>? = null
        var walls : MutableList<Wall>? = null
        var pointHightCashe : Array<Float>? = null

        wallCashe!!.plus(Wall(dataSet))

        while(counter<wallCashe.size){
            counter += 1
            if ((wallCashe[counter].direction!! <= 1f) and (wallCashe[counter].direction!! >= -1f)){
                var wall = wallCashe[counter]
                for (point in wall.points) {
                    var difference = point.x - wall.first.x
                    var pointCashe = Coordinate(point.x- difference, point.y - difference*wall.direction!!)
                    pointHightCashe!!.plus((pointCashe.y-wall.first.y).pow(2))
                }
                var highestValue : Float = 0f
                for (value in pointHightCashe!!){
                    if (value > highestValue){
                        highestValue = value
                    }
                    counter += 1
                }
                if (highestValue > threshHold){
                    var wallOne : Array<Coordinate>? = null
                    var wallTwo : Array<Coordinate>? = null
                    for (i in 0 until pointHightCashe.size ) {
                        if(i <= highestValue){
                            wallOne!!.plus(dataSet[i])
                        }; if(i>= highestValue) {
                            wallTwo!!.plus(dataSet[i])
                        }
                    }
                    wallCashe.plus(Wall(wallOne!!))
                    wallCashe.plus(Wall(wallTwo!!))
                } else {
                    walls!!.plus(wall)
                }
            }
        }

        for (wall in walls!!){
            var density = wall.length/wall.points.size
            if(density < pointDensity){
                walls.remove(wall)
            }
        }
        return walls
    }
}

data class Coordinate(val x : Float,val y : Float){

}

data class Wall(val points : Array<Coordinate>){

    val first = points.first()
    val last = points.last()

    val length = ((last.x-first.x).pow(2)+(last.y-first.y).pow(2)).pow(1/2)

    var direction : Float? = null

    init {
        if (last.x-first.x != 0f) {
            val direction = (last.y-first.y)/(last.x-first.x)
        }
    }
}