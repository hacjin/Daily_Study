package 미해결;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Solution_전화번호목록 {
	public static void main(String[] args) {
		System.out.println(solution(new String[] {"123", "456", "789"})?"true":"false");
	}

	public static boolean solution(String[] phone_book) {
		boolean answer = true;
		Arrays.sort(phone_book, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o2.length()-o1.length();
			}
		});
		HashMap<Integer, Integer> map = new HashMap<>();
		int size = phone_book.length;
		for (int l = 0; l < phone_book.length-1; l++) {
			
			char[] arr = phone_book[l].toCharArray();
			for (int k = 0; k < arr.length; k++) {
				map.put(k, arr[k]-'0');
			}
			for (int i = l+1; i < size; i++) {
				boolean chk = true;
				char[] tmp = phone_book[i].toCharArray();
				for (int j = 0; j < tmp.length; j++) {
					if(map.get(j) != tmp[j]-'0') chk = false;
				}
				if(chk) {
					answer = false;
					break;
				}
			}
		}
		return answer;
	}
}
