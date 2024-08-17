package com.hacker.rank.solutions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

class TimeConversionResult {

	/*
	 * Complete the 'timeConversion' function below.
	 *
	 * The function is expected to return a STRING. The function accepts STRING
	 * s as parameter.
	 */
	private static final String AM = "AM";
	private static final String PM = "PM";
	public static String timeConversion(String s) {

		// Write your code here
		StringBuilder convertedSb = new StringBuilder();

		if (s != null) {
			int hour = Integer.parseInt(s.substring(0, 2));
			if (s.contains(PM)) {
				convertedSb.append(s.replace(PM, ""));
				if (hour != 12) {
					hour = 12 + hour;
					convertedSb.replace(0, 2, Integer.toString(hour));
				}
			} else if (s.contains(AM)) {
				convertedSb.append(s.replace(AM, ""));
				if (hour == 12) {
					convertedSb.replace(0, 2, "00");
				}
			}
		}

		return convertedSb.toString();
	}

}

public class TimeConversion {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(
				new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = bufferedReader.readLine();

		String result = TimeConversionResult.timeConversion(s);

		bufferedWriter.write(result);
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
