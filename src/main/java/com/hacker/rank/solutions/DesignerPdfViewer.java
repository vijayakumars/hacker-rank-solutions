package com.hacker.rank.solutions;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class DesignerPdfViewerResult {

	/*
	 * Complete the 'designerPdfViewer' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts
	 * following parameters: 1. INTEGER_ARRAY h 2. STRING word
	 */

	public static int designerPdfViewer(List<Integer> h, String word) {
		// Write your code here
		char[] chars = word.toCharArray();
		int height = 0;
		int max = 0;
		for (char c : chars) {
			int asciiIndex = (int) c - 97;
			int charHeight = h.get(asciiIndex);
			if (charHeight > max) {
				max = charHeight;
			}
		}
		height = max * chars.length;

		return height;
	}

}

public class DesignerPdfViewer {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(
				new FileWriter(System.getenv("OUTPUT_PATH")));

		List<Integer> h = Stream.of(
				bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		String word = bufferedReader.readLine();

		int result = DesignerPdfViewerResult.designerPdfViewer(h, word);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
