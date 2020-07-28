package programmers;

import java.io.*;
import java.util.*;
public class Solution_9940_순열1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            boolean arr[] = new boolean[100001];
            for (int i = 0; i < N; i++) {
                int input = Integer.parseInt(st.nextToken());
                arr[input] = true;
            }

            boolean ok = true;
            for (int i = 1; i <= N ; i++) {
                if(!arr[i]) {
                    ok = false;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#"+t+" ");
            if(ok) {
                sb.append("Yes");
            }else sb.append("No");
            System.out.println(sb);
        }
    }
}
