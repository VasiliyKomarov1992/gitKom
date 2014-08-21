package codeLines;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CountCodeLines {

	File file = new File("/Users/student/Documents/CodeKata/13/textBig");
	Scanner scannerText;
	String textLine;
	StringTokenizer token;
	int count = 0;
	char[] ch;
	String string = "*/";
	
	public void countingLines() {
		try {
			scannerText = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (scannerText.hasNextLine()) {
			textLine = scannerText.nextLine().trim();
//			token = new StringTokenizer(textLine, "");
//			token.;
			boolean comment = 
					 textLine.startsWith("//") 
//					 textLine.startsWith("/*"); 
//					|| textLine.endsWith("*/") 
					|| textLine.startsWith("*") || textLine.isEmpty();
			ch = textLine.toCharArray();
			
			if (!comment){
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
