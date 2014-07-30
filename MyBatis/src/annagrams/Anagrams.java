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

			String sortedWord = sortingWords(word);
			ArrayList<String> anagrams = map.get(sortedWord); // this is key

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

/*
 *  http://forum.sources.ru/index.php?showtopic=9357
 *  http://books.google.ru/books?id=FpueE_bteEcC&pg=PA252&lpg=PA252&dq=как+строить+анаграммы+java&source=bl&ots=bhM2IqjNFE&sig=XR7rftOWCaMbliSzr2J_AR6LKu8&hl=ru&sa=X&ei=_JzXU8-2N6rNygOvkoCABA&ved=0CCIQ6AEwAA#v=onepage&q=как%20строить%20анаграммы%20java&f=false
 *  http://www.cs.cmu.edu/~adamchik/15-121/lectures/Hashing/code/Anagrams.java
 *  http://javist.ru/skanirovanie-teksta-s-java-util-scanner/ -- как считывать из файла данные (File)
 *  http://codingrus.ru/readarticle.php?article_id=673 -- как считывать из файла данные (Scanner)
*/		