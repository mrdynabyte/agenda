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

	private AgendaMenu menu;
	
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
		menu			= new AgendaMenu();
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
		String path = new File("agenda/src/images").getAbsolutePath();
		ImageIcon icon = new ImageIcon(path+"/logo.jpg");
		JLabel label = new JLabel();

		leftContainer.setBounds(10, 10, 150, 572);
	   
		window.setSize(950, 650);
		window.setLocation(145, 100);
		window.setLocationRelativeTo(null);
		window.setResizable(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("Agenda Inc.");

		label.setIcon(icon);

		/* the globalContainer */
		globalContainer = new JPanel();
		globalContainer.setLayout(new BorderLayout());
		globalContainer.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.decode("#1098DA")));
		
		/* the northContainer */
		northContainer = new JPanel();
		northContainer.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.decode("#1098DA")));
		northContainer.setLocation(0, 100);
		northContainer.setBackground(Color.WHITE);
		northContainer.add(label);
		
		/*the leftContainer*/
		leftContainer 	= new JScrollPane(list);
		
		/*the rightContainer */
		rightContainer = this.container;
		rightContainer.setBorder(BorderFactory.createMatteBorder(0, 4, 0, 0, Color.decode("#1098DA")));
		
		globalContainer.add(rightContainer, BorderLayout.CENTER);
		globalContainer.add(northContainer, BorderLayout.NORTH);
		globalContainer.add(leftContainer, BorderLayout.WEST);
		
		window.setJMenuBar(menu.getMenu());
		window.setContentPane(globalContainer);
		window.setVisible(true);
   }

	private void configureEvents() {
		list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
				if(list.getSelectedValue() != null)
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
				list.setSelectedIndex(list.getComponentCount() - 1);
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
		
		menu.getEnglishMenu().addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent e) {
				updateLabelLanguage(menu.getLanguageProperties("en"));
			}
		});

		menu.getDeutschMenu().addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent e) {
				updateLabelLanguage(menu.getLanguageProperties("de"));
			}
		});

		menu.getFrenchMenu().addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent e) {
				updateLabelLanguage(menu.getLanguageProperties("fr"));	
			}
		});

		menu.getSpanishMenu().addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent e) {
				updateLabelLanguage(menu.getLanguageProperties("es"));	
			}
		});

		menu.getFileExit().addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		menu.getFileOpen().addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent e) {
				model.getFileManager().setToPreferenceFile();
				model.getFileManager().launchDirectoryChooser(false);
				list.setSelectedIndex(0);
				listModel.removeAllElements();
				populateContactsList();
			}
		});

		menu.getFileSaveAs().addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent e) {
				model.getFileManager().launchDirectoryChooser(true);
				list.setSelectedIndex(0);
				listModel.removeAllElements();
				populateContactsList();				
			}
		});		
	}
	
	private void updateLabelLanguage(String[] labels) {
		this.nameLabel.setText(labels[0]);
		this.surnameLabel.setText(labels[1]);
		this.homePhoneLabel.setText(labels[2]);
		this.officePhoneLabel.setText(labels[3]);
		this.cellPhoneLabel.setText(labels[4]);
		this.emailLabel.setText(labels[5]);
		this.addressLabel.setText(labels[6]);
		this.birthdayLabel.setText(labels[7]);

		this.add.setText(labels[8]);
		this.save.setText(labels[9]);
		this.delete.setText(labels[10]);
	}

	private void refresh() {
		leftContainer.repaint();
		window.repaint();
	}

}
