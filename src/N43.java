
public class N43 {
    public String multiply(String num1, String num2) {
        int l1 = num1.length(), l2 = num2.length();
        int[] ans = new int[l1 + l2];
        
        for (int i = l1 - 1; i >= 0; i--) {
			for (int j = l2 - 1; j >= 0; j--) {
				int mul = Integer.valueOf(String.valueOf(num1.charAt(i))) * Integer.valueOf(String.valueOf(num2.charAt(j)));
				int p1 = i + j, p2 = i + j + 1;
				int sum = mul + ans[p2];
				ans[p1] += sum / 10;
				ans[p2] = sum % 10;
			}
		}
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : ans) {
			if (!(stringBuilder.length() == 0 && i == 0)) {
				stringBuilder.append(i);
			}
		}
        if (stringBuilder.length() == 0) {
			stringBuilder.append(0);
		}
        return stringBuilder.toString();
    }
}
