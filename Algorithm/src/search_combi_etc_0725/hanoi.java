package search_combi_etc_0725;

import java.util.Scanner;

public class hanoi {
	static int N, S, E, M, result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = 1;
		M = 2;
		E = 3;
		result = 0;
		hanoiCount(N, S, M, E);
		System.out.println(result);
		printMove(N, S, M, E);
	}

	// N=3 일때 3이 1->3 으로 마지막에 가야 됨
	// N-1은 1->2 로 완성 되야함.
	public static void hanoiCount(int N, int S, int M, int E) {

		if (N == 1) {
			result++;
			return;
		} else {
			hanoiCount(N - 1, S, E, M); // N=1 일때 리턴되어 1->3 출력
			result++;
			hanoiCount(N - 1, M, S, E); // N 1을 3->2로
		}
	}
	public static void printMove(int N, int S, int M, int E) {
		
		if (N == 1) {
			System.out.println(S + " " + E); // N=1일땐 1->3 리턴
			return;
		} else {
			printMove(N - 1, S, E, M); // N=1 일때 리턴되어 1->3 출력
			System.out.println(S + " " + E); // N 2 는 1에서 나머지 3을 통해 2로 가야됨.
			printMove(N - 1, M, S, E); // N 1을 3->2로
		}
	}
}
