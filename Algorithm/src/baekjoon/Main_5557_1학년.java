package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_5557_1학년 {
	static int N;
	static int data[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		long sum[][];
		N = Integer.parseInt(br.readLine());
		data = new int[N];
		sum = new long[N][21];
		for (long i[] : sum) {
			Arrays.fill(i, 0);
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		sum[0][data[0]]=1;
		calc(sum,1);
	}
	private static void calc(long sum[][],int index) {
		int hap=0,sub=0;
		if(index==N-1) {
			if(sum[index-1][data[index]]>0) {
				System.out.println(sum[index-1][data[index]]);
			}
			return;
		}
		else {
			for (int i = index-1; i < index; i++) {
				for (int j = 0; j < 21; j++) {
					if(sum[i][j]>0) {
						 hap = j + data[index];
						 sub = j - data[index];
						if(hap<=20 && hap>=0) {
							if(sum[i+1][hap]==0) sum[i+1][hap]= sum[i][j];
							else sum[i+1][hap] += sum[i][j];
						}
						if(sub >= 0 && sub <=20) {
							if(sum[i+1][sub]==0) sum[i+1][sub]= sum[i][j]; 
							else sum[i+1][sub] += sum[i][j];
						}
					}
				}// for j end
			}// for i end
		}
		calc(sum,index+1);
	}
}