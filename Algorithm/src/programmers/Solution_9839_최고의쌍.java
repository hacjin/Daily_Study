package programmers;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_9839_최고의쌍 {
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            result = -1;
            int N = Integer.parseInt(br.readLine());
            int input[] = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < N; j++) {
                input[j] = Integer.parseInt(st.nextToken());
            }

            int mul= 1;
            for (int j = 0; j < N; j++) {
                dfs(j,mul*input[j],1, N, input);
            }
            System.out.println("#"+t+" "+result);
        }

    }

    private static void dfs(int index, int mul,int cnt,int N,int[] input) {
        if(cnt==2) {
            int pre = mul%10;
            int tmp = mul/10;
            boolean ok = true;
            while(tmp>0) {
                int mod = tmp%10;
                if(mod == pre-1) {
                    pre = mod;
                }
                else ok = false;
                tmp /= 10;
            }
            if(ok && result < mul) result = mul;
            return;
        }
        for (int i = index+1; i < N; i++) {
            dfs(i,mul*input[i],cnt+1,N,input);
        }
    }
}
