package leetcode;

public class N24 {
    public ListNode swapPairs(ListNode head) {
    	if (head == null || head.next == null) {
			return head;
		}
    	else {
			ListNode node = head.next;
			node.next = head;
			head.next = swapPairs(head.next.next);
			return node;
		}
    }
}
