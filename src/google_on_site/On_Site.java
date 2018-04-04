package google_on_site;

public class On_Site {
	public boolean isSubsequence(String a, String b) {
		int i = 0;
		for (int j = 0; i < a.length() && j < b.length(); j++) {
			if (a.charAt(i) == b.charAt(j)) i++;
		}
		return i == a.length();
	}
}
