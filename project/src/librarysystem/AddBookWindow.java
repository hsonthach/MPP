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
	private ArrayList<Author> authors;
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
		addAuthorBtn.setBounds(161, 148, 150, 25);
		frame.getContentPane().add(addAuthorBtn);


		frame.setBounds(100, 100, 1115, 735);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		isbn = new JTextField();
		isbn.setBounds(66, 74, 96, 20);
		frame.getContentPane().add(isbn);
		isbn.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ISBN");
		lblNewLabel.setBounds(66, 49, 49, 14);
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
		addNewBook.setBounds(433, 339, 152, 23);
		frame.getContentPane().add(addNewBook);
		
		JLabel lblNumberOfCopy = new JLabel("Number of copy");
		lblNumberOfCopy.setBounds(321, 49, 133, 14);
		frame.getContentPane().add(lblNumberOfCopy);
		
		copyNum = new JTextField();
		copyNum.setColumns(10);
		copyNum.setBounds(320, 74, 96, 20);
		frame.getContentPane().add(copyNum);

		authorsDisplay = new JScrollPane();
		authorsDisplay.setBounds(66, 205, 941, 94);
		frame.getContentPane().add(authorsDisplay);

		JButton btnBackToMain = new JButton("Back to Main");
		btnBackToMain.setBounds(66, 614, 150, 25);
		frame.getContentPane().add(btnBackToMain);
		
		JLabel lblNewLabel_1 = new JLabel("Authors");
		lblNewLabel_1.setBounds(66, 153, 49, 14);
		getContentPane().add(lblNewLabel_1);

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
			// show success message
			JOptionPane.showMessageDialog(frame, "Book added successfully");
		});

		// Inside the initialize() method of AddBookWindow
		addAuthorBtn.addActionListener(evt -> {
			AddAuthorWindow addAuthorWindow = new AddAuthorWindow(authors);
			addAuthorWindow.setVisible(true);
			// when add author window is closed, update authors list
			addAuthorWindow.addWindowListener(new java.awt.event.WindowAdapter() {
				@Override
				public void windowClosed(java.awt.event.WindowEvent windowEvent) {
					displayAuthors();
				}
			});
		});
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
