package main;

import java.time.LocalDateTime;

public class Entry {

	String contents;
	String time;

	public Entry(String data) {

		contents = data;
		time = "" + LocalDateTime.now();

	}

	public static void main(String[] args) {

		Entry x = new Entry("123");
		System.out.println(x.time);

	}

}
