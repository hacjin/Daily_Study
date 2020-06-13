package 미해결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_8983_사냥꾼_미해결_이학진 {
	static public class Gun implements Comparable<Gun> {
		public int x;

		public Gun(int x) {
			this.x = x;
		}

		@Override
		public int compareTo(Gun o) {
			return this.x - o.x;
		}
	}

	static public class Animal implements Comparable<Animal> {
		public int x;
		public int y;

		public Animal(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Animal o) {
			int x = this.x - o.x;
			return x == 0 ? this.y - o.y : x;
		}
	}

	static List<Gun> G;
	static List<Animal> A;
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M, N, L; // M 사대수 N 동물 수
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		G = new ArrayList<Gun>();
		A = new ArrayList<Animal>();
		st = new StringTokenizer(br.readLine());
		for (int m = 0; m < M; m++) {
			int data = Integer.parseInt(st.nextToken());
			G.add(new Gun(data)); // data == x좌표
		}
		Collections.sort(G);

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			A.add(new Animal(x, y));
		}
		Collections.sort(A);
		
		
		// 동물 기준으로 사대 비교 
		//1. 현 동물 기준으로 같거나 다음위치에 있는 사대 위치 탐색
		// 동물이 정렬 되어 있으므로 사대는 이전 반복 사대부터 탐색하면 된다.
		// 이전 사대위치의 범위 안인지 체크 단, 이전 사대가 0번째보다 커야 한다. 
		// 현 사대의 범위 안인지 체크, 현 사대는 총 사대의 범위보다 작아야 한다. 현사대==총사대 일경우 처리가 불가능.
		int j = 0, i = 0;
		while (i < A.size()) {
			int gx = G.get(j).x;
			int ax = A.get(i).x;
			int ay = A.get(i).y;

			if (ay <= L ) {
				if (gx - L <= ax && ax <= gx + L) {
					if(Math.abs(gx - ax) + ay <= L) {
						res++;
					}else if(Math.abs(G.get(j+1).x - ax) + ay <= L){
						j++;
						continue;
					}
				}else if(ax > gx+L) {
					j++;
					continue;
				}
			}
			i++;
		}
		System.out.println(res);
	}
}