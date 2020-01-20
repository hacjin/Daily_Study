package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_B1786_찾기_이학진 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] T = br.readLine().toCharArray();
		char[] P = br.readLine().toCharArray();
		
		int tLength = T.length;
		int pLength = P.length;
		
		int[] fail = new int[pLength];
		for (int i = 1,j=0; i < pLength; i++) {
			while(j>0 && P[i] != P[j]) j = fail[j-1]; 
			if(P[i]==P[j]) fail[i] = ++j;
		}
		List<Integer> index = new ArrayList<Integer>();
		int cnt = 0;
		for (int i = 0,j = 0; i < tLength; i++) {
			while(j>0 && T[i] != P[j]) j = fail[j-1];
			
			if(T[i]==P[j]) {
				if(j==pLength-1) {
					index.add(i-pLength+2);
					cnt++;
					j = fail[j];
				} else {
					j++;
				}
			}
		}
		System.out.println(cnt);
		for (Integer integer : index) {
			System.out.print(integer+" ");
		}
	}
}
