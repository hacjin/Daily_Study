package 미해결;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/*
 * 1. 두 지역구로 나누기 - 조합이용	nC1~nChalf 까지 중복 제거
 * 1-2. 각 지역구 인접여부 => 그래프 탐색(BFS/DFS) 한지역구라도 인접여부 X 1번 반복
 * 1-3. 두 지역 인구수차이 최소값 갱신
 */
public class Main_17471_게리맨더링_이학진_미해결 {
	static int N, a, b;
	static int man[];
	static int Node[][]; // 각 마을의 인접여부 확인을 위한 행렬
	static boolean selected[];
	static boolean visited[];
	static List<Integer> alist, blist;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		man = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		selected = new boolean[N];
		for (int i = 0; i < N; i++) {
			man[i] = Integer.parseInt(st.nextToken());
		}
		Node = new int[N][N];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			for (int i = 0,j=0; i < size; i++) {
				j = Integer.parseInt(st.nextToken())-1;
				Node[n][j] = 1;
				Node[j][n] = 1;
			}
		}
		
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

}
