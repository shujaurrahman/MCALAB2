//package Swing_Playground;
//import java.awt.*;
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.BufferedReader;
//import java.io.FileReader;
//
//public class UserLogin implements ActionListener {
//
//    private JButton login;
//    private JTextField userNameField;
//    private JTextField passwordField;
//    String filename;
//
//    private void UserLoginGUI(){
//        JFrame frame = new JFrame("User Login");
//
//        JPanel panel = new JPanel(new GridLayout(6,12));
//        JLabel userName = new JLabel("User Name");
//        JTextField userNameField = new JTextField();
//        JLabel password = new JLabel("Password");
//        JTextField passwordField = new JTextField();
//        JButton login = new JButton("Login");
//        login.addActionListener(this);
//        JLabel messageLabel = new JLabel();
//
//        panel.add(userName);
//        panel.add(userNameField);
//        panel.add(password);
//        panel.add(passwordField);
//        panel.add(login);
//        panel.add(messageLabel);
//
//        frame.add(panel);
//
//
//        frame.setVisible(true);
//
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == login){
//            String UserId = userNameField.getText();
//            String pass = passwordField.getText();
//
//            if (isValiduser(UserId,pass,filename)){
//                JOptionPane.showMessageDialog(null,"Login Successfull!");
//            }
//            else{
//                JOptionPane.showMessageDialog(null, "Incorrect Credentials");
//            }
//        }
//    }
//
//    public boolean isValidUser(String user,String pass , String filename){
//
//        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                String[] parts = line.split(",");
//                if (parts.length == 2 && parts[0].equals(user) && parts[1].equals(pass)) {
//                    return true;
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    public static void main(String[] args) {
//        String filename = "/Users/apple/Desktop/Study File/Codarea/Java/Swing_Playground/resources/password.txt";
//
//        UserLogin main = new UserLogin();
//        SwingUtilities.invokeLater(main::UserLoginGUI);
//    }
//
//
//}
