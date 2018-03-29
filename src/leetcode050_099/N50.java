package leetcode050_099;

public class N50 {
    public double myPow(double x, int n) {
        int N = n;
        if (N < 0) {
			x = 1 / x;
			N = -N;
		}
        double res = 1;
        double pro = x;
        for (int i = N; i >= 1; i /= 2) {
			if (i % 2 == 1) {
				res = res * pro;
			}
			pro *= pro;
		}
        return res;
    }
}
