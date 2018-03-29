package leetcode050_099;

public class N91 {
    public int numDecodings(String s) {
        int size = s.length();
        if (size == 0) {
			return 0;
		}
        if (size == 1 && s.charAt(0) - '0' != 0) {
			return 1;
		}
        int index = 0;
        return DFSHelper(s, index);
    }

	private int DFSHelper(String s, int index) {
		if (index  == s.length()) {
			return 1;
		}
		if (s.charAt(index) - '0' == 0) {
			return 0;
		}
		int n1 = DFSHelper(s, index + 1), n2 = 0;
		if (index < s.length() - 1) {
			if (s.charAt(index) - '0' == 1 || s.charAt(index) - '0' == 2 && s.charAt(index + 1) - '0' <= 6) {
				n2 = DFSHelper(s, index + 2);
			}
		}
		return n1 + n2;
	}
	
	public int numDecodings2(String s) {
        int size = s.length();
        if (size == 0) {
			return 0;
		}
        if (size == 1) {
			return (s.charAt(0) == '0') ? 0 : 1;
		}
        int[] map = new int[size + 1];
        map[size] = 1;
        map[size - 1] = (s.charAt(size - 1) - '0' == 0) ? 0 : 1;
        
        for (int i = size - 2; i >= 0; i--) {
        		if (s.charAt(i) == '0') continue;
			map[i] = (Integer.valueOf(s.substring(i, i + 2)) <= 26)? map[i + 1] + map[i + 2] : map[i + 1];
		}
        return map[0];
    }
}
