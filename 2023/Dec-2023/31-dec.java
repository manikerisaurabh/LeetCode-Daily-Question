/*
====================================================== 1624. Largest Substring Between Two Equal Characters ======================================================


Problem Statement : Given a string s, return the length of the longest substring between two equal characters, excluding the two characters. If there is no such substring return -1.

                    A substring is a contiguous sequence of characters within a string.


Examples : 

                    Example 1:
                    Input: s = "aa"
                    Output: 0
                    Explanation: The optimal substring here is an empty substring between the two 'a's.


                    Example 2:
                    Input: s = "abca"
                    Output: 2
                    Explanation: The optimal substring here is "bc".


                    Example 3:
                    Input: s = "cbzxy"
                    Output: -1
                    Explanation: There are no characters that appear twice in s.
*/

public class 31-dec {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] firstOccurrence = new int[26]; 

        for (int i = 0; i < firstOccurrence.length; i++) {
            firstOccurrence[i] = -1;
        }

        int maxLength = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';

            if (firstOccurrence[index] == -1) {
                firstOccurrence[index] = i;
            } else {
                int currentLength = i - firstOccurrence[index] - 1;
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }
}