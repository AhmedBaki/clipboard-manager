package main;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class Controller {

	EntryStack stack;

	public Controller() {

		stack = new EntryStack();
		listen();
	}

	public void listen() {

		Thread clipboard = new Thread() {

			public void run() {

				while (true) {   //add a new entry if the clipboard has changed

					try {

						String data = (String) Toolkit.getDefaultToolkit()
								.getSystemClipboard()
								.getData(DataFlavor.stringFlavor);

						Entry x = new Entry(data);						
						
						if (!stack.contains(x)) {

							stack.push(x);

						}
					}

					catch (Exception e) {

						e.printStackTrace();

					}

				}

			}

		};

		Thread keyboard = new Thread() {

			public void run() {

				while (true) {

					// listen to keyboard even when not in focus

				}

			}

		};

		clipboard.start();
		keyboard.start();

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

	public static void main(String[] args) {
		Controller x = new Controller();
	}

}
