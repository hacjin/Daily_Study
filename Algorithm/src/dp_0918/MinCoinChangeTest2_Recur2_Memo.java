package dp_0918;
import java.util.Arrays;
import java.util.Scanner;

public class MinCoinChangeTest2_Recur2_Memo {
	static int memo[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		memo = new int[money+1];
		Arrays.fill(memo, -1);
		System.out.println(changeCoin(money));
	}
	//money 금액을 만들 수 있는 최소동전개수 리턴
	private static int changeCoin(int money) {
		if(money==0) return 0;
		if(memo[money] != -1) return memo[money];
		
		int min = Integer.MAX_VALUE;
		int temp;
		// 6원 시도
		if(money>=6 && (temp=changeCoin(money-6)+1) < min ) min = temp;
		// 4원 시도
		if(money>=4 && (temp=changeCoin(money-4)+1) < min ) min = temp;
		// 1원 시도
		if(money>=1 && (temp=changeCoin(money-1)+1) < min ) min = temp;
		
		return memo[money]=min;
	}	

}
