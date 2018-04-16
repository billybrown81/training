package google_on_site;

public class RangeSum {
	int[] arr, BIT;
	int n;
	public RangeSum(int[] arr) {
		this.arr = arr;
		this.n = arr.length;
		BIT = new int[n + 1];
		for (int i = 0; i < n; i++) {
			updateBIT(i, arr[i]);
		}
	}
	private void updateBIT(int i, int diff) {
		i++;
		while (i <= n) {
			BIT[i] += diff;
			i += i & -i;
		}
	}
	public void update(int index, int value) {
		int diff = value - arr[index];
		arr[index] = value;
		updateBIT(index, diff);
	}
	public int sum(int i, int j) {
		return getSum(j) - getSum(i - 1);
	}
	private int getSum(int i) {
		i++;
		int res = 0;
		while (i > 0) {
			res += BIT[i];
			i -= i & -i;
		}
		return res;
	}
}
