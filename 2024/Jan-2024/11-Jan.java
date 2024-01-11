/*
====================================================== 1026. Maximum Difference Between Node and Ancestor ======================================================


Problem Statement : Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b where v = |a.val - b.val| and a is an ancestor of b.

                    A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.


Examples : 

                    Example 1:
                    Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
                    Output: 7
                    Explanation: We have various ancestor-node differences, some of which are given below :
                    |8 - 3| = 5
                    |3 - 7| = 4
                    |8 - 1| = 7
                    |10 - 13| = 3
                    Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.


                    Example 2:
                    Input: root = [1,null,2,null,0,3]
                    Output: 3
*/



public class 11-Jan {
    
    public int calculateMax(TreeNode root, int smallest, int biggest) {
        if (root.right == null && root.left == null) {
            return Math.abs(Math.max(biggest, root.val) - Math.min(smallest, root.val));
        } else {
            int min = Math.min(smallest, root.val);
            int max = Math.max(biggest, root.val);
            int left = root.left != null ? calculateMax(root.left, min, max) : 0;
            int right = root.right != null ? calculateMax(root.right, min, max) : 0;
            return Math.max(left, right);
        }
    }
    public int maxAncestorDiff(TreeNode root) {
        return calculateMax(root, root.val, root.val);
    }
}
