package 미해결;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution_위장 {
	public static void main(String[] args) {
		System.out.println(solution(new String[][] {
			{"yellow_hat","headgear"},{"blue_sunglasses","eyewear"}
					,{"green_turban","headgear"}
		}));
	}

	public static int solution(String[][] clothes) {
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < clothes.length; i++) {
			String key = clothes[i][1];
			if(map.get(key)==null) {
				list.add(key);
				map.put(key, 1);
			}
			else {
				int val = map.get(key);
				map.put(key, val+1);
			}
		}
		int answer = 1;
		for (int i = 0; i < list.size(); i++) {
			String key = list.get(i);
			answer *= map.get(key)+1;
		}
		return answer-1;
	}



}
