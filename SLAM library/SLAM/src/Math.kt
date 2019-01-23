import kotlin.math.pow

class Math{

    val threshHold = 1f

    fun lineSplitter(dataSet : Array<Coordinate>) : Array<Wall>{
        var done = false
        var counter = -1

        var wallCashe : Array<Wall>? = null
        var walls : Array<Wall>? = null
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
                var highestPosition : Int = 0
                for (value in pointHightCashe!!){
                    if (value > highestValue){
                        highestValue = value
                        highestPosition = counter
                    }
                    counter += 1
                }
                if (highestValue > threshHold){
                    var wallOne : Array<Coordinate>? = null
                    var wallTwo : Array<Coordinate>? = null
                    for (i in 0 until pointHightCashe.size ) {
                        if(i <= threshHold){
                            wallOne!!.plus(dataSet[i])
                        }; if(i>= threshHold) {
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

        return walls!!
    }

    /*fun linReg(dataSet : Array<Coordinate>) : Vector{

        var counter = 0

        var A = 0f
        var B = 0f
        var C = 0f
        var D = 0f
        var N = 0f

        for(coordinate in dataSet){
            var x = coordinate.x
            var y = coordinate.y

            A += x*y
            B += x*x
            C += x
            D += y
            N += 1

            counter += 1
        }

        var k : Float = ((N*A)-(C*D))/((N*B)-(C*C))
        var m : Float = ((B*D)-(A*C))/((N*B)-(C*C))
        var l : Float = ((dataSet[counter-1].x - dataSet[0].x).pow(2))+((dataSet[counter-1].y - dataSet[0].y).pow(2)).pow(1/2)

        return Vector(k,l,m)

    }*/
}

data class Coordinate(val x : Float,val y : Float){

}

data class Wall(val points : Array<Coordinate>){

    val first = points.first()
    val last = points.last()

    var direction : Float? = null

    init {
        if (last.x-first.x != 0f) {
            val direction = (last.y-first.y)/(last.x-first.x)
        }
    }
}