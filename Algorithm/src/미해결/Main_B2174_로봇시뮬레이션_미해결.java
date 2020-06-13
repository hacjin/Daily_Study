package 미해결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B2174_로봇시뮬레이션_미해결 {
	static int dir[][] = {{-1,0},{0,1},{1,0},{0,-1}};
	static int A,B,N,M,result,crash;// 가로, 세로, 로봇, 명령수
	static int locate[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		locate = new int[B][A];
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Robot robot[] = new Robot[N]; 
		for (int i = 0; i < N; i++) {
			st= new StringTokenizer(br.readLine()," ");
			int c = Integer.parseInt(st.nextToken())-1;
			int r = B-Integer.parseInt(st.nextToken());
			locate[r][c] = i+1;
			char direction = st.nextToken().charAt(0);
			int direct = 0;
			switch(direction) {
				case 'N' : direct = 0; break;
				case 'E' : direct = 1; break;
				case 'S' : direct = 2; break;
				case 'W' : direct = 3; break;
			}
			robot[i] = new Robot(r,c,direct);
		}
		int current = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int num = Integer.parseInt(st.nextToken())-1;
			char com = st.nextToken().charAt(0);
			int imut = Integer.parseInt(st.nextToken());
			int comnum = (com=='F'?0:((com=='L')?-1:1));
			dfs(robot[num],0,imut,comnum);
			if(result>0) {
				current = num+1;
				break; 
			}
		}
		if(result==1) {
			System.out.println("Robot "+current+" crashes into the wall");
		}else if(result==2) {
			System.out.println("Robot "+current+" crashes into robot "+crash);
		}else System.out.println("OK");
	}
	private static void dfs(Robot ro,int cnt, int imut,int com) {
		int x = ro.x,y = ro.y,direct = ro.direct; 
		if(cnt == imut) {
			return;
		}
		if(com==0) {
			int nx,ny;
			int tmp = locate[x][y];
			nx = x+dir[direct][0]; ny = y+dir[direct][1];
			if(nx<B && ny<A && nx>=0 && ny>=0) {
				if(locate[nx][ny]>0 ) {
					crash = locate[x][y];
					result = 2;
					return;
				}
				locate[x][y]=0;
				locate[nx][ny]=tmp;
				ro.x = nx; ro.y=ny;
			}else {
				result = 1;
				return;
			}
		}else {
			ro.direct = direct+com<0?3:(direct+com)%4;
		}
		dfs(ro,cnt+1,imut,com);
	}
	public static class Robot {
		int x;
		int y;
		int direct;
		
		public Robot() {
		}
		public Robot(int x, int y, int direct) {
			this.x = x;
			this.y = y;
			this.direct = direct;
		}
		@Override
		public String toString() {
			return "Robot [x=" + x + ", y=" + y + ", direct=" + direct + "]";
		}
	}
}
