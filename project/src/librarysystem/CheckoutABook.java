package librarysystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Font;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import business.Book;
import business.BookCopy;
import business.CheckoutEntry;
import business.CheckoutException;
import business.ControllerInterface;
import business.SystemController;

import javax.swing.JTextField;
import java.awt.Color;

import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTable;

public class CheckoutABook extends JFrame implements LibWindow {
	private static final long serialVersionUID = 1L;
	public static final CheckoutABook INSTANCE = new CheckoutABook();
	
	private ControllerInterface ci = new SystemController();
	private int width = 0, height = 0;
	private boolean initialized = false;
	private JTextField txtMemberId;
	private JTextField txtIsbn;
	private JTable tableEntries;
	private DefaultTableCellRenderer centerRenderer;
	private DefaultTableCellRenderer leftRenderer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckoutABook frame = INSTANCE;
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private CheckoutABook() {
		setTitle("Checkout Book");
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		setResizable(false);
		init();
	}

	@Override
	public void init() {
		if (isInitialized()) {
			setSize(width, height);
			tableEntries.setModel(new CheckoutEntryTableModel());
			formatTable();
			txtMemberId.setText("");
			txtIsbn.setText("");
			return;
		}
		isInitialized(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		width = this.getWidth();
		height = this.getHeight();
		getContentPane().setLayout(null);
		
		JButton btnMain = new JButton("<== Back to Main");
//		btnMain.addActionListener(evt -> {
//			LibrarySystem.showUp(LibrarySystem.INSTANCE);
//	    });
		btnMain.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnMain.setBounds(10, 402, 143, 31);
		getContentPane().add(btnMain);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel.setBounds(10, 10, 606, 162);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Checkout Book");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(0, 0, 109, 17);
		panel.add(lblNewLabel);
		
		txtMemberId = new JTextField();
		txtMemberId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMemberId.setBounds(119, 52, 138, 19);
		panel.add(txtMemberId);
		txtMemberId.setColumns(10);
		
		txtIsbn = new JTextField();
		txtIsbn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtIsbn.setBounds(119, 97, 138, 19);
		panel.add(txtIsbn);
		txtIsbn.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Member ID");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(31, 52, 78, 17);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("ISBN");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(31, 97, 78, 17);
		panel.add(lblNewLabel_1_1);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(evt -> {
			clearForm();
			txtMemberId.grabFocus();
	    });
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnClear.setBounds(389, 46, 109, 31);
		panel.add(btnClear);
		
		JButton btnCheckout = new JButton("Checkout");
		btnCheckout.addActionListener(evt -> {
			checkoutBook();
			txtIsbn.grabFocus();
	    });
		btnCheckout.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCheckout.setBounds(389, 91, 109, 31);
		panel.add(btnCheckout);
		
		Border border = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        centerRenderer.setBorder(border);
        leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(JLabel.LEFT);
        leftRenderer.setBorder(border);

		tableEntries = new JTable();
		JScrollPane scrollPane = new JScrollPane(tableEntries);
		scrollPane.setBounds(10, 170, 606, 222);
		getContentPane().add(scrollPane);
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}

	@Override
	public void isInitialized(boolean val) {
		initialized = val;
	}
	
	private void clearForm() {
		txtMemberId.setText("");
		txtIsbn.setText("");
	}
	
	private void checkoutBook() {
		try {
			ci.checkoutBook(txtMemberId.getText().trim(), txtIsbn.getText().trim(), LocalDate.now());
		}
		catch (CheckoutException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
		
		Iterable<CheckoutEntry> entries = ci.getCheckoutEntry(txtMemberId.getText().trim());
		CheckoutEntryTableModel tableModel = new CheckoutEntryTableModel(entries);
		tableEntries.setModel(tableModel);
		formatTable();
	}
	
	private void formatTable() {
        tableEntries.getColumnModel().getColumn(0).setCellRenderer(leftRenderer);
        tableEntries.getColumnModel().getColumn(1).setCellRenderer(leftRenderer);
        tableEntries.getColumnModel().getColumn(2).setCellRenderer(leftRenderer);
        tableEntries.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tableEntries.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
	}
	
	private class CheckoutEntryTableModel extends AbstractTableModel {
		private static final long serialVersionUID = -5597046908706605837L;
		private static String[] columnNames = { "Copy Num", "ISBN", "Book Name", "Check Out Date", "Due Date" };
		
		private List<CheckoutEntry> entries;
		
		CheckoutEntryTableModel() {
			entries = new ArrayList<CheckoutEntry>();
		}
		
		CheckoutEntryTableModel(Iterable<CheckoutEntry> entries) {
			this();
			for (CheckoutEntry checkoutEntry : entries) {
				this.entries.add(checkoutEntry);
			}
		}

		@Override
		public int getRowCount() {
			return entries.size();
		}

		@Override
		public int getColumnCount() {
			return columnNames.length;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			CheckoutEntry entry = this.entries.get(rowIndex);
			BookCopy bookCopy = entry.getBookCopy();
			Book book = bookCopy.getBook();
			switch (columnIndex) {
			case 0:
				return bookCopy.getCopyNum();
			case 1:
				return book.getIsbn();
			case 2:
				return book.getTitle();
			case 3:
				return entry.getCheckoutDate();
			case 4:
				return entry.getDueDate();
			default:
				return null;
			}
		}
		
		@Override
		public String getColumnName(int column) {
            return columnNames[column];
        }
	}
}
