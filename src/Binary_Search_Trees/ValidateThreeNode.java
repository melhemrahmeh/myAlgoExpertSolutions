package Binary_Search_Trees;

public class ValidateThreeNode {
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {

        if (isDescendant(nodeTwo , nodeOne)) return isDescendant(nodeThree , nodeTwo);
        if (isDescendant(nodeTwo , nodeThree)) return isDescendant(nodeOne , nodeTwo);
        return false;
    }

    public boolean isDescendant(BST node , BST target){
        if (node == null) return false;
        if (node == target) return true;

        if (target.value < node.value) return isDescendant(node.left , target);
        else  return isDescendant(node.right,target);

    }

}
