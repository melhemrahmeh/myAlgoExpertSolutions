package Binary_Trees;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTree {
    public static BinaryTree flattenBinaryTree(BinaryTree root) {
        List<BinaryTree> nodes = inOrderTraversal(root , new ArrayList<BinaryTree>());
        for (int i = 0; i < nodes.size()-1; i++) {
            BinaryTree left = nodes.get(i);
            BinaryTree right = nodes.get(i + 1);
            right.left = left;
            left.right = right;
        }
        return nodes.get(0);
    }

    public static List<BinaryTree> inOrderTraversal(BinaryTree node , List<BinaryTree> array){
        if (node!=null){
            inOrderTraversal(node.left , array);
            array.add(node);
            inOrderTraversal(node.right , array);
        }
        return array;
    }

    static class BinaryTree {
        int value;
        BinaryTree left = null;
        BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
    }
}
