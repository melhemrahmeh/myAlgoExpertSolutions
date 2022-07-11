package Binary_Trees;

import java.util.List;

public class FindSuccessor {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        if (node.right != null) {
            return getLeftMostChild(node.right);
        }
        return getRightMostParent(node);
    }
    public BinaryTree getLeftMostChild(BinaryTree node){
        BinaryTree current = node;
        while (current.left!=null){
            current = current.left;
        }
        return current;
    }
    public BinaryTree getRightMostParent(BinaryTree node){
        BinaryTree current = node;
        while (current.left!=null && current.parent.right == node){
            current = current.parent;
        }
        return current.parent;
    }

}
