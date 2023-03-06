fun main(){
    val A: Array<IntArray> = arrayOf(
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(0, 0, 1, 0, 0),
        intArrayOf(0, 0, 0, 1, 0),
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0),
    )
    solution(2, A)
}

fun checkAround(numberArray: Array<IntArray>, booleanArray: Array<BooleanArray>, rowPosition: Int, columnPosition: Int, K: Int) {
    if(booleanArray[rowPosition][columnPosition] == false) {
        numberArray[rowPosition][columnPosition] += 1
        booleanArray[rowPosition][columnPosition] = true
    }
    if(K == 0){
        return
    } else {
        if( numberArray.size - 1 >= rowPosition + 1) { //desno
            checkAround(numberArray, booleanArray, rowPosition + 1, columnPosition, K - 1)
        }
        if( numberArray[0].size - 1 >= columnPosition + 1) { //dolje
            checkAround(numberArray, booleanArray, rowPosition, columnPosition + 1, K - 1)
        }
        if(rowPosition != 0) { //lijevo
            checkAround(numberArray, booleanArray, rowPosition - 1, columnPosition, K - 1)
        }
        if(columnPosition != 0) { //gore
            checkAround(numberArray, booleanArray, rowPosition , columnPosition - 1, K - 1)
        }
    }
}

fun fillWithZeros( numberArray: Array<IntArray> ){
    numberArray.indices.forEach { i ->
        numberArray[i].indices.forEach { j ->
            numberArray[i][j] = 0
        }
    }
}

fun fillWithFalse( booleanArray: Array<BooleanArray> ){
    booleanArray.indices.forEach { i ->
        booleanArray[i].indices.forEach { j ->
            booleanArray[i][j] = false
        }
    }
}

fun solution(K: Int, A: Array<IntArray>): Int {
    val numberArray: Array<IntArray> = Array(A.size) { i ->
        IntArray(A[0].size)
    }

    val booleanArray: Array<BooleanArray> = Array(A.size) { i ->
        BooleanArray(A[0].size)
    }

    var housesCounter = 0
    var suitableStoreSpacesCounter = 0

    fillWithZeros(numberArray)

    numberArray.indices.forEach { i ->
        numberArray[i].indices.forEach { j ->
            if(A[i][j] == 1) {
                fillWithFalse(booleanArray)
                checkAround(numberArray, booleanArray, i,j, K)
                numberArray[i][j] = 0 //remove the number from the place of house (store can't be there)
                housesCounter++
            }
        }
    }

    numberArray.indices.forEach { i ->
        numberArray[i].indices.forEach { j ->
            print(numberArray[i][j].toString())
            if(numberArray[i][j] == housesCounter) {
                suitableStoreSpacesCounter++
                print("t\t")
            }else{
                print("\t")
            }
        }
        println()
    }

    return suitableStoreSpacesCounter
}
