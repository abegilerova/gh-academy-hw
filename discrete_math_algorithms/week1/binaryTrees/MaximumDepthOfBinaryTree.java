package binaryTrees;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
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
  }
public class MaximumDepthOfBinaryTree {
    public  static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        //BFS breadth first search

//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        int depth = 0;
//
//
//        while(!queue.isEmpty()) {
//            int levelSize = queue.size();
//
//            for (int i = 0; i < levelSize; i++) {
//                TreeNode current = queue.poll();
//                printTree(current);
//
//                if (current.left != null) {
//                    queue.add(current.left);
//                }
//
//                if (current.right != null) {
//                    queue.add(current.right);
//                }
//
//                System.out.println("queue size is " + queue.size());
//            }
//
//            depth++;
//        }
//
//        return  depth;
        //DFS will use recusion

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return 1 + Math.max(leftDepth, rightDepth);

    }

    public static void printTree (TreeNode root){
        if(root == null){
            return;
        }

        System.out.println("current is " + root.val + " ");
        printTree(root.left);
        printTree(root.right);

    }

    public static void main(String[] args) {
        //root = [3,9,20,null,null,15,7]
       TreeNode root = new TreeNode(3);
       root.left = new TreeNode(9);
       root.right = new TreeNode(20);
       root.right.left = new TreeNode(15);
       root.right.right = new TreeNode(7);
       int result = maxDepth(root);
       System.out.println("result " + result);


    }
}
