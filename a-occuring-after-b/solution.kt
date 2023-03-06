fun solution(S: String): Boolean {
    var flagStartB = false;
    for (character in S ) {
        if (character == 'a') {
            if(flagStartB) {
                return false
            }
        }else if (!flagStartB) {
            flagStartB = true
        }
    }
    return true
}
