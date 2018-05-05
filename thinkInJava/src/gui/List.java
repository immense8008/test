package gui;

//: gui/List.java
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import util.SwingConsole;

public class List extends JFrame {
	private static final long serialVersionUID = -6762264750245946779L;
	private String[] flavors = { "Chocolate", "Strawberry",
			"Vanilla Fudge Swirl", "Mint Chip", "Mocha Almond Fudge",
			"Rum Raisin", "Praline Cream", "Mud Pie" };
	private DefaultListModel lItems = new DefaultListModel();
	private JList lst = new JList(lItems);
	private JTextArea t = new JTextArea(flavors.length, 20);
	private JButton b = new JButton("Add Item");
	private JButton delButton = new JButton("Del Item");
	private ActionListener al = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (count < flavors.length) {
				lItems.add(0, flavors[count++]);
			} else {
				// Disable, since there are no more
				// flavors left to be added to the List
				b.setEnabled(false);
			}
		}
	};
	private ActionListener al2 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (lst.isSelectionEmpty()) {
				// Disable, since there are no selected
				delButton.setEnabled(false);
			} else {
				for (Object item : lst.getSelectedValues())
					lItems.removeElement(item);
			}
		}
	};
	private ListSelectionListener ll = new ListSelectionListener() {
		public void valueChanged(ListSelectionEvent e) {
			if (e.getValueIsAdjusting())
				return;
			t.setText("");
			for (Object item : lst.getSelectedValues())
				t.append(item + "\n");
			if (!lst.isSelectionEmpty()) {
				// Disable, since there are no selected
				delButton.setEnabled(true);
			}
		}
	};
	private int count = 0;

	public List() {
		t.setEditable(false);
		setLayout(new GridLayout(4, 1));
		// Create Borders for components:
		Border brd = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK);
		lst.setBorder(brd);
		t.setBorder(brd);
		// Add the first four items to the List
		for (int i = 0; i < 4; i++)
			lItems.addElement(flavors[count++]);
		add(t);
		//add(lst);
		add(new JScrollPane(lst));
		add(b);
		add(delButton);
		// Register event listeners
		lst.addListSelectionListener(ll);
		b.addActionListener(al);
		delButton.addActionListener(al2);
	}

	public static void main(String[] args) {
		SwingConsole.run(new List(), 250, 375);
	}
} ///:~
