package main;

import java.time.LocalDateTime;


public class Entry{
	
	String contents;
	String source;
	String time;
	
	public Entry(String data, String src){
		
		contents = data;
		source = src;
		time = "" + LocalDateTime.now();
		
	}
	
	public static void main(String[] args) {
		
		Entry x = new Entry("!23", "1232");
		System.out.println(x.time);
		
	}
	
}
