package view;

import java.awt.Color;

import javax.swing.*;
import javax.swing.event.*;

import model.ContactModel;

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

		 list.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent arg0) {
				String[] tokens = list.getSelectedValue().toString().split(" ");
				contactForm.setValues(ContactModel.getContact(tokens[0], tokens[1]));
			}
        });
		 
		 addElements();

		 window.setVisible(true);

	}
	
	public void populateContactsList(String[] contacts) {

		for(int i = 0; i < contacts.length; i++) {
			 listModel.addElement(contacts[i]);
		 }

		//change font size
		 list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         list.setSelectedIndex(0);
		 list.setVisibleRowCount(10);
		 
		 refresh();
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
