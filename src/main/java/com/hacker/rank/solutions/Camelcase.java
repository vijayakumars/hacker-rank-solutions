package com.hacker.rank.solutions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

class CamelcaseResult {

	/*
	 * Complete the 'camelcase' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts
	 * STRING s as parameter.
	 */

	public static int camelcase(String s) {
		// Write your code here
		int count = 1;
		char[] chars = s.toCharArray();
		for (char c : chars) {
			int asciiVal = (int) c;
			if (((97 - asciiVal) > 0)) {
				count++;
			}
		}
		return count;
	}

}

public class Camelcase {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(
				new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = bufferedReader.readLine();

		int result = CamelcaseResult.camelcase(s);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
