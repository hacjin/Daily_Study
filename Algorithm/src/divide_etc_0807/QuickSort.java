package divide_etc_0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuickSort {
	static int L,R,pivot;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = st.countTokens();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		for (int i : quickSort(a,0,n-1)) {
			System.out.printf(i+" ");
		}
		
	}
	
/*	L : 피봇보다 같거나 큰값 찾기
 * 	R : 피봇보다 작은값 찾기
*/
	public static int partition(int a[], int begin, int end) {
		pivot = (begin+end)/2;
		L = begin;
		R = end;
		while(L<R) {
			while(a[pivot] > a[L] && L<R) {
				L++;
			}
			while(a[pivot] <= a[R] && L<R) {
				R--;
			}
			if(L<R) {
				int tmp = a[L];
				a[L]= a[R];
				a[R] = tmp;
			}
		}
		int tmp = a[pivot];
		a[pivot] = a[R];
		a[R] = tmp;
		return R;
	}
	public static int[] quickSort(int a[],int begin,int end) {
		int p;
		if(begin<end) {
			p = partition(a,begin,end);
			quickSort(a, begin, p-1);
			quickSort(a, p+1, end);
		}
		return a;
	}
}
 