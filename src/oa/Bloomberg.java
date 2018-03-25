package oa;

import java.util.Stack;

import leetcode.ListNode;
import leetcode.TreeNode;

public class Bloomberg {
	public static String deleteDuplication(String s) {
		Stack<int[]> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			checkDuplication(stack, c);
		}
		if (!stack.isEmpty()) {
			int last[] = stack.peek();
			if (last[1] >= 3)
				for (int i = 0; i < last[1]; i++) stack.pop();
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.insert(0, (char) ('A' + stack.pop()[0]));
		}
		return sb.toString();
	}

	private static void checkDuplication(Stack<int[]> stack, char c) {
		if (stack.isEmpty()) {
			stack.push(new int[] {c - 'A', 1});
			return;
		}
		int ch[] = stack.peek();
		if (ch[0] == c - 'A') {
			int count = ch[1] + 1;
			stack.push(new int[] {c - 'A', count});
		} else {
			int count = ch[1];
			if (count >= 3) {
				for (int i = 0; i < count; i++) {
					stack.pop();
				}
				checkDuplication(stack, c);
			} else {
				stack.push(new int[] {c - 'A', 1});
			}
		}
	}
	
	//Leetcode 114
	public void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        stk.push(root);
        while (!stk.isEmpty()){
            TreeNode curr = stk.pop();
            if (curr.right!=null)  
                 stk.push(curr.right);
            if (curr.left!=null)  
                 stk.push(curr.left);
            if (!stk.isEmpty()) 
                 curr.right = stk.peek();
            curr.left = null;  // dont forget this!! 
        }
	}
	
	//Leetcode 143 Reorder List
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode fast = head, slow = head;
        //find middle
        while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
        //reverse rear part
        ListNode middle = slow;
        ListNode rear = slow.next;
        while (rear.next != null) {
			ListNode tmp = rear.next;
			rear.next = tmp.next;
			tmp.next = middle.next;
			middle.next = tmp;		
		}
        //reorder list
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
    
    //Leetcode 25 K = 2
    public ListNode reverse2Group(ListNode head) {
    		ListNode dummy = new ListNode(0);
    		dummy.next = head;
    		ListNode prev = dummy;
        while (head != null && head.next != null) {
			ListNode tmp = head.next;
			head.next = tmp.next;
			tmp.next = head;
			prev.next = tmp;
			prev = head;
			head = head.next;
		}
        return dummy.next;
    }
    
    //Leetcode 25 K
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while (cur != null && count < k) {
			count++;
			cur = cur.next;
		}
        if (count == k) {
			cur = reverseKGroup(cur, k);
			while (count > 0) {
				ListNode tmp = head.next;
				head.next = cur;
				cur = head;
				head = tmp;
				count--;
			}
			head = cur;
		}
        return head;
    }
    
    //Leetcode 91 Decode Ways
    public int numDecodings(String s) {
        int size = s.length();
        if (size == 0) {
			return 0;
		}
        if (size == 1) {
			return (s.charAt(0) == '0') ? 0 : 1;
		}
        int[] map = new int[size + 1];
        map[size] = 1;
        map[size - 1] = (s.charAt(size - 1) - '0' == 0) ? 0 : 1;
        
        for (int i = size - 2; i >= 0; i--) {
        		if (s.charAt(i) == '0') continue;
			map[i] = (Integer.valueOf(s.substring(i, i + 2)) <= 26)? map[i + 1] + map[i + 2] : map[i + 1];
		}
        return map[0];
    }
}
