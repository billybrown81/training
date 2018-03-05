
public class N59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int num = 1;
        for (int i = 0; i < (n + 1) / 2; i++) {
			int len = n - 2 * i;
			if (len == 1) {
				res[i][i] = num;
			} else {
				for (int j = 0; j < len - 1; j++) {
					res[i][i + j] = num;
					res[i + j][n - i - 1] = num + len - 1;
					res[n - i - 1][n - i - j - 1] = num + 2 * (len - 1);
					res[n - i - j - 1][i] = num + 3 * (len - 1);
					num++;
				}
			}
			num += 3 * (len - 1);
		}
        
        return res;
    }
}
