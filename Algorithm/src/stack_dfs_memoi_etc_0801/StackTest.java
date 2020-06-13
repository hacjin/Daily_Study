package stack_dfs_memoi_etc_0801;

public class StackTest {
	public static void main(String[] args) {
		
//		Stack stack = new Stack(3);
		java.util.Stack stack = new java.util.Stack();
		System.out.println(stack.size());
		try {
			stack.push("월요일");
			stack.push("화요일");
			stack.push("수요일");
			stack.push("목요일");
		} catch (Exception e) {
			System.out.println("예외발생 : "+e.getMessage());
		}
		System.out.println(stack.size());
		System.out.println("peek : " +stack.peek());
		System.out.println(stack.size());
		System.out.println("pop : " +stack.pop());
		System.out.println("pop : " +stack.pop());
		System.out.println("pop : " +stack.pop());
		System.out.println("pop : " +stack.pop());	// 예외 처리 안해줘서 밑의 size 안찍힘
		System.out.println(stack.size());
	}
}
