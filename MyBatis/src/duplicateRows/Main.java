package duplicateRows;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	private static final int NUMBER = 1000000;
	static String arr[] = { "static", "mama", "papa", "cosmos", "space",
			"shuttle", "cream", "clavicle" };

	static void fillList(List<String> list) {
		Random r = new Random();
		for (int i = 0; i < NUMBER; i++) {
			// list.add(arr[Math.abs(r.nextInt()) % arr.length]);
			list.add(String.valueOf(r.nextInt(NUMBER / 10)));
		}
	}

	// public void deleteLines(List<String> _list) {
	// List newList = new ArrayList<>();
	// for (int i = 0; i < _list.; i++) {
	//
	// }
	// if (!newList.contains()) {
	// newList.add(_list);
	// System.out.println(newList);
	// }
	// }

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		Main rows = new Main();

		list.add("privaet");
		list.add("privaet");
		list.add("hello");
		list.add("hi");
		list.add("hello");
		list.add("privaet");
		list.add("234");
		list.add("dobryi den");
		list.add("privaet");

		fillList(list);
		
		long start = System.currentTimeMillis();
		Set treeSet = new TreeSet<>(list);
		long stop = System.currentTimeMillis();
		System.out.println("Time set: " + (stop - start));

		start = System.currentTimeMillis();
		Set hashSet = new HashSet<>(list);
		stop = System.currentTimeMillis();
		System.out.println("Time hashSet: " + (stop - start));

		start = System.currentTimeMillis();
		Set linkedHashSet = new LinkedHashSet<>(list);
		stop = System.currentTimeMillis();
		System.out.println("Time linkedHashSet: " + (stop - start));

		start = System.currentTimeMillis();
		TrieST<String> trie = new TrieST<>();
		trie.put(key, val);;
		stop = System.currentTimeMillis();
		System.out.println("Time trie: " + (stop - start));
		// rows.deleteLines(list);
	}
}
