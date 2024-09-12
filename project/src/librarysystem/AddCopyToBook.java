package librarysystem;

import business.Book;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.EventQueue;
import java.util.Collection;

public class AddCopyToBook extends JFrame implements LibWindow {

	public static final AddCopyToBook INSTANCE = new AddCopyToBook();
	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCopyToBook window = new AddCopyToBook();
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
	public AddCopyToBook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 914, 697);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane booksDisplay = new JScrollPane();
		booksDisplay.setBounds(94, 283, 707, 320);
		frame.getContentPane().add(booksDisplay);


		// show all books to booksDisplay
		DataAccess da = new DataAccessFacade();

		displayBooks(da, booksDisplay);

		JLabel isbn = new JLabel("ISBN");
		isbn.setBounds(113, 115, 149, 44);
		frame.getContentPane().add(isbn);

		JButton addCopyBtn = new JButton("Add copy");
		addCopyBtn.setBounds(228, 150, 89, 23);
		frame.getContentPane().add(addCopyBtn);

		textField = new JTextField();
		textField.setBounds(113, 151, 96, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);


		JButton btnBackToMenu = new JButton("Back to menu");
		btnBackToMenu.setBounds(571, 122, 193, 37);
		frame.getContentPane().add(btnBackToMenu);

		btnBackToMenu.addActionListener(evt -> {
			AddCopyToBook.INSTANCE.setVisible(false);
			LibrarySystem.INSTANCE.setVisible(true);
		});

		addCopyBtn.addActionListener(evt -> {
			String isbnStr = textField.getText();
			if (isbnStr.isEmpty()) {
				JOptionPane.showMessageDialog(frame, "Please enter both ISBN and number of copies");
				return;
			}

			Book book = da.readBooksMap().get(isbnStr);
			if (book == null) {
				JOptionPane.showMessageDialog(frame, "Book with ISBN " + isbnStr + " not found");
				return;
			}

			book.addCopy();
			da.saveNewBook(book);

			JOptionPane.showMessageDialog(frame, "Added copy to book with ISBN " + isbnStr);
			displayBooks(da, booksDisplay);
		});


	}

	private static void displayBooks(DataAccess da, JScrollPane booksDisplay) {
		Collection<Book> books = da.readBooksMap().values();

		// Define column names for the table
		String[] columnNames = {"ISBN", "Title", "Max Checkout Length", "Number of Copies", "Authors"};

		// Create a table model and set column names
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

		// Populate the table model with book data
		for (Book book : books) {
			String authors = book.getAuthors().stream()
					.map(author -> author.getFirstName() + " " + author.getLastName())
					.reduce((a, b) -> a + ", " + b)
					.orElse("");
			Object[] rowData = {
					book.getIsbn(),
					book.getTitle(),
					book.getMaxCheckoutLength(),
					book.getNumCopies(),
					authors
			};
			tableModel.addRow(rowData);
		}

		JTable table = new JTable(tableModel);
		booksDisplay.setViewportView(table);
	}

	@Override
	public void init() {
		frame.setVisible(true);
	}

	@Override
	public boolean isInitialized() {
		return false;
	}

	@Override
	public void isInitialized(boolean val) {

	}
}
