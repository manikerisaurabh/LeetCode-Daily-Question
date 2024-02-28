/*
====================================================== 513. Find Bottom Left Tree Value  ======================================================


Problem Statement : Given the root of a binary tree, return the leftmost value in the last row of the tree.


Examples : 

Example 1:
Input: root = [2,1,3]
Output: 1


Example 2:  
Input: root = [1,2,3,4,null,5,6,null,null,7]
Output: 7
 
*/



public class 28-Feb {
    private int maxDepth;
    private int bottomLeft;

    public int findBottomLeftValue(TreeNode root) {
        maxDepth = -1;
        bottomLeft = 0;
        dfs(root, 0);
        return bottomLeft;
    }

    private void dfs(TreeNode curr, int depth) {
        if (curr == null) {
            return;
        }
        if (depth > maxDepth) { 
            maxDepth = depth;
            bottomLeft = curr.val;
        }
        dfs(curr.left, depth + 1);
        dfs(curr.right, depth + 1);
    }
}
