package binaryTrees;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode3 {
      int val;
      TreeNode3 left;
      TreeNode3 right;
      TreeNode3() {}
      TreeNode3(int val) { this.val = val; }
      TreeNode3(int val, TreeNode3 left, TreeNode3 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class ValidateBinarySearchTree {

    static class NodeBounds {
        TreeNode3 node;
        long min, max;
        NodeBounds(TreeNode3 node, long min, long max){
            this.node = node;
            this.min = min;
            this.max = max;
        }
    }

     public static boolean isValidBST(TreeNode3 root) {
        if(root == null){
            return true;
        }


         Queue<NodeBounds> queue = new LinkedList<>();
         queue.add(new NodeBounds(root, Long.MIN_VALUE, Long.MAX_VALUE));

         while(!queue.isEmpty()){
             NodeBounds current = queue.poll();
             TreeNode3 node = current.node;

             // fits widest range
             if(node.val <= current.min || node.val >= current.max){
                 return false;
             }

             if(node.left != null){
                 queue.add(new NodeBounds(node.left, current.min, node.val));
             }

             if(node.right != null){
                 queue.add(new NodeBounds(node.right, node.val, current.max));
             }
         }

         return true;
     }

    public static void main(String[] args) {
         //[2,1,3]
        TreeNode3 root = new TreeNode3(2);
        root.left = new TreeNode3(1);
        root.right = new TreeNode3(3);
        System.out.println(isValidBST(root));

    }

}
