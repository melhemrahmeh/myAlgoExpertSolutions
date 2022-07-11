package Binary_Trees;

import java.util.*;

public class InOrder {
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

    public List<Integer> inorderTraversal(TreeNode root) {
          List<Integer> list = new ArrayList<>();
        inOrderTraversalHelper(root, list);
        return list;
    }

    public void inOrderTraversalHelper(TreeNode root , List<Integer> array){
        if (root!=null){
            inOrderTraversalHelper(root.left , array);
            array.add(root.val);
            inOrderTraversalHelper(root.right , array);
        }
    }
      public int maxDepth(TreeNode root) {
        if (root == null){
            return  0;
        }
        else {
            return 1 + Math.max(maxDepth(root.left) , maxDepth(root.right));
        }
      }

      public int nodeDepths(TreeNode root) {
          if (root == null){
              return  0;
          }
          else {
              return 1 + Math.max(maxDepth(root.left) , maxDepth(root.right));
          }
      }
  }
}
