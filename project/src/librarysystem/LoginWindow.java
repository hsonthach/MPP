package librarysystem;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import business.LoginException;
import business.SystemController;
import dataaccess.Auth;
import dataaccess.User;

public class LoginWindow extends JFrame implements LibWindow{

    public static final LoginWindow INSTANCE = new LoginWindow();
    private static final long serialVersionUID = 1L;

    // Instance variables
    private int width = 300, height = 200;
    private boolean initialized = false;

    private JPasswordField passwordField;
    private JTextField textField;

    private SystemController controller = new SystemController();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginWindow frame = INSTANCE;
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    private LoginWindow() {
        setTitle("Login");
        setResizable(false);
        init();
    }

    /**
     * Initialize the contents of the frame.
     */
    public void init() {
        if (isInitialized()) {
            setSize(width, height);
            return;
        }
        isInitialized(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 240);
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Username");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(10, 10, 102, 29);
        getContentPane().add(lblNewLabel);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblPassword.setBounds(219, 10, 102, 29);
        getContentPane().add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(219, 37, 150, 25);
        getContentPane().add(passwordField);

        JButton btnNewButton = new JButton("Login");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = textField.getText();
                String password = new String(passwordField.getPassword());

                // Perform authentication check
                User authenticatedUser = authenticate(username, password);

                if (authenticatedUser != null) {
                    // Successful login
                    JOptionPane.showMessageDialog(LoginWindow.this,
                            "Welcome, " + authenticatedUser.getId() + " (" + authenticatedUser.getAuthorization() + ")");
                    LibrarySystem.INSTANCE.enableMenuItemsForUser(authenticatedUser);
                } else {
                    // Failed login
                    JOptionPane.showMessageDialog(LoginWindow.this,
                            "Invalid username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton.setBounds(141, 84, 100, 30);
        getContentPane().add(btnNewButton);


        textField = new JTextField();
        textField.setBounds(10, 37, 150, 25);
        getContentPane().add(textField);
        textField.setColumns(10);
        
        JButton btnNewButton_1 = new JButton("Back to Main");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 LoginWindow.INSTANCE.setVisible(false);
                 LibrarySystem.INSTANCE.setVisible(true);
        	}
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton_1.setBounds(120, 144, 150, 30);
        getContentPane().add(btnNewButton_1);

//        JButton btnBackToMain = new JButton("Back to Main");
//        btnBackToMain.setBounds(272, 496, 150, 25);
//        frame.getContentPane().add(btnBackToMain);
//
//        btnBackToMain.addActionListener(evt -> {
//            AddBookWindow.INSTANCE.frame.setVisible(false);
//            LibrarySystem.INSTANCE.setVisible(true);
//        });
    }

    public boolean isInitialized() {
        return initialized;
    }

    public void isInitialized(boolean val) {
        initialized = val;
    }

    /**
     * Authenticate user by checking username and password.
     */
    private User authenticate(String username, String password)  {
        User user = this.controller.findUserByUsernameAndPassword(username, password);
        if (user != null) {
            return user; // Authentication successful
        }
        return null; // Authentication failed
    }
}
