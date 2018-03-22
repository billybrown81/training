package leetcode301_400;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

//313. Super Ugly Number

public class N313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) return 1;
        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(1);
        int num = 1;
        Set<Integer> set = new HashSet<>();
        while (n > 0) {
			num = queue.poll();
			n--;
			for (int prime : primes) {
				int tmp = num * prime;
				if (set.contains(tmp)) continue;
				set.add(tmp);
				queue.offer(tmp);
			}
		}
        return num;
    }
    
    public int nthSuperUglyNumber2(int n, int[] primes) {
    		int ugly[] = new int[n];
    		int idx[] = new int[primes.length];
    		ugly[0] = 1;
    		for (int i = 1; i < n; i++) {
			ugly[i] = Integer.MAX_VALUE;
			for (int j = 0; j < primes.length; j++) {
				ugly[i] = Math.min(ugly[i], primes[j] * ugly[idx[j]]);
			}
			for (int j = 0; j < primes.length; j++) {
				while (primes[j] * ugly[idx[j]] <= ugly[i]) {
					idx[j]++;
				}
			}
		}
    		return ugly[n - 1];
    }
}
