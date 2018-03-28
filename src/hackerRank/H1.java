package hackerRank;
import java.util.Scanner;

public class H1 {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner in = new Scanner(System.in);
		int n = Integer.valueOf(in.nextLine());
        for (int i = 1; i <= n; i++) {
 		String string = in.nextLine();
 		int px = Integer.valueOf(string.charAt(0));
 		int py = Integer.valueOf(string.charAt(2));
 		int qx = Integer.valueOf(string.charAt(4));
 		int qy = Integer.valueOf(string.charAt(6));
 		int rx = 2 * qx - px;
 		int ry = 2 * qy - py;
 		System.out.println(rx + ' ' + ry);
 		}
    }
	
    static int countHoles(int num) {
    		int ans = 0;
    		String number = String.valueOf(num);
    		for (int i = 0; i < number.length(); i++) {
				int cur = Integer.valueOf(String.valueOf(number.charAt(i)));
				switch (cur) {
				case 1 : case 2 : case 3: case 5 : case 7:
					
					break;
				case 0 : case 4 : case 6: case 9 :
					ans += 1;
					break;
					
					case 8:
						ans += 2;
						break;
				}
				
			}
    		return ans;
    }
    
    
    static int[] getMinimumDifference(String[] a, String[] b) {
    		int numA = Integer.valueOf(a[0]), numB = Integer.valueOf(b[0]);
    		int length = Integer.min(numA, numB);
    		int[] res = new int[a.length - 1];
    		for (int i = 0; i < length; i++) {
				String aa = a[i+1], bb = b[i + 1];
				int aSize = aa.length(), bSize = bb.length();
				StringBuilder aBuilder = new StringBuilder(aa), bBuilder = new StringBuilder(bb);
				int num = 0;
				if (aSize != bSize) {
					num = -1;
				} else {
					for (int j = 0; j < aSize; j++) {
						char c = aa.charAt(j);
						int index = bBuilder.indexOf(String.valueOf(c));
						if (index >= 0) {
							bBuilder.deleteCharAt(index);
						} else {
							num += 1;
						}
					}
				}	
				res[i] = num;
			}
    		
    		return res;
    }
    
    static long countX(String[] steps) {
    		int num = Integer.valueOf(steps[0]);
    		long ans = 0;
    		long row = 1000000, col = 1000000;
    		for (int i = 0; i < steps.length; i++) {
				String string = steps[i + 1];
				long row1 = Long.valueOf(String.valueOf(string.charAt(0)));
				long col1 = Long.valueOf(String.valueOf(string.charAt(2)));
				row = Long.min(row, row1);
				col = Long.min(col, col1);
			}
    		ans = row * col;
    		return ans;
    }
    
    static String[] reducedFractionSums(String[] expressions) {
    		int num = Integer.valueOf(expressions[0]);
    		String[] res = new String[num];
    		for (int i = 1; i < expressions.length; i++) {
				String string = expressions[i];
				int size = string.length();
				int j = 0;
				int num1, num2, num3, num4;
				while (j < size && string.charAt(j) != '/') {
					j++;
				}
				num1 = Integer.valueOf(string.substring(0, j - 1));
				int k = j + 1;
				while (j < size && string.charAt(j) != '+') {
					j++;
				}
				num2 = Integer.valueOf(string.substring(k, j - 1));
				k = j + 1;
				while (j < size && string.charAt(j) != '/') {
					j++;
				}
				num3 = Integer.valueOf(string.substring(k, j - 1));
				k = j + 1;
				num4 = Integer.valueOf(string.substring(k, size - 1));
				
				int ans1 , ans2;
				ans2 =  num2 * num4;
				ans1 =  num1 * num4 + num2 * num3;
				
				res[i - 1] = asFraction(ans1, ans2);
				
			}
    		
    		
    		return res;
    }
    static int gcm(int a, int b) {
        return b == 0 ? a : gcm(b, a % b);
    }

    static String asFraction(int a, int b) {
        int gcm = gcm(a, b);
        return (a / gcm) + "/" + (b / gcm);
    }
}
