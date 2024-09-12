package librarysystem;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import dataaccess.Auth;
import dataaccess.User;

public class LoginWindow {

    private JFrame frame;
    private JPasswordField passwordField;
    private JTextField textField;

    // Hardcoded users for authentication purposes
    private User librarian = new User("librarian", "lib123", Auth.LIBRARIAN);
    private User admin = new User("admin", "admin123", Auth.ADMIN);
    private User both = new User("both", "both123", Auth.BOTH);

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginWindow window = new LoginWindow();
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
    public LoginWindow() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Library System Login");
        frame.setBounds(100, 100, 423, 179);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Username");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(10, 10, 102, 29);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblPassword.setBounds(219, 10, 102, 29);
        frame.getContentPane().add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(219, 37, 150, 25);
        frame.getContentPane().add(passwordField);

        JButton btnNewButton = new JButton("Login");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = textField.getText();
                String password = new String(passwordField.getPassword());

                // Perform authentication check
                User authenticatedUser = authenticate(username, password);

                if (authenticatedUser != null) {
                    // Successful login
                    JOptionPane.showMessageDialog(frame, "Welcome, " + authenticatedUser.getId() + " (" + authenticatedUser.getAuthorization() + ")");
                } else {
                    // Failed login
                    JOptionPane.showMessageDialog(frame, "Invalid username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton.setBounds(141, 84, 100, 30);
        frame.getContentPane().add(btnNewButton);

        textField = new JTextField();
        textField.setBounds(10, 37, 150, 25);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
    }

    /**
     * Authenticate user by checking username and password.
     */
    private User authenticate(String username, String password) {
        if (librarian.getId().equals(username) && librarian.getPassword().equals(password)) {
            return librarian;
        } else if (admin.getId().equals(username) && admin.getPassword().equals(password)) {
            return admin;
        } else if (both.getId().equals(username) && both.getPassword().equals(password)) {
            return both;
        }
        return null; // Authentication failed
    }
}
