package subset_0731;

public class StringBuilderTest {
	public static void main(String[] args) {
		String str = "i";
		
		System.out.println(str);
		System.out.println(str+"am ");
		System.out.println(str+"happy");
		System.out.println(str);
		
		str = str +"am ";
		str += "happy";
		
		StringBuilder sb = new StringBuilder();
		sb.append("i");
		sb.append(" am");
		sb.append(" happy");
		System.out.println(sb);
		
		StringBuilder sb2 = new StringBuilder();
		System.out.println(sb2.append("i").append(" am").append(" happy").toString());
		
		System.out.println(new StringBuilder().append("i").append(" am").append(" happy").toString());
		
		System.out.println(sb.reverse());
		System.out.println(sb.toString());
		sb.setLength(4);					// builder 비우길 원할시 setLength(0)
		System.out.println(sb.toString());
		sb.insert(0, "haha ");				// 앞쪽으로 입력
		System.out.println(sb.toString());
		sb.insert(0, "hoho ");
		System.out.println(sb.toString());
	}
}
