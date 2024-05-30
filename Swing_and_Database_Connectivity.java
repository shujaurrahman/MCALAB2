/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swing;
import java.io.*;
import java.util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


class swingdemo {
    Connection conn;
    String INSERT_QUERY = "insert into student values(?,?);";
    String DELETE_QUERY = "delete from student where sname=? and srollno=?";
    String UPDATE_QUERY = "update student set sname=? where srollno=?";
    String SELECT_QUERY = "select sname, srollno from student";
swingdemo() {
    
    try{
        //Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/department",
               "root", "root");
        
         
    //Statement stmt = conn.createStatement();
    
    PreparedStatement stmt = conn.prepareStatement(SELECT_QUERY);
    
    
    //ResultSet rs = stmt.executeQuery("select sname,srollno from student");
    ResultSet rs = stmt.executeQuery();
        System.out.println("TEsting Testing");
    
    while(rs.next())
    {
        System.out.println(rs.getString(1)+" "+rs.getString(2));
    }
    }
    catch(Exception se)
    {
        System.out.println("Not Connected"+se);
    }
    
    
// Create a new JFrame container.
JFrame jf = new JFrame("My first frmae");
jf.setLayout(new GridLayout(3,2));
jf.setSize(300, 200);
jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

JLabel jlb1 = new JLabel("Student's Name: ");
JLabel jlb2 = new JLabel("Student's Roll No: ");

JTextField jtf1 = new JTextField("");
JTextField jtf2 = new JTextField("");


JButton jbtn1 = new JButton("Insert");
JButton jbtn2 = new JButton("Delete");

jf.add(jlb1);
jf.add(jtf1);

jf.add(jlb2);
jf.add(jtf2);

jf.add(jbtn1);
jf.add(jbtn2);

ActionListener al1 = new ActionListener() //Handler for Insert button press
{
    public void actionPerformed(ActionEvent ae)
    {
        try{
            PreparedStatement stmt = conn.prepareStatement(INSERT_QUERY); 
            stmt.setString(1, jtf1.getText());  
            stmt.setString(2, jtf2.getText()); 
            System.out.println(stmt.execute());
        }
        catch(SQLException se)
    {
        System.out.println("Error"+se);
    }
    }
};

ActionListener al2 = new ActionListener() //Handler for Delete button press
{
    public void actionPerformed(ActionEvent ae)
    {
        try{
            PreparedStatement stmt = conn.prepareStatement(DELETE_QUERY); 
            stmt.setString(1, jtf1.getText());  
            stmt.setString(2, jtf2.getText()); 
            System.out.println(stmt.execute());
        }
        
        catch(SQLException se)
    {
        System.out.println("Error"+se);
    }
    }
};


jbtn1.addActionListener(al1);
jbtn2.addActionListener(al2);


jf.setVisible(true);

}
}
public class myswing
{
public static void main(String[] args) {
    
    
    Runnable r = new Runnable()
    {
        public void run()
        {
            swingdemo sd = new swingdemo();
        }
    };
    
    SwingUtilities.invokeLater(r);   
}
}


