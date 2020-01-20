package baekjoon;

import java.util.Scanner;

public class Main_1592_영식이와친구들 {
	static int seat[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N, M, L;
		N = sc.nextInt();
		seat = new int[N];	// 0 ~ N-1 까지
		M = sc.nextInt();
		L = sc.nextInt();
		
		int cnt = 0;	// 공을 던진 횟수
		int index = 0;	// 첫 시작은 1번째
		while(true) {
			seat[index] += 1;
			if(seat[index]==M) break;	// 공 주고 받기를 끝내는 시점
			else {
				if(seat[index]%2==1) {	// 홀수
					index = index+L;
					if(index>N-1) {
						index = index%N;
					}
				}else {					// 짝수
					index = index-L;
					if(index<0) {
						index = N+index;
					}
				}
			}
			cnt++;
		}
		
		System.out.println(cnt);
	}
}
