package google_on_site;

public class N679 {
    public boolean judgePoint24(int[] nums) {
        double[] input = new double[] {nums[0], nums[1], nums[2], nums[3]};
        return helper(input);
    }

	private boolean helper(double[] input) {
		if (input.length == 1) {
			return input[0] == 24;
		}
		for (int i = 0; i < input.length; i++) {
			for (int j = i + 1; j < input.length; j++) {
				double[] tmp = new double[input.length - 1];
				for (int k = 0, l = 0; k < tmp.length; k++) {
					if (k != i && k != j) tmp[l++] = input[k];
				}
				for (double d : compute(input[i], input[j])) {
					tmp[tmp.length - 1] = d;
					if (helper(tmp)) return true;
				}
			}
		}
		return false;
	}

	private double[] compute(double a, double b) {
		return new double[] {a + b, a - b, b - a, a * b, a / b, b / a};
	}
}
