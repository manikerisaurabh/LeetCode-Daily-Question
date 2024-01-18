/*
====================================================== 70. Climbing Stairs ======================================================


Problem Statement : You are climbing a staircase. It takes n steps to reach the top.

                    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?


Examples : 

                    Example 1:
                    Input: n = 2
                    Output: 2
                    Explanation: There are two ways to climb to the top.
                    1. 1 step + 1 step
                    2. 2 steps


                    Example 2:
                    Input: n = 3
                    Output: 3
                    Explanation: There are three ways to climb to the top.
                    1. 1 step + 1 step + 1 step
                    2. 1 step + 2 steps
                    3. 2 steps + 1 step
*/



public class 18-Jan {
    int []AM;
    public int climbStairsforA(int A){
        if(A <= 1){
            return 1;
        }
        if(AM[A] != -1){
            return AM[A];
        }
        AM[A] = climbStairsforA(A-1) + climbStairsforA(A-2);
        return AM[A];
    }


    public int climbStairs(int A) {         //main calling function
        AM = new int[A+1];
        Arrays.fill(AM, -1);
        return climbStairsforA(A);
    }
}
