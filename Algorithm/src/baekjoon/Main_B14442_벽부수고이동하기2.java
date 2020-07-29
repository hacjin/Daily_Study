package baekjoon;

import java.io.*;
import java.util.*;

public class Main_B14442_벽부수고이동하기2 {
    static int N,M,K;
    static boolean[][][] visit;
    static int[][] dir= {{-1,0},{0,1},{1,0},{0,-1}};
    static char[][] map;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visit = new boolean[N][M][11];
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        result = -1;
        bfs(0,0,0,1);
        System.out.println(result);
    }

    private static void bfs(int x, int y, int kcnt,int acc) {
        visit[x][y][kcnt] = true;
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x,y,kcnt,acc});
        while(!que.isEmpty()) {
            int[] tmp = que.poll();
            int nkcnt = tmp[2];
            int nacc = tmp[3];
            if(tmp[0] == N-1 && tmp[1] == M-1) {
                result = nacc;
                return;
            }
            for (int d = 0; d < dir.length; d++) {
                int nx = tmp[0] + dir[d][0];
                int ny = tmp[1] + dir[d][1];
                if(nx>=0 && nx<N && ny>=0 && ny<M && !visit[nx][ny][nkcnt]) {
                    if(map[nx][ny]=='1') {
                        if(nkcnt+1<=K) {
                            que.add(new int[]{nx,ny,nkcnt+1,nacc+1});
                            visit[nx][ny][nkcnt]= true;
                        }
                    }else {
                        que.add(new int[]{nx,ny,nkcnt,nacc+1});
                        visit[nx][ny][nkcnt]= true;
                    }
                }
            }
        }
    }
}
