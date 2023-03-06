import kotlin.math.abs

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

fun findHouseIndexes(rowIndexes: MutableList<Int>, columnIndexes: MutableList<Int>, A: Array<IntArray>) {
    A.indices.forEach { i ->
        A[i].indices.forEach { j ->
            if(A[i][j] == 1) {
                rowIndexes.add(i)
                columnIndexes.add(j)
            }
        }
    }
}

fun isSpotEligible(rowPosition: Int, columnPosition: Int, K: Int, rowIndexes: MutableList<Int>, columnIndexes: MutableList<Int>): Boolean {
    rowIndexes.indices.forEach { index ->
        if( abs(rowPosition - rowIndexes[index]) + abs(columnPosition - columnIndexes[index]) > K ) {
            return false
        }
    }
    return true
}

fun solution(K: Int, A: Array<IntArray>): Int {

    val rowIndexes: MutableList<Int> = mutableListOf()
    val columnIndexes: MutableList<Int> = mutableListOf()

    var counter = 0

    findHouseIndexes(rowIndexes, columnIndexes, A)

    A.indices.forEach { i ->
        A[i].indices.forEach { j ->
            if(isSpotEligible(i, j, K, rowIndexes, columnIndexes)) {
                print("$i, $j")
                counter++
                println()
            }
        }
    }

    return counter
}
