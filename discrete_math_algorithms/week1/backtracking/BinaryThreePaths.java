package backtracking;
import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class BinaryThreePaths {
    public static List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new ArrayList<>();
        if(root != null){
            dfs(root, "", result);
        }
        return result;
    }

    public static void dfs(TreeNode node, String path, List<String> result){
        if (node == null){
            return;
        }

        path+=node.val;

        if(node.left == null && node.right == null){
            result.add(path);
        } else {
            path+="->";
            dfs(node.left, path, result);
            dfs(node.right, path, result);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        System.out.println(binaryTreePaths(root));
    }
}
