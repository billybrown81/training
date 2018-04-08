package google_on_site;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import leetcode.TreeNode;

//297. Serialize and Deserialize Binary Tree

public class Codec {
	private String NN = "null";
	private String sp = ",";
	
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        build(root, sb);
        return sb.toString();
    }

    private void build(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append(NN).append(sp);
		} else {
			sb.append(root.val).append(sp);
			build(root.left, sb);
			build(root.right, sb);
		}
	}

	// Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(sp)));
        return decode(queue);
    }

	private TreeNode decode(Queue<String> queue) {
		String val = queue.remove();
		if (val.equals(NN)) return null;
		TreeNode root = new TreeNode(Integer.valueOf(val));
		root.left = decode(queue);
		root.right = decode(queue);
		return root;
	}
}
