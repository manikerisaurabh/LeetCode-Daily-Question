/*
====================================================== 201. Bitwise AND of Numbers Range  ======================================================


Problem Statement : Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers in this range, inclusive.


Examples : 

                    Example 1:
                    Input: left = 5, right = 7
                    Output: 4


                    Example 2:
                    Input: left = 0, right = 0
                    Output: 0


                    Example 3:
                    Input: left = 1, right = 2147483647
                    Output: 0
*/

public class 21-Feb {
    public int rangeBitwiseAnd(int left, int right) {
        int rightShiftcnt = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            rightShiftcnt++;
        }
        return (left << rightShiftcnt);
    }
}
