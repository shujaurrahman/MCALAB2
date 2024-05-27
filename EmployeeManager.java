package Swing_Playground;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import javax.swing.*;


public class EmployeeManager implements ActionListener {

    class Employee{
        String name;
        String empId;
        int age;
        public Employee(String name, String empId, int age){
            this.name = name;
            this.empId = empId;
            this.age = age;
        }
    }

    private static LinkedList<Employee> empList;
    private JTextArea empIdField;
    private JButton delete;

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == delete){
            String empId = empIdField.getText();
            if (!empId.isEmpty()){
                deleteEmployee(empId);
            }
            else{
                JOptionPane.showMessageDialog(null, "Please enter an employeeId to delete");
            }
        }
    }

    private void deleteEmployee(String empId){
        for (Employee emp : empList){
            if (emp.empId.equals(empId)){
                empList.remove(emp);
                JOptionPane.showMessageDialog(null,"Employee deleted Successfully!");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Employee not found");
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Employee Manager");
        frame.setSize(800, 600);
        JPanel panel = new JPanel(new GridLayout(6, 12));

        JLabel labelEmpId = new JLabel("Emp ID");
        empIdField = new JTextArea();
        JButton delete = new JButton("Delete");
        delete.addActionListener(this);

        panel.add(labelEmpId);
        panel.add(empIdField);
        panel.add(delete);
        frame.add(panel);

        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EmployeeManager main = new EmployeeManager();
        main.empList = new LinkedList<>();
        SwingUtilities.invokeLater(main::createAndShowGUI);


    }
}