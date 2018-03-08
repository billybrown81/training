
public class N226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode tmp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = tmp;
        return root;
    }
}
