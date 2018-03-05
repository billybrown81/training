import javax.xml.stream.events.EndDocument;

public class N74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
    		int m = matrix.length, n = matrix[0].length;
    		if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) {
			return false;
		}
    		int start = 0, end = matrix.length - 1, mid, mid1;
    		while (true) {
			mid = start + (end - start) / 2;
			if (matrix[mid][0] > target) {
				end = mid - 1;
			} else {
				if (mid == matrix.length - 1 || matrix[mid + 1][0] > target) {
					break;
				}
				start = mid + 1;
			}
		}
    		start = 0;
    		end = matrix[0].length - 1;
    		while (start < end) {
			mid1 = start + (end - start) / 2;
			if (matrix[mid][mid1] == target) {
				return true;
			} else if (matrix[mid][mid1] > target) {
				end = mid1 - 1;
			} else {
				start = mid1 + 1;
			}
		}
    		return matrix[mid][start] == target;
    }
}
