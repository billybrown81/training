
public class N82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = head, second = dummy;
        while (first != null) {
        		while (first.next != null && first.val == first.next.val) {
					first = first.next;
				}
        		if (second.next == first) {
					second = second.next;
				}else {
					second.next = first.next;
				}
        		first = first.next;
		}
        return dummy.next;
    }
}
