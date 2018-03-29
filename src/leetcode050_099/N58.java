package leetcode050_099;

public class N58 {
	   public int lengthOfLastWord(String s) {
	        int index = s.length() - 1;
	        
	        while (index >= 0 && s.charAt(index) == ' ') {
				index--;
			}
	        int end = index;
	        while (index >= 0 && s.charAt(index) != ' ') {
				index--;
			}
	        
	        return end - index;
	    }
}
