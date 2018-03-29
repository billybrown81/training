package leetcode050_099;

public class N67 {
    public String addBinary(String a, String b) {
    		int sizeA = a.length(), sizeB = b.length();
    		if (sizeA < sizeB) {
			String temp = a;
			a = b;
			b = temp;
		}
        StringBuilder res = new StringBuilder(0);
        int i, extra = 0, aextra, bextra;
        for (i = a.length() - 1; i >= 0 ; i--) {
			if (i < a.length() - b.length()) {
				bextra = 0;
			} else {
				bextra = Integer.valueOf(String.valueOf(b.charAt(i- (a.length() - b.length()))));
			}
			aextra = Integer.valueOf(String.valueOf(a.charAt(i)));
			int sum = aextra + bextra + extra;
			int cur = sum % 2;
			extra = sum / 2;
			res.insert(0, String.valueOf(cur));
		}
        if (i == -1 && extra == 1) {
			res.insert(0, "1");
		}
        return res.toString();
    }
}
