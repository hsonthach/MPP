package librarysystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTextField;

public class CheckoutABook extends JFrame implements LibWindow {
	private static final long serialVersionUID = 1L;
	public static final CheckoutABook INSTANCE = new CheckoutABook();
	
	private int width = 0, height = 0;
	private boolean initialized = false;
	private JTextField textField;

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
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(68, 41, 85, 21);
		getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(57, 112, 96, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnMain = new JButton("<== Back to Main");
		btnMain.addActionListener(evt -> {
			LibrarySystem.showUp(LibrarySystem.INSTANCE);
	    });
		btnMain.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnMain.setBounds(10, 402, 143, 31);
		getContentPane().add(btnMain);
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}

	@Override
	public void isInitialized(boolean val) {
		initialized = val;
	}
}
