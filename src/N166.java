import java.util.HashMap;

public class N166 {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        sb.append(numerator / denominator);
        int n = numerator % denominator;
        if (n == 0) return sb.toString();
        sb.append(".");
        int pos = sb.length();
        numerator = n * 10;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			sb.append(numerator / denominator);
			n = numerator % denominator;
			return null;
    }
}
