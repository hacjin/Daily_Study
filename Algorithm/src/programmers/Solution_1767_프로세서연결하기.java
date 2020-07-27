package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1767_프로세서연결하기 {
	static int dir[][] = {{-1,0},{0,1},{1,0},{0,-1}}; // 북 , 동 , 남 , 서
	static ArrayList<int[]> core;
	static int min,coreCnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int arr[][] = new int[N][N];
			core = new ArrayList<>();
			min = N*N;
			coreCnt = 0;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j]==1) {
						if(j != N-1 && i != N-1 && j!= 0 && i!=0) core.add(new int[] {i,j});
					}
				}
			}
			dfs(arr,0,N,0,0);
			System.out.println("#"+t+" "+min);
		}
	}
	private static void dfs(int[][] arr,int index,int N,int sum,int cnt) {
		if(index == core.size()) {
			if(cnt > coreCnt) {
				coreCnt = cnt;
				min = sum;
			}else if(cnt == coreCnt) {
				if(min > sum) min = sum;
			}
			return;
		}
		if(coreCnt > core.size()-index + cnt) return;
		for (int d = 0; d < dir.length; d++) {
			int size = 0;
			int[] tmp = core.get(index);
			boolean chk = true;
			int nx = tmp[0];
			int ny = tmp[1];
			while(true) {
				nx += dir[d][0];
				ny += dir[d][1];
				if(nx >= N || ny>= N || nx<0 || ny<0) break;
				if(arr[nx][ny]==0) size++;
				else {
					chk = false;
					break;
				}
			}
			if(chk) {
				setLine(index, d, arr, N,true);
				dfs(arr, index+1,N,sum+size,cnt+1);
				setLine(index, d, arr, N,false);
				
			}else dfs(arr, index+1,N,sum,cnt);
		}
	}
	private static void setLine(int index, int d,int[][] arr, int N,boolean chk) {
		int[] tmp = core.get(index);
		int nx = tmp[0];
		int ny = tmp[1];
		while(true) {
			nx += dir[d][0];
			ny += dir[d][1];
			if(nx >= N || ny>= N || nx<0 || ny<0) break;
				if(chk) arr[nx][ny] = 2;
				else arr[nx][ny] = 0;
		}
	}
}
