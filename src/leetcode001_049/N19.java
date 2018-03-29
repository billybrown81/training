package leetcode001_049;

import leetcode.ListNode;

public class N19 {
public ListNode removeNthFromEnd(ListNode head, int n) {
	ListNode dummy = new ListNode(0);
	dummy.next = head;
	ListNode first = dummy;
	ListNode second = dummy;
	for (int i = 0; i <= n; i++) {
		first = first.next;
	}
	while (first.next != null) {
		first = first.next;
		second = second.next;
	}
	second.next = second.next.next;
	return dummy.next;
        
    }

}
