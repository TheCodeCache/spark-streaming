package com.stream.test.sparksqs;

import java.util.HashMap;
import java.util.Map;

public class MapExample {

	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<>();
		System.out.println(map.putIfAbsent(2, 1));
		System.out.println(map.putIfAbsent(2, 3));
		System.out.println(map.putIfAbsent(3, 1));
		System.out.println();
		
		System.out.println(map);
	}
}
