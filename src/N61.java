
public class N61 {
    public ListNode rotateRight(ListNode head, int k) {
    		if (head == null || head.next == null || k <= 0) {
				return head;
			}
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy, second = dummy;
        int i;
        for (i = 0; first.next != null; i++) {
			first = first.next;
		}
        for (int j = 0; j < i - k % i; j++) {
			second = second.next;
		}
        first.next = dummy.next;
        dummy.next = second.next;
        second.next = null;
        
        return dummy.next;
    }
}
