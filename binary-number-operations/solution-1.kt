fun main(){
    solution("11011")
}

fun solution(S: String): Int {
    var counter_0 = 0
    var counter_1 = 0
    for(character in S) {
        if(character == '1') {
            counter_1 += 2
        } else {
            counter_0 += 1
        }
    }
    println(counter_1 + counter_0 - 1)
    return counter_1 + counter_0 - 1
}
