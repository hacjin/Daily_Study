package kakao_intern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Solution3_2 {
	public static void main(String[] args) {
		int result[] = solution(new String[] {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});
		System.out.println(result[0] + "," + result[1]);
	}
	public static int[] solution(String[] gems) {
		HashMap<String,Integer> gem = new HashMap<>();
		ArrayList<String> have = new ArrayList<>();
		for (int i = 0; i < gems.length; i++) {
			String cur = gems[i];
			if(gem.get(cur)==null) {
				have.add(cur);
				gem.put(cur,i);
			}else {
				gem.put(cur, i);
			}
		}
		int st = 0;
		int[] answer = new int[2];
		int min = Integer.MAX_VALUE;
		// 마지막에 발견된 보석이 제일 적은 범위를 갖을것
		int des = gem.get(have.get(have.size()-1));
		HashSet<String> check = new HashSet<>();
		for (int i = des; i >= 0; i--) {
			check.add(gems[i]);
			if(check.size() == have.size()) {
				st = i;
				answer[0] = st+1;
				answer[1] = des+1;
				break;
			}
		}
        return answer;
    }
}
