package leetcode300_349;
//318. Maximum Product of Word Lengths

public class N318 {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) return 0;
        int n = words.length;
        int values[] = new int[n];
        for (int i = 0; i < n; i++) {
			String tmp = words[i];
			for (int j = 0; j < tmp.length(); j++)
				values[i] |= 1 << (tmp.charAt(j) - 'a');
		}
        int max = 0;
        for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if ((values[i] & values[j]) == 0 && words[i].length() * words[j].length() > max) {
					max = words[i].length() * words[j].length();
				}
			}
		}
        return max;
    }
}
