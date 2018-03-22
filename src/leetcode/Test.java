package leetcode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode201_300.N290;

public class Test {

	public static void main(String args[]) {
		if (N290.wordPattern("abba", "dog cat cat dog")) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
	}
	
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
			return res;
		}
        DFSHelper(res, nums, 0);
        return res;
    }

	private static void DFSHelper(List<List<Integer>> res, int[] nums, int index) {
		if (index == nums.length - 1) {
			List<Integer> cur = new ArrayList<Integer>();
			for (int i = 0; i < nums.length; i++) {
				cur.add(nums[i]);
			}
			res.add(cur);
			return;
		}
		for (int i = index; i < nums.length; i++) {
			if (nums[index] == nums[i]) {
				continue;
			}
			swap(nums, index, i);
			DFSHelper(res, nums, index + 1);
			swap(nums, index, i);
		}
		
	}

	private static void swap(int[] nums, int index, int i) {
		int temp = nums[index];
		nums[index] = nums[i];
		nums[i] = temp;
	}
	
    public static int almost_palindromes(String str) {
        int score = 0, start = 0, end = str.length() - 1;
        while (start < end) {
			if (str.charAt(start) != str.charAt(end)) score += 2;
			start++; end --;
		}
        return score;
    }
    
    public static int ascii_deletion_distance(String str1, String str2) {
    	int len1 = str1.length();
    	int len2 = str2.length();
     
    	// len1+1, len2+1, because finally return dp[len1][len2]
    	int[][] dp = new int[len1 + 1][len2 + 1];
     
    	for (int i = 0; i <= len1; i++) {
    		if (i == 0) dp[i][0] = i;
    		else {
    			dp[i][0] = (int) str1.charAt(i - 1);
		}
    	}
     
    	for (int j = 0; j <= len2; j++) {
    		if (j == 0) dp[j][0] = j;
    		else {
    			dp[j][0] = (int) str1.charAt(j - 1);
		}
    	}
     
    	//iterate though, and check last char
    	for (int i = 0; i < len1; i++) {
    		char c1 = str1.charAt(i);
    		for (int j = 0; j < len2; j++) {
    			char c2 = str2.charAt(j);
     
    			//if last two chars equal
    			if (c1 == c2) {
    				dp[i + 1][j + 1] = dp[i][j];
    			} else {
    				int replace = dp[i][j];
    				int insert = dp[i][j + 1] + 1;
    				int delete = dp[i + 1][j] + 1;
     
    				int min = replace > insert ? insert : replace;
    				min = delete > min ? min : delete;
    				dp[i + 1][j + 1] = min;
    			}
    		}
    	}
     
    	return dp[len1][len2];
    }
    

    public static int four_letter_words(String sentence) {
        String[] words = sentence.split(" ");
        int res = 0;
        for (String string : words) {
			if (string.length() == 4) res++;
		}
        return res;
    }
}
