package programmers_back;

public class Solution2 {
	public static void main(String[] args) {
		System.out.println(solution(new int[][] {
			{5,-1,4},{6,3,-1},{2,-1,1}},1,0,new String[ ]{"go", "go", "right", "go", "right", "go", "left", "go"}));
	}

	public static int solution(int[][] office, int r, int c, String[] move) {
		int[][] direct = {{-1,0},{0,1},{1,0},{0,-1}}; // 북, 동, 남, 서
		int N = office.length;
		int answer = 0;
		int dir = 0;
		int nr = r,nc = c;
		for (int i = 0; i < move.length; i++) {
			String comd = move[i];
			if(comd.equals("go")) {
				nr += direct[dir][0];
				nc += direct[dir][1];
				if(nr>=0 && nc>=0 && nr<N && nc<N && office[nr][nc]>=0) {
						answer+=office[nr][nc];
						office[nr][nc] = 0;
				}else {
					nr -= direct[dir][0];
					nc -= direct[dir][1];
				}
			}else if(comd.equals("right")) {
				dir = (dir+1)%4;
			}else {
				dir = dir-1<0?dir=3:dir-1;
			}
		}
		return answer;
	}
}
