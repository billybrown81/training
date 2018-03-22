package leetcode101_200;

import leetcode.TreeLinkNode;

public class N117 {
    public static void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode start = root;
        while (start!= null) {
			TreeLinkNode cur = findNext(start);
			if (cur != null) {
				start = cur.left != null ? cur.left : cur.right;
			} else start = null;
			while (cur != null) {
				TreeLinkNode tmp;
				if (cur.left != null && cur.right != null) {
					cur.left.next = cur.right;
					tmp = cur.right;
				} else tmp = (cur.left != null)? cur.left : cur.right;
				TreeLinkNode nextCur = findNext(cur.next);
				if (nextCur != null) {
					tmp.next = (nextCur.left != null)? nextCur.left : nextCur.right;
				} else tmp.next = null;
				cur = nextCur;
			}
		}
    }

	private static TreeLinkNode findNext(TreeLinkNode root) {
		while(root != null) {
			if (root.left != null || root.right != null) return root;
			root = root.next;
		}
		return root;
	}
}
