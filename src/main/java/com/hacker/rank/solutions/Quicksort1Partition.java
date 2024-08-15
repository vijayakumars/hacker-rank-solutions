package com.hacker.rank.solutions;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class Result {

	/*
	 * Complete the 'quickSort' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * INTEGER_ARRAY arr as parameter.
	 */

	public static List<Integer> quickSort(List<Integer> arr) {
		// Write your code here
		List<Integer> sortedList = new ArrayList<>();
		List<Integer> ltList = new ArrayList<>();
		List<Integer> gtList = new ArrayList<>();
		List<Integer> eqList = new ArrayList<>();
		Integer pivot = arr.get(0);
		for (Integer i : arr) {
			if (i == pivot) {
				eqList.add(i);
			} else if (i > pivot) {
				gtList.add(i);
			} else {
				ltList.add(i);
			}
		}
		sortedList.addAll(ltList);
		sortedList.addAll(eqList);
		sortedList.addAll(gtList);
		return sortedList;
	}

}

public class Quicksort1Partition {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		List<Integer> result = Result.quickSort(arr);

		bufferedWriter.write(result.stream().map(Object::toString).collect(joining(" ")) + "\n");

		bufferedReader.close();
		bufferedWriter.close();
	}
}