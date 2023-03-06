fun solution(S: String): Int {
    var number: BigInteger = BigInteger(S, 2)
    var operationCounter: Int = 0
    while( number != BigInteger("0") ) {
        if(number % BigInteger("2") == BigInteger("0")) {
            number /= BigInteger("2")
        } else{ 
            number -= BigInteger("1")
        }
        operationCounter++
    }
    return operationCounter
}

/*
fun convertFromBinaryToDecimal(S: String): String {
    var exponent: Int = 0
    var decimalResult: BigInteger = BigInteger("0")
    for( i in (S.length-1) downTo 0 ) {
        if(S[i] == '1') {
            decimalResult += BigInteger(2f.pow(exponent).toLong().toString())
        }
        exponent++
    }
    return decimalResult.toString()
}
*/
