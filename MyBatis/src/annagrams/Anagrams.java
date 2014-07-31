package annagrams;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Anagrams {

	private final HashMap<String, ArrayList<String>> map = new HashMap<>();
	Scanner scannerWord = new Scanner(System.in);
	private String text;

	public void searchAnagram() throws IOException {
		URL url = new URL("http://codekata.com/data/wordlist.txt");
		Scanner scannerText = new Scanner(url.openStream());

		System.out.println("Enter the words:");
		text = scannerWord.nextLine();

		while (scannerText.hasNextLine()) {
			String word = scannerText.nextLine();
			String sortedWord;			// key

			sortedWord = sortingWords(word);
			
			ArrayList<String> anagrams = map.get(sortedWord); // value

			if (anagrams == null) {
				anagrams = new ArrayList<>();
			}
			anagrams.add(word);
			map.put(sortedWord, anagrams);
		}

		System.out.println(map.get(sortingWords(text)));
	}

	private String sortingWords(String newSortedWord) {
		char[] ch = newSortedWord.toCharArray();
		Arrays.sort(ch);
		return new String(ch);
	}

	public static void main(String[] args) throws IOException {
		Anagrams ann = new Anagrams();
		long start = System.currentTimeMillis();
		ann.searchAnagram();
		long stop = System.currentTimeMillis();
		System.out.println(stop - start);
	}
}
