package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import model.ContactModel;
import model.Contact;

public class Agenda extends ContactForm{
	private JFrame window;
	private JPanel globalContainer;
	private JList<Contact> list;
	private JScrollPane leftContainer;
	private DefaultListModel<Contact> listModel;
	private ContactModel model;
	private boolean newContact;
	
	/*right container*/
	private JPanel rightContainer;
	
	/* north container */
	private JPanel northContainer;

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
		window.setLocationRelativeTo(null);
		window.setResizable(true);
		//window.setLayout(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("Agenda Inc.");
		//window.getContentPane().setBackground(Color.decode("#3E4147"));

		/* the globalContainer */
		globalContainer = new JPanel();
		globalContainer.setLayout(new BorderLayout());
		globalContainer.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.decode("#1098DA")));
		
		/* the northContainer */
		northContainer = new JPanel();
		northContainer.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.decode("#1098DA")));
		
		String path = new File("agenda/src/images").getAbsolutePath();
		ImageIcon icon = new ImageIcon(path+"/logo.jpg");
		JLabel label = new JLabel();
		
		label.setIcon(icon);
		northContainer.add(label);
		northContainer.setBackground(Color.WHITE);
		globalContainer.add(northContainer, BorderLayout.NORTH);
		
		/*the leftContainer*/
		leftContainer 	= new JScrollPane(list);
		globalContainer.add(leftContainer, BorderLayout.WEST);
		
		/*the rightContainer */
		rightContainer = this.container;
		rightContainer.setBorder(BorderFactory.createMatteBorder(0, 4, 0, 0, Color.decode("#1098DA")));
		
		globalContainer.add(rightContainer, BorderLayout.CENTER);

		window.setContentPane(globalContainer);

		window.setVisible(true);
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
				Random random = new Random(System.currentTimeMillis());
				Contact contact;

				if( newContact ) {
					contact = new Contact();
					contact.setKey(String.valueOf(random.nextInt()));
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

		delete.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Contact contact = list.getSelectedValue();
				model.deleteContact(contact);
				list.setSelectedIndex(0);
				listModel.removeElement(contact);
			}
		});

		add.addActionListener(new ActionListener(){
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
