package Binary_Trees;

public class Invert {
    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    public TreeNode invert(TreeNode root){
        if (root == null){
            return null;
        }
        else {
            TreeNode left = root.left;
            TreeNode right = root.right;

            root.left = right;
            root.right = left;
            invert(root.left);
            invert(root.right);
            return root;
        }
    }
}
