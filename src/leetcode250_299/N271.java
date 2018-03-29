package leetcode250_299;
import java.util.ArrayList;
import java.util.List;

public class N271 {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String string : strs) {
			sb.append(string.length()).append("@").append(string);
		}
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
			int at = s.indexOf("@", i);
			int len = Integer.parseInt(s.substring(i, at));
			result.add(s.substring(at + 1, at + len + 1));
			i = at + len + 1;
		}
        return result;
    }
}
