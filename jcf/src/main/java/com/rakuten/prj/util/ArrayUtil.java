package com.rakuten.prj.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.rakuten.prj.entity.Triplet;

/**
 * 
 * @author nishanth
 *
 */
final class ArrayUtil {
	private ArrayUtil() {

	}

	/**
	 * 
	 * @param data
	 * @return
	 */
	public static int getSum(int[] data) {
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return sum;
	}

	/**
	 * 
	 * @param data
	 * @param a
	 * @return
	 */
	public static int getOccurence(int[] data, int a) {
		int count = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i] == a)
				count++;
		}
		return count;
	}

	/**
	 * 
	 * @param data
	 */
	public static void sort(int[] data) {
		Arrays.sort(data);
	}
	
	/**
	 * 
	 * @param items which are comparable
	 */
	public static void sort(Comparable[] items) {
		for (int i = 0; i < items.length; i++) {
			for (int j = i + 1; j < items.length; j++) {
				if (items[i].compareTo(items[j]) > 0) {
					Comparable temp = items[i];
					items[i] = items[j];
					items[j] = temp;
				}
			}
		}
	}
	
	/**
	 * 
	 * @param data
	 * @return
	 */
	public static List<Triplet> printTriplets(int[] data) {
		List<Triplet> list = new ArrayList<>();
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length; j++) {
				if (i != j && check(data[i] + data[j], data) && data[i] < data[j]) {
					Triplet triplet = new Triplet(data[i], data[j], data[i] + data[j]);
					list.add(triplet);
				}
			}
		}
		Collections.sort(list, (s1, s2) -> s1.getThird() - s2.getThird());
		return list;
	}

	private static boolean check(int element, int[] data) {
		for (int i = 0; i < data.length; i++) {
			if (element == data[i])
				return true;
		}
		return false;
	}

	
}
