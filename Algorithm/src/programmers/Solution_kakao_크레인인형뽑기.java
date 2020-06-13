package programmers;

import java.util.Stack;

public class Solution_kakao_크레인인형뽑기 {
	public static void main(String[] args) {
		System.out.println(solution(new int[][] {
			{0, 0, 0, 0, 0},
			{0, 0, 1, 0, 3},
			{0, 2, 5, 0, 1},
			{4, 2, 4, 4, 2},
			{3, 5, 1, 3, 1}},new int[] {1, 5, 3, 5, 1, 2, 1, 4}));
	}
	public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        int size = board.length;
        Stack<Integer> dolls[] = new Stack[size];
        // 각 열의 인형들 stack에 삽입
        for (int i = size-1; i >= 0; i--) {
			for (int j = 0; j < board[i].length; j++) {
				if(dolls[j] == null ) dolls[j] = new Stack<Integer>();
				int cur = board[i][j];
				if(cur>0) {
					dolls[j].push(cur);
				}
			}
		}
        Stack<Integer> receive = new Stack<Integer>();
        for (int i = 0; i < moves.length; i++) {
			int index = moves[i]-1;
			if(dolls[index].isEmpty()) continue;
			int get = dolls[index].pop();
			if(!receive.isEmpty() && receive.peek() == get) {
				receive.pop();
				answer+=2;
			}else {
				receive.add(get);
			}
		}
        return answer;
	}
}
