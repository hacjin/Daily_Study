package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 계산은 무조건 앞에서 부터
 * 2. 나눗셈은 몫만 취한다.
 * 3. 음수를 양수로 나눌때는 양수로 바꾼뒤 몫을 취하고 몫을 음수로 바꾼것
 */
public class Main_B14888_연산자끼워넣기 {
	static int min = 1000000000, max = -1000000000;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int number[] = new int[N];
		int calc[] = new int[4]; // + , -, *, /
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < calc.length; i++) {
			calc[i] = Integer.parseInt(st.nextToken());
		}

		int index = 0;
		for (int i = 0; i < calc.length; i++) {
			if (calc[i] > 0) {
				int result = 0;
				calc[i]--;
				switch (i) {
				case 0:
					result = number[index] + number[index+1];
					break;
				case 1:
					result = number[index] - number[index+1];
					break;
				case 2:
					result = number[index] * number[index+1];
					break;
				case 3:
					result = number[index] / number[index+1];
					break;
				}
				dfs(index+2, result, calc, number, N);
				calc[i]++;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(max+"\n"+min);
		System.out.println(sb);
		
	}

	private static void dfs(int index, int result, int[] calc, int[] number, int N) {
		if (index == N) {
			if (result > max) max = result;
			if (result < min) min = result;
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (calc[i] > 0) {
				calc[i]--;
				switch (i) {
				case 0:
					dfs(index+1, result+number[index], calc, number, N);
					break;
				case 1:
					dfs(index+1, result-number[index], calc, number, N);
					break;
				case 2:
					dfs(index+1, result*number[index], calc, number, N);
					break;
				case 3:
					if(result<0) {
						dfs(index+1, ((result*-1)/number[index])*-1, calc, number, N);
					}else dfs(index+1, result/number[index], calc, number, N);
					break;
				}
				calc[i]++;
			}
		}
	}
}
