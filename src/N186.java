
public class N186 {
    public void reverseWords(char[] str) {
    		reverse(str, 0, str.length - 1);
    		int start = 0;
    		for (int i = 0; i < str.length; i++) {
				if (str[i] == ' ') {
					reverse(str, start, i - 1);
					start = i + 1;
				}
			}
    		reverse(str, start, str.length - 1);
    		
    }

	private void reverse(char[] str, int i, int j) {
		while (i < j) {
			char tmp = str[i];
			str[i] = str[j];
			str[j] = tmp;
			i++;
			j--;
		}
	}
}
