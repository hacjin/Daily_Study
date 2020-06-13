package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main_J2577_회전초밥고_이학진 {
    static int N,d,k,c;
    static int arr[];
    static int visit[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visit = new int[d+1];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int max = 0;
        int cnt = 0;

    	visit[c]++;
    	cnt++;
    	
        for (int i = 0; i < k; i++) {
        	if(visit[arr[i]]==0) cnt++;
			visit[arr[i]]++;
		}
        
        for (int i = 1; i < N; i++) {
        	int t = i+k-1>=N?i+k-1-N:i+k-1;
    		visit[arr[i-1]]--;
    		if(visit[arr[i-1]]==0) cnt--;
    		visit[arr[t]]++;
        	if(visit[arr[t]]==1) {
        		cnt++;
        	}
        	if(max<cnt) {
        		max = cnt;
        	}
        }
        System.out.println(max);
    }
}
