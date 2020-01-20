package dijkstra_prim_0829;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DijkstraTest {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());		// 정점수 
		int[][] input = new int[N][N];
		
		
		StringTokenizer st=null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}// 인접행렬 생성
		
		int start = 0, end = N-1;
		int[] distance = new int[N];
		boolean visit[] = new boolean[N];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		distance[start] = 0;
		
		int min = Integer.MAX_VALUE,minIndex = 0;
		for (int i = 0; i < N; i++) {
			min = Integer.MAX_VALUE;
			//step1. 미방문 정점중 최적비용이 최소인 정점 찾기
			for (int j = 0; j < N; j++) {
				if(!visit[j] && distance[j] < min) {
					min = distance[j];
					minIndex = j;
				}
			}
			//step2. 선택정점 방문하고 경유지로 고려하여
			//		 미방문정점들로 가는 최적비용을 최적화
			visit[minIndex] = true;
			if(minIndex == end) break;
			for (int j = 0; j < N; j++) {
				if(!visit[j] && input[minIndex][j]!=0 && min + input[minIndex][j] < distance[j]) {
					distance[j] = distance[minIndex] + input[minIndex][j];
				}
			}
		}
		System.out.println(distance[end]);
	}
}
