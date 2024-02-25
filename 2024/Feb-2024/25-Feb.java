/*
======================================================  2709. Greatest Common Divisor Traversal   ======================================================


Problem Statement : You are given a 0-indexed integer array nums, and you are allowed to traverse between its indices. You can traverse between index i and index j, i != j, if and only if gcd(nums[i], nums[j]) > 1, where gcd is the greatest common divisor.

                    Your task is to determine if for every pair of indices i and j in nums, where i < j, there exists a sequence of traversals that can take us from i to j.

                    Return true if it is possible to traverse between all such pairs of indices, or false otherwise.


Examples : 

                    Example 1:
                    Input: nums = [2,3,6]
                    Output: true
                    Explanation: In this example, there are 3 possible pairs of indices: (0, 1), (0, 2), and (1, 2).
                    To go from index 0 to index 1, we can use the sequence of traversals 0 -> 2 -> 1, where we move from index 0 to index 2 because gcd(nums[0], nums[2]) = gcd(2, 6) = 2 > 1, and then move from index 2 to index 1 because gcd(nums[2], nums[1]) = gcd(6, 3) = 3 > 1.
                    To go from index 0 to index 2, we can just go directly because gcd(nums[0], nums[2]) = gcd(2, 6) = 2 > 1. Likewise, to go from index 1 to index 2, we can just go directly because gcd(nums[1], nums[2]) = gcd(3, 6) = 3 > 1.


                    Example 2:
                    Input: nums = [3,9,5]
                    Output: false
                    Explanation: No sequence of traversals can take us from index 0 to index 2 in this example. So, we return false.


                    Example 3:
                    Input: nums = [4,3,12,8]
                    Output: true
                    Explanation: There are 6 possible pairs of indices to traverse between: (0, 1), (0, 2), (0, 3), (1, 2), (1, 3), and (2, 3). A valid sequence of traversals exists for each pair, so we return true.
*/



public class 25-Feb {   
    private int findRoot(int[] parent, int x) {
        return parent[x] == x ? x : (parent[x] = findRoot(parent, parent[x]));
    }

    private void union(int[] parent, int[] count, int x, int y) {
        x = findRoot(parent, x);
        y = findRoot(parent, y);
        if (x == y) {
            return;
        }
        if (count[x] < count[y]) {
            int temp = x;
            x = y;
            y = temp;
        }
        parent[y] = x;
        count[x] += count[y];
    }

    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return true;
        }
        int[] parent = new int[n];
        int[] count = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
            count[i] = 1;
        }

        Map<Integer, Integer> factors = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            int num = nums[i];
            if (num == 1) {
                return false;
            }
            for (int d = 2; d * d <= num; ++d) {
                if (num % d == 0) {
                    if (factors.containsKey(d)) {
                        union(parent, count, i, factors.get(d));
                    } else {
                        factors.put(d, i);
                    }
                    while (num % d == 0) {
                        num /= d;
                    }
                }
            }
            if (num > 1) {
                if (factors.containsKey(num)) {
                    union(parent, count, i, factors.get(num));
                } else {
                    factors.put(num, i);
                }
            }
        }
        return count[findRoot(parent, 0)] == n;
    }
}