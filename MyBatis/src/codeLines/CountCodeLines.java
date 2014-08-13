package codeLines;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountCodeLines {

	File file = new File("/Users/student/Documents/CodeKata/13/textSmall");
	// FileInputStream fileInput = new FileInputStream(file.);
	int count = 0;
	String textLine;
	Scanner scannerText;

	public void countingLines() {

		try {
			scannerText = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while (scannerText.hasNextLine()) {
			textLine = scannerText.nextLine();
				
			
			System.out.println(textLine);
		}
	}

	public static void main(String[] args) {

		CountCodeLines lines = new CountCodeLines();
		lines.countingLines();
	}
}

//			char[] ch = textLine.toCharArray();
//			count++