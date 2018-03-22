package leetcode201_300;

import leetcode.TreeNode;

public class N270 {
    public int closestValue(TreeNode root, double target) {
        int a = root.val;
        TreeNode next = target < a ? root.left : root.right;
        if (next == null) return a;
        int b = closestValue(next, target);
        return Math.abs(target - a) < Math.abs(target - b)? a : b;
    }
}
