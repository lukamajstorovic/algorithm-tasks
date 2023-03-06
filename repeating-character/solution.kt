fun solution(S: String): String {
    for ( i in 0..(S.length-1) ) {
        for ( j in (i+1)..(S.length-1) ) {
            if ( S[i] == S[j] ) {
                return S[i].toString()
            }
        }
    }
    return ""
}