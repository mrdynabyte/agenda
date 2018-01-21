package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.ContainerOrderFocusTraversalPolicy;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ContactModel;
import model.Contact;

public class Agenda extends ContactForm{
	private JFrame window;
	private JList<Contact> list;
	private JScrollPane leftContainer;
	private DefaultListModel<Contact> listModel;
	private ContactModel model;
	private boolean newContact;

	public Agenda() {
		listModel  		= new DefaultListModel<Contact>();
		list 			= new JList<Contact>(listModel);
		leftContainer 	= new JScrollPane(list);
		window 			= new JFrame();
		model			= new ContactModel();

		configElements();
		configureEvents();
	};
	
	public void populateContactsList() {
		Contact [] contacts = model.getContactList();

		for(int i = 0; i < contacts.length; i++) {
			 listModel.addElement(contacts[i]);
		 }

		//change font size
		 list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         list.setSelectedIndex(0);
		 list.setVisibleRowCount(10);
		 refresh();
	}

	private void configElements() {
		leftContainer.setBounds(10, 10, 150, 572);
	   
		window.setSize(950, 650);
		window.setLocation(145, 100);
		window.setResizable(true);
		window.setLayout(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("Agenda Inc.");
		window.getContentPane().setBackground(Color.decode("#3E4147"));

		addElements();

		window.setVisible(true);
   }

	private void addElements() {
		window.add(leftContainer);
		window.add(this.container);
	}

	private void configureEvents() {
		list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
				setValues(list.getSelectedValue());
			}
		});

		save.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {

				System.out.println("Saving contact");

				Contact contact;

				if( newContact ) {
					contact = new Contact();
					contact.setKey(String.valueOf(model.getContactSize() + 1));
					listModel.addElement(contact);
				}
				else {
					contact = list.getSelectedValue();
				}

				contact.setName(name.getText());
				contact.setSurname(surname.getText());
				contact.setHomePhone(homePhone.getText());
				contact.setOfficePhone(officePhone.getText());
				contact.setCellPhone(cellPhone.getText());
				contact.setEmail(email.getText());
				contact.setBirthday(birthday.getText());
				contact.setAddress(address.getText());

				model.saveContact(contact);
				
				list.setSelectedIndex(listModel.getSize() - 1);
				
				newContact = false;

				refresh();
			}
		});

		clear.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				clearFields();
				newContact =  true;
			}
		});
			
	}
	
	private void refresh() {
		leftContainer.repaint();
		window.repaint();
	}

}
