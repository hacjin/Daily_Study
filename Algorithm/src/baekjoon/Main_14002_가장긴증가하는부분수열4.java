 package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14002_가장긴증가하는부분수열4 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int D[] = new int[N];
		int res[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 1,maxindex=0;
		for (int i = 0; i < N; i++) {
			D[i] = 1;
			res[i] = -1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					if (D[j] + 1 > D[i]) {
						D[i] = D[j] + 1;
						res[i] = j;
						if(max < D[i]) { max = D[i]; maxindex=i;}
					}
				}
			}
		}
		System.out.println(max);
		int output[] = new int[max];
		output[max-1] = arr[maxindex];
		int index = maxindex;
		int oin = max-2;
		while(true) {
			if(res[index]==-1) break;
			output[oin]=arr[res[index]];
			index = res[index];
			oin--;
		}
		for (int i = 0; i < output.length; i++) {
			System.out.print(output[i]+" ");
		}
	}
}
