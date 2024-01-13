/*
====================================================== 1347. Minimum Number of Steps to Make Two Strings Anagram ======================================================


Problem Statement : You are given two strings of the same length s and t. In one step you can choose any character of t and replace it with another character.

                    Return the minimum number of steps to make t an anagram of s.

                    An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.


Examples : 

                    Example 1:
                    Input: s = "bab", t = "aba"
                    Output: 1
                    Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.


                    Example 2:
                    Input: s = "leetcode", t = "practice"
                    Output: 5
                    Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from t with proper characters to make t anagram of s.


                    Example 3:
                    Input: s = "anagram", t = "mangaar"
                    Output: 0
                    Explanation: "anagram" and "mangaar" are anagrams. 
*/



public class 13-Jan {
    public int minSteps(String s, String t) {
        int[] hash = new int[26];
        int result = 0;
        for(char ch : s.toCharArray()) {
            hash[ch-0-'a']++;
        } 
        for(char ch : t.toCharArray()) {
            if(hash[ch-0-'a']>0) {
                hash[ch-0-'a']--;
            }
        } 
        for(char ch : s.toCharArray()) {
            if(hash[ch-0-'a']>0){
                result += hash[ch-0-'a'];
                hash[ch-0-'a']=0;
            }
        }
        return result;
    }
}
