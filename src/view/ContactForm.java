package view;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Contact;

public class ContactForm {
	
	protected JTextField name;
	protected JTextField surname;
	protected JTextField homePhone;
	protected JTextField cellPhone;
	protected JTextField officePhone;
	protected JTextField email;
	protected JTextField address;
	protected JTextField birthday;

	protected JLabel nameLabel;
	protected JLabel surnameLabel;
	protected JLabel homePhoneLabel;
	protected JLabel cellPhoneLabel;
	protected JLabel officePhoneLabel;
	protected JLabel emailLabel;
	protected JLabel addressLabel;
	protected JLabel birthdayLabel;

	protected JButton save;
	protected JButton delete;
	protected JButton clear;

	protected JPanel container;
	
	public ContactForm() {
		name 		= new JTextField();
		surname 	= new JTextField();
		homePhone 	= new JTextField();
		cellPhone 	= new JTextField();
		officePhone = new JTextField();
		email 		= new JTextField();
		address 	= new JTextField();
		birthday 	= new JTextField();

		nameLabel 			= new JLabel("Name");
		surnameLabel 		= new JLabel("Surname");
		homePhoneLabel 		= new JLabel("Home");
		cellPhoneLabel 		= new JLabel("Cellphone");
		officePhoneLabel 	= new JLabel("Office");
		emailLabel 			= new JLabel("Email");
		addressLabel 		= new JLabel("Address");
		birthdayLabel 		= new JLabel("Birthday");


		save = new JButton("Save");
		delete = new JButton("Delete");
		clear = new JButton("Clear fields");
		
		configElements();
	}

	public JPanel getForm() {
		return this.container;
	}

	public void setValues(Contact contact) {
		name.setText(contact.getName());
		surname.setText(contact.getSurname());
		homePhone.setText(contact.getHomePhone());
		officePhone.setText(contact.getOfficePhone());
		cellPhone.setText(contact.getCellPhone());
		email.setText(contact.getEmail());
		address.setText(contact.getAddress());
		birthday.setText(contact.getBirthday());

		refresh();
	}

	private void configElements() {
		nameLabel.setBounds(40, 50, 127, 25);
		name.setBounds(97, 50, 127, 25);
		
		surnameLabel.setBounds(350, 50, 127, 25);
		surname.setBounds(420, 50, 127, 25);

		homePhoneLabel.setBounds(40, 100, 127, 25);
		homePhone.setBounds(97, 100, 127, 25);

		cellPhoneLabel.setBounds(350, 100, 127, 25);
		cellPhone.setBounds(420, 100, 127, 25);

		
		officePhoneLabel.setBounds(40, 150, 127, 25);
		officePhone.setBounds(97, 150, 127, 25);

		emailLabel.setBounds(350, 150, 127, 25);
		email.setBounds(420, 150, 127, 25);
		
		addressLabel.setBounds(40, 200, 127, 25);
		address.setBounds(97, 200, 127, 25);
		
		birthdayLabel.setBounds(350, 200, 127, 25);
		birthday.setBounds(420, 200, 127, 25);

		save.setBounds(150, 350, 150, 40);
		delete.setBounds(350, 350, 150, 40);
		
		clear.setBounds(275, 450, 100, 25);
				
		container = new JPanel();
		container.setBounds(240, 10, 640, 570);
		container.setBackground(Color.decode("#FFFEDF"));
		container.add(name);
		container.add(surname);
		container.add(homePhone);
		container.add(cellPhone);
		container.add(officePhone);
		container.add(email);
		container.add(address);
		container.add(birthday);

		container.add(nameLabel);
		container.add(surnameLabel);
		container.add(homePhoneLabel);
		container.add(cellPhoneLabel);
		container.add(officePhoneLabel);
		container.add(emailLabel);
		container.add(addressLabel);
		container.add(birthdayLabel);

		container.add(save);
		container.add(delete);
		container.add(clear);


		clear.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				clearFields();
			}
		});

		container.setLayout(new BorderLayout());		
	}

	public void clearFields() {
		name.setText("");
		surname.setText("");
		homePhone.setText("");
		officePhone.setText("");
		cellPhone.setText("");
		email.setText("");
		address.setText("");
		birthday.setText("");		
	}

	private void refresh() {
		container.repaint();
	}	
}
