package jungol;

import java.util.Scanner;

public class Main_숫자사각형3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.printf("%d ",n*j + i);
			}
			System.out.println();
		}
	}
}

/**
 * Hint]
 * <생각하기>
열을 우선으로 하여 바깥 for문을 작성하고, 열이 결정되면 행을 나타내는 for문을 작성해서 채워나가면 된다.
for (i = 0; i < n; i++) { 
     for (j = 0; j < n; j++){
         arr[j][i] = num++;
     }
 }
 */
