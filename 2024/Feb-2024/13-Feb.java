/*
====================================================== 2108. Find First Palindromic String in the Array ======================================================


Problem Statement : Given an array of strings words, return the first palindromic string in the array. If there is no such string, return an empty string "".

                    A string is palindromic if it reads the same forward and backward.


Examples : 

                    Example 1:
                    Input: words = ["abc","car","ada","racecar","cool"]
                    Output: "ada"
                    Explanation: The first string that is palindromic is "ada".
                    Note that "racecar" is also palindromic, but it is not the first.


                    Example 2:
                    Input: words = ["notapalindrome","racecar"]
                    Output: "racecar"
                    Explanation: The first and only string that is palindromic is "racecar".


                    Example 3:
                    Input: words = ["def","ghi"]
                    Output: ""
                    Explanation: There are no palindromic strings, so the empty string is returned.
*/





public class 13-Feb {
    public String firstPalindrome(String[] words) {
        for(String word: words) {
            StringBuilder reversed = new StringBuilder(word).reverse();
            if(word.equals(reversed.toString())) {
                return word;
            }
        }
         return "";
    }
}
