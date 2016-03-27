package main;

import java.time.LocalDateTime;

public class Entry {

	String contents;
	String time;

	public Entry(String data) {

		contents = data;
		time = "" + LocalDateTime.now();

	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public static void main(String[] args) {

		Entry x = new Entry("123");
		System.out.println(x.time);

	}

}
