package Binary_Trees;

public class AllKindOfNodeDepth {
    public static int allKindsOfNodeDepths(BinaryTree root) {
        return depthSum(root  , 0 , 0 );
    }
    public static int depthSum(BinaryTree root , int depthSum , int depth){
        if (root == null) return 0;
        depthSum+=depth;
        return depthSum + depthSum(root.left , depthSum , depth+1) + depthSum(root.right , depthSum , depth+1);
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
