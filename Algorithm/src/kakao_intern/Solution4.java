package kakao_intern;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution4 {
	public static void main(String[] args) {
		System.out.println(solution(new int[][] {
			{0, 0, 0, 0, 0, 0},
			{0, 1, 1, 1, 1, 0},
			{0, 0, 1, 0, 0, 0},
			{1, 0, 0, 1, 0, 1},
			{0, 1, 0, 0, 0, 1},
			{0, 0, 0, 0, 0, 0}}));
	}
	public static int solution(int[][] board) {
		int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}}; // 상, 하, 좌, 우
		int N = board.length;
		int[][][] map = new int[N][N][2];
		boolean[][] visit = new boolean[N][N];
		// 0 : 방향 , 1 : 비용
		map[0][0][0] = -1;
		map[0][0][1] = 0;
		visit[0][0] = true;
		PriorityQueue<int[]> que = new PriorityQueue(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
		// 0 : 행 , 1 : 열 , 2 : 깊이
		que.add(new int[] {0,0,0});
		while(!que.isEmpty()) {
			int[] tmp = que.poll();
			int sr = tmp[0];
			int sc = tmp[1];
			int dept = tmp[2];
			// 이전 방향
			int pred = map[sr][sc][0];
			// 이전 비용
			int prev = map[sr][sc][1];
			for (int i = 0; i < dir.length; i++) {
				int nr = sr + dir[i][0];
				int nc = sc + dir[i][1];
				int curv = prev;
				if(nr>=0 && nc>=0 && nr<N && nc<N && board[nr][nc]==0) {
					// 시작점 방향은 -1 이전방향 비교후 같을경우 100 , 아닐 경우 500
					if(pred== -1 || pred == i) {
						curv += 100;
					}else {
						curv += 600;
					}
					// 방문한 적이 없는 경우 
					if(!visit[nr][nc]) {
						map[nr][nc][0] = i;
						map[nr][nc][1] = curv;
						que.add(new int[] {nr,nc,dept+1});
						visit[nr][nc] = true;
					}
					// 방문은 했으나 가격이 작아지는 경우
					else {
						if(map[nr][nc][1] > curv) {
							map[nr][nc][0] = i;
							map[nr][nc][1] = curv;
							que.add(new int[] {nr,nc,dept+1});
						}
					}
				}
			}
		}
        int answer = map[N-1][N-1][1];
        return answer;
    }
}
