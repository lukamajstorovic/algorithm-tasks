using System;
using System.Collections.Generic;
using System.Linq;

class Solution {
    public string solution(string[] A, string[] B, string P) {
        List<string> names = new List<string>();
        int i = 0;
        string result = "";
        foreach(string number in B){
            if(number.Contains(P)){
                names.Add(A[i]);
            }
            i++;
        }
        foreach(string name in names){
            Console.WriteLine(name);
        }
        if(!names.Any()){
            return "NO CONTACT";
        }else if(names.Count == 1){
            return names[0];
        }
        
        foreach(string name in names){
            for(i = 0; i < names.Count; i++){
                for(int j = 0; j < name.Length; j++){
                    if(name[j] <= names[i][j] && name != names[i] &&
                    result != name){
                        result = name;
                        break;
                    }else if(name[j] >= names[i][j] && name != names[i]
                    && result != names[i]){
                        result = names[i];
                        break;
                    }
                }
            } 
        }
        return result;
    }
}
