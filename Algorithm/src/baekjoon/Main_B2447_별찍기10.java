package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B2447_별찍기10 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] arr = new char[2187][2187];
//		print_star(0,0,N,arr);
		
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				draw(i,j,N);
			}
			System.out.println();
		}
	}

	private static void draw(int i, int j, int n) {
		if((i/n)%3==1 && (j/n)%3==1) System.out.print(' ');
		else {
			if(n/3 == 0) System.out.print('*');
			else draw(i,j,n/3);
		}
	}

	private static void print_star(int x, int y, int n, char[][] arr) {
		if(n==1) {
			arr[x][y]='*';
			return;
		}
		int div = n/3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(i==1 && j==1) continue;
				print_star(x+(div*i),y+(div*j),div,arr);
			}
		}
	}
}
