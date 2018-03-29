package leetcode150_199;

public class N165 {
    public int compareVersion(String version1, String version2) {
    		int i = 0, j = 0;
        while (i < version1.length() && version1.charAt(i) != '.') i++;
        while (j < version2.length() && version2.charAt(j) != '.') j++;
        int n1 = Integer.parseInt(version1.substring(0, i)), n2 = Integer.parseInt(version2.substring(0, j));
        if (n1 > n2) return 1;
        else if (n1 < n2) return -1;
        else {
            while (i < version1.length() && version1.charAt(i) != '.') i++;
            while (j < version2.length() && version2.charAt(j) != '.') j++;
			n1 = i == version1.length()? 0 : Integer.parseInt(version1.substring(i + 1, version1.length()));
			n2 = j == version2.length()? 0 : Integer.parseInt(version2.substring(j + 1, version2.length()));
	        if (n1 > n2) return 1;
	        else if (n1 < n2) return -1;
	        else return 0;
		}
    }
}
