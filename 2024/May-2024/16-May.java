public class 16-May {
    public boolean evaluateTree(TreeNode root) {
        if(root.left == null && root.right == null){
           return   (root.val == 1);
        }
        if(root.val == 2){
            boolean leftVal = evaluateTree(root.left);
            if(leftVal == true)return true;
            return evaluateTree(root.right);
        }else{
            boolean leftVal = evaluateTree(root.left);
            if(leftVal == false)return false;
            return evaluateTree(root.right);
        }
    }
}
