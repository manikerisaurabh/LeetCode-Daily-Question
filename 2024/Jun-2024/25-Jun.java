public class 25-Jun {
    private int globalSum;

    private TreeNode postExtremeLeftFunc(TreeNode node) {
        TreeNode post = node.right;
        while (post.left != null && post.left != node) {
            post = post.left;
        }
        return post;
    }

    public TreeNode bstToGst(TreeNode root) {
        globalSum = 0;
        TreeNode node = root;

        while (node != null) {
            TreeNode post = node.right;
            if (post == null) {
                globalSum += node.val;
                node.val = globalSum;
                node = node.left;
            } else {
                TreeNode postExtremeLeft = postExtremeLeftFunc(node);

                if (postExtremeLeft.left == null) {
                    postExtremeLeft.left = node;
                    node = node.right;
                } else {
                    postExtremeLeft.left = null;
                    globalSum += node.val;
                    node.val = globalSum;
                    node = node.left;
                }
            }
        }
        return root;
    }
}
