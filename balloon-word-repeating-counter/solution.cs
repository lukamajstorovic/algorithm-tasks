using System;

class Solution {
    public int solution(string S) {
        // write your code in C# 6.0 with .NET 4.5 (Mono)
        int result = 0;
        int B = 0;
        int A = 0;
        int L = 0;
        int O = 0;
        int N = 0;
        foreach(char letter in S){
            Console.WriteLine(letter);
            if(letter == 'B'){
                B++;
            }else if(letter == 'A'){
                A++;
            }else if(letter == 'L'){
                L++;
            }else if(letter == 'O'){
                O++;
            }else if(letter == 'N'){
                N++;
            }
        }
        while(  B >= 1 &&
                A >= 1 &&
                L >= 2 &&
                O >= 2 &&
                N >= 1)
                {
                    B -= 1;
                    A -= 1;
                    L -= 2;
                    O -= 2;
                    N -= 1;
                    result++;
                }

        return result;
    }
}
