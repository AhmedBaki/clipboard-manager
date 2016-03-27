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

				while (true) { // add a new entry if the clipboard has changed

					String data = getCurrentClipboard();

					if (!stack.getAllContent().contains(data)) {

						stack.push(new Entry(data));
						stack.addDataToContent(data); // add the raw data

					}

					else { // data exists in stack, move it to top

						for (int i = 0; i < stack.size(); i++) {

							if (((Entry) stack.get(i)).getContents().equals(data)) {

								stack.remove(i);
								stack.push(new Entry(data));

							}

						}
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

	@SuppressWarnings("unchecked")
	public void addToStack(Entry x) {

		stack.push(x);

	}

	public String getCurrentClipboard() {

		try {
			return (String) Toolkit.getDefaultToolkit().getSystemClipboard()
					.getData(DataFlavor.stringFlavor);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

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
