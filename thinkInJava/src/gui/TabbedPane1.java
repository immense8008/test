package gui;

	//: gui/TabbedPane1.java
	// Demonstrates the Tabbed Pane.
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import util.SwingConsole;

public class TabbedPane1 extends JFrame {
	private static final long serialVersionUID = 1388773810681146407L;
	private String[] flavors = { "Chocolate", "Strawberry",
			"Vanilla Fudge Swirl", "Mint Chip", "Mocha Almond Fudge",
			"Rum Raisin", "Praline Cream", "Mud Pie" };
	private JTabbedPane tabs = new JTabbedPane();
	private JTextField txt = new JTextField(20);

	public TabbedPane1() {
		int i = 0;
		for (@SuppressWarnings("unused") String flavor : flavors)
			tabs.addTab(flavors[i], new JButton("Tabbed pane " + i++));
		tabs.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				txt.setText("Tab selected: " + tabs.getSelectedIndex());
			}
		});
		add(tabs);
		add(BorderLayout.SOUTH, txt);
	}

	public static void main(String[] args) {
		SwingConsole.run(new TabbedPane1(), 400, 250);
	}
} ///:~
