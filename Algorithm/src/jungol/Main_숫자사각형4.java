package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_숫자사각형4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] data;
		int n, m;
		data = br.readLine().split(" ");
		n = Integer.parseInt(data[0]);
		m = Integer.parseInt(data[1]);
		switch (m) {
		case 1:
			for (int i = 1; i <= n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.printf("%d ", i);
				}
				System.out.println();
			}
			break;
		case 2:
			for (int i = 1; i <= n; i++) {
				if (i % 2 == 0) {
					for (int j = n; j > 0; j--) {
						System.out.printf("%d ", j);
					}
				}
				if (i % 2 == 1) {
					for (int j = 1; j <= n; j++) {
						System.out.printf("%d ", j);
					}
				}
				System.out.println();
			}
			break;
		case 3:
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					System.out.printf("%d ", i * j);
				}
				System.out.println();
			}
			break;

		default:
			break;

		}

	}
}
