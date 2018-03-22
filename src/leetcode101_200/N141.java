package leetcode101_200;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import leetcode.ListNode;

public class N141 {
    public boolean hasCycle(ListNode head) {
        ListNode dummy = head;
        HashMap<ListNode, Integer> map = new HashMap();
        while (dummy != null) {
			map.put(dummy, 0);
			if (map.containsKey(dummy.next)) return true;
			dummy = dummy.next;
		}
        return false;
    }
}
