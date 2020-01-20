package string_pattern_0926;

public class Tmp {
	public static void main(String[] args) {
		String str = "ababaca";
		String jarr[] = new String[str.length()];
		int max[] = new int[str.length()];
		for (int i = 1; i <= jarr.length; i++) {
			String in = "";
			for (int j = 0; j < i; j++) {
				in += str.charAt(j);
			}
			jarr[i - 1] = in;
		}
		for (String string : jarr) {

			System.out.println(string);
		}
		int s = 1;	// 비교할 길이 
		int b = 0;	// 접두와 접미가 같은 갯수
		boolean chk = false;
		for (int i = 0; i < jarr.length; i++) {
			if(jarr[i].length()==1) max[i]=0;
			else {
				for (int j = 0; j < s; j++) {
					char st = jarr[i].charAt(j);
					char end = jarr[i].charAt(jarr[i].length()-1-b+j);
					if(st==end) { chk = true;}
					else chk = false;
				}
				if(chk) {s++;  b++;}
				else b = 0;
				max[i] = b;
			}
		}
		for (int string : max) {

			System.out.println(string);
		}
	}
}
