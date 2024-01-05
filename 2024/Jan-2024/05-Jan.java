/*
======================================================300. Longest Increasing Subsequence ======================================================


Problem Statement : Given an integer array nums, return the length of the longest strictly increasing subsequence.


Examples : 

                    Example 1
                    Input: nums = [10,9,2,5,3,7,101,18]
                    Output: 4
                    Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
                    
                    
                    Example 2:
                    Input: nums = [0,1,0,3,2,3]
                    Output: 4
                    
                    
                    Example 3:
                    Input: nums = [7,7,7,7,7,7,7]
                    Output: 1
*/

public class 05-Jan {
    public int LIS(int ind,int prev,int nums[],int dp[][]){
        if(ind == nums.length) {
            return 0;
        } 
        int pick = 0;
        if(dp[ind][prev+1] != -1) {
            return dp[ind][prev+1];
        } 
        if(prev == -1 || nums[prev]<nums[ind]) {
            pick = 1+LIS(ind+1,ind,nums,dp);
        } 
        int notPick = LIS(ind+1,prev,nums,dp);
        return dp[ind][prev+1] = Math.max(pick,notPick);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n+1];
        for(int i=0; i<n; i++) {
            Arrays.fill(dp[i],-1);
        } 
        return LIS(0,-1,nums,dp);
    }
}
