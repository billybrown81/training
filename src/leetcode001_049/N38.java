package leetcode001_049;

import java.util.ArrayList;
import java.util.List;

public class N38 {
    public String countAndSay(int n) {
        String answer = "1";
        if (n < 0) {
			return null;
		}
        else if (n == 0) {
			return answer;
		}
        else {
            for (int i = 1; i < n; i++) {
            	StringBuilder newAns = new StringBuilder();
            	char curr = answer.charAt(0);
            	int count = 0;
            	for (int j = 0; j < answer.length(); j++) {
            		if (curr != answer.charAt(j)) {
						newAns.append(count).append(curr);
						curr = answer.charAt(j);
						count = 1;
					}
            		else count ++;
            		if (j == answer.length() - 1) {
            			newAns.append(count).append(curr);
					}
				}
            	answer = newAns.toString();
    			}
		}

        
        return answer;
    }
}
