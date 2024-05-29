package Swing_Playground;
import javax.swing.*;
import java.awt.*;
import  java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Button clicked Program
public class calculator implements ActionListener{
    private JTextField num1;
    private JTextField num2;
    private JButton add;
    private JButton sub;
    private JButton mul;
    private JButton divide;
    private JLabel displaymsg;
    public calculator(){
        JFrame fr=new JFrame("Calculator");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(400,600);

        JPanel panel=new JPanel(new GridLayout(8,1));
        JLabel l1=new JLabel("Enter First Number");
        num1=new JTextField();
        JLabel l2=new JLabel("Enter Second Number");
        num2=new JTextField();
        add=new JButton("Add");
        sub=new JButton("Subtract");
        mul=new JButton("Multiply");
        divide=new JButton("Divide");
        displaymsg=new JLabel();
        panel.add(l1);
        panel.add(num1);
        panel.add(l2);
        panel.add(num2);
        panel.add(add);
        panel.add(sub);
        panel.add(mul);
        panel.add(divide);
        panel.add(displaymsg);
        fr.add(panel);
        fr.setVisible(true);
        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        divide.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        int n1=Integer.parseInt(num1.getText());
        int n2=Integer.parseInt(num2.getText());
        int result=0;
        if(e.getSource()==add){
            result=n1+n2;
        }else if(e.getSource()==sub){
            result=n1-n2;
        }else if(e.getSource()==mul){
            result=n1*n2;
        }else if(e.getSource()==divide){
                result=n1/n2;
        }else{
            displaymsg.setText("There was some problem with calculator!");
        }
        displaymsg.setText("Result : "+result);
        if(n2==0){
            displaymsg.setText("Divider cannot be zero.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(calculator::new);
    }
}


