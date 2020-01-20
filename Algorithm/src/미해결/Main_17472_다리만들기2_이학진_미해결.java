package 미해결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17472_다리만들기2_이학진_미해결 {
	static int map[][],tmp[][];
	static boolean visit[][];
	static int connect[][];
	static int dir[][] = { {0,1},{1,0},{0,-1},{-1,0} };
	static int R,C;
	static int minr,maxr,minc,maxc;
	static List<int[]> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		tmp = new int[R][C];
		visit = new boolean[R][C];
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt=1;
		list = new ArrayList<int[]>();
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < R; c++) {
				if(!visit[r][c] && map[r][c]==1) {
					visit[r][c] = true;
					minr = maxr = r;
					minc = maxc = c;
					tmp[r][c] = cnt;
					dfs(r,c,cnt);
					list.add(new int[] {minr,maxr,minc,maxc});
					cnt++;
				}
			}
		}
		connect = new int[list.size()][list.size()];
		for (int[] tmi : connect) {
			Arrays.fill(tmi, Integer.MAX_VALUE);
		}
		find();
		int concnt = 0;
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if(connect[i][j]>0 && connect[i][j]<Integer.MAX_VALUE) concnt++;
			}
		}
		int sum = 0,minval,bet=0;
		if(concnt >= (list.size()-1)*2) {
			for (int i = 0; i < list.size(); i++) {
				minval=Integer.MAX_VALUE;
				for (int j = 0; j < list.size(); j++) {
					if(connect[i][j]>0 && minval>connect[i][j]) {
						minval = connect[i][j];
					}
				}
				bet++;
				if(bet<list.size()) {
					sum +=  minval;
				}
			}
		}
		System.out.println(sum);
	}
	private static void find() {
		int mir,mxr,mic,mxc;
		for (int i = 0; i < list.size(); i++) {
			mir = list.get(i)[0];
			mxr = list.get(i)[1];
			mic = list.get(i)[2];
			mxc = list.get(i)[3];
			for (int j = 0; j < list.size(); j++) {
				int minr = Integer.MAX_VALUE;
				int minc = Integer.MAX_VALUE;
				if(i!=j) {
					if((mir<=list.get(j)[0] && list.get(j)[0]<= mxr) || 
							(mir<= list.get(j)[1] && list.get(j)[1] <= mxr)) {	// 동, 서
						if(list.get(j)[2] > mxc && list.get(j)[2]-mxc < minc) minc =list.get(j)[2]-mxc;   
						else if(list.get(j)[3] < mic && mic-list.get(j)[3] < minc) minc = mic-list.get(j)[3];
						
					}else if((mic<=list.get(j)[2] && list.get(j)[2] <= mxc) ||
							(mic <= list.get(j)[3] && list.get(j)[3] <= mxc)) {	// 북, 남 
						if(list.get(j)[0] > mxr && list.get(j)[0]-mxr < minr) minr = list.get(j)[0]-mxr;
						else if(list.get(j)[1] < mir && mir-list.get(j)[1] < minr) minr = mir-list.get(j)[1];
					}
					if((mir>=list.get(j)[0] && list.get(j)[1]>= mir) || 
							(mxr>= list.get(j)[0] && list.get(j)[1] >= mxr)) {	// 동, 서
						if(list.get(j)[2] > mxc && list.get(j)[2]-mxc < minc) minc =list.get(j)[2]-mxc;   
						else if(list.get(j)[3] < mic && mic-list.get(j)[3] < minc) minc = mic-list.get(j)[3];
						
					}else if((mic>=list.get(j)[2] && list.get(j)[3] >= mic) ||
							(mxc >= list.get(j)[3] && list.get(j)[3] >= mxc)) {	// 북, 남 
						if(list.get(j)[0] > mxr && list.get(j)[0]-mxr < minr) minr = list.get(j)[0]-mxr;
						else if(list.get(j)[1] < mir && mir-list.get(j)[1] < minr) minr = mir-list.get(j)[1];
					}
					if(minc!=Integer.MAX_VALUE && minc>2 && connect[i][j] > minc-1) { connect[i][j] = minc-1; connect[j][i] = minc-1;}
					else if( minr!=Integer.MAX_VALUE && minr>2 && connect[i][j] > minr-1) { connect[i][j] = minr-1; connect[j][i] = minr-1;} 
				}
			}
		}
	}
	private static void dfs(int r, int c,int cnt) {
		int nr, nc;
		for (int d = 0; d < dir.length; d++) {
			nr = r+ dir[d][0];
			nc = c+ dir[d][1];
			if(nr>=0 && nc>=0 && nr<R && nc<C) {
				if(!visit[nr][nc] && map[nr][nc]==1) {
					visit[nr][nc]=true;
					tmp[nr][nc] = cnt;
					if(minr>nr)minr=nr;
					if(maxr<nr)maxr=nr;
					if(minc>nc)minc=nc;
					if(maxc<nc)maxc=nc;
					dfs(nr,nc,cnt);
				}
			}
		}
	}
}
