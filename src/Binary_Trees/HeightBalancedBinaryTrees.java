package Binary_Trees;

public class HeightBalancedBinaryTrees {
    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    static class TreeInfo{
        public boolean isBalanced;
        public int height;

        public TreeInfo(boolean isBalanced , int height){
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        TreeInfo treeInfo = getInfo(tree);
        return treeInfo.isBalanced;
    }

    public TreeInfo getInfo(BinaryTree node){
        if (node == null){
            return new TreeInfo(true , -1);
        }
        else {
            TreeInfo left = getInfo(node.left);
            TreeInfo right = getInfo(node.right);

            return new TreeInfo(left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) <=1, Math.max(left.height, right.height) +1);
        }
    }
}
