package greedy_etc_0821;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*
10
1 1 4
2 1 6
3 6 10
4 5 7
5 3 8
6 5 9
7 3 5
8 8 11
9 2 13
10 12 14
 */
public class MeetingRoomTest2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
//		int list[][] = new int[count][3];
		int list[][] = new int[count][];
		
		for (int i = 0; i < count; ++i) {
/*			list[i][0] = sc.nextInt();
			list[i][1] = sc.nextInt();
			list[i][2] = sc.nextInt();*/
			list[i] = new int[] {sc.nextInt(), sc.nextInt(), sc.nextInt()};
 		}
		List<int[]> mList = makeSchedule(list);
		System.out.println("최대회의수 : "+mList.size());
		for (int[] meetingRoom : mList) {
			System.out.println(meetingRoom[0]);
		}
		
	}

	private static List<int[]> makeSchedule(int[][] mList) {
		Arrays.sort(mList , new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				int temp = o1[2]-o2[2];
				return temp!=0?temp:o1[1]-o2[1];// 종료시간이 같다면 시작시간기준으로 오름차순
			}
			
		}); // 종료시간기준 오름차순
		List<int[]> result = new ArrayList<int[]>();
		result.add(mList[0]);
		for (int i = 1; i < mList.length; ++i) {
			if(result.get(result.size()-1)[2] <= mList[i][1]) result.add(mList[i]);
		}
		return result;
	}

}



















