package leetcode200_249;

import leetcode.ListNode;

public class N203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode res = dummy;
        while (dummy.next != null) {
			if (dummy.next.val == val) dummy.next = dummy.next.next;
			else dummy = dummy.next;
		}
        return res.next;
    }
}
