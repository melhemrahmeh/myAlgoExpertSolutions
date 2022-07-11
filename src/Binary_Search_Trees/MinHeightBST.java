package Binary_Search_Trees;

import java.util.*;

public class MinHeightBST {
    public static BST minHeightBst(List<Integer> array) {
        return constructBST(array , null , 0 ,array.size()-1);
    }

    public static BST constructBST(List<Integer> array , BST node , int start , int end){
        int mid = (start + end) / 2;
        if (start > end) return null;
        if (node == null){
            node = new BST(array.get(mid));
        }
        else {
            node.insert(array.get(mid));
        }

        constructBST(array , node , start , mid -1 );
        constructBST(array , node , mid  +1 , end );
        return node;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }
}
