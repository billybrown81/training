package leetcode050_099;
import java.util.ArrayList;
import java.util.List;

public class N54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return res;
		}
        int row = matrix.length, col = matrix[0].length;
        int circle = (Math.min(row, col) + 1) / 2;
        for (int i = 0; i < circle; i++) {
			int circleRow = row - 2 * i, circleCol = col - 2 * i;
				if (circleRow == 1) {
					for (int j = 0; j < circleCol; j++) {
						res.add(matrix[i][i + j]);
					}
				}else if (circleCol == 1) {
					for (int j = 0; j < circleRow; j++) {
						res.add(matrix[i + j][i]);
					}
				} else {
				for (int j = 0; j < circleCol - 1; j++) {
					res.add(matrix[i][i + j]);
				}
				for (int j = 0; j < circleRow - 1; j++) {
					res.add(matrix[i + j][col - i - 1]);
				}
				for (int j = 0; j < circleCol - 1; j++) {
					res.add(matrix[row - i - 1][col - i - j - 1]);
				}
				for (int j = 0; j < circleRow- 1; j++) {
					res.add(matrix[row - i - j - 1][i]);
				}
			}
		}
        
        return res;
    }
}
