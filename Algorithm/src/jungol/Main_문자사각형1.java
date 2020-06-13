package jungol;

import java.util.Scanner;

public class Main_문자사각형1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr;
		int n = sc.nextInt();
		arr = new int[n][n];
		int a = 65;		// A : 65 Z : 90
		int index=0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if( (n*n + a - j*n -i-1) > 90) {
					index = ((n*n + a - j*n -i-1)-65)/26;
					arr[i][j] = ((n*n + a - j*n -i-1)-65)%(26*index) + 65;
				}
				else {
				arr[i][j] = (n*n + a - j*n -i-1);
				}
				System.out.printf("%c ",arr[i][j]);
			}
			System.out.println();
		}
	}
}
/**
 * 
<생각하기> 
열을 우선으로 하여 바깥 for문을 작성하되 
행과 열 모두 n부터 1까지로 순서를 정해서 채워나가면 된다.
채워야 할 배열은 정수가 아닌 문자배열로 선언하고
 int num = 1; 대신 char ch = 'A'; 와 같이 
 문자로 선언하고 초기화 해서 처리하면 된다.
 * 
 */
