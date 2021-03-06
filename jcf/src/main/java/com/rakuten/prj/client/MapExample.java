package com.rakuten.prj.client;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author nishanth
 *
 */
public class MapExample {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "Java is OOP, Java is open source";
		str = str.replaceAll("[-+.^:,]", "");
		String[] splitString = str.split(" ");
		Map<String, Integer> index = new HashMap<>();
		for (int i = 0; i < splitString.length; i++) {
			if (index.containsKey(splitString[i])) 
				index.put(splitString[i], index.get(splitString[i]) + 1);
			index.putIfAbsent(splitString[i], 1);
		}
		System.out.println(index);
	}
}
