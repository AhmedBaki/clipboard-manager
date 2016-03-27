package main;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;

public class Controller {

	EntryStack stack;
	ClipboardManager clipboardManager; 

	public Controller() {
		clipboardManager = new ClipboardManager(); 
		stack = new EntryStack();
		listen();
	}

	public void listen() {

		Thread clipboard = new Thread() {

			@Override
			public void run() {

				while (true) { // add a new entry if the clipboard has changed

					String data = getCurrentClipboard();

					if (!stack.getAllContent().contains(data)) {

						stack.push(new Entry(data));
						stack.addDataToContent(data); // add the raw data

					}

					else { // data exists in stack, move it to top

						for (int i = 0; i < stack.size(); i++) {

							if (((Entry) stack.get(i)).getContents().equals(
									data)) {

								stack.remove(i);
								stack.push(new Entry(data));

							}

						}
					}
				}

			}

		};

		Thread keyboard = new Thread() {

			@Override
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

	public void paste(String entryData) {

		clipboardManager.setClipboard(entryData); //transfer data into clipboard
		
		
		//code to perform a paste instruction 
		
	}

	public void clearStack() {

		stack = new EntryStack();

	}

	public static void main(String[] args) {
		Controller x = new Controller();
	}

}
