package codeLines;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountCodeLines {

	File file = new File("/Users/student/Documents/CodeKata/13/textBig");
	Scanner scannerText;
	String textLine;
	int count = 0;

	public void countingLines() {
		try {
			scannerText = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (scannerText.hasNextLine()) {
			textLine = scannerText.nextLine().trim();

			// for (String str : textLine.split("/*")) {
			// System.out.println(str);
			// }

			boolean startWithComment = textLine.startsWith("//")
					|| textLine.startsWith("*") || textLine.isEmpty();

			// boolean borderInTheCommentLine = textLine.startsWith("/*")
			// && textLine.indexOf("*/") != -1 && !textLine.endsWith("*/");
			//
			boolean str1 = textLine.startsWith("/*")
					&& textLine.cod
					
//					textLine.indexOf("*/") != -1;

			if (!startWithComment || str1) {
				System.out.println(textLine);
				count++;
			}
		}
		System.out.println(count);
	}

	public static void main(String[] args) {

		CountCodeLines lines = new CountCodeLines();
		lines.countingLines();
	}
}
