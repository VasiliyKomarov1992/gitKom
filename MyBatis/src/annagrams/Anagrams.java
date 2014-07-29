package annagrams;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Anagrams {

	private static HashMap<String, LinkedList<String>> anagram = new HashMap<>();

	int size;
	String word;
	Scanner scanner = new Scanner(System.in);
	File file = new File("/Users/student/Downloads/wordlist.txt");

	public void inputText() {

		System.out.println("Enter the words:");
		word = scanner.nextLine();
		size = word.length();
		searchAnagram(size);
	}

	private void searchAnagram(int newSize) {
		if (newSize <= 1) {
			return;
		}
		for (int i = 0; i < newSize; i++) {
			
		}
	}

	@Override
	public String toString() {
		return word;
	}

	public static void main(String[] args) throws IOException {
		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));
		// File f = new File("/Users/student/Downloads/wordlist.txt");
		// BufferedReader fin = new BufferedReader(new FileReader(f));
		// String name;
		// String line;
		// System.out.println("Print File "+f.getName()+"? y/n");
		// name = br.readLine();
		// if(name.equals("y")) {
		// while ((line = fin.readLine()) != null) {
		// System.out.println(line);
		// }
		// }
		Anagrams ann = new Anagrams();
		ann.inputText();
		System.out.println("Word: " + ann.toString() + "\n" + " Anagrams: "
				+ anagram);

	}
}
