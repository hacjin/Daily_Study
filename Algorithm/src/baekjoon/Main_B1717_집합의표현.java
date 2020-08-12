package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
참고 : 2020-08-12 15:46분
https://ssungkang.tistory.com/entry/Algorithm-%EC%9C%A0%EB%8B%88%EC%98%A8-%ED%8C%8C%EC%9D%B8%EB%93%9CUnion-Find
서로소 집합(Disjoint-set) : Union - find 개념 익히기
Find : 노드 x가 어느 집합에 포함되어 있는지 찾는 연산
=> x == parent[x] 즉 부모노드가 자기자신, 루트노드를 의미
Union : 노드 x가 포함된 집합과 노드 y가 포함된 집합을 합치는 연산
Make-set : 노드 x의 부모 노드를 x로 초기화

 */
public class Main_B1717_집합의표현 {
    static int[] parent;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        StringBuilder sb= new StringBuilder();
        parent = new int[N+1];
        makeSet();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int cal = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(cal==0) {
                union(a,b);
            }else {
                int px = findSet(a);
                int py = findSet(b);
                if(px == py) sb.append("YES\n");
                else sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }

    private static void makeSet() {
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
    }

    private static int findSet(int x) {
        if(x == parent[x]) return x;
        else {
            parent[x] = findSet(parent[x]);
            return parent[x];
        }
    }
    private static void union(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);

        if(px != py) {
            parent[py] = px;
        }
    }
}
