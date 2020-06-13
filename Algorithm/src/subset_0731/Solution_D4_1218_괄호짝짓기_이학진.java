package subset_0731;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_D4_1218_괄호짝짓기_이학진 {
	static int T = 0, res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> s = new Stack<Character>(); 
		String in;
		char tmp;
		for (int i = 1; i <= 10; i++) {
			s.clear();
			T = Integer.parseInt(br.readLine());
			in = br.readLine();
			for (int j = 0; j < T; j++) {
				tmp = in.charAt(j);
				switch (tmp) {
				case '(':
					s.push(tmp);
					break;
				case '[':
					s.push(tmp);
					break;
				case '{':
					s.push(tmp);
					break;
				case '<':
					s.push(tmp);
					break;
				case ')':
					if(s.peek()=='(') {
						s.pop();
					}else {
						s.push(tmp);
					}
					break;
				case ']':
					if(s.peek()=='[') {
						s.pop();
					}else {
						s.push(tmp);
					}
					break;
				case '}':
					if(s.peek()=='{') {
						s.pop();
					}else {
						s.push(tmp);
					}
					break;
				case '>':
					if(s.peek()=='<') {
						s.pop();
					}else {
						s.push(tmp);
					}
					break;
				}
			}
			if(i==6) {
				System.out.println(s.toString());
			}
			if(s.isEmpty()) {
				res = 1;
			}
			else {
				res = 0;
			}
			System.out.println("#"+i+" "+res);
		}

	}
}
