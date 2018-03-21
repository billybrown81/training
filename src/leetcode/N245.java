package leetcode;

public class N245 {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int p1 = -1, p2 = -1, min = Integer.MAX_VALUE;
        boolean same = word1.equals(word2);
        for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				if (same) {
					p1 = p2;
					p2 = i;
				} else p1 = i;
			} else if (words[i].equals(word2)) p2 = i;
			if (p1 != -1 && p2 != -1) {
				min = Math.min(min, Math.abs(p2 - p1));
			}
		}
        return min;
    }
}
