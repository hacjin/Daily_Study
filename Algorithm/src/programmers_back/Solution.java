package programmers_back;

public class Solution {
	public static void main(String[] args) {
		
	}
	public static int solution(String p, String s) {
		char[] cur = p.toCharArray();
		char[] pass = s.toCharArray();
		
		int answer = 0;
		for (int i = 0; i < cur.length; i++) {
			int cur_int = cur[i]-'0';
			int pass_int = pass[i]-'0';
			int gap = 0;
			if(cur_int >= pass_int) {
				gap = Math.min(pass_int+10-cur_int,cur_int-pass_int);
			}else {
				gap = Math.min(cur_int+10-pass_int, pass_int-cur_int);
			}
			answer += gap;
		}
		return answer;
	}
}
