package baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B17085_십자가2개놓기 {
    static int dir[][] = {{-1,0},{0,1},{1,0},{0,-1}};
    static char[][] map;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]=='#') {
                    //방향 보고
                    int cnt = max(i, j);
                    fill(i, j, cnt);
                    int mul = cnt * 4 + 1;
                    mul *= (dfs(i, j + 1, mul) * 4 + 1);
                    //방향 풀고
                    unfill(i, j, cnt);
                    if (mul > result) result = mul;
                }
            }
        }
        System.out.println(result);

    }

    private static int dfs(int x, int y, int mul) {
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]=='#'){
                    int cnt = max(i,j);
                    if(cnt>max) max = cnt;
                }
            }
        }
        return max;
    }

    private static void unfill(int i, int j, int cnt) {
        map[i][j] = '#';
        for (int d = 0; d < dir.length; d++) {
            int nx = i;
            int ny = j;
            for (int k = 1; k <= cnt; k++) {
                nx += dir[d][0];
                ny += dir[d][1];
                map[nx][ny] = '#';
            }
        }
    }
    private static int max(int i, int j) {
        int max = M>N?M:N;
        for (int d = 0; d < dir.length; d++) {
            int cnt = 0;
            int nx = i+dir[d][0];
            int ny = j+dir[d][1];
            while(nx>=0 && nx<N && ny>=0 && ny <M &&map[nx][ny]=='#'){
                cnt++;
                nx += dir[d][0];
                ny += dir[d][1];
            }
            if(max > cnt) max = cnt;
        }
        return max;
    }
    private static void fill(int i, int j, int cnt) {
        map[i][j] = '*';
        for (int d = 0; d < dir.length; d++) {
            int nx = i;
            int ny = j;
            for (int k = 1; k <= cnt; k++) {
                nx += dir[d][0];
                ny += dir[d][1];
                map[nx][ny] = '*';
            }
        }
    }
}
