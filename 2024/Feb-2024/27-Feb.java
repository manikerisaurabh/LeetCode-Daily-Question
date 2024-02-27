/*
====================================================== 543. Diameter of Binary Tree    ======================================================


Problem Statement : Given the root of a binary tree, return the length of the diameter of the tree.

                    The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

                    The length of a path between two nodes is represented by the number of edges between them.


Examples : 

                    Example 1:
                    Input: root = [1,2,3,4,5]
                    Output: 3
                    Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].


                    Example 2:
                    Input: root = [1,2]
                    Output: 1
*/



public class 27-Feb {
    public int diameterOfBinaryTree(TreeNode root) {
        findDia(root);
        return maxDia;
    }
    int maxDia = 0;
    private int findDia(TreeNode root){
        if(root == null)return 0;
        int leftDepth = findDia(root.left);
        int rightDepth = findDia(root.right);
        int currDia = leftDepth + rightDepth;
        maxDia = Math.max(maxDia, currDia);
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
