package dp_0918;
import java.util.Scanner;

public class MinCoinChangeTest_Recur {
	static int min=Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		
		System.out.println(changeCoin(money));
	}
	//money 금액을 만들 수 있는 최소동전개수 리턴
	private static int changeCoin(int money) {
		if(money==0) return 0;
		int min = Integer.MAX_VALUE;
		int temp;
		// 6원 시도
		if(money>=6 && (temp=changeCoin(money-6)+1) < min ) min = temp;
		// 4원 시도
		if(money>=4 && (temp=changeCoin(money-4)+1) < min ) min = temp;
		// 1원 시도
		if(money>=1 && (temp=changeCoin(money-1)+1) < min ) min = temp;
		
		return min;
	}	

}
