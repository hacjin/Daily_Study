package kakao_intern;

import java.util.ArrayList;
import java.util.HashSet;

public class Solution3 {
	public static void main(String[] args) {
		int result[] = solution(new String[] {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});
		System.out.println(result[0] + "," + result[1]);
	}
	public static int[] solution(String[] gems) {
		HashSet<String> gem = new HashSet<>();
		ArrayList<String> have = new ArrayList<>();
		for (int i = 0; i < gems.length; i++) {
			String cur = gems[i];
			if(gem.add(cur)) {
				have.add(cur);
			}
		}
		int st = 0, des = 0;
		int[] answer = new int[2];
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < gems.length; i++) {
			gem = new HashSet<>();
			st = i;
			for (int j = i; j < gems.length; j++) {
				if(gem.add(gems[j]) && gem.size() == have.size()) {
					des = j;
					break;
				}
			}
			if(gem.size() == have.size()) {
				int dis = des-st;
				if(min > dis) {
					min = dis;
					answer[0] = st+1;
					answer[1] = des+1;
				}
			}
		}
        return answer;
    }
}
