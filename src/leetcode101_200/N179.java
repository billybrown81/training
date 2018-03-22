package leetcode101_200;
import java.util.Arrays;
import java.util.Comparator;

public class N179 {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        String[] strings = new String[nums.length];
        for (int i = 0; i < strings.length; i++) strings[i] = nums[i] + "";
        Comparator<String> comparator = new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				String s1 = a + b;
				String s2 = b + a;
				return s1.compareTo(s2);
			}
		};
        Arrays.sort(strings, comparator);
        if (strings[strings.length - 1].charAt(0) == '0') return "0";
        String res = new String();
        for (String string : strings) res = string + res;
        return res;
    }
}
