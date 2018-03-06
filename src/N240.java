
public class N240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int rowlen = matrix.length, collen = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[rowlen - 1][collen - 1]) return false;
        int i = 0, j = collen - 1;
        while (i < rowlen && j >= 0) {
			if (target == matrix[i][j]) return true;
			if (target < matrix[i][j]) j--;
			else i++;
		}
        return false;
    }
}
