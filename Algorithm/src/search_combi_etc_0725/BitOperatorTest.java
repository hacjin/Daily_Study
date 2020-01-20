package search_combi_etc_0725;
/**
 * 비트 마스킹 사용법
 *
 */
public class BitOperatorTest {
	public static void main(String[] args) {
		int i = 1;	// 0001
		int j = 6;	// 0110
//		Integer.toBinaryString 은 앞의 0 을 제외하고 출력한다
		System.out.println(Integer.toBinaryString(i));
		System.out.println(Integer.toBinaryString(j));
		
//		1<<x
//		i = i<<1 동일 i <<= 1;
		System.out.println("1<<1 : " + Integer.toBinaryString(i<<1));
		System.out.println("1<<4 : " + Integer.toBinaryString(i<<4));
		
		System.out.println("i&j : " + Integer.toBinaryString(i&j));
		System.out.println("i|j : " + Integer.toBinaryString(i|j));
	}
}
