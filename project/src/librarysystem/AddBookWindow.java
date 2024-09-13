package librarysystem;

import business.Address;
import business.Author;
import business.SystemController;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class AddBookWindow extends JFrame implements LibWindow {

	public static final AddBookWindow INSTANCE = new AddBookWindow();
	JFrame frame;
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
	private ArrayList<Author> authors;
	private JLabel lblAuthors;
	private JScrollPane authorsDisplay;
	private final SystemController controller = new SystemController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBookWindow window = INSTANCE;
					window.setVisible(true);
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
		setTitle("Add Book");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = this;

		this.authors = new ArrayList<>();

		// Add "Add Author" button
		JButton addAuthorBtn = new JButton("Add Author");
		addAuthorBtn.setBounds(718, 350, 150, 25);
		frame.getContentPane().add(addAuthorBtn);


		frame.setBounds(100, 100, 1115, 735);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		isbn = new JTextField();
		isbn.setBounds(78, 74, 96, 20);
		frame.getContentPane().add(isbn);
		isbn.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ISBN");
		lblNewLabel.setBounds(78, 49, 49, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(439, 49, 49, 14);
		frame.getContentPane().add(lblTitle);
		
		title = new JTextField();
		title.setColumns(10);
		title.setBounds(439, 74, 96, 20);
		frame.getContentPane().add(title);
		
		JLabel lblMaxOutLength = new JLabel("Max out length");
		lblMaxOutLength.setBounds(197, 49, 133, 14);
		frame.getContentPane().add(lblMaxOutLength);
		
		maxoutLength = new JTextField();
		maxoutLength.setColumns(10);
		maxoutLength.setBounds(197, 74, 96, 20);
		frame.getContentPane().add(maxoutLength);
		
		JButton addNewBook = new JButton("Add new book");
		addNewBook.setBounds(583, 73, 152, 23);
		frame.getContentPane().add(addNewBook);
		
		JLabel lblNumberOfCopy = new JLabel("Number of copy");
		lblNumberOfCopy.setBounds(321, 49, 133, 14);
		frame.getContentPane().add(lblNumberOfCopy);
		
		copyNum = new JTextField();
		copyNum.setColumns(10);
		copyNum.setBounds(320, 74, 96, 20);
		frame.getContentPane().add(copyNum);
		
		JLabel label = new JLabel("Author Street Address");
		label.setBounds(249, 327, 119, 14);
		frame.getContentPane().add(label);
		
		authorStreetAddress = new JTextField();
		authorStreetAddress.setColumns(10);
		authorStreetAddress.setBounds(249, 352, 96, 20);
		frame.getContentPane().add(authorStreetAddress);
		
		authorZip = new JLabel("Author Zip");
		authorZip.setBounds(784, 271, 119, 14);
		frame.getContentPane().add(authorZip);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(784, 296, 96, 20);
		frame.getContentPane().add(textField);
		
		lblAuthorFirstName = new JLabel("Author First name");
		lblAuthorFirstName.setBounds(249, 271, 119, 14);
		frame.getContentPane().add(lblAuthorFirstName);
		
		lblAuthorLastName = new JLabel("Author last name");
		lblAuthorLastName.setBounds(378, 271, 119, 14);
		frame.getContentPane().add(lblAuthorLastName);
		
		lblAuthorTelephone = new JLabel("Author telephone");
		lblAuthorTelephone.setBounds(526, 271, 119, 14);
		frame.getContentPane().add(lblAuthorTelephone);
		
		authorFirstName = new JTextField();
		authorFirstName.setColumns(10);
		authorFirstName.setBounds(249, 296, 96, 20);
		frame.getContentPane().add(authorFirstName);
		
		authorLastName = new JTextField();
		authorLastName.setColumns(10);
		authorLastName.setBounds(378, 296, 96, 20);
		frame.getContentPane().add(authorLastName);
		
		authorTelephone = new JTextField();
		authorTelephone.setColumns(10);
		authorTelephone.setBounds(526, 296, 96, 20);
		frame.getContentPane().add(authorTelephone);
		
		lblAuthorBio = new JLabel("Author bio");
		lblAuthorBio.setBounds(655, 271, 119, 14);
		frame.getContentPane().add(lblAuthorBio);
		
		authorBio = new JTextField();
		authorBio.setColumns(10);
		authorBio.setBounds(655, 296, 96, 20);
		frame.getContentPane().add(authorBio);
		
		lblAuthorCityaddress = new JLabel("Author City Address");
		lblAuthorCityaddress.setBounds(378, 327, 119, 14);
		frame.getContentPane().add(lblAuthorCityaddress);
		
		authorCityAddress = new JTextField();
		authorCityAddress.setColumns(10);
		authorCityAddress.setBounds(378, 352, 96, 20);
		frame.getContentPane().add(authorCityAddress);
		
		lblAuthorStateAddress = new JLabel("Author State Address");
		lblAuthorStateAddress.setBounds(526, 327, 119, 14);
		frame.getContentPane().add(lblAuthorStateAddress);
		
		authorStateAddress = new JTextField();
		authorStateAddress.setColumns(10);
		authorStateAddress.setBounds(526, 352, 96, 20);
		frame.getContentPane().add(authorStateAddress);

		authorsDisplay = new JScrollPane();
		authorsDisplay.setBounds(76, 140, 941, 94);
		frame.getContentPane().add(authorsDisplay);

		JButton btnBackToMain = new JButton("Back to Main");
		btnBackToMain.setBounds(272, 496, 150, 25);
		frame.getContentPane().add(btnBackToMain);

		displayAuthors();

		btnBackToMain.addActionListener(evt -> {
			//AddBookWindow.INSTANCE.frame.setVisible(false);
			//LibrarySystem.INSTANCE.setVisible(true);
			LibrarySystem.showUp(LibrarySystem.INSTANCE);
		});
		// Create new book when addNewBook button is clicked
		addNewBook.addActionListener(evt -> {
			if (!validateAddBook()) {
				return;
			}
			extractAndSaveBook();
			clearData();
		});

		addAuthorBtn.addActionListener(evt -> {
			if (!validateAddAuthor()) {
				return;
			}
			addAuthor();
			displayAuthors();
			clearAuthorFields();
		});
	}

	private boolean validateAddAuthor() {
		if (authorStreetAddress.getText().isEmpty() || textField.getText().isEmpty() || authorFirstName.getText().isEmpty() || authorLastName.getText().isEmpty() || authorTelephone.getText().isEmpty() || authorBio.getText().isEmpty() || authorCityAddress.getText().isEmpty() || authorStateAddress.getText().isEmpty()) {
			JOptionPane.showMessageDialog(frame, "Please fill out all fields");
			return false;
		}

		// zip must be a number and 5 digits
		if (!textField.getText().matches("[0-9]+") || textField.getText().length() != 5) {
			JOptionPane.showMessageDialog(frame, "Zip must be a 5 digit number");
			return false;
		}
		// phone must be number and 9 digits
		if (!authorTelephone.getText().matches("[0-9]+") || authorTelephone.getText().length() != 9) {
			JOptionPane.showMessageDialog(frame, "Phone must be a 9 digit number");
			return false;
		}


		return true;
	}

	private boolean validateAddBook() {
		if (this.controller.findBookId(isbn.getText())) {
			JOptionPane.showMessageDialog(frame, "Book with ISBN " + isbn.getText() + " already exists");
			return false;
		}
		if (isbn.getText().isEmpty() || title.getText().isEmpty() || maxoutLength.getText().isEmpty() || copyNum.getText().isEmpty()) {
			JOptionPane.showMessageDialog(frame, "Please fill out all fields");
			return false;
		}

		// authors must be added
		if (authors.isEmpty()) {
			JOptionPane.showMessageDialog(frame, "Please add at least one author");
			return false;
		}

		// maxOutLength and copyNum must be a number
		if (!maxoutLength.getText().matches("[0-9]+") || !copyNum.getText().matches("[0-9]+")) {
			JOptionPane.showMessageDialog(frame, "Max out length and number of copies must be a number");
			return false;
		}

		// maxOutLength is 7 or 21 only
		if (!maxoutLength.getText().equals("7") && !maxoutLength.getText().equals("21")) {
			JOptionPane.showMessageDialog(frame, "Max out length must be 7 or 21");
			return false;
		}
		return true;
	}

	private void clearAuthorFields() {
		authorStreetAddress.setText("");
		textField.setText("");
		authorFirstName.setText("");
		authorLastName.setText("");
		authorTelephone.setText("");
		authorBio.setText("");
		authorCityAddress.setText("");
		authorStateAddress.setText("");
	}

	private void addAuthor() {
		System.out.println("Add author button clicked");
		// create address
		Address address = new Address(authorStreetAddress.getText(), authorCityAddress.getText(), authorStateAddress.getText(), textField.getText());
		// create author
		Author author = new Author(authorFirstName.getText(), authorLastName.getText(), authorTelephone.getText(), address, authorBio.getText());
		authors.add(author);
	}

	private void extractAndSaveBook() {
		DataAccess da = new DataAccessFacade();
		int maxoutLengthText = Integer.parseInt(maxoutLength.getText());
		int copyNumText = Integer.parseInt(copyNum.getText());
		// create book
		String isbnText = isbn.getText();
		String titleText = title.getText();

		this.controller.saveBook(isbnText, titleText, maxoutLengthText, copyNumText, authors);
	}

	private void clearData() {
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

		lblAuthors = new JLabel("Authors");
		lblAuthors.setBounds(249, 115, 119, 14);
		frame.getContentPane().add(lblAuthors);
		this.authors = new ArrayList<>();
		displayAuthors();
	}

	private void displayAuthors() {
		String[] columnNames = {"First Name", "Last Name", "Telephone", "Street Address", "City", "State", "Zip", "Bio"};

		// Create a table model and set column names
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

		// Populate the table model with book data
		for (Author author : authors) {
			String[] data = {author.getFirstName(), author.getLastName(), author.getTelephone(), author.getAddress().getStreet(), author.getAddress().getCity(), author.getAddress().getState(), author.getAddress().getZip(), author.getBio()};
			tableModel.addRow(data);
		}
		authorsDisplay.setViewportView(new JTable(tableModel));
	}

	@Override
	public void init() {
		//frame.setVisible(true);


	}

	@Override
	public boolean isInitialized() {
		return false;
	}

	@Override
	public void isInitialized(boolean val) {

	}
}
