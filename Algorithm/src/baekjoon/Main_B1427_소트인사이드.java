package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main_B1427_소트인사이드 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int temp = N;
		int i = 0;
		while(temp>0){
			arr.add(temp%10);
			temp = temp/10;
			i++;
		}
		Collections.sort(arr);
		StringBuilder sb = new StringBuilder();
		for (int j = arr.size()-1; j >= 0; j--) {
			sb.append(arr.get(j));
		}
		System.out.println(sb.toString());
	}
}
