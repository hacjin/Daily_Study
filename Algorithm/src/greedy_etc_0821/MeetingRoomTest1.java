package greedy_etc_0821;

import java.util.ArrayList;
import java.util.Arrays;
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
public class MeetingRoomTest1 {

	static class MeetingRoom implements Comparable<MeetingRoom>{
		int no,start,end;
		public MeetingRoom(int no, int start, int end) {
			super();
			this.no = no;
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(MeetingRoom o) {
			int temp = this.end-o.end;
			return temp!=0?temp:this.start-o.start;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		MeetingRoom list[] = new MeetingRoom[count];
		
		for (int i = 0; i < count; ++i) {
			list[i] = new MeetingRoom(sc.nextInt(), sc.nextInt(), sc.nextInt());
 		}
		List<MeetingRoom> mList = makeSchedule(list);
		System.out.println("최대회의수 : "+mList.size());
		for (MeetingRoom meetingRoom : mList) {
			System.out.println(meetingRoom.no);
		}
		
	}

	private static List<MeetingRoom> makeSchedule(MeetingRoom[] mList) {
		Arrays.sort(mList); // 종료시간기준 오름차순
		List<MeetingRoom> result = new ArrayList<MeetingRoom>();
		result.add(mList[0]);
		for (int i = 1; i < mList.length; ++i) {
			if(result.get(result.size()-1).end <= mList[i].start) result.add(mList[i]);
		}
		return result;
	}

}



















