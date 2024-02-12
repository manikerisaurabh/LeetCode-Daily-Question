/*
====================================================== 169. Majority Element  ======================================================


Problem Statement : Given an array nums of size n, return the majority element.

                    The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.


Examples : 

                    Example 1:
                    Input: nums = [3,2,3]
                    Output: 3


                    Example 2:
                    Input: nums = [2,2,1,1,1,2,2]
                    Output: 2
*/






public class 12-Feb {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length / 2;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int ans = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n) {
                ans = entry.getKey();
                break;
            }
        }

        return ans;
    }
}
