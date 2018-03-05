
public class N55 {
    public boolean canJump(int[] nums) {
        int size = nums.length, position = size - 1;
        for (int i = size - 1; i >= 0 ; i--) {
			if (i + nums[i] >= position) {
				position = i;
			}
		}
        return position == 0;
    }
}
