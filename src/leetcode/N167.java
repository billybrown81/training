package leetcode;

public class N167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int start = 0, end = numbers.length - 1;
        	while (start < end) {
			if (numbers[start] + numbers[end] == target) {
				res[0] = start + 1;
				res[1] = end + 1;
				break;
			} else if (numbers[start] + numbers[end] < target) start = start + 1;
			else end = end - 1;
		}
        	return res;
    }
}
