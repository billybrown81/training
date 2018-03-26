package oa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import leetcode.TreeLinkNode;
import leetcode.TreeNode;

public class Google_Phone {
	
//给一个dic：(a, b) (c, d)
//	(a, b)意思是a、b同义，可以互相转化。
//	那么ac = bd, ac = ad, ac = ac
//	问两个string是否相同。
	public static boolean isSymmetric(String s1, String s2, char[][] edges) {
		if (s1.length() != s2.length()) return false;
		char[] map = new char[128];
		Arrays.fill(map, '0');
		for (char edge[] : edges) {
			char x = find(map, edge[0]);
			char y = find(map, edge[1]);
			if (x == y) continue;
			map[x] = y;
		}
		for (int i = 0; i < s1.length(); i++) {
			char x = find(map, s1.charAt(i));
			char y = find(map, s2.charAt(i));
			if (x != y) return false;
		}
		return true;
	}

	private static char find(char[] map, char c) {
		if (map[c] == '0') return c;
		return find(map, map[c]);
	}
	
//	给两个char array，其中有一些char 为backspace 就是删除前面的字符，要求输出一个boolean 判断
//	两个char array 是否相同，时间要求O(n) , 空间要求O(1)
//	例如：
//	[a,b,'\b',d,c] 和[a,d,c] true
//	[a,b,'\b','\b','\b',d,c] 和 [d,c] true
//	[a,b,d,'\b'] 和 [a,d] false
	
	public static boolean isSameCharArray(char[] ch1, char[] ch2) {
		int p1 = ch1.length - 1, p2 = ch2.length - 1;
		while (p1 >= 0 && p2 >= 0) {
			int count1 = 0, count2 = 0;
			while (p1 >= 0 && ch1[p1] == '\b') {
				p1--;
				count1++;
			}
			while (p2 >= 0 && ch2[p2] == '\b') {
				p2--;
				count2++;
			}
			
			p1 -= count1; p2 -= count2;
			
			while (p1 >= 0 && ch1[p1] != '\b' && p2 >= 0 && ch2[p2] != '\b') {
				if (ch1[p1] != ch2[p2]) return false;
				p1--; p2--;
			}
		}
		return true;
	}
	
//Randomly pick one
	public static int generate(int[] candy, Set<Integer> ex) {
	    //select one random valid number from candy(not in ex){
	    int count = 0;
	    int ret = -1;
	    for(int i = 0; i<candy.length; i++) {
	      if(ex.contains(i)) continue;
	      count ++;
	      double pick = Math.random() * count;
	      if( pick  < 1 ) ret = i;
	    }
	    return ret;
	  }
	
	//347. Top K Frequent Elements
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			heap.offer(entry);
		}
        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {
			res.add(heap.poll().getKey());
		}
        return res;
    }
    
    //Leetcode 282. Expression Add Operators
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) return res;
        DFSHelper(res, "", num, target, 0, 0, 0);
        return res;
    }

	private void DFSHelper(List<String> res, String path, String num, int target, int pos, long value, long prev) {
		if (pos == num.length()) {
			if (value == target) res.add(path);
			return;
		}
		for (int i = pos; i < num.length(); i++) {
			if (i != pos && num.charAt(pos) == '0') break;
			long cur = Long.parseLong(num.substring(pos, i + 1));
			if (pos == 0) {
				DFSHelper(res, path + cur, num, target, i + 1, cur, cur);
			} else {
				DFSHelper(res, path + "+" + cur, num, target, i + 1, value + cur, cur);
				DFSHelper(res, path + "-" + cur, num, target, i + 1, value - cur, -cur);
				DFSHelper(res, path + "*" + cur, num, target, i + 1, value - prev + prev * cur, prev * cur);
			}
		}
	}

//	Create a weighted random number generator.
//	假定有100 个国家， 每个国家的人口给定，写一个函数根据国家的人口数目为权重随机返回一个国
//	家。How do we create a function which returns a randomly selected country weighted by the country's
//	population size。
	public static int weightedRandomNumber(int[] population) {
		int count = 0, res = -1;
		for (int i = 0; i < population.length; i++) {
			count += population[i];
			double pick = Math.random() * count;
			if (pick < population[i]) res = i;
		}
		return res;
		
		
	}
	
//	222. Count Complete Tree Nodes
    public int countNodes(TreeNode root) { 
		if (root == null) return 0;
		int count = 1;
		TreeNode left = root.left, right = root.left;
		while (right != null) {
			left = left.left;
			right = right.right;
			count = count << 1;
		}
		return count + (left == null? countNodes(root.right) : countNodes(root.left));
    }
    
 //   98. Validate Binary Search Tree
    public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
}

private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
	if (root == null) return true;
	if (root.val <= minValue || root.val >= maxValue) return false; 
	return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
}


//1. In an array with positive, negative and zero floats, find continuous subarray that has maximum
//product, output the start and end index of this subarray.. From 1point

//被坑了，特别恶心的一道dp n / 2 where n is even
//有个函数 y =
//3n + 1 otherwise. 1point3acres.com/bbs
//有一个数，n，然后不断求f(x)，例如5，16，8，4，2，1。长度为6。记为len(5) = 6
//我们有一个数n，len(n), len(n - 1), len(n - 2).... len(2), len(1)的最大值。

	public static int maxLength(int n) {
		int[] dp = new int[n + 1];
		dp[1] = 1;
		int res = 0;
		for (int i = 2; i <= n; i++) {
			int tmp = i, len = 0;
			while (tmp > 1) {
				if (tmp % 2 == 0) {
					tmp /= 2; len++;
				} else {
					tmp = tmp * 3 + 1;
					len++;
				}
				if (tmp <= n && dp[tmp] != 0) {
					len += dp[tmp];
					break;
				}
			}
			dp[i] = len;
			res = Math.max(res, len);
		}
		return res;
	}
	
	//Leetcode 116. Populating Next Right Pointers in Each Node
    public void connect(TreeLinkNode root) {
        if (root == null) return;
TreeLinkNode start = root;
while (start != null) {
	TreeLinkNode cur = start;
	while (cur != null) {
		if (cur.left != null) cur.left.next = cur.right;
		if (cur.right != null && cur.next != null) cur.right.next = cur.next.left;
		cur = cur.next;
	}
	start = start.left;
}
}
    
    //Leetcode 297. Serialize and Deserialize Binary Tree
    public class Codec {
    	private String NN = "null";
    	private String sp = ",";
    	
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            build(root, sb);
            return sb.toString();
        }

        private void build(TreeNode root, StringBuilder sb) {
    		if (root == null) {
    			sb.append(NN).append(sp);
    		} else {
    			sb.append(root.val).append(sp);
    			build(root.left, sb);
    			build(root.right, sb);
    		}
    		
    	}

    	// Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Queue<String> queue = new LinkedList<>();
            queue.addAll(Arrays.asList(data.split(sp)));
            return decode(queue);
        }

    	private TreeNode decode(Queue<String> queue) {
    		String val = queue.remove();
    		if (val.equals(NN)) return null;
    		TreeNode root = new TreeNode(Integer.valueOf(val));
    		root.left = decode(queue);
    		root.right = decode(queue);
    		return root;
    	}
    }
}
