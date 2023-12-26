/*
====================================================== 1155. Number of Dice Rolls With Target Sum ======================================================


Problem Statement : You have n dice, and each die has k faces numbered from 1 to k.

                    Given three integers n, k, and target, return the number of possible ways (out of the kn total ways) 

                    to roll the dice, so the sum of the face-up numbers equals target. Since the answer may be too large, return it modulo 109 + 7.


Examples : 

                    Example 1:
                    Input: n = 1, k = 6, target = 3
                    Output: 1
                    Explanation: You throw one die with 6 faces.
                    There is only one way to get a sum of 3.


                    Example 2:
                    Input: n = 2, k = 6, target = 7
                    Output: 6
                    Explanation: You throw two dice, each with 6 faces.
                    There are 6 ways to get a sum of 7: 1+6, 2+5, 3+4, 4+3, 5+2, 6+1.


                    Example 3:
                    Input: n = 30, k = 30, target = 500
                    Output: 222616187
                    Explanation: The answer must be returned modulo 109 + 7.
*/


public class 26-dec {
    public int numRollsToTarget(int d, int f, int target) {
        final int mod = 1000000007;

        int[] dp1 = new int[target + 1];  
        int[] dp2 = new int[target + 1];  

        dp1[0] = 1;

        for (int i = 1; i <= d; ++i) {
            int prev = dp1[0];  
            for (int j = 1; j <= target; ++j) {
                dp2[j] = prev;  
                prev = (int) ((prev + dp1[j]) % mod);  
                if (j >= f) prev = (int) ((prev - dp1[j - f] + mod) % mod);
            }

            int[] temp = dp1;
            dp1 = dp2;
            dp2 = temp;

            dp2[0] = 0;
        }
        return dp1[target];
    }
}
