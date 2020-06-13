package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_14888_연산자끼워넣기 {
	static int N;
	static StringBuilder cals = new StringBuilder();
	static int cal[] = new int[4]; // 0 : + || 1 : - || 2 : x || 3: / ||
	static int tmp[] = new int[4];
	static List<Integer> A = new LinkedList<Integer>();
	static int min=1000000000, max=-1000000000;
	static boolean chk;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			cal[i] = Integer.parseInt(st.nextToken());
		}
		System.arraycopy(cal, 0, tmp, 0, 4);
		permu(0);
		
		System.out.printf("%d\n%d",max,min);

	}

	public static void permu(int index) {
		if (index == N - 1) {
			chk = true;
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (tmp[i] != 0) {
				cals.append(i);
				tmp[i]--;
				permu(index + 1);
				if(chk && index!=0) return;
				calcu();
				cals.setLength(0);
				System.arraycopy(cal, 0, tmp, 0, 4);
				chk = false;
			}
		}
	}

	public static void calcu() {
		List<Integer> tmp = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			tmp.add(A.get(i));
		}
		int a , b;
		for (int i = 0; i < N - 1; i++) {
			switch (cals.charAt(i) - '0') {
			case 0:
				a = tmp.get(0);
				b = tmp.get(1);
				tmp.remove(0);
				tmp.remove(0);
				tmp.add(0, a+b);
				break;
			case 1:
				a = tmp.get(0);
				b = tmp.get(1);
				tmp.remove(0);
				tmp.remove(0);
				tmp.add(0, a-b);
				break;
			case 2:
				a = tmp.get(0);
				b = tmp.get(1);
				tmp.remove(0);
				tmp.remove(0);
				tmp.add(0, a*b);
				break;
			case 3:
				a = tmp.get(0);
				b = tmp.get(1);
				if(a<0) {
					a = a*-1;
					tmp.remove(0);
					tmp.remove(0);
					tmp.add(0, (a/b)*-1);
				}else {
					tmp.remove(0);
					tmp.remove(0);
					tmp.add(0, a/b);
				}
				break;
			}
		}
		int num = tmp.get(0);
		if(num > max) {
			max = num;
		}
		if(num < min) {
			min = num;
		}
	}
}
