package queue_linkedList_sort_etc_0808;

import java.util.ArrayList;

public class MergeSort {

	public static ArrayList<Integer> mergeSort(ArrayList<Integer> list) {
		final int SIZE = list.size();
		ArrayList<Integer> left, right;
		int middle = SIZE / 2;
		if (SIZE <= 1)
			return list;
		else {
			left = new ArrayList<Integer>();
			for (int i = 0; i < middle; i++) {
				left.add(list.get(i));
			}

			right = new ArrayList<Integer>();
			for (int i = middle; i < SIZE; i++) {
				right.add(list.get(i));
			}
		}
		return merge(mergeSort(left), mergeSort(right));
	}

	public static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {
		ArrayList<Integer> result;
		result = new ArrayList<Integer>();
		int lsize = left.size();
		int rsize = right.size(); 
		int index = 0;
		while (lsize > 0 || rsize > 0) {
			rsize = right.size();
			lsize = left.size();
			if (lsize > 0 && rsize > 0) {
				if (left.get(index) <= right.get(index)) {
					result.add(left.get(index));
					left.remove(index);
				} else {
					result.add(right.get(index));
					right.remove(index);
				}
			} else if (lsize > 0) {
				result.add(left.get(index));
				left.remove(index);
			} else if (rsize > 0) {
				result.add(right.get(index));
				right.remove(index);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(69);
		list.add(10);
		list.add(30);
		list.add(2);
		list.add(16);
		list.add(8);
		list.add(31);
		list.add(22);
		System.out.println(mergeSort(list));
		
	}
}
