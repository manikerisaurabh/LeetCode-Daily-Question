/*
====================================================== 645. Set Mismatch ======================================================


Problem Statement : You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.

                    You are given an integer array nums representing the data status of this set after the error.
                    
                    Find the number that occurs twice and the number that is missing and return them in the form of an array.


Examples : 

                    Example 1:
                    Input: nums = [1,2,2,4]
                    Output: [2,3]


                    Example 2:
                    Input: nums = [1,1]
                    Output: [1,2]
*/

public class 22-Jan {
    public int[] findErrorNums(int[] nums) {
        int duplicate=0;
        HashSet<Integer> hs = new HashSet<>();
        int res[] = new int[2];
        for(int x : nums)
        {
            if(hs.contains(x))
            {
                duplicate=x;
                break;
            }
            else
            {
                hs.add(x);
            }
        }
        res[0]=duplicate;
        int n = nums.length;
        int expected_sum = n*(n+1)/2;
        int actual_sum=0;
        for(int i=0;i<n;i++)
        {
            actual_sum+=nums[i];
        }
        int missing = duplicate+(expected_sum-actual_sum);
        res[1] = missing;

        return res;
    }
}
