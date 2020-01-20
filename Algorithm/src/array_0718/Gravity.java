package array_0718;

//import java.util.Random;
import java.util.Scanner;

public class Gravity {
	static int size = 9;

	public static void main(String[] args) {

		int data[] = new int[size]; // 방의 길이 100x100
		int depth[][] = new int[size][size];
		int high = 0, count=0, max = 0;
		build_data(data);

		for (int i = 0; i < size; i++) {

			for (int j = 0; j < data[i]; j++) {
				depth[i][j]++;
			}
		}
		for (int i = 0; i <size; i++) {
			high = 0;
			count=0;
			for (int j = 0; j < size; j++) {
				
				if (depth[j][i] == 1) {
					count++;
					if ( size-j > high) {
						high = size-j;
					}
				}
			}
			if(high-count > max) {
				max = high - count;
			}
		}

		System.out.println("Max_difference_depth : " + max);
//		ex) R[0] = 100 이면  회전을 통해 배열을 생각시 0열에 100개의 높이로 이루어져 있다고 생각 가능하다. 

	}

	public static void build_data(int[] data) {
		Scanner sc = new Scanner(System.in);
//		Random ran = new Random();
		for (int i = 0; i < size; i++) {
//			data[i] = ran.nextInt(size+1);
			data[i] = sc.nextInt();
		}
	}

}
