package leetcode001_049;
//4. Median of Two Sorted Arrays

public class N04 {
	public double findMedianSortedArrays(int[] A, int[] B) {
		int m = A.length, n = B.length;
		int l = (m + n + 1) / 2;
		int r = (m + n + 2) / 2;
		return (getKth(A, 0, B, 0, l) + getKth(A, 0, B, 0, r)) / 2;
	}

	private double getKth(int[] a, int i, int[] b, int j, int k) {
		if (i > a.length - 1) return b[j + k - 1];
		if (j > b.length - 1) return a[i + k - 1];
		if (k == 1) return Math.min(a[i], b[j]);
		
		int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
		if (i + k / 2 - 1 < a.length) aMid = a[i + k / 2 - 1];
		if (j + k / 2 - 1 < b.length) bMid = b[j + k / 2 - 1];
		
		if (aMid < bMid) return getKth(a, i + k / 2, b, j, k - k / 2);
		return getKth(a, i, b, j + k / 2, k - k / 2);
	}
}
