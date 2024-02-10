/*
====================================================== 647. Palindromic Substrings  ======================================================


Problem Statement : Given a string s, return the number of palindromic substrings in it.

                    A string is a palindrome when it reads the same backward as forward.

                    A substring is a contiguous sequence of characters within the string.


Examples : 

                    Example 1:
                    Input: s = "abc"
                    Output: 3
                    Explanation: Three palindromic strings: "a", "b", "c".


                    Example 2:
                    Input: s = "aaa"
                    Output: 6
                    Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
*/





public class 10-Feb {
    public boolean isPalindrome(String s, int left, int right) {
        while(left < right) {
            if(s.charAt(left++) != s.charAt(right--)) return false;
        } 
        return true;
    }
    
    public int countSubstrings(String s) {
        int ans = 0;
        int n = s.length();
        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                if(isPalindrome(s, i, j)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
