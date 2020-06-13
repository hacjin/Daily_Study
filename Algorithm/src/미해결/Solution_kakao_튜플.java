package 미해결;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class Solution_kakao_튜플 {
	public static void main(String[] args) {
		int [] result = solution("{{20,111},{111}}");
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]+" ");
		}
	}
	public static int[] solution(String s) {
		String[] arr2 = s.replaceAll("[{}]", " ").trim().split(" , ");
		System.out.println(s.replaceAll("[{}]", " ").trim());
		boolean visit[] = new boolean[100001];
		char[] arr = s.toCharArray();
		ArrayList<Stack<Integer>> list = new ArrayList<>();
		String value = "";
		Stack<Integer> tmp = null;
		boolean open = false;
		for (int i = 1; i < arr.length-1; i++) {
			char cur = arr[i];
			if(cur == '{') {
				tmp = new Stack<Integer>();
				open = true;
			}else if(cur == ',') {
				if(open) {
					tmp.push(Integer.parseInt(value));
					value = "";
				}
				else continue;
			}else if(cur == '}') {
				tmp.push(Integer.parseInt(value));
				value = "";
				list.add(tmp);
				open = false;
			}else value += cur;
		}
		Collections.sort(list, new Comparator<Stack<Integer>>() {
			@Override
			public int compare(Stack<Integer> o1, Stack<Integer> o2) {
				// TODO Auto-generated method stub
				return o1.size()-o2.size();
			}
		});
		int size = list.size();
		int[] answer = new int[size];
		answer[0] = list.get(0).pop();
		visit[answer[0]] = true;
		for (int i = 1; i < size; i++) {
			tmp = list.get(i);
			while(!tmp.isEmpty()) {
				int top = tmp.pop();
				if(!visit[top]) {
					answer[i] = top;
					visit[top] = true;
				}
			}
		}
        return answer;
    }
}
