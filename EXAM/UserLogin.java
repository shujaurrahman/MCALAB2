package Swing_Playground;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UserLogin implements ActionListener {

    private JTextField userNameField;
    private JTextField passwordField;

    private JLabel messageLabel;

    public UserLogin() {
        JFrame frame = new JFrame("User Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(4, 4));
        JLabel userNameLabel = new JLabel("User Name:");
        userNameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JTextField();
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        messageLabel=new JLabel();


        panel.add(userNameLabel);
        panel.add(userNameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(messageLabel);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = userNameField.getText();
        String password = passwordField.getText();

        if (isValidUser(username, password)) {
            messageLabel.setText("Login Successful");
        } else {
            messageLabel.setText("Incorrect Password");
        }
    }

    public boolean isValidUser(String username, String password) {
        String filename = "/Users/shujaurrahman/Desktop/Sessional/file.txt"; // Path to your file
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(UserLogin::new);
    }
}
