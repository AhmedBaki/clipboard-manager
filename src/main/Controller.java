package main;

public class Controller {

	EntryStack stack;

	public Controller() {

		stack = new EntryStack();

	}

	public void listen() {

		Thread clipboard = new Thread();
		Thread keyboard = new Thread();

	}

	public void addToStack(Entry x) {

		stack.push(x);

	}

	public void removeFromStack(Entry x) {

		stack.remove(x);

	}

	public void paste() {

	}

	public void clearStack() {

		stack = new EntryStack();
	}

}
