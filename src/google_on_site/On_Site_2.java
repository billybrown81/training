package google_on_site;

public class On_Site_2 {
	public int lengthOfSubfixEqualsPrefix(int[] A, int[] B) {
		int a = A.length, b = B.length;
		int[] kmp = new int[a + b];
		int len = 0;
		int i = 1;
		while (i < a + b) {
			int[] cur = i < b ? B: A;
			int idx = i < b? i : i - b;
			if (cur[idx] == B[len]) {
				len++;
				kmp[i] = len;
				i++;
			} else {
				if (len != 0) {
					len = kmp[len - 1];
				} else {
					kmp[i] = len;
					i++;
				}
			}
		}
		return kmp[a + b - 1];
	}
}
