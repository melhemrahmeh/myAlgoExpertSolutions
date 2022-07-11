package Binary_Trees;

import java.util.*;

public class ReconstructBST {
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public BST reconstructBst(List<Integer> preOrderTraversalValues) {
        if (preOrderTraversalValues.size() == 0) return null;

        int rightSubtreeIndex = preOrderTraversalValues.size();

        for (int i = 1; i < preOrderTraversalValues.size(); i++) {
            if (preOrderTraversalValues.get(i) >= preOrderTraversalValues.get(0)){
                rightSubtreeIndex = i;
                break;
            }
        }

        BST left = reconstructBst(preOrderTraversalValues.subList(1 , rightSubtreeIndex));
        BST right = reconstructBst(preOrderTraversalValues.subList(rightSubtreeIndex , preOrderTraversalValues.size()));

        BST root = new BST(preOrderTraversalValues.get(0));
        root.left = left;
        root.right = right;
        return root;
    }
}
