package divide_etc_0807;

public class PowerTest {
	
	// 2^4 = 2^3*2
	//		 2^3 = 2^2 *2
	//			   2^2 = 2^1 *2
	
	// 2^100 = 2^50 * 2^50
	//		   2^50 = 2^25 * 2^25
	
	public static int power0(int base, int exp) {
		if(exp==1) return base;
		return power0(base,exp-1)*base;
	}
	public static int power(int base,int exp) {
		if(exp == 1) return base;
		int halfExp = exp/2;
		int result = power(base,halfExp);
		result *= result;
		if(exp%2==1) result *= base;	// 홀수 지수
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(power(2,100000));
		System.out.println(power0(2,100000));
	}
}
