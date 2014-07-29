package annagrams;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Anagrams {

	public static HashMap<String, LinkedList<String>> anagrams = new HashMap<>();

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

	public static void main(String[] args) {
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
				+ anagrams);

	}
}

//http://forum.sources.ru/index.php?showtopic=9357
//http://books.google.ru/books?id=FpueE_bteEcC&pg=PA252&lpg=PA252&dq=как+строить+анаграммы+java&source=bl&ots=bhM2IqjNFE&sig=XR7rftOWCaMbliSzr2J_AR6LKu8&hl=ru&sa=X&ei=_JzXU8-2N6rNygOvkoCABA&ved=0CCIQ6AEwAA#v=onepage&q=как%20строить%20анаграммы%20java&f=false