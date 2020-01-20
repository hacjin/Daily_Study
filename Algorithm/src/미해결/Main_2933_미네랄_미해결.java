package 미해결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2933_미네랄_미해결 {
	static int R, C, N;
	static char map[][];
	static int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	static boolean visit[][];
	static List<int[]> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 막대기를 던진후 바뀐 위치 저장 list
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			map[r] = st.nextToken().toCharArray();
		}
		N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int h=0;
		for (int n = 0; n < N; n++) {
			h = Integer.parseInt(st.nextToken());
			if(n%2==0) left(h);
			else right(h);
		}
		for (char[] cr : map) {
			for (char c : cr) {
				System.out.print(c);
			}
			System.out.println();
		}
	}

	private static void right(int h) {
		int height = R-h,c=0;
		// 오른쪽
		for (int i = C-1; i >=0 ; i--) {
			if(map[height][i]=='x') {
				map[height][i] = '.';
				c = i;
				break;
			}
		}
		int arr[] = checkCluster(height,c);
		if(arr[0]==1) gravity(arr[1],arr[2]);
	}

	private static void left(int h) {
		int height = R-h,c=0;
		// 왼쪽
		for (int i = 0; i < C; i++) {
			if(map[height][i]=='x') {
				map[height][i] = '.';
				c = i;
				break;
			}
		}
		int arr[] = checkCluster(height,c);
		if(arr[0]==1) gravity(arr[1],arr[2]);
	}

	private static int[] checkCluster(int tr, int tc) {
		Queue<int[]> que = new LinkedList<int []>();
		int nr=0,nc=0;
		int ret[] = new int[3];
		list = new ArrayList<int[]>();
		visit = new boolean[R][C];
		visit[tr][tc] = true;
		int r=0,c=0;
		for (int j = 0; j < dir.length; j++) {
			r = tr + dir[j][0];
			c = tc + dir[j][1];
			int maxr=-1,tmpc=-1;
			if(r>=0 && c>=0 && r<R && c<C) {
				visit[r][c] = true;
				que.add(new int[] {r,c});
				while(!que.isEmpty()) {
					int[] tmp = que.poll();
					r = tmp[0];
					c = tmp[1];
					list.add(new int[] {r,c});
					for (int i = 0; i < dir.length; i++) {
						nr = r + dir[i][0];
						nc = c + dir[i][1];
						if(nr>=0 && nc>=0 && nr<R && nc <C) {
							if(!visit[nr][nc] && map[nr][nc]=='x') {
								visit[nr][nc] = true;
								que.add(new int[] {nr,nc});
								if(maxr < nr) { maxr= nr; tmpc = nc; }
							}
						}
					}
				}
			}
			if(maxr==R-1) { ret = new int[] {-1,-1,-1}; } 
			else if(maxr!=-1 && maxr!=R-1) { ret = new int[] {1,maxr,tmpc}; break;}
		}
		return ret;
	}

	private static void gravity(int maxr, int tmpc) {
		Collections.sort(list,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]==o2[1]?o2[0]-o1[0]:o1[1]-o2[1];
			}
		});
		int tc = tmpc ,dr=-1;
		int nr=0,nc=0;
		
		for (int i = 0; i < list.size(); i++) {
			nc = list.get(i)[1];
			if(tc!=nc) dr=-1;
			for (int r = R-1; r >=0 ; r--) {
				if(dr!=-1 && map[r][nc]=='.') break;
				if(map[r][nc]=='.') dr = r;
			}
			nr = list.get(i)[0] + dr-maxr;
			char val = map[list.get(i)[0]][list.get(i)[1]];
			map[nr][nc] = val;
			if(map[nr-(dr-maxr)][nc]=='x') map[nr-(dr-maxr)][nc]='.'; 
			tc = nc;
		}
		
	}
}
