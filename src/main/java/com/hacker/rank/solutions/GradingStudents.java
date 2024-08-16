package com.hacker.rank.solutions;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;

public class GradingStudents {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(
				new FileWriter(System.getenv("OUTPUT_PATH")));

		int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		List<Integer> result = GradingStudentsResult.gradingStudents(grades);

		bufferedWriter.write(
				result.stream().map(Object::toString).collect(joining("\n"))
						+ "\n");

		bufferedReader.close();
		bufferedWriter.close();
	}
}

class GradingStudentsResult {

	/*
	 * Complete the 'gradingStudents' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * INTEGER_ARRAY grades as parameter.
	 */

	public static List<Integer> gradingStudents(List<Integer> grades) {
		// Write your code here
		for (int i = 0; i < grades.size(); i++) {
			int val = grades.get(i);
			if (val >= 38) {
				int diff = val % 5;
				if (diff >= 3) {
					grades.set(i, val + (5 - diff));
				}
			}

		}
		return grades;
	}

}
