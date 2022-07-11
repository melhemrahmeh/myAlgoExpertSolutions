package Binary_Trees;

import org.w3c.dom.Node;

public class BinaryTreeDiameter {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public int binaryTreeDiameter(BinaryTree tree) {
        return findMaxDiameter(tree).diameter;
    }

    public NodeInfo findMaxDiameter(BinaryTree tree){
        if (tree == null) return new NodeInfo(0 , 0);
        else {
            NodeInfo leftinfo = findMaxDiameter(tree.left);
            NodeInfo rightinfo = findMaxDiameter(tree.right);

            int currentDiameter = Math.max(leftinfo.height+rightinfo.height, Math.max(leftinfo.diameter , rightinfo.diameter));
            int currentHeight = 1 + Math.max(leftinfo.height, rightinfo.height);

            return new NodeInfo(currentDiameter , currentHeight);
        }
    }


    static class NodeInfo{
        int diameter;
        int height;

        NodeInfo(int diameter , int height){
            this.diameter = diameter;
            this.height = height;
        }
    }

}
