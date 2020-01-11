package com.rakuten.prj.util;

import java.util.Arrays;

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
}
