package librarysystem;

import business.Address;
import business.Author;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddAuthorWindow extends JFrame {
    private JTextField authorFirstName;
    private JTextField authorLastName;
    private JTextField authorTelephone;
    private JTextField authorStreetAddress;
    private JTextField authorCityAddress;
    private JTextField authorStateAddress;
    private JTextField authorZip;
    private JTextField authorBio;
    private ArrayList<Author> authors;

    public AddAuthorWindow(ArrayList<Author> authors) {
        this.authors = authors;
        setTitle("Add Author");
        setBounds(100, 100, 450, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblAuthorFirstName = new JLabel("Author First Name");
        lblAuthorFirstName.setBounds(10, 10, 150, 25);
        getContentPane().add(lblAuthorFirstName);

        authorFirstName = new JTextField();
        authorFirstName.setBounds(170, 10, 250, 25);
        getContentPane().add(authorFirstName);

        JLabel lblAuthorLastName = new JLabel("Author Last Name");
        lblAuthorLastName.setBounds(10, 50, 150, 25);
        getContentPane().add(lblAuthorLastName);

        authorLastName = new JTextField();
        authorLastName.setBounds(170, 50, 250, 25);
        getContentPane().add(authorLastName);

        JLabel lblAuthorTelephone = new JLabel("Author Telephone");
        lblAuthorTelephone.setBounds(10, 90, 150, 25);
        getContentPane().add(lblAuthorTelephone);

        authorTelephone = new JTextField();
        authorTelephone.setBounds(170, 90, 250, 25);
        getContentPane().add(authorTelephone);

        JLabel lblAuthorStreetAddress = new JLabel("Author Street Address");
        lblAuthorStreetAddress.setBounds(10, 130, 150, 25);
        getContentPane().add(lblAuthorStreetAddress);

        authorStreetAddress = new JTextField();
        authorStreetAddress.setBounds(170, 130, 250, 25);
        getContentPane().add(authorStreetAddress);

        JLabel lblAuthorCityAddress = new JLabel("Author City Address");
        lblAuthorCityAddress.setBounds(10, 170, 150, 25);
        getContentPane().add(lblAuthorCityAddress);

        authorCityAddress = new JTextField();
        authorCityAddress.setBounds(170, 170, 250, 25);
        getContentPane().add(authorCityAddress);

        JLabel lblAuthorStateAddress = new JLabel("Author State Address");
        lblAuthorStateAddress.setBounds(10, 210, 150, 25);
        getContentPane().add(lblAuthorStateAddress);

        authorStateAddress = new JTextField();
        authorStateAddress.setBounds(170, 210, 250, 25);
        getContentPane().add(authorStateAddress);

        JLabel lblAuthorZip = new JLabel("Author Zip");
        lblAuthorZip.setBounds(10, 250, 150, 25);
        getContentPane().add(lblAuthorZip);

        authorZip = new JTextField();
        authorZip.setBounds(170, 250, 250, 25);
        getContentPane().add(authorZip);

        JLabel lblAuthorBio = new JLabel("Author Bio");
        lblAuthorBio.setBounds(10, 290, 150, 25);
        getContentPane().add(lblAuthorBio);

        authorBio = new JTextField();
        authorBio.setBounds(170, 290, 250, 25);
        getContentPane().add(authorBio);

        JButton btnAddAuthor = new JButton("Add Author");
        btnAddAuthor.setBounds(170, 330, 150, 25);
        getContentPane().add(btnAddAuthor);

        btnAddAuthor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateFields()) {
                    addAuthor();
                    dispose();
                }
            }
        });
    }

    private boolean validateFields() {
        if (authorFirstName.getText().isEmpty() || authorLastName.getText().isEmpty() || authorTelephone.getText().isEmpty() ||
                authorStreetAddress.getText().isEmpty() || authorCityAddress.getText().isEmpty() || authorStateAddress.getText().isEmpty() ||
                authorZip.getText().isEmpty() || authorBio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill out all fields");
            return false;
        }
        if (!authorZip.getText().matches("\\d{5}")) {
            JOptionPane.showMessageDialog(this, "Zip must be a 5 digit number");
            return false;
        }
        if (!authorTelephone.getText().matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "Phone must be a 10 digit number");
            return false;
        }
        return true;
    }

    private void addAuthor() {
        Address address = new Address(authorStreetAddress.getText(), authorCityAddress.getText(), authorStateAddress.getText(), authorZip.getText());
        Author author = new Author(authorFirstName.getText(), authorLastName.getText(), authorTelephone.getText(), address, authorBio.getText());
        authors.add(author);
    }
}