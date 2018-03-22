package leetcode201_300;

public class N223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int len = findLen(A, C, E, G);
        int hgt = findLen(B, D, F, H);
        return (A - C) * (B - D) + (E - G) * (F - H) - len * hgt;
    }

	private int findLen(int a, int b, int c, int d) {
		if (a == b || c == d) return 0;
		if (c < a) {
			if (d < a) return 0;
			if (d >= a && d <= b) return d - a;
			if (d > b) return b - a;
		} else if (c >= a && c <= b) {
			if (d <= b) return d - c;
			if (d > b) return b - c;
		}
		return 0;
	}
}
