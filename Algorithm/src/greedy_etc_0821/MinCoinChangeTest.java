package greedy_etc_0821;

import java.util.Arrays;
import java.util.Scanner;

public class MinCoinChangeTest {

	public static void main(String[] args) {
		
//		int[] coin = {500,100,50,10};
		int[] coin = {500,400,100,50,10};
		int[] result = new int[coin.length];
		int money = new Scanner(System.in).nextInt();
		
		for(int i = 0; i < coin.length; ++i) {
			result[i] = money/coin[i];
			money = money % coin[i];
		}
		System.out.println(Arrays.toString(result));
	}

}








