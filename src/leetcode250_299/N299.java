package leetcode250_299;
//299. Bulls and Cows


public class N299 {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] number = new int[128];
        for (int i = 0; i < secret.length(); i++) {
			char s = secret.charAt(i);
			char g = guess.charAt(i);
			if (s == g) bulls++;
			else {
				if (number[s] < 0) cows++;
				if (number[g] > 0) cows++;
				number[s]++;
				number[g]--;
			}
		}
        return bulls + "A" + cows + "B";
    }
}
