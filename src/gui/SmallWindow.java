package gui;

import main.Entry;
import main.EntryStack;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class SmallWindow extends JFrame{

	public SmallWindow() {

		super();
		setSize(new Dimension(250, 430));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(10, 2));
		setFont(new Font("Calibri", Font.PLAIN, 20));
		setResizable(false);
	//	add(new JScrollBar());
		validate();
		setVisible(true);
		
	}

	public void addEntry(Entry x) {

		JPanel container = new JPanel();
		container.setLayout(new GridLayout(2, 1));
		container.setSize(250, 10);
		
		JTextArea toAdd = new JTextArea();
		toAdd.setEditable(false);
		toAdd.setSize(250, 70);
		toAdd.setText(x.getContents());
		toAdd.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.DARK_GRAY));
		toAdd.setToolTipText(x.getTime());

		container.add(toAdd);

		add(container);
		repaint();
		revalidate();

	}

	public static void main(String[] args) {

		Entry x = new Entry("test1");
		Entry y = new Entry("test2");
		EntryStack a = new EntryStack();
		a.add(x);
		a.add(y);

		SmallWindow b = new SmallWindow();

		for (int i = 0; i < a.size(); i++) {
			b.addEntry(x);
			b.addEntry(y);
		}

	}

}
