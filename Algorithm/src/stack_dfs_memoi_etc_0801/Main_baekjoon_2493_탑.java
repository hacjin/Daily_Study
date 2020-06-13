package stack_dfs_memoi_etc_0801;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_baekjoon_2493_탑 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N, index = 0;
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> ins = new Stack<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tmp = 0;
		for (int i = 0; i < N; i++) {
			tmp = Integer.parseInt(st.nextToken());
			if (stack.isEmpty()) {
				bw.write(0 + " ");
				stack.push(tmp);
				ins.push(index);
				index++;
			} else {
				while (true) {
					if (stack.peek() < tmp) {
						stack.pop();
						ins.pop();
						if (stack.isEmpty()) {
							bw.write(0 + " ");
							stack.push(tmp);
							ins.push(index);
							break;
						}
					} else if (stack.peek() > tmp) {
						bw.write(ins.peek() + 1 + " ");
						stack.push(tmp);
						ins.push(index);
						break;
					}
				}
				index++;
			}
		}
		bw.flush();
	}
}
