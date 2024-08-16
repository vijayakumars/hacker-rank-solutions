package com.hacker.rank.solutions;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class MiniMaxSumResult {

	/*
	 * Complete the 'miniMaxSum' function below.
	 *
	 * The function accepts INTEGER_ARRAY arr as parameter.
	 */

	public static void miniMaxSum(List<Integer> arr) {
		// Write your code here
		List<Long> sums = new ArrayList<>();
		for (int i = 0; i < arr.size(); i++) {
			long sum = 0;
			for (int j = 0; j < arr.size(); j++) {

				if (i != j) {
					sum += arr.get(j);
				}

			}
			sums.add(sum);
		}
		Collections.sort(sums);
		System.out.println(sums.get(0) + " " + sums.get(arr.size() - 1));
	}
}

public class MiniMaxSum {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		MiniMaxSumResult.miniMaxSum(arr);

		bufferedReader.close();
	}
}
