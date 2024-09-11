package librarysystem;

import business.Address;
import business.Author;
import business.Book;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JButton;

public class AddBookWindow {

	private JFrame frame;
	private JTextField isbn;
	private JTextField title;
	private JTextField maxoutLength;
	private JTextField copyNum;
	private JTextField authorStreetAddress;
	private JLabel authorZip;
	private JTextField textField;
	private JLabel lblAuthorFirstName;
	private JLabel lblAuthorLastName;
	private JLabel lblAuthorTelephone;
	private JTextField authorFirstName;
	private JTextField authorLastName;
	private JTextField authorTelephone;
	private JLabel lblAuthorBio;
	private JTextField authorBio;
	private JLabel lblAuthorCityaddress;
	private JTextField authorCityAddress;
	private JLabel lblAuthorStateAddress;
	private JTextField authorStateAddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBookWindow window = new AddBookWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddBookWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 762, 634);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		isbn = new JTextField();
		isbn.setBounds(78, 85, 96, 20);
		frame.getContentPane().add(isbn);
		isbn.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ISBN");
		lblNewLabel.setBounds(78, 49, 49, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(78, 140, 49, 14);
		frame.getContentPane().add(lblTitle);
		
		title = new JTextField();
		title.setColumns(10);
		title.setBounds(78, 165, 96, 20);
		frame.getContentPane().add(title);
		
		JLabel lblMaxOutLength = new JLabel("Max out length");
		lblMaxOutLength.setBounds(285, 49, 133, 14);
		frame.getContentPane().add(lblMaxOutLength);
		
		maxoutLength = new JTextField();
		maxoutLength.setColumns(10);
		maxoutLength.setBounds(287, 85, 96, 20);
		frame.getContentPane().add(maxoutLength);
		
		JButton addNewBook = new JButton("Add new book");
		addNewBook.setBounds(313, 467, 152, 23);
		frame.getContentPane().add(addNewBook);
		
		JLabel lblNumberOfCopy = new JLabel("Number of copy");
		lblNumberOfCopy.setBounds(460, 49, 133, 14);
		frame.getContentPane().add(lblNumberOfCopy);
		
		copyNum = new JTextField();
		copyNum.setColumns(10);
		copyNum.setBounds(460, 85, 96, 20);
		frame.getContentPane().add(copyNum);
		
		JLabel label = new JLabel("Author Street Address");
		label.setBounds(249, 278, 119, 14);
		frame.getContentPane().add(label);
		
		authorStreetAddress = new JTextField();
		authorStreetAddress.setColumns(10);
		authorStreetAddress.setBounds(249, 303, 96, 20);
		frame.getContentPane().add(authorStreetAddress);
		
		authorZip = new JLabel("Author Zip");
		authorZip.setBounds(76, 356, 119, 14);
		frame.getContentPane().add(authorZip);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(68, 381, 96, 20);
		frame.getContentPane().add(textField);
		
		lblAuthorFirstName = new JLabel("Author First name");
		lblAuthorFirstName.setBounds(231, 140, 119, 14);
		frame.getContentPane().add(lblAuthorFirstName);
		
		lblAuthorLastName = new JLabel("Author last name");
		lblAuthorLastName.setBounds(392, 140, 119, 14);
		frame.getContentPane().add(lblAuthorLastName);
		
		lblAuthorTelephone = new JLabel("Author telephone");
		lblAuthorTelephone.setBounds(544, 140, 119, 14);
		frame.getContentPane().add(lblAuthorTelephone);
		
		authorFirstName = new JTextField();
		authorFirstName.setColumns(10);
		authorFirstName.setBounds(231, 165, 96, 20);
		frame.getContentPane().add(authorFirstName);
		
		authorLastName = new JTextField();
		authorLastName.setColumns(10);
		authorLastName.setBounds(388, 165, 96, 20);
		frame.getContentPane().add(authorLastName);
		
		authorTelephone = new JTextField();
		authorTelephone.setColumns(10);
		authorTelephone.setBounds(537, 165, 96, 20);
		frame.getContentPane().add(authorTelephone);
		
		lblAuthorBio = new JLabel("Author bio");
		lblAuthorBio.setBounds(68, 278, 119, 14);
		frame.getContentPane().add(lblAuthorBio);
		
		authorBio = new JTextField();
		authorBio.setColumns(10);
		authorBio.setBounds(65, 303, 96, 20);
		frame.getContentPane().add(authorBio);
		
		lblAuthorCityaddress = new JLabel("Author City Address");
		lblAuthorCityaddress.setBounds(378, 278, 119, 14);
		frame.getContentPane().add(lblAuthorCityaddress);
		
		authorCityAddress = new JTextField();
		authorCityAddress.setColumns(10);
		authorCityAddress.setBounds(378, 303, 96, 20);
		frame.getContentPane().add(authorCityAddress);
		
		lblAuthorStateAddress = new JLabel("Author State Address");
		lblAuthorStateAddress.setBounds(526, 278, 119, 14);
		frame.getContentPane().add(lblAuthorStateAddress);
		
		authorStateAddress = new JTextField();
		authorStateAddress.setColumns(10);
		authorStateAddress.setBounds(526, 303, 96, 20);
		frame.getContentPane().add(authorStateAddress);


		// Create new book when addNewBook button is clicked
		addNewBook.addActionListener(evt -> {
			System.out.println("Add new book button clicked");
			// create address
			Address address = new Address(authorStreetAddress.getText(), authorCityAddress.getText(), authorStateAddress.getText(), textField.getText());

			// create author
			Author author = new Author(authorFirstName.getText(), authorLastName.getText(), authorTelephone.getText(), address, authorBio.getText());

			// create book
			Book book = new Book(isbn.getText(), title.getText(), Integer.parseInt(maxoutLength.getText()), Integer.parseInt(copyNum.getText()), List.copyOf(List.of(author)));

			// save book to database
			DataAccess da = new DataAccessFacade();
			da.saveNewBook(book);

			// clear all fields
			isbn.setText("");
			title.setText("");
			maxoutLength.setText("");
			copyNum.setText("");
			authorStreetAddress.setText("");
			textField.setText("");
			authorFirstName.setText("");
			authorLastName.setText("");
			authorTelephone.setText("");
			authorBio.setText("");
			authorCityAddress.setText("");
			authorStateAddress.setText("");

		});

	}

}
