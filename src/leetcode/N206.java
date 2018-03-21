package leetcode;

public class N206 {
    public ListNode reverseList(ListNode head) {
    		if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0), pre = head, cur = head.next;
        dummy.next = head;
        while (cur != null) {
			pre.next = cur.next;
			cur.next = dummy.next;
			dummy.next = cur;
			cur = pre.next;
		}
        return dummy.next;
    }
}
