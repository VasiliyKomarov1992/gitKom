package duplicateRows;

public class TrieST<Value> {
	private static int R = 256;
	private Node root;

	private static class Node {
		private Object val;
		private final Node[] next = new Node[R];
	}

	public Value get(String key) {
		Node x = get(root, key, 0);
		if (x == null) {
			return null;
		}
		return (Value) x.val;
	}

	private Node get(Node x, String key, int d) {
		// Возвращает значение, связанное с ключом key в поддереве с корнем x
		if (x == null) {
			return null;
		}
		if (d == key.length()) {
			return x;
		}
		char c = key.charAt(d); // Определение поддерева на основе d-ого символа
								// ключа key
		return get(x.next[c], key, d + 1);
	}

	public void put(String key, Value val) {
		root = put(root, key, val, 0);
	}

	private Node put(Node x, String key, Value val, int d) {
		// изменение значения, связанного с ключом key в поддереве с корнем x
		if (x == null) {
			x = new Node();
		}
		if (d == key.length()) {
			x.val = val;
			return x;
		}
		char c = key.charAt(d); // Определение поддерева на основе d-ого символа
								// ключа key
		x.next[c] = put(x.next[c], key, val, d + 1);
		return x;
	}

}
