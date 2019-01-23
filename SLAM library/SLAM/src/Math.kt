import kotlin.math.pow

class Math{

    fun lineSplitter(){

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

    fun furthestPoint(dataSet : Array<Double>, line : Array<Double>){

    }
}

class Coordinate(xCord : Float, yCord: Float){

    var x : Float = 0f
    var y : Float = 0f

    init{
        this.x = xCord
        this.y = yCord
    }
}

class spaceWall(firstIn : Coordinate, secondIn : Coordinate){
    var first : Coordinate? = null
    var second : Coordinate? = null

    init {
        this.first = firstIn
        this.second = secondIn
    }
}