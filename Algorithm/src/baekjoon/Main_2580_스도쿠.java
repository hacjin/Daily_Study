package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2580_스도쿠 {
	public static class None {
		int r;
		int c;

		public None(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static final int N = 9;

	public static void main(String[] args) throws IOException {
		int[][] arr = new int[N][N];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ArrayList<None> none = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 0)
					none.add(new None(i, j));
			}
		}

		// 0번째 행을 기준으로 시작
		bf(arr, 0, none);
	}

	// 1~9까지 한개씩 할당해보고 가로, 세로, 3x3영역을 만족할 경우 다음의 0을 찾아 시작
	private static void bf(int[][] arr, int cur, ArrayList<None> none) {

		// 분기점
		if (cur == none.size()) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
			System.exit(0);
		}

		// 1. 처음 단계 0을 찾고 1~9까지 할당하는 메서

			for (int k = 1; k <= N; k++) {
				if(check(arr,cur,none,k)) {
					arr[none.get(cur).r][none.get(cur).c] = k;
					bf(arr, cur + 1, none);
					arr[none.get(cur).r][none.get(cur).c] = 0;
				}
			}
	}

	private static boolean check(int[][] arr,int cur,  ArrayList<None> none, int k) {
		int r = none.get(cur).r;
		int c = none.get(cur).c;
		boolean result = true;
		// 1. 가로
		int index;
		for (int i = 0; i < N; i++) {
			index = arr[r][i];
			if (index == 0)
				continue;
			if (index == k) {
				result = false;
			}
		}
		// 2. 세로
		for (int i = 0; i < N; i++) {
			index = arr[i][c];
			if (index == 0)
				continue;
			if (index == k) {
				result = false;
			}
		}
		// 3. 3x3영역
		int x = (r / 3) * 3;
		int y = (c / 3) * 3;
		for (int i = x; i < x + 3; i++) {
			for (int j = y; j < y + 3; j++) {
				index = arr[i][j];
				if (index == 0)
					continue;
				if (index == k) {
					result = false;
				}
			}
		}
		return result;
	}
}
