package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1127_맛있는음식_모든경우의수 {
	static int MAX_COUNT;
	static int N,idx;
	static int resS[],resB[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int S[],B[];
		N = Integer.parseInt(br.readLine());
		S = new int[N];
		B = new int[N];
		MAX_COUNT = (int)Math.pow(2, N)-1;
		resS = new int[MAX_COUNT];
		resB = new int[MAX_COUNT];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}
//		=================== 입력 =======================
		idx=0;
		multi(S,0,1);
		for (int i : resS) {
			System.out.print(i+" ");
		}
		System.out.println();
		idx=0;
		sum(B,0,0);
		for (int i : resB) {
			System.out.print(i+" ");
		}
		System.out.println();
	
		int res = 1000000000;
		int min;
		for (int i = 0; i < MAX_COUNT; i++) {
			for (int j = 0; j < MAX_COUNT; j++) {
				min = Math.abs(resS[i]-resB[j]);	// 
				System.out.println("뺀 값 : "+min);
				if(res>min) {
					res = min;
				}
			}
		}
		System.out.println(res);
	}

	public static void multi(int arr[],int index,int num) {	// 선택지가 될 배열 S or B와 선택의 위치인 인덱스, 곱하거나 더해질 숫자가 들어와야 될것
		if(index == N) {
				if(idx<MAX_COUNT) {
					resS[idx++]=num;
				}
			return;
		}
		
		multi(arr,index+1,num*arr[index]);
		multi(arr,index+1,num);
	}
	public static void sum(int arr[],int index,int num) {	// 선택지가 될 배열 S or B와 선택의 위치인 인덱스, 곱하거나 더해질 숫자가 들어와야 될것
		
		if(index == N) {
				if(idx<MAX_COUNT) {
					resB[idx++]=num;
				}
			return;
		}
		sum(arr,index+1,num+arr[index]);
		sum(arr,index+1,num);
		
	}
}
