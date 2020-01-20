package dijkstra_prim_0829;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PrimTest {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] input = new int[N][N];
		
		StringTokenizer st=null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}// 인접행렬 생성
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		boolean visit[] = new boolean[N];
		int min,next=0,res=0;
		
		// 임의의  시작점
		visit[0] = true;
		list.add(0);
		res += 0;
		
		for (int i = 0; i < N-1; i++) {		// 선택한 임의의 정점을 뺀 나머지 정점수만큼 반복
			min = Integer.MAX_VALUE;
			// 1. 이미 방문한 모든 정점 기준으로 방문하지 않은 정점으로의 최소비용
			for (int cur : list) {
				// cur 기준으로 인접행렬 보며 방문하지 않은 정점으로의 최소값 찾기
				for (int j = 0; j < N; j++) {
					if(!visit[j] && input[cur][j]!=0 && input[cur][j]<min) {
						min = input[cur][j];
						next = j;
					}
				}
			}
			visit[next] = true;
			list.add(next);
			res += min;
		}
		System.out.println(res);
	}
}
