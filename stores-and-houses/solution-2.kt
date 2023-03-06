fun main(){
    val A: Array<IntArray> = arrayOf(
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(0, 0, 1, 0, 0),
        intArrayOf(0, 0, 0, 1, 0),
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0),
    )
    solution(1, A)
}

fun checkAround(flagArray: Array<IntArray>, rowPosition: Int, columnPosition: Int, K: Int) {
    flagArray[rowPosition][columnPosition] = 1
    if(K == 0){
        return
    } else {
        if( flagArray.size - 1 >= rowPosition + 1) { //desno
            checkAround(flagArray, rowPosition + 1, columnPosition, K - 1)
        }
        if( flagArray[0].size - 1 >= columnPosition + 1) { //dolje
            checkAround(flagArray, rowPosition, columnPosition + 1, K - 1)
        }
        if(rowPosition != 0) { //lijevo
            checkAround(flagArray, rowPosition - 1, columnPosition, K - 1)
        }
        if(columnPosition != 0) { //gore
            checkAround(flagArray, rowPosition , columnPosition - 1, K - 1)
        }
    }
}

fun compareAvailableAndHouses(A: Array<IntArray>, flagArray: Array<IntArray>): String {
    flagArray.indices.forEach { i ->
        flagArray[i].indices.forEach { j ->
            if(flagArray[i][j] == 0) {
                if (A[i][j] == 1) {
                    return "Fail"
                }
            }
        }
    }
    return "Success"
}

fun fillWithZeros( flagArray: Array<IntArray> ){
    flagArray.indices.forEach { i ->
        flagArray[i].indices.forEach { j ->
            flagArray[i][j] = 0
        }
    }
}

fun solution(K: Int, A: Array<IntArray>): Int {
    val flagArray: Array<IntArray> = Array(A.size) { i ->
        IntArray(A[0].size)
    }

    var counter = 0

    flagArray.indices.forEach { i ->
        flagArray[i].indices.forEach { j ->
            fillWithZeros(flagArray)
            checkAround(flagArray, i,j, K)
            if( compareAvailableAndHouses(A, flagArray) == "Success" ) {
                counter++
                println("$i $j")
            }
        }
    }

    return counter
}
