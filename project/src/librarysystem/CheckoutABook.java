package librarysystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable;

public class CheckoutABook extends JFrame implements LibWindow {
	private static final long serialVersionUID = 1L;
	public static final CheckoutABook INSTANCE = new CheckoutABook();
	
	private int width = 0, height = 0;
	private boolean initialized = false;
	private JTextField txtMemberId;
	private JTextField txtIsbn;
	private JTable table;

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
			return;
		}
		isInitialized(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		width = this.getWidth();
		height = this.getHeight();
		getContentPane().setLayout(null);
		
		JButton btnMain = new JButton("<== Back to Main");
		btnMain.addActionListener(evt -> {
			LibrarySystem.showUp(LibrarySystem.INSTANCE);
	    });
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
			clearForm();
			txtMemberId.grabFocus();
	    });
		btnCheckout.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCheckout.setBounds(389, 91, 109, 31);
		panel.add(btnCheckout);
		
		table = new JTable();
		table.setBounds(10, 170, 606, 222);
		getContentPane().add(table);
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
	}
}
