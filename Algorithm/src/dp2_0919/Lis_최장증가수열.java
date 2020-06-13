package dp2_0919;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Lis_최장증가수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[];
		int D[];
		int N = sc.nextInt();
		arr = new int[N+1];
		D = new int[N+1];
		List<Integer> list[] = new LinkedList[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 1; i <=N ; i++) {
			D[i] = 1;
		}
		for (int i = 1; i <= N; i++) {
			list[i] = new LinkedList<Integer>();
			for (int j = 1; j < i; j++) {
				if(arr[i]>arr[j]) {
					int tmp = D[j]+1;
					if(D[i]<tmp) {
						D[i] = tmp;
						list[i].add(arr[j]);
					}
					else if(D[i]==tmp) {
						if(arr[j]<list[i].get(list[i].size()-1)) {
							list[i].remove(list[i].size()-1);
							list[i].add(arr[j]);
						}
					}
				}
			}
			list[i].add(arr[i]);
		}
		
		int maxindex = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			if(D[i]>max) { max = D[i]; maxindex=i;}
		}
		System.out.println(list[maxindex].toString());
		System.out.println(D[maxindex]);
	}
}
