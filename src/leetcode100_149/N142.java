package leetcode100_149;
import java.util.HashMap;

import leetcode.ListNode;

public class N142 {
    public ListNode detectCycle(ListNode head) {
        ListNode dummy = head;
        HashMap<ListNode, Integer> map = new HashMap();
        while (dummy != null) {
			map.put(dummy, 0);
			if (map.containsKey(dummy.next)) return dummy.next;
			dummy = dummy.next;
		}
        return null;
    }
}
