/*
====================================================== 872. Leaf-Similar Trees ======================================================


Problem Statement : Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.

                    For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

                    Two binary trees are considered leaf-similar if their leaf value sequence is the same.

                    Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.


Examples : 

                    Example 1:
                    Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
                    Output: true


                    Example 2:
                    Input: root1 = [1,2,3], root2 = [1,3,2]
                    Output: false
*/



public class 09-Jan {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> firstList = new ArrayList<>();
        ArrayList<Integer> secondList = new ArrayList<>();
        getIntoList(root1, firstList);
        getIntoList(root2, secondList);

        if(firstList.equals(secondList)) {
            return true;
        }

        return false;

    }
    public static void getIntoList(TreeNode root, ArrayList<Integer> list) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            list.add(root.val);
        }

        getIntoList(root.left, list);
        getIntoList(root.right, list);
    }
}
