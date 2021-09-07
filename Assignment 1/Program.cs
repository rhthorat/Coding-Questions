using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;

namespace DIS_Assignmnet1_Fall_2021
{
    class Program
    {
        static void Main(string[] args)
        {
            //Question 1
            Console.WriteLine("Q1 : Enter the string:");
            string s = Console.ReadLine();
            bool pos = HalvesAreAlike(s);
            if (pos)
            {
                Console.WriteLine("Both Halfs of the string are alike");
            }
            else
            {
                Console.WriteLine("Both Halfs of the string are not alike");
            }

            Console.WriteLine();

            //Question 2:
            Console.WriteLine(" Q2 : Enter the string to check for pangram:");
            string s1 = Console.ReadLine();
            bool flag = CheckIfPangram(s1);
            if (flag)
            {
                Console.WriteLine("Yes, the given string is a pangram");
            }
            else
            {
                Console.WriteLine("No, the given string is not a pangram");
            }
            Console.WriteLine();

            //Question 3:
            int[,] arr = new int[,] { { 1, 2, 3 }, { 3, 2, 1 } };
            int Wealth = MaximumWealth(arr);
            Console.WriteLine("Q3:");
            Console.WriteLine("Richest person has a wealth of {0}", Wealth);


            //Question 4:
            string jewels = "aA";
            string stones = "aAAbbbb";
            Console.WriteLine("Q4:");
            int num = NumJewelsInStones(jewels, stones);
            Console.WriteLine("the number of stones you have that are also jewels are {0}:", num);

            Console.WriteLine();

            //Question 5:
            Console.WriteLine("Q5:");
            String word2 = "aiohn";
            int[] indices = { 3, 1, 4, 2, 0 };
            String rotated_string = RestoreString(word2, indices);
            Console.WriteLine("The Final string after rotation is "+ rotated_string);


            //Quesiton 6:
            Console.WriteLine("Q6: Enter the sentence to convert:");
            int[] nums = { 0, 1, 2, 3, 4 };
            int[] index = { 0, 1, 2, 2, 1 };
            int[] target = CreateTargetArray(nums, index);
            Console.WriteLine("Target array  for the Given array's is:");
            for (int i = 0; i < target.Length; i++)
            {
                Console.Write(target[i] + "\t");
            }
            Console.WriteLine();

        }



        /* 
        <summary>
        You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the first half and b be the second half.
        Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and lowercase letters.
        Return true if a and b are alike. Otherwise, return false

        Example 1:
        Input: s = "book"
        Output: true
        Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.
        </summary>
        */

        //Start of HalvesAreAlike function
        private static bool HalvesAreAlike(string s)
        {
            try
            {
                /* <Summary of logic>
                 first we divide the given string into 2 equal halves using string function Substring(). Then we traverse through each char of both halves using foreach loop. If string
                 "aeiou" contains the char then the vowelCounter is incremented by 1. At the end we check if both the vowelCounters for both the halves of given string are equal. If yes then we return
                 boolean true, else we return boolean false.
                 */
                s = s.ToLower();
                int length = s.Length;
                int midPoint = length / 2; //to get the mid index of the string
                string a = s.Substring(0, midPoint);
                string b = s.Substring(midPoint);
                int totalAVowels = 0, totalBVowels = 0;
                foreach (char c in a) {
                    if ("aeiou".Contains(c)) //Contains is also a string method to check if "aeiou" has the char in it
                        totalAVowels++;
                } // end of the loop
                foreach (char c in b) {
                    if ("aeiou".Contains(c))
                        totalBVowels++;
                } //end of the loop
                if (totalAVowels == totalBVowels)
                    return true;
                else
                    return false;
            }
            catch (Exception)
            {
                throw;
            }

        } //End of HalvesAreAlike function




        /* 
 <summary>
A pangram is a sentence where every letter of the English alphabet appears at least once.
Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.
Example 1:
Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
Output: true
Explanation: sentence contains at least one of every letter of the English alphabet.
</summary>
</returns> true/false </returns>
Note: Use of String function (Contains) and hasmap is not allowed, think of other ways how you could the numbers be represented
*/

        //Start of CheckIfPangram function
        private static bool CheckIfPangram(string s)
        {
            try
            {
                /* <Summary of logic>
                 looping through all lowercase letters of English alphabets to check if appear in the given sentence at least once. As we encounter the first occurence of a letter,
                our boolean found becomes true and we break out of the foreach loop and we move on to check if next letter is present. If in case we do not find a particular letter of english alphabet in the sentence,
                the boolean found remains false, which means we didn't find the letter in given sentence. As we could not find a particular letter of alphabets in the sentence, it shows that the sentence
                is not a pangram and we do not have to continue through the for loop to check the presence of further letter. (Here we are checking with the ASCII values of the letter which goes from 97 to 122 for lowecase a to z)
                For example, if the given sentence is s = "vital". Then we start with i = 97 (ASCII value of a) and foreach loop loops through complete sentence "vital" to check if "a" is present in it.
                As "a" is present in it,so found = true and flag = true and we continue to check if "b" is present in the sentence.
                Now, as "b" is not in sentence "vital", found remains false and thus flag = false and we jump out of the main for loop to return false.
                 */
                s = s.ToLower();
                bool found = false, flag = false;
                for (int i = 97; i <= 122; i++) // iterates through ASCII values of the a to z letters of alphabets
                {
                    foreach (char c in s) { // iterates through each character of the given sentence
                        if ((int)c == i) // checks if the ASCII values of the letters of english alphabets is equal to that of the character from the sentence. If equal sets boolen found to true.
                        {
                            found = true;
                            break;
                        }
                        else
                            continue;
                    } //end of foreach loop
                    if (found) // if letter from alphabets was found in the sentence then continue the loop
                    {
                        flag = true;
                        continue;
                    }
                    else
                    {
                        flag = false;
                        break;
                    }
                }
                return flag;
            }
            catch (Exception)
            {

                throw;
            }

        } //End of CheckIfPangram function




        /*
        <summary> 
        You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the ith customer has in the jth bank. Return the wealth that the richest customer has.
       A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is the customer that has the maximum wealth.

       Example 1:
       Input: accounts = [[1,2,3],[3,2,1]]
       Output: 6
       Explanation:
       1st customer has wealth = 1 + 2 + 3 = 6
       2nd customer has wealth = 3 + 2 + 1 = 6
       Both customers are considered the richest with a wealth of 6 each, so return 6.
       </summary>
        */

        //Start of MaximumWealth function
        private static int MaximumWealth(int[,] accounts)
        {
            /* <Summary of logic>
             The code loops through all the rows of the input 2d array. Within each row it loops through each column value and add them. By comparing these added values of each row,
            it decides which row has maximum sum and returns it.
             */
            try
            {
                int finalSum = 0;
                for (int i = 0; i <= accounts.GetUpperBound(0); i++) // GetUpperbound(int dim) gives the last elements index of the dimemsion. loop through rows
                {
                    int sum = 0;
                    for (int j = 0; j <= accounts.GetUpperBound(1); j++) // loops through each columns of the rows
                    {
                        sum += accounts[i, j];
                    } //end of for loop

                    if (finalSum < sum)
                    {
                        finalSum = sum;
                    }
                } //end of for loop
                return finalSum;
            }
            catch (Exception)
            {
                throw;
            }
        } // End of MaximumWealth function



        /*
 <summary>
You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have.
Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.
Letters are case sensitive, so "a" is considered a different type of stone from "A".
 
Example 1:
Input: jewels = "aA", stones = "aAAbbbb"
Output: 3
Example 2:
Input: jewels = "z", stones = "ZZ"
Output: 0
 
Constraints:
•	1 <= jewels.length, stones.length <= 50
•	jewels and stones consist of only English letters.
•	All the characters of jewels are unique.
</summary>
 */
        //Start of NumJewelsInStones function
        private static int NumJewelsInStones(string jewels, string stones)
        {
            /* <Summary of logic>
             the code loops through each character of the stone string and checks if the character is present in the jewels string. If it is present, the counter "stoneCount" is incremented by 1.
            The string function Contains is case sensitive. And as this question does not specify that we cannot use string functions,so I used it.
             */
            try
            {
                int stoneCount = 0;
                foreach (char c in stones) //loop through each char of the stones
                {
                    if (jewels.Contains(c))
                        stoneCount++;
                } // end of foreach loop
                return stoneCount;
            }
            catch (Exception e)
            {

                Console.WriteLine("An error occured: " + e.Message);
                throw;
            }

        } //End of NumJewelsInStones function





        /*
        <summary>
        Given a string s and an integer array indices of the same length.
        The string s will be shuffled such that the character at the ith position moves to indices[i] in the shuffled string.
        Return the shuffled string.

        Example 3:
        Input: s = "aiohn", indices = [3,1,4,2,0]
        Output: "nihao"
        */

        // Start of RestoreString function
        private static string RestoreString(string s, int[] indices)
        {
            /* <Summary of logic>
             the code has a for loop that runs the givenString.length times. the loop traverse through the each character of the string (s[i]) and insert it at the indices[i] value index in new char array.
             once all the char from given string are put at right position in new char array, the loop ends. This char array is converted into string and return.
             */
            try
            {
                int stringLength = s.Length;
                char[] newString = new char[stringLength];
                for (int i = 0; i < stringLength; i++)
                {
                    newString[indices[i]] = Convert.ToChar(s[i]); // As newString accepts only char
                } // end of for loop

                string finalString = new string(newString); // return type of the function is string
                return finalString;
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
                throw;
            }

        } // End of RestoreString function



        /*
        <summary>
Given two arrays of integers nums and index. Your task is to create target array under the following rules:
•	Initially target array is empty.
•	From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
•	Repeat the previous step until there are no elements to read in nums and index.
Return the target array.
It is guaranteed that the insertion operations will be valid.
 
Example 1:
Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
Output: [0,4,1,3,2]


Explanation:
nums       index     target
0            0        [0]
1            1        [0,1]
2            2        [0,1,2]
3            2        [0,1,3,2]
4            1        [0,4,1,3,2]
*/
        // Start of CreateTargetArray function
        private static int[] CreateTargetArray(int[] nums, int[] index)
        {
            /* <Summary of Logic>
             In an array if element are inserted at a specific index, it replaces the existing element at that index. Therefore, the code uses a list. The for loop runs through all the elements of
            index array and nums array and inserts the values from nums into the target list at the index specified by index[] value.
             */
            try
            {
                int[] target = new int[index.Length];
                List<int> newTarget = new List<int>(index.Length);
                for (int i = 0; i < index.Length; i++) //loops till the length of index array
                {
                    newTarget.Insert(index[i], nums[i]);
                } //end of for loop

                target = newTarget.ToArray(); // convert list into an array, as the expected output of this method is an integer array
                return target;
            }
            catch (Exception)
            {

                throw;
            }

        } // End of CreateTargetArray function
    }
}
