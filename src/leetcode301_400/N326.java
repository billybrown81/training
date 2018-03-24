package leetcode301_400;

public class N326 {
    public boolean isPowerOfThree(int n) {
        int max = (int) (Math.pow(3, (int) (Math.log(Integer.MAX_VALUE) / Math.log(3))));
        return n == 0? false : max % n == 0;
    }
}
