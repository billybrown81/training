package leetcode050_099;

import leetcode.ListNode;

public class N83 {
    public ListNode deleteDuplicates(ListNode head) {
    		if (head == null || head.next == null) {
				return head;
			}
    		head.next = deleteDuplicates(head.next);
    		return head.val == head.next.val? head.next : head;
    }
}
