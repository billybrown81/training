package google_on_site;

import java.util.ArrayList;
import java.util.List;

public class KMP_String_Matching {
	public List<Integer> search(String s, String pattern) {
		List<Integer> res = new ArrayList<>();
		int[] lps = computeLPS(pattern);
		int i = 0, j = 0;
		int m = s.length(), n = pattern.length();
		while (i < m) {
			if (s.charAt(i) == pattern.charAt(j)) {
				i++; j++;
			} else  {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					i++;
				}
			}
			if (j == n) {
				res.add(i - j);
				j = lps[j - 1];
			}
		}
		return res;
	}

	private int[] computeLPS(String pattern) {
		int n = pattern.length();
		int[] lps = new int[n];
		int len = 0, i = 1;
		while (i < n) {
			if (pattern.charAt(i) == pattern.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {
				if (len != 0) {
					len = lps[len - 1];
				} else {
					lps[i++] = 0;
				}
			}
		}
		return lps;
	}
}
