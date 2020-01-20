package permu_combi_bitOper_etc_0816;

public class Permutation1Test {

//	1,2,3
//	3자리수 순열
//	3P3 = 3! = 6가지 경우
	public static void main(String[] args) {
		int n = 3;
		int count = 0;
		for (int i = 1; i <= n; i++) { // 첫째 수 : 1,2,3 시도
			for (int j = 1; j <= n; j++) { // 둘째 수 : 1,2,3 시도
				if (i != j) { // 첫째 수와 둘째 수가 다르면
					for (int k = 1; k <= n; k++) { // 셋째 수 : 1,2,3 시도
						if (i != k && j != k) {
							System.out.println(i + " " + j + " " + k);
							count++;
						}
					}
				}
			}
		}
		System.out.println("경우의수 : " + count);
	}
}
