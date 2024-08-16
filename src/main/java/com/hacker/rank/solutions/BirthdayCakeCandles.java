package com.hacker.rank.solutions;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

class BirthdayCakeCandlesResult {

	/*
	 * Complete the 'birthdayCakeCandles' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts
	 * INTEGER_ARRAY candles as parameter.
	 */

	public static int birthdayCakeCandles(List<Integer> candles) {
		// Write your code here
		Map<Integer, Integer> countMap = new HashMap<>();
		int max = candles.get(0);
		for (int i = 0; i < candles.size(); i++) {
			int val = candles.get(i);
			if (val > max) {
				max = val;
			}
			Integer valCount = countMap.get(val);
			if (valCount != null) {
				valCount++;
			} else {
				valCount = 1;
			}
			countMap.put(val, valCount);
		}
		return countMap.get(max);
	}

}

public class BirthdayCakeCandles {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(
				new FileWriter(System.getenv("OUTPUT_PATH")));

		int candlesCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> candles = Stream.of(
				bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		int result = BirthdayCakeCandlesResult.birthdayCakeCandles(candles);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
