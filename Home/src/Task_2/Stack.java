package Task_2;

public class Stack<T> {

	int item = 0;
	Object[] stackArray;

	@SuppressWarnings("unchecked")
	public Stack(int sizeArray) {
		stackArray = new Object[sizeArray];
	}

	public Object top() {
		if (isEmpty()) {
			return null;
		}
		return stackArray[item - 1];
	}

	public Object pop() {
		if (isEmpty()) {
			return null;
		}
		return stackArray[--item];
	}


	public void push(Object _item) throws StackOverflow {
		if (size() == stackArray.length) {
			throw new StackOverflow();
		} else {
			stackArray[item++] = _item;
		}
	}

	private boolean isEmpty() {
		return size() == 0;
	}

	private int size() {
		return item;
	}

	public static void main(String[] args) {

		Stack<String> stack = new Stack<>(20);
		try {
			stack.push("one");
			stack.push("two");
			stack.push("three");
		} catch (StackOverflow e) {
			e.printStackTrace();
		}

		while (stack.top() != null) {
			System.out.println(stack.pop());
		}
	}
}
