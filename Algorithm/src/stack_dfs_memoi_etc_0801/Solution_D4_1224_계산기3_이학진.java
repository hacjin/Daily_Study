package stack_dfs_memoi_etc_0801;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_D4_1224_계산기3_이학진 {
	static int T = 10;
	static char[] ct;
	static Stack<Character> stack = new Stack<Character>();
	static Stack<Integer> sk = new Stack<Integer>();
	static StringBuilder sb;
	static int isnum=0;
	static boolean chk = false;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tlen;
		String input;
		for (int i = 1; i <= T; i++) {
			sb = new StringBuilder();
			isnum=0;
			tlen = Integer.parseInt(br.readLine());
			input = br.readLine();
			ct = input.toCharArray();
			for (int j = 0; j < tlen; j++) {
				makeafter(ct[j]);
			}
			while(!stack.isEmpty()) {sb.append(stack.pop());}
			calc();
			System.out.println("#"+i+" "+sk.pop());
		}
	}

	public static void makeafter(char ch) {
		char tmp;
		if(isnum==2) {
			if(ch=='*') {
				if(stack.peek().equals('*')) {
					sb.append(stack.pop());
				}
				isnum--;
			}
			else if(ch=='+') {
				if(stack.peek().equals('*')) {
					sb.append(stack.pop());
				}
				if(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				isnum--;
			}
		}
//		닫는괄호가 나올 시 pop
		switch (ch) {
		case '+':
			if(!stack.isEmpty() && stack.peek().equals('*')) {
				tmp = stack.pop();
				stack.push(ch);
				stack.push(tmp);
			}
			else {
				stack.push(ch);
			}
			break;
		case '*':
			stack.push(ch);
			break;
		case '(':
			stack.push(ch);
			chk = true;
			break;
		case ')':
			if(chk) {
				
			}
			break;
		default:
			sb.append(ch);
			isnum++;
			break;
		}
		
	}
	
	public static void calc() {
		int a,b; 
		for (int i = 0,sbIndex=sb.length(); i < sbIndex; i++) {
			if(sb.charAt(i)=='+') {
				b = sk.pop();
				a = sk.pop();
				sk.push(a+b);
			}else if(sb.charAt(i)=='*') {
				b = sk.pop();
				a = sk.pop();
				sk.push(a*b);
			}else {
				sk.push(sb.charAt(i)-'0');
			}
		}
	}
}
