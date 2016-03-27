package main;

import java.util.ArrayList;
import java.util.Stack;

public class EntryStack extends Stack {

	ArrayList<String> allContent;

	public EntryStack() {

		super();
		allContent = new ArrayList<String>();

	}

	public void addDataToContent(String data) {
		allContent.add(data);
	}

	public ArrayList<String> getAllContent() {
		return allContent;
	}

	public EntryStack getStack() {

		return this;

	}

}
