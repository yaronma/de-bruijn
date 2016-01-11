package com.algorithms.debruijn;

public class TestUtils {

	public static Character[] toObjectArray(String input) {
		Character[] result = input.chars().mapToObj(c -> (char) c).toArray(Character[]::new);

		return result;
	}

}
