package Binary_Trees;

import java.util.ArrayList;
import java.util.List;

public class FindClosest {

    public static int findClosestValueInBst(BST tree, int target) {
        return findClosest(tree , target , tree.value);
    }
    public static int findClosest(BST tree , int target , int closest){
        if (Math.abs(target - closest) > Math.abs(target-tree.value)) closest = tree.value;
        if (tree.value > closest  && tree.left != null) return findClosest(tree.left , target , closest);
        else if (tree.value < closest && tree.right!=null ) return findClosest(tree.right , target , closest);
        else return closest;
    }
    public static boolean validateBst(BST tree) {
        if (tree == null) return true;
        if (tree.left!= null && tree.value < tree.left.value) return false;
        if (tree.right!= null && tree.value > tree.right.value) return false;
        return validateBst(tree.left) && validateBst(tree.right);
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }


}
