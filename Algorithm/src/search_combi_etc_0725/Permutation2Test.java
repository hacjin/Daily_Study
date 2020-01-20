package search_combi_etc_0725;

public class Permutation2Test {

//	1,2,3
//	3자리수 순열
//	3P2 = 3!/1! = 6가지 경우
	public static void main(String[] args) {
		int n = 3;
		int count = 0;
		for (int i = 1; i <= n; i++) { // 첫째 수 : 1,2,3 시도
			for (int j = 1; j <= n; j++) { // 둘째 수 : 1,2,3 시도
				if (i != j) { // 첫째 수와 둘째 수가 다르면
							System.out.println(i + " " + j);
							count++;
				}
			}
		}
		System.out.println("경우의수 : " + count);
	}
}
