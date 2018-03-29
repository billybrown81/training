package oa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import leetcode.Interval;
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
    
    //56. Merge Intervals
    public List<Interval> merge3(List<Interval> intervals) {
		List<Interval> res= new ArrayList<>();
		if (intervals == null || intervals.size() == 0) return res;
		intervals.sort((a, b) -> (a.start - b.start));
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		for (Interval interval : intervals) {
		if (interval.start > end) {
			res.add(new Interval(start, end));
			start = interval.start;
			end = interval.end;
		}
		else {
			end = Math.max(end, interval.end);
		}
	}
		res.add(new Interval(start, end));
		return res;
    }
    
    // Find kth biggest in BST
    public int findKthBiggest(TreeNode root, int k) {
		int[] count = new int[] {0};
		int[] res = new int[] {Integer.MIN_VALUE};
		DFSHelper(root, res, count, k);
		return res[0] == Integer.MIN_VALUE? -1 : res[0];
	}

	private void DFSHelper(TreeNode node, int[] res, int[] count, int k) {
		if (node == null || count[0] >= k) {
			return;
		}
		DFSHelper(node.right, res, count, k);
		count[0]++;
		if (count[0] == k) {
			res[0] = node.val;
		}
		DFSHelper(node.left, res, count, k);
	}
	
	//6 位数，要求返回前三位和等于后三位和的个数。eg : 123420 就是valid， 1+2+3 = 4+2+0。 注
	//意该6 位数为valid 的6 位数，第一位不能为0.
	public boolean valid6digits(int number) {
		if (number / 100000 == 0) return false;
		int front = 0, rear = 0;
		int count = 0;
		while (number > 0) {
			if (count < 3) rear += number % 10;
			else front += number % 10;
			number = number / 10;
			count++;
		}
		return front == rear;
	}
	
	//305. Number of Islands II
	int direction[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
    	List<Integer> res = new ArrayList<>();
        if (m < 0 || n < 0) return res;
        
        int count = 0;
        int roots[] = new int[m * n];
        Arrays.fill(roots, -1);
        
        for (int[] p : positions) {
			int root = p[0] * n + p[1];
			roots[root] = root;
			count++;
			
			for (int[] d : direction) {
				int x = p[0] + d[0], y = p[1] + d[1];
				int tmp = n * x + y;
				if (x < 0 || x >= m || y < 0 || y >= n || roots[tmp] == -1) continue;
				int rootTmp = findRoot(roots, tmp);
				if (rootTmp != root) {
					roots[root] = rootTmp;
					root = rootTmp;
					count--;
				}
			}
			res.add(count);
		}
        return res;
    }
	private int findRoot(int[] roots, int tmp) {
		while (roots[tmp] != tmp) {
			roots[tmp] = roots[roots[tmp]];
			tmp = roots[tmp];
		}
		return tmp;
	}
	
	//694. Number of Distinct Islands
    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					StringBuilder sb = new StringBuilder();
					DFSHelper(grid, i, j, sb, 'o');
					set.add(sb.toString());
				}
			}
		}
        return set.size();
    }

	private void DFSHelper(int[][] grid, int i, int j, StringBuilder sb, char dir) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) return;
		sb.append(dir);
		grid[i][j] = 0;
		DFSHelper(grid, i - 1, j, sb, 'u');
		DFSHelper(grid, i + 1, j, sb, 'd');
		DFSHelper(grid, i, j - 1, sb, 'l');
		DFSHelper(grid, i, j + 1, sb, 'r');
		sb.append('b');
	}
	
	//210. Course Schedule II
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return null;
        int[] pcount = new int[numCourses], order = new int[numCourses];
        	int index = 0;
        for (int i = 0; i < prerequisites.length; i++)
			pcount[prerequisites[i][0]]++;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++)
			if (pcount[i] == 0) {
				order[index++] = i;
				queue.add(i);
			}
        while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int i = 0; i < prerequisites.length; i++) {
				if (cur == prerequisites[i][1]) {
					pcount[prerequisites[i][0]]--;
					if (pcount[prerequisites[i][0]] == 0) {
						order[index++] = prerequisites[i][0];
						queue.add(prerequisites[i][0]);
					}
				}
			}
		}
        return (index == numCourses)? order : new int[0];
    }
    
    //283. Move Zeroes
    public void moveZeroes(int[] nums) {
        int i = 0, start = 0;
        while (i < nums.length) {
			while (i < nums.length && nums[i] == 0) i++;
			if (i != start && i < nums.length) swap(nums, i, start);
			start++;
			i++;
		}
    }

	private void swap(int[] nums, int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
	
	//Insert BST
	TreeNode insertRec(TreeNode root, int key) {
		 
        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }
 
        /* Otherwise, recur down the tree */
        if (key < root.val)
            root.left = insertRec(root.left, key);
        else if (key > root.val)
            root.right = insertRec(root.right, key);
 
        /* return the (unchanged) node pointer */
        return root;
    }
	
	//42. Trapping Rain Water
    public int trap(int[] height) {
        int start = 0, end = height.length - 1;
        int left = 0, right = 0;
        int res = 0;
        while (start <= end) {
			left = Math.max(left, height[start]);
			right = Math.max(right, height[end]);
			if (left < right) {
				res += left - height[start];
				start++;
			} else {
				res += right - height[end];
				end--;
			}
		}
        return res;
    }
    //162. Find Peak Element
    int findPeakElement(int[] num) 
    {
        int low = 0;
        int high = num.length-1;
        
        while(low < high)
        {
            int mid1 = (low+high)/2;
            int mid2 = mid1+1;
            if(num[mid1] < num[mid2])
                low = mid2;
            else
                high = mid1;
        }
        return low;
    }
    
    //69. sqrt(x)
    public int mySqrt(int x) {
		if (x == 0) {
			return 0;
		}
		int start = 1, end = x;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (mid > x / mid) {
				end = mid - 1;
			} else {
				if ((mid + 1) > x / (mid + 1)) {
					return mid;
				}
				start = mid + 1;
			}
		}
		return start;
    }
    //628. Maximum Product of Three Numbers
    public int maximumProduct(int[] nums) {
        if (nums.length < 3) return 0;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int i : nums) {
			if (i > max1) {
				max3 = max2;
				max2 = max1;
				max1 = i;
			} else if (i > max2) {
				max3 = max2;
				max2 = i;
			} else if (i > max3) {
				max3 = i;
			}
			if (i < min1) {
				min2 = min1;
				min1 = i;
			} else if (i < min2) {
				min2 = i;
			}
		}
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }
    
    //s1 = "How about today and today is a nice day"
//    s2 = "How and today nice"
//    		按顺序打印出s2 中缺少的s1 中有的单词。
//    		接着follow up 是：
//    		如果s2 中的单词无序，譬如.
//    		s2 = "nice and how today"
//    		那么程序怎么改？（此时输出也可以无序）
    public void missingWords(String s1, String s2) {
		String[] ch1 = s1.split(" "), ch2 = s2.split(" ");
		int p1 = 0, p2 = 0;
		while (p1 < ch1.length && p2 < ch2.length) {
			if (!ch1[p1].equals(ch2[p2])) {
				System.out.println(ch1[p1]);
				p1++;
			} else {
				p1++; p2++;
			}
		}
		while (p1 < ch1.length) {
			System.out.println(ch1[p1]);
			p1++;
		}
	}
    public void missingWords2(String s1, String s2) {
		String[] ch1 = s1.split(" "), ch2 = s2.split(" ");
		Set<String> set = new HashSet<>();
		for (String s : ch2) {
			set.add(s);
		}
		for (String s : ch1) {
			if (set.contains(s)) {
				set.remove(s);
			} else {
				set.add(s);
			}
		}
		System.out.println(set);
	}
    
    
    //254. Factor Combinations
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        DFSHelper(res, new ArrayList<Integer>(), n, 2);
        return res;
    }

	private void DFSHelper(List<List<Integer>> res, ArrayList<Integer> path, int n, int index) {
			if (path.size() >= 1) {
				path.add(n);
				res.add(new ArrayList<>(path));
				path.remove(path.size()-1);
			}
		for (int i = index; i * i <= n; i++) {
			if (n % i == 0) {
				path.add(i);
				DFSHelper(res, path, n / i, i);
				path.remove(path.size() - 1);
			}
		}
	}
	
}
