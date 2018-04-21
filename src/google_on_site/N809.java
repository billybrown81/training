package google_on_site;

public class N809 {
    public int expressiveWords(String S, String[] words) {
        int count = 0;
        for (String string : words) {
			if (isSimilar(S, string)) {
				count++;
			}
		}
        return count;
    }

	public boolean isSimilar(String A, String B) {
		int i = 0, j = 0;
		int a = A.length(), b = B.length();
		while (i < a && j < b) {
			char ca = A.charAt(i), cb = B.charAt(j);
			if(ca != cb) return false;
			int ic = 0, jc = 0;
			while (i < a && A.charAt(i) == ca) {
				i++; ic++;
			}
			while (j < b && B.charAt(j) == cb) {
				j++; jc++;
			}
			if (jc == ic) continue;
			if (ic < 3 || ic < jc) return false;
		}
		return i == a && j == b;
	}
}
