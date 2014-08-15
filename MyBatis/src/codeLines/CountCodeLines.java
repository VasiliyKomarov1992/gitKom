package codeLines;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountCodeLines {

	File file = new File("/Users/student/Documents/CodeKata/13/textSmall");
	Scanner scannerText;
	String textLine;
	int count = 0;
	char[] ch;

	public void countingLines() {
		try {
			scannerText = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (scannerText.hasNextLine()) {
			textLine = scannerText.nextLine().trim();
			boolean comment = textLine.startsWith("/*")
					|| textLine.startsWith("//") || textLine.endsWith("*/")
					|| textLine.startsWith("*") || textLine.isEmpty();
			if (!comment) {
				count++;
				System.out.println(textLine);
			}
		}
		System.out.println(count);
	}

	public static void main(String[] args) {

		CountCodeLines lines = new CountCodeLines();
		lines.countingLines();
	}
}
