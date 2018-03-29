package leetcode001_049;

import leetcode.ListNode;

public class N25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while (cur != null && count < k) {
			count++;
			cur = cur.next;
		}
        if (count == k) {
			cur = reverseKGroup(cur, k);
			while (count > 0) {
				ListNode tmp = head.next;
				head.next = cur;
				cur = head;
				head = tmp;
				count--;
			}
			head = cur;
		}
        return head;
    }
}
