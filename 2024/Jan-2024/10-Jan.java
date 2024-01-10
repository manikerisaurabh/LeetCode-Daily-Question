/*
====================================================== 2385. Amount of Time for Binary Tree to Be Infected    ======================================================


Problem Statement : You are given the root of a binary tree with unique values, and an integer start. At minute 0, an infection starts from the node with value start.

                    Each minute, a node becomes infected if:

                    The node is currently uninfected.

                    The node is adjacent to an infected node.

                    Return the number of minutes needed for the entire tree to be infected.


Examples : 

                    Example 1:
                    Input: root = [1,5,3,null,4,10,6,9,2], start = 3
                    Output: 4
                    Explanation: The following nodes are infected during:
                    - Minute 0: Node 3
                    - Minute 1: Nodes 1, 10 and 6
                    - Minute 2: Node 5
                    - Minute 3: Node 4
                    - Minute 4: Nodes 9 and 2
                    It takes 4 minutes for the whole tree to be infected so we return 4.


                    Example 2:
                    Input: root = [1], start = 1
                    Output: 0
                    Explanation: At minute 0, the only node in the tree is infected so we return 0.
*/





public class 10-Jan {
    

    public void getMaxFromStack() {
        for(int i = stack.size() - 2; i >= 0; i--) {
            if (stack.get(i).left != stack.get(i + 1)) {
                getMaxDepth(stack.get(i).left, stack.size() - i);
            }
            if (stack.get(i).right != stack.get(i + 1)) {
                getMaxDepth(stack.get(i).right, stack.size() - i);
            }
        }
    }

    public void getMaxDepth(TreeNode root, int depth) {
        if (root == null) {
            maxDepthFromStack = Math.max(maxDepthFromStack, depth - 1);
            return;
        }
        if (root.left != null) {
            getMaxDepth(root.left, depth + 1);
        }
        if (root.right != null) {
            getMaxDepth(root.right, depth + 1);
        }
        if (root.left == null && root.right == null) {
            maxDepthFromStack = Math.max(maxDepthFromStack, depth);
        }
    }

    boolean valFound = false;
    List<TreeNode> stack = new ArrayList<>();
    int maxDepthDownToVal = 0;
    int maxDepthFromStack = 0;
    public void findVal(TreeNode root, int start, int steps, boolean countSteps) {
        if (!valFound) {
            stack.add(root);
        }
        if (root.val == start) {
            valFound = true;
            countSteps = true;
            steps = 0;
        }

        if (root.left != null) {
            findVal(root.left, start, steps + 1, countSteps);
        }
        if (root.right != null) {
            findVal(root.right, start, steps + 1, countSteps);
        }

        if (valFound && root.left == null && root.right == null && countSteps) {
            maxDepthDownToVal = Math.max(maxDepthDownToVal, steps);
        }

        if (!valFound) {
            stack.remove(stack.size() - 1);
        }
    }

    //calling function
    public int amountOfTime(TreeNode root, int start) {
        findVal(root, start, 0, false);
        getMaxFromStack();
        return Math.max(maxDepthDownToVal, maxDepthFromStack);
    }
}
