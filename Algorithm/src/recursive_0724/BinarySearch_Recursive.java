package recursive_0724;

import java.util.Scanner;

public class BinarySearch_Recursive {
	static int N;
	static int arr[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		int f;

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		f = sc.nextInt(); // 찾을 값
		recursive(f,arr,0,N);

	}

	public static void recursive(int f, int arr[],int s,int e) {
		int key = (s+e)/2;
		if(s>e) {
			System.out.println("검색한 값이 존재하지 않습니다.");
			return;
		}
		if (f == arr[key]) {
			System.out.println("검색한 " + f + "값이 존재하는 위치 : " + (key+1));
		} else if (f < arr[key]) {
			e = key-1;
			recursive(f, arr,s,e);
		} else {
			s = key+1;
			recursive(f, arr,s,e);
		}
	}
}
