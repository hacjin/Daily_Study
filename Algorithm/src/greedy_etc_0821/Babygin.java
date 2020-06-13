package greedy_etc_0821;



import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;
/**counting 하여 세기*/
/*
5
667767
054060
101123
123123
777777
 */
public class Babygin {
	static int N = 6;
	static int numbers[];	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/babygin.txt"));
		Scanner sc = new Scanner(System.in);
		numbers= new int[N];
		int T = sc.nextInt();
		int i=0;
		for (int tc = 1; tc <=T; tc++) {
			String data = sc.next();
			for (i = 0; i <6; i++) {
				numbers[i] = data.charAt(i)-'0';
			}
			if(isBabygin()) {
				System.out.println("#"+tc+" is Babygin");
			}else {
				System.out.println("#"+tc+" is not Babygin");
			}
		}
	}
	private static boolean isBabygin() {
		int run = 0, triplet = 0;
		int size = 10;
		int[] counts = new int [size+2];
		for (int i = 0; i <6; i++)  counts[numbers[i]]++;

		int i=0;
		while(i<size) {
			if(counts[i]>=3) {
				counts[i] -= 3;
				++triplet;
				continue;
			}else if(counts[i]>=1 && counts[i+1] >=1 && counts[i+2] >=1) {
				++run;
				counts[i]--;
				counts[i+1]--;
				counts[i+2]--;
				continue;
			}
			++i;
		}
		return run+triplet==2?true:false;
	}
}


















