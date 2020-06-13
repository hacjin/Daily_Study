package pretest_0717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_1289_원재의메모리복구 {
		// NumberFormatException 은 parseInt 때문, IOException은 readLine 때문
	public static void main(String[] args) throws NumberFormatException, IOException {
//		Scanner sc = new Scanner(System.in);
//		int T = sc.nextInt();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
//			char[] input = sc.next().toCharArray(); // char 배열로
			char[] input = br.readLine().toCharArray();	// compile error 발생시 예외 처리
			int N = input.length,count = 0;
			char[] init = new char[N];
			Arrays.fill(init, '0');

			for (int j = 0; j < N; j++) { // input 기준으로 한비트씩 앞쪽에서 검사
				if (input[j] == init[j]) {
					continue; // 고칠필요없는 비트이면 건너뜀
				}
				for (int k = i; k < N; k++) {
					init[k] = input[j];
				}
				count++;	// 고쳤으니 카운트 증가
			}
			System.out.println("#"+i+" "+count);
		}
	}
}
