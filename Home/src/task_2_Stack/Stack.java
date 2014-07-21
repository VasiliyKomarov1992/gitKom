package task_2_Stack;

public class Stack<T> {

	int size = 0;
	Object[] stackArray;

	public Stack(int sizeArray) {
		stackArray = new Object[sizeArray];
	}

	public Object top() {
		if (isEmpty()) {
			return null;
		}
		return stackArray[size - 1];
	}

	public Object pop() {
		if (isEmpty()) {
			return null;
		}
		return stackArray[--size];
	}


	public void push(Object _size) throws StackOverflow {
		if (size() == stackArray.length) {
			throw new StackOverflow();
		} else {
			stackArray[size++] = _size;
		}
	}

	private boolean isEmpty() {
		return size() == 0;
	}

	private int size() {
		return size;
	}

	public static void main(String[] args) {

		Stack<String> stack = new Stack<>(20);
		try {
			stack.push("1");
			stack.push("2");
			stack.push("3");
			stack.push("3");
			stack.push("4");
			stack.push("4");
			stack.push("2");

		} catch (StackOverflow e) {
			e.printStackTrace();
		}

		System.out.println("The number of elements in the stack: " + stack.size());
		System.out.println("- - - - - - ");
		while (stack.top() != null) {
			System.out.println(stack.pop());
		}
	}
}
