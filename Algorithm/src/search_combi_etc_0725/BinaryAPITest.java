package search_combi_etc_0725;

import java.util.Arrays;

public class BinaryAPITest {
	public static void main(String[] args) {
		int[] values = {3,11,15,20,21,29,15};
		Arrays.sort(values);
		System.out.println(Arrays.toString(values));
		System.out.println(Arrays.binarySearch(values, 15));
		System.out.println(Arrays.binarySearch(values, 20));
		System.out.println(Arrays.binarySearch(values, 17));
		
	}
}
