package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_B2108_통계학 {
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int size = 8001;
		int arr[] = new int[size];
		double sum=0;
		int avg, cnt=N/2, mid =0, many=0, fre=0,frecnt=0, min = size, max = -4000;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num < min)  min = num;
			if(num > max) max = num;
			arr[num+4000]++;
			sum += num;
		}
		for (int i = 0; i < size; i++) {
			if(arr[i]>0) {
				// 최빈값을 위한 값
				if(fre < arr[i]) {
					frecnt=0;
					fre = arr[i];
					many = i-4000;
				}else if(fre == arr[i] && frecnt == 0) {
					++frecnt;
					fre = arr[i];
					many = i-4000;
				}
				// 중앙값 계산
				cnt -= arr[i];
				if(cnt < 0 && mid == 0) mid = i-4000; 
			}
			
		}
		avg = (int)Math.round(sum/N);
		StringBuilder sb = new StringBuilder();
		sb.append(avg+"\n"+mid+"\n"+many+"\n"+(max-min)+"\n");
		System.out.println(sb.toString());
	}
}
