//302. Smallest Rectangle Enclosing Black Pixels

public class N302 {
    public int minArea(char[][] image, int x, int y) {
        int m = image.length, n = image[0].length;
        int left = searchCol(image, 0, y, 0, m, true);
        int right = searchCol(image, y + 1, n , 0, m, false);
        int top = searchRow(image, 0, x, 0, n, true);
        int bottom = searchRow(image, x + 1, m, 0, n, false);
        return (right - left) * (bottom - top);
    }

	private int searchRow(char[][] image, int i, int j, int left, int right, boolean b) {
		while (i != j) {
			int k = left, mid = (i + j) / 2;
			while (k < right && image[mid][k] == '0') k++;
			if (k < right == b) {
				j = mid;
			} else {
				i = mid + 1;
			}
		}
		return i;
	}

	private int searchCol(char[][] image, int i, int j, int top, int bottom, boolean b) {
		while (i != j) {
			int k = top, mid = (i + j) / 2;
			while (k < bottom && image[k][mid] == '0') k++;
			if (k < bottom == b) {
				j = mid;
			} else {
				i = mid + 1;
			}
		}
		return i;
	}
}
