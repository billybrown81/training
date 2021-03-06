package leetcode150_199;

import leetcode.ListNode;

public class N160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    		if (headA == null || headB == null) return null;
        ListNode a = headA, b = headB;
        while (a != b) {
			a = a == null? headB : a.next;
			b = b == null? headA : b.next;
		}
        return a;
    }
}
