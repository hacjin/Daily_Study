package jungol;

import java.util.Scanner;

/**
 * 
 * 사각형 내부에 지그재그 형태로 1부터 n*m번까지 숫자가 차례대로 출력되는 프로그램 작성.
 *
 */
public class Main_숫자사각형2 {
	public static void main(String[] args) {
		int n, m; // n : 높이 , m : 너비
		int num;

		Scanner sc = new Scanner(System.in);

		while (true) {
			n = sc.nextInt();
			m = sc.nextInt();
			if (n > 100 || m > 100) {
				System.out.println("n,m의 범위는 100이하의 정수입니다.");
			} else {
				for (int i = 1; i <= n; i++) {
					if (i % 2 == 0) {
						num = i * m;
						for (int j = 0; j < m; j++) {
							System.out.printf("%d ", num--);
						}
					} else {
						if (i == 1) {
							num = 1;
						} else {
							num = (i-1) * m + 1;
						}
						for (int j = 0; j < m; j++) {
							System.out.printf("%d ", num++);
						}
					}
					System.out.println();
				}
			}
		}
	}
}

/**
 * hint) 
 * <알아두기>
배열을 이용한 출력 
수들의 형태가 순서대로 되어 있다면 앞에서처럼 이중 for문으로 간단하게 출력할 수 있지만 그 순서가 변형이 되면 프로그램이 매우 복잡해 질 수 있다.
 왜냐하면 일반적으로 출력을 할 때에는 위에서 아래로, 그리고 앞에서 뒤로 순서대로 해야 하기 때문이다.
반면에 배열에는 값을 저장하는데 순서대로 채울 필요가 없기 때문에 규칙에 따라 해당 위치에 수들을 배치해 놓고 
순서대로 출력을 하면 간단하게 문제를 해결할 수 있다.

<코드>
 01 void fill()
 02 {
 03   int i, j; 
 04   int num = 1; 
 05   for (i = 0; i < n; i++) {      // n행만큼 반복
 06     if (i % 2 == 0) {             // 짝수행이면 
 07       for (j = 0; j < m; j++){  // 앞에서부터 m열만큼 반복
 08         arr[i][j] = num++;     // 배열에 수를 넣고 1증가시킨다. 
 09       }
 10     }
 11     else {                               // 짝수행이 아니면(홀수행이면) 
 12       for (j = m-1; j >= 0; j--){   // 뒤에서 부터 첫 번째 열까지 반복 
 13         arr[i][j] = num++;          // 배열에 수를 넣고 1증가시킨다. 
 14       }
 15     }
 16   }

<코드분석>
01 : fill()은 주어진 규칙에 따라 배열에 수를 채우는 함수이다.
06~10 : 짝수행일 경우에는 앞에서부터 차례대로 배열을 채워나가고, 
11~15 : 홀수행일 경우에는 뒤에서부터 채워나간다. 
※ 만약 직접 출력하려면 뒤에서부터 출력할 수 없기 때문에 
   각 행마다 맨 앞에 들어갈 수를 구해서 1씩 늘이거나 줄여가면서 처리해야 하므로 매우 복잡해진다.
 *
 */
