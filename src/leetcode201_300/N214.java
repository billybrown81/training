package leetcode201_300;

public class N214 {
    public String shortestPalindrome(String s) {
        String tmp = s + "#" + new StringBuilder(s).reverse().toString();
        int[] table = buildTable(tmp);
        return new StringBuilder(s.substring(table[table.length - 1])).reverse() + s;
    }

	private int[] buildTable(String s) {
		int[] table = new int[s.length()];
		int len= 0;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(len) == s.charAt(i)) {
				len++;
				table[i] = len;
			} else {
				while (len > 0 && s.charAt(len) != s.charAt(i)) {
					len = table[len - 1];
				}
				if (s.charAt(len) == s.charAt(i)) {
					len++;
				}
				table[i] = len;
			}
		}
		return table;
	}
}
