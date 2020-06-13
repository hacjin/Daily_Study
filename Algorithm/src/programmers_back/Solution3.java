package programmers_back;

public class Solution3 {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{3,7,2,8,6,4,5,1},3));
	}
	public static int solution(int[] numbers, int K) {
        int answer = 0;
        for (int i = 0; i < numbers.length; i++) {
        	int[] arr = numbers;
        	for (int j = 0; j < arr.length-1; j++) {
        		if(Math.abs(arr[j]-arr[j+1])>K) {
        			swap(arr,i,K);
        		}
			}
		}
        return answer;
    }
	private static void swap(int[] arr, int i,int K) {
		for (int j = i+1; j < arr.length; j++) {
			int tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
		}
	}
}
