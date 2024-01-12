/*
====================================================== 1704. Determine if String Halves Are Alike ======================================================


Problem Statement : You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the first half and b be the second half.

                    Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and lowercase letters.

                    Return true if a and b are alike. Otherwise, return false.


Examples : 

                    Example 1:
                    Input: s = "book"
                    Output: true
                    Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.


                    Example 2:
                    Input: s = "textbook"
                    Output: false
                    Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2. Therefore, they are not alike.
                    Notice that the vowel o is counted twice.
*/  


public class 12-Jan {
    private static int countVowels(String str) {
        int count = 0;
        for (char ch : str.toLowerCase().toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        return count;
    }

    public boolean halvesAreAlike(String s) {
        int length = (s.length())/2;
        String firstPart = s.substring(0, length);
        String secondPart = s.substring(length);

        int vowelsInFirstPart = countVowels(firstPart);
        int vowelsInSecondPart = countVowels(secondPart);

        if (vowelsInFirstPart == vowelsInSecondPart) {
            return true;
        } 
        
        return false;
    
    }
}
