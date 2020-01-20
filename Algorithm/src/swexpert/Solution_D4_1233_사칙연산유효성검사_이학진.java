package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1233_사칙연산유효성검사_이학진 {
	
	static Object[] tree;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N,idx,level;
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			tree = new Object[N+1];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				idx = Integer.parseInt(st.nextToken());
				tree[idx] = st.nextToken();
			}
			
			level = (int)Math.ceil(Math.log(N+1)/Math.log(2))-1;	// 깊이 7까지 171의경우
			
			int left, right,res=-1;
			for (int i = 1; i <= N; i++) {
				if(i>N/2) {
					left = -1;
					right = -1;
				} else {
					left = i*2;
					right = i*2+1;
				}
				if(tree[i].equals("+") || tree[i].equals("-") 
						|| tree[i].equals("*")||tree[i].equals("/")) {
					if(left != -1 && right != -1) {	// 노드가 연산자고 좌우 노드가 숫자면 1
						if(!tree[left].equals("+") || !tree[left].equals("-") 
								|| !tree[left].equals("*")|| !tree[left].equals("/") 
								&& !tree[right].equals("+") || !tree[right].equals("-") 
								|| !tree[right].equals("*")|| !tree[right].equals("/")) {
							res = 1;
						} else {	// 노드가 연산자고 좌우 노드가 연산자면 0
							res = 0;
						}
					} else {	// 노드가 연산자고 좌우 노드가 없으면 0
						res = 0;
					}
				}
			}
			System.out.println("#"+t+" "+res);
		}
	}
}
