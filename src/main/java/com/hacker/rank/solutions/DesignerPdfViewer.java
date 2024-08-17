package com.hacker.rank.solutions;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

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
