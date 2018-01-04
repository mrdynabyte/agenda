package view;

import java.awt.Color;

import javax.swing.*;

public class Agenda {
	private JFrame window;
	private JList list;
	private JScrollPane leftContainer;
	private DefaultListModel listModel;
	private ContactForm contactForm;
	
	public Agenda() {
		
		 listModel  	= new DefaultListModel();
		 list 			= new JList<>(listModel);
		 leftContainer 	= new JScrollPane(list);
		 window 		= new JFrame();
		 contactForm	= new ContactForm();

		 configElements();
	};
	
	private void configElements() {
		 leftContainer.setBounds(10, 10, 150, 572);
		
		 window.setSize(950, 650);
		 window.setLocation(145, 100);
		 window.setResizable(true);
		 window.setLayout(null);
		 window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 window.setTitle("Agenda Inc.");
		 window.getContentPane().setBackground(Color.decode("#3E4147"));
		 
		 populateContactsList(null);
		 addElements();
		 
		 window.setVisible(true);

	}
	
	private void populateContactsList(String[] contacts) {

		 listModel.addElement("Element 1");
		 listModel.addElement("Element 2");
		 listModel.addElement("Element 3");
		

		//change font size
		 list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         list.setSelectedIndex(0);
         list.setVisibleRowCount(10);
	}
	
	private void addElements() {
		window.add(leftContainer);
		window.add(contactForm.getForm());
	}
	
	private void refresh() {
		leftContainer.repaint();
		window.repaint();
	}
}
