using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

namespace PizzaCutter
{
    class Solution {

        public static int FormatAngle(int angle) {
            if (angle < 0) {
                angle += (int)360*(int)Math.Ceiling((double)Math.Abs(angle) / (double)360);
                if(angle >= 180) {
                    angle -= 180;
                }
            }else if (angle > 360) {
                angle -= (int)360*(int)Math.Floor((double)Math.Abs(angle) / (double)360);
            }
            if(angle >= 180) {
                angle -= 180;
            }
            return angle;
        }

        public static List<int> GetInput() {

            int testCasesNumber = Int32.Parse(Console.ReadLine());
        
            string input;
        
            string numberInString = "";

            List<int> numberInInt = new List<int>();

            numberInInt.Add(testCasesNumber);

                for(int i = 0; i < testCasesNumber; i++) {
                    input = Console.ReadLine();
                    for (int j = 0; j < input.Length; j++)
                    {
                        if(input[j] == 32 || input[j] == 10) {
                            numberInInt.Add(Int32.Parse(numberInString));
                            numberInString = "";
                        }else if (Char.IsDigit(input[j]) || input[j] == '-'){
                            numberInString += input[j];
                            if(j == input.Length - 1) {
                                numberInInt.Add(Int32.Parse(numberInString));
                                numberInString = "";
                            }
                        }
                    }
                }

                return numberInInt;
            }

        static void Main(String[] args) {

            List<int> numberInInt;

            List<List<int>> finalResult = new List<List<int>>();

            List<int> result = new List<int>();

            numberInInt = Solution.GetInput();

            int counter = 0;
            int outerCounter = 0;

            finalResult.Add(new List<int>());
            finalResult[0].Add(numberInInt[0]);

            for(int i = 0; i < numberInInt[0]; i++) {
                counter = 0;
                for(int j = 0; j < numberInInt[ 1 + outerCounter]; j++) {
                    result.Add(numberInInt[2 + outerCounter + counter]);
                    counter++;
                }
                outerCounter += counter + 1;

                finalResult.Add(new List<int>());

                for(int j = 0; j < result.Count(); j++) {
                    
                    finalResult[i + 1].Add(result[j]);
                }
                result.Clear();
            }

            List<List<int>> anglesFormatted = new List<List<int>>();

            int angle;

            finalResult.RemoveAt(0);

            for(int i = 0; i < finalResult.Count(); i++) {
                anglesFormatted.Add(new List<int>());
                for(int j = 0; j < finalResult[i].Count(); j++) {
                    angle = Solution.FormatAngle(finalResult[i][j]);
                    if(!anglesFormatted[i].Contains(angle)) {
                        anglesFormatted[i].Add(angle);
                    }
                }
            }
            int finalAngles;

            for(int i = 0; i < anglesFormatted.Count(); i++) {
                
                finalAngles = anglesFormatted[i].Count()*2;

                if(finalAngles == 0){
                    Console.WriteLine("1");
                }else{
                    Console.WriteLine(finalAngles);
                }
            }
        }
    }
}
