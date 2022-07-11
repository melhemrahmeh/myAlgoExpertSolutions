package Binary_Trees;

import java.util.function.Function;

public class IterativeInOrderTraversal {
    public static void iterativeInOrderTraversal(BinaryTree tree, Function<BinaryTree, Void> callback) {
        BinaryTree previous = null;
        BinaryTree current = tree;
        while (current!=null){
            BinaryTree nextNode;
            if (previous == null || previous == current.parent){
                if (current.left!=null){
                    nextNode = current.left;
                }
                else {
                    callback.apply(current);
                    if (current.right!=null){
                        nextNode = current.right;
                    }
                    else {
                        nextNode = current.parent;
                    }
                }
            }
            else if (previous == current.left){
                callback.apply(current);
                if (current.right!=null){
                    nextNode = current.right;
                }
                else {
                    nextNode = current.parent;
                }
            }
            else {
             nextNode = current.parent;
            }
            previous = current;
            current = nextNode;
        }
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;
        public BinaryTree parent;

        public BinaryTree(int value) {
            this.value = value;
        }

        public BinaryTree(int value, BinaryTree parent) {
            this.value = value;
            this.parent = parent;
        }
    }

}
