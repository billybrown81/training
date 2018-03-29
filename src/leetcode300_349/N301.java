package leetcode300_349;
import java.util.ArrayList;
import java.util.List;

//301. Remove Invalid Parentheses
public class N301 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        remove(ans, s, 0, 0, new char[] {'(', ')'});
        return ans;
    }

	private void remove(List<String> ans, String s, int last_i, int last_j, char[] cs) {
		for (int stack = 0, i = last_i; i < s.length(); i++) {
			if (s.charAt(i) == cs[0]) stack++;
			if (s.charAt(i) == cs[1]) stack--;
			if (stack < 0) {
				for (int j = last_j; j <= i; j++) {
					if (s.charAt(j) == cs[1] && (j == last_j || s.charAt(j - 1) != cs[1])) {
						remove(ans, s.substring(0, j) + s.substring(j + 1, s.length()), i, j, cs);
					}
				}
				return;
			}
		}
		String reversed = new StringBuilder(s).reverse().toString();
		if (cs[0] == '(') {
			remove(ans, reversed, 0, 0, new char[] {')', '('});
		} else {
			ans.add(reversed);
		}
	}
}