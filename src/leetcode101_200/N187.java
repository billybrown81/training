package leetcode101_200;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class N187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() < 10) return res;
        Set<String> first = new HashSet<String>(), second = new HashSet<String>();
        for (int i = 0; i <= s.length() - 10; i++) {
			String s1 = s.substring(i, i + 10);
			if (!first.add(s1)) second.add(s1);
		}
        res.addAll(second);
        return res;
    }
}
