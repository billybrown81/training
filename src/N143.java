
public class N143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
        ListNode middle = slow;
        ListNode rear = slow.next;
        while (rear.next != null) {
			ListNode tmp = rear.next;
			rear.next = tmp.next;
			tmp.next = middle.next;
			middle.next = tmp;		
		}
        fast = middle.next;
        slow = head;
        while (slow != middle) {
			middle.next = fast.next;
			fast.next = slow.next;
			slow.next = fast;
			slow = fast.next;
			fast = middle.next;
		}
    }
}
