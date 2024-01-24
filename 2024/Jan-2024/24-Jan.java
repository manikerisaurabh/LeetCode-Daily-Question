/*
======================================================  1457. Pseudo-Palindromic Paths in a Binary Tree ======================================================


Problem Statement : Given a binary tree where node values are digits from 1 to 9. A path in the binary tree is said to be pseudo-palindromic if at least one permutation of the node values in the path is a palindrome.

                    Return the number of pseudo-palindromic paths going from the root node to leaf nodes.


Examples : 

                    Example 1:
                    Input: root = [2,3,1,3,1,null,1]
                    Output: 2 
                    Explanation: The figure above represents the given binary tree. There are three paths going from the root node to leaf nodes: the red path [2,3,3], the green path [2,1,1], and the path [2,3,1]. Among these paths only red path and green path are pseudo-palindromic paths since the red path [2,3,3] can be rearranged in [3,2,3] (palindrome) and the green path [2,1,1] can be rearranged in [1,2,1] (palindrome).


                    Example 2:
                    Input: root = [2,1,1,1,3,null,null,null,null,null,1]
                    Output: 1 
                    Explanation: The figure above represents the given binary tree. There are three paths going from the root node to leaf nodes: the green path [2,1,1], the path [2,1,3,1], and the path [2,1]. Among these paths only the green path is pseudo-palindromic since [2,1,1] can be rearranged in [1,2,1] (palindrome).


                    Example 3:
                    Input: root = [9]
                    Output: 1
*/


public class 24-Jan {
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] arr = new int[10];
        return solve(root, arr);
    }

    int solve(TreeNode root, int[] arr) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null) {
            arr[root.val]++;
            int odd = 0;
            for (int i : arr) {
                if (i % 2 != 0)
                    odd++;
            }
            int local =  odd <= 1 ? 1 : 0;
            arr[root.val]--;
            return local;
        }
        arr[root.val]++;
        int ans = solve(root.left, arr) + solve(root.right, arr);
        arr[root.val]--;
        return ans;
    }
}
