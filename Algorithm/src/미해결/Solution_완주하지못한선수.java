package 미해결;

import java.util.HashMap;

public class Solution_완주하지못한선수 {
	public static void main(String[] args) {
		System.out.println(solution(new String[] {"marina", "josipa", "nikola", "vinko", "filipa"}
		,new String[] {"josipa", "filipa", "marina", "nikola"}));
	}
	public static String solution(String [] participant, String[] completion) {
		HashMap<String,Integer> part = new HashMap<>();
		HashMap<String,Integer> comple = new HashMap<>();
		for (String str : completion) {
			if(comple.get(str) == null) comple.put(str, 1);
			else {
				int val = comple.get(str);
				comple.put(str, val+1);
			}
		}
		String answer = "";
		for (String str : participant) {
			if(part.get(str) == null) part.put(str, 1);
			else {
				int val = part.get(str);
				part.put(str, val+1);
			}
		}
		for (String str : participant) {
			int val = part.get(str);
			if(comple.get(str)==null || val != comple.get(str)) answer = str;
		}
		return answer;
	}
}
