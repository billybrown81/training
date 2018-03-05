
public class N147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy, cur = head, next;
        while (cur != null) {
        		next = cur.next;
			while (pre.next != null && pre.next.val < cur.val) pre = pre.next;
			cur.next = pre.next;
			pre.next = cur;
			pre = dummy;
			cur = next;
		}
        return dummy.next;
    }
}
