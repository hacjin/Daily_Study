package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2817_부분수열의합 {
	static int N,K,T,cnt=0;
	static int A[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			A = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			
			subset(A,0,0);
			
			System.out.println("#"+(t+1)+" "+cnt);
			
			
		}
		
		
		
		
	}
	public static void subset(int[] a,int index,int sum) {
		if(sum>K || index==N) {
			if(sum==K) {
				cnt++;
			}
			return;
		}
		subset(a,index+1,sum+a[index]);
		subset(a,index+1,sum);
		
	}
}
