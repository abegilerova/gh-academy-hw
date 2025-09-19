package binaryTrees;
class TreeNode5 {
    int val;
    TreeNode5 left;
    TreeNode5 right;
    TreeNode5() {}
    TreeNode5(int val) { this.val = val; }
    TreeNode5(int val, TreeNode5 left, TreeNode5 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class PathSumIII {

    public int pathSum(TreeNode5 root, int targetSum) {

        if(root == null){
            return 0;
        }

       return countFrom(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);

    }

    public int countFrom(TreeNode5 root, int targetSum){
        if (root == null){
            return 0;
        }

        int count = 0;

        if(root.val == targetSum){
            count++;
        }

        count += countFrom(root.left, targetSum -root.val);
        count += countFrom(root.right, targetSum - root.val);


        return count;
    }
    public static void main(String[] args) {
// Example: [10,5,-3,3,2,null,11,3,-2,null,1]
        TreeNode5 root = new TreeNode5(10);
        root.left = new TreeNode5(5);
        root.right = new TreeNode5(-3);
        root.left.left = new TreeNode5(3);
        root.left.right = new TreeNode5(2);
        root.right.right = new TreeNode5(11);
        root.left.left.left = new TreeNode5(3);
        root.left.left.right = new TreeNode5(-2);
        root.left.right.right = new TreeNode5(1);

        PathSumIII solver = new PathSumIII();
        System.out.println(solver.pathSum(root, 8)); // expected 3
    }
}
