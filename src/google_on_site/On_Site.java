package google_on_site;

public class On_Site {
	public boolean isSubsequence(String a, String b) {
		int i = 0;
		for (int j = 0; i < a.length() && j < b.length(); j++) {
			if (a.charAt(i) == b.charAt(j)) i++;
		}
		return i == a.length();
	}
	
	public int minTwoes(int N) {
		int count = 0, n = N;
		while (n > 0) {
			if ((n & 1) == 1) count++;
			n >>>= 1;
		}
		return count;
	}
	
	public int minTwoesN(int N) {
		int res = minTwoes(N);
		int n = 1;
		while (n < N) {
			n *= 2;
		}
		res = Math.min(res, minTwoes(n) + minTwoes(n - N));
		return res;
	}
}
