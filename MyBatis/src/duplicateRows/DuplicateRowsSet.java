package duplicateRows;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class DuplicateRowsSet {

	public void deleteDuplicateRowsSet(List<String> _list) {
		Set set = new TreeSet<>(_list);
		System.out.println(set);
	}

	public void deleteDuplicateLines() {
		
	}
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		DuplicateRowsSet rows = new DuplicateRowsSet();

		list.add("privaet");
		list.add("privaet");
		list.add("hello");
		list.add("hi");
		list.add("hello");
		list.add("privaet");
		list.add("234");
		list.add("dobryi den");
		list.add("privaet");
		
		rows.deleteDuplicateRowsSet(list);
	}
}
