package Binary_Trees;

public class MaxPathSum {
    static int max_path_sum;
    public static int maxPathSum(BinaryTree tree) {
        max_path_sum = Integer.MIN_VALUE;
        pathSum(tree);
        return max_path_sum;
    }

    public static int pathSum(BinaryTree node){
        if (node == null) return 0;
        int left = Math.max(0 , pathSum(node.left));
        int right = Math.max(0 , pathSum(node.right));
        max_path_sum = Math.max(max_path_sum , left+right+node.value);
        return Math.max(left,right) + node.value;
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
