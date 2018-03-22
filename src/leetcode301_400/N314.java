package leetcode301_400;
// 314. Binary Tree Vertical Order Traversal

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.TreeNode;

public class N314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Integer> queue = new LinkedList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        queue.offer(0);
        nodes.offer(root);
        int zeroPoint = -1;
        while (!queue.isEmpty() && !nodes.isEmpty()) {
        		TreeNode node = nodes.poll();
			int val = node.val, x = queue.poll(), pos = x + zeroPoint;
			if (pos < 0 || pos > res.size() - 1) {
				List<Integer> newCol = new ArrayList<>();
				newCol.add(val);
				if (pos < 0) {
					res.add(0, newCol);
					zeroPoint++;
				} else res.add(res.size(), newCol);
			} else res.get(pos).add(val);
			if (node.left != null) {
				queue.offer(x - 1);
				nodes.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(x + 1);
				nodes.offer(node.right);
			}
		}
        return res;
    }
}
