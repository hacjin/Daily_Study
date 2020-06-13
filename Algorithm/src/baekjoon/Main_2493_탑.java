package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_2493_탑 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N;
		int maxi = 0;			// 첫번째자리를 가장큰 기둥으로 보고 index 0으로 설정
		int midi = 0;			// 9 5 8 4 7 와 같이 예외 상황 처리를 위한 중간값
		int index=0,arr[];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		
		while(index<N) {
			if(index==0) {	// 첫번째자리는 0 이라서
				System.out.printf("%d ",0);
			}
			else {
				if(arr[index-1]>arr[index]) {	// 바로 앞자리가 큰것은 앞자리의 인덱스를 바로 뽑아낼것
					System.out.printf("%d ",index);		// index는 0부터 시작이라 그자리의 인덱스를 뽑아내면됨
												// 출력후 그다음 index 실행을 위해 +1
				}
				else if(arr[index-1] < arr[index]) {	// 바로 앞자리가 작으면 그전 가장큰 기둥과 확인해 볼것
					if(arr[maxi] < arr[index]) {	// 가장큰 기둥보다 크면 index를 바꾸어 준다
						maxi = index;				
					}else if (arr[maxi] > arr[index]) { // 단, 예외 상황 9 5 8 4 7 와같이 중간값의 기둥이 오면?
						if(arr[index-2] < arr[maxi] && arr[index-2] >arr[index]) {
							System.out.printf("%d ",index-1);
						}else {
							System.out.printf("%d ",maxi+1);	// maxi 0부터 시작이라
						}
					}
				}
			}
			index++;
		}
	}
}
