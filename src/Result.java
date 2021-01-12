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

class Result {

	/*
	 * Complete the 'countGroups' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts
	 * STRING_ARRAY related as parameter.
	 */

	public static int countGroups(List<String> related) {
		// Write your code here
		int len = related.size();

		if (len == 0)
			return 0;

		int[][] matrix = new int[len][len];

		for (int i = 0; i < len; i++) {
			matrix[i] = new int[len];
			char[] chars = related.get(i).toCharArray();

			for (int k = 0; k < len; k++)
				if (chars[k] == '1')
					matrix[i][k] = 1;
		}

		int groups = 0;

		for (int i = 0; i < len; i++) {
			if (matrix[i][i] == 1) {
				parseFurther(matrix, i);
				groups++;
			}
		}

		return groups;

	}

	public static void parseFurther(int[][] matrix, int i) {
		int len = matrix.length;
		if (matrix[i][i] == 0)
			return;

		for (int k = 0; k < len; k++) {
			if (matrix[i][k] == 1) {
				matrix[i][k] = 0;
				parseFurther(matrix, k);
			}
		}
	}

}
