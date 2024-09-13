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

public class AddLibraryMemberWindow extends JFrame implements LibWindow{

    public static final AddLibraryMemberWindow INSTANCE = new AddLibraryMemberWindow();
    private static final long serialVersionUID = 1L;

    // Instance variables
    private int width = 400, height = 240;
    private boolean initialized = false;

    private SystemController controller = new SystemController();
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddLibraryMemberWindow frame = INSTANCE;
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
    private AddLibraryMemberWindow() {
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
        setBounds(100, 100, 541, 294);
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Member ID");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(10, 10, 102, 29);
        getContentPane().add(lblNewLabel);

        JLabel lblPassword = new JLabel("First name");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblPassword.setBounds(121, 10, 102, 29);
        getContentPane().add(lblPassword);

        JButton btnNewButton = new JButton("Add");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 if (validateFields()) {
                     saveMemberData();
                     clearForm();
                 }
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton.setBounds(204, 164, 100, 30);
        getContentPane().add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Back to Main");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 AddLibraryMemberWindow.INSTANCE.setVisible(false);
                 LibrarySystem.INSTANCE.setVisible(true);
        	}
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton_1.setBounds(182, 205, 150, 30);
        getContentPane().add(btnNewButton_1);
        
        JLabel lblPassword_1 = new JLabel("Last name");
        lblPassword_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblPassword_1.setBounds(230, 10, 102, 29);
        getContentPane().add(lblPassword_1);
        
        JLabel lblPassword_1_1 = new JLabel("Street");
        lblPassword_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblPassword_1_1.setBounds(342, 10, 102, 29);
        getContentPane().add(lblPassword_1_1);
        
        textField = new JTextField();
        textField.setBounds(121, 41, 86, 20);
        getContentPane().add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setBounds(230, 41, 86, 20);
        getContentPane().add(textField_1);
        textField_1.setColumns(10);
        
        textField_2 = new JTextField();
        textField_2.setBounds(342, 41, 150, 20);
        getContentPane().add(textField_2);
        textField_2.setColumns(10);
        
        textField_3 = new JTextField();
        textField_3.setBounds(10, 41, 86, 20);
        getContentPane().add(textField_3);
        textField_3.setColumns(10);
        textField_3.setEditable(false);
        // Generate unique Member ID
        String memberId = generateUniqueMemberID();
        textField_3.setText(memberId);
        
        JLabel lblNewLabel_1 = new JLabel("City");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(10, 82, 46, 14);
        getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("ZIP Code");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1_1.setBounds(230, 82, 86, 14);
        getContentPane().add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("Phone Number");
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1_1_1.setBounds(342, 82, 102, 14);
        getContentPane().add(lblNewLabel_1_1_1);
        
        JLabel lblNewLabel_1_1_2 = new JLabel("State");
        lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1_1_2.setBounds(121, 84, 86, 14);
        getContentPane().add(lblNewLabel_1_1_2);
        
        textField_4 = new JTextField();
        textField_4.setBounds(10, 107, 86, 20);
        getContentPane().add(textField_4);
        textField_4.setColumns(10);
        
        textField_5 = new JTextField();
        textField_5.setBounds(121, 109, 86, 20);
        getContentPane().add(textField_5);
        textField_5.setColumns(10);
        
        textField_6 = new JTextField();
        textField_6.setBounds(230, 107, 86, 20);
        getContentPane().add(textField_6);
        textField_6.setColumns(10);
        
        textField_7 = new JTextField();
        textField_7.setBounds(342, 107, 150, 20);
        getContentPane().add(textField_7);
        textField_7.setColumns(10);
    }

    public boolean isInitialized() {
        return initialized;
    }

    public void isInitialized(boolean val) {
        initialized = val;
    }
    
    private boolean validateFields() {
        if (textField_3.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Member ID cannot be empty");
            return false;
        }
        if (textField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "First name cannot be empty");
            return false;
        }
        if (textField_1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Last name cannot be empty");
            return false;
        }
        if (textField_2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Street cannot be empty");
            return false;
        }
        if (textField_4.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "City cannot be empty");
            return false;
        }
        if (textField_5.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "State cannot be empty");
            return false;
        }
        // Validate ZIP Code
        String zipCode = textField_6.getText();
        if (zipCode.isEmpty()) {
            JOptionPane.showMessageDialog(this, "ZIP Code cannot be empty");
            return false;
        }
        if (!zipCode.matches("\\d{5}(-\\d{4})?")) {  // US ZIP Code format: XXXXX or XXXXX-XXXX
            JOptionPane.showMessageDialog(this, "Invalid ZIP Code. Format: XXXXX or XXXXX-XXXX");
            return false;
        }
        // Validate Phone Number
        String phoneNumber = textField_7.getText();
        if (phoneNumber.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Phone Number cannot be empty");
            return false;
        }
        if (!phoneNumber.matches("\\(\\d{3}\\) \\d{3}-\\d{4}") && !phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}")) {
            JOptionPane.showMessageDialog(this, "Invalid Phone Number. Format: (XXX) XXX-XXXX or XXX-XXX-XXXX");
            return false;
        }
        return true;
    }

    private void saveMemberData() {
        try {
            String memberId = textField_3.getText();
            String firstName = textField.getText();
            String lastName = textField_1.getText();
            String street = textField_2.getText();
            String city = textField_4.getText();
            String state = textField_5.getText();
            String zip = textField_6.getText();
            String phoneNumber = textField_7.getText();

            // Assuming SystemController handles member creation and persistence
            controller.addLibraryMember(memberId, firstName, lastName, street, city, state, zip, phoneNumber);
            
            JOptionPane.showMessageDialog(this, "Library Member added successfully!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error adding library member: " + ex.getMessage());
        }
    }
    
    private void clearForm() {
        textField_3.setText("");
        textField.setText("");
        textField_1.setText("");
        textField_2.setText("");
        textField_4.setText("");
        textField_5.setText("");
        textField_6.setText("");
        textField_7.setText("");
    }

    // Method to generate a unique Member ID
    private String generateUniqueMemberID() {
        String memberId;
        do {
            memberId = "" + (int) (Math.random() * 1000000); // Generate a random ID
        } while (controller.memberIdExists(memberId)); 
        return memberId;
    }
}
