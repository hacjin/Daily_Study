package divide_etc_0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuickSort2 {
//	static int L, R, pivot;
	static int a[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = st.countTokens();
		a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		quicksort(a,0,n-1);
		for (int i : a) {
			System.out.print(i+" ");
		}
	}

	/*
	 * L : 피봇보다 같거나 큰값 찾기 R : 피봇보다 작은값 찾기
	 */
	public static void quicksort(int a[], int begin, int end) {
		if(end <= begin) return;
		int tmp=0;
		int pivot = (begin + end) / 2;
		int L = begin;
		int R = end;
		while (L<R) {
			if (a[L]<=a[pivot]) {
				L++;
			}
			if(a[R]>=a[pivot]) {
				R--;
			}
			if(a[L]>a[pivot] && a[R]<a[pivot]) {
				if(L<R) {
					tmp = a[L];
					a[L] = a[R];
					a[R] = tmp;
				}
			}
			if(L==R) {
				tmp = a[pivot];
				a[pivot] = a[R];
				a[R] = tmp;
				break;
			}
		}
		quicksort(a, begin, R-1);
		quicksort(a, R+1, end);
	}
}
