package Swing_Playground;

//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//
//public class pract implements ActionListener{
//    private JTextField UserName;
//    private JTextField pasword;
//    private JLabel message;
//
//    public pract(){
//        JFrame frame=new JFrame("User Login");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        JPanel panel=new JPanel(new GridLayout(4,4));
//        JLabel usernameLabel=new JLabel("Username");
//        UserName=new JTextField();
//        JLabel passwordLabel=new JLabel("Password");
//        pasword=new JTextField();
//        JButton btn=new JButton("Login");
//        btn.addActionListener(this);
//        message=new JLabel();
//
//        panel.add(usernameLabel);
//        panel.add(UserName);
//        panel.add(passwordLabel);
//        panel.add(pasword);
//        panel.add(btn);
//        panel.add(message);
//
//        frame.add(panel);
//        frame.pack();
//        frame.setVisible(true);
//    }
//    @Override
//    public void actionPerformed(ActionEvent e){
//        String username=UserName.getText();
//        String password= pasword.getText();
//
//        if(isvalidUser(username,password)){
//            message.setText("Login Success!");
//        }
//        else{
//            message.setText("Incorrect details");
//        }
//    }
//
//    public boolean isvalidUser(String username,String password){
//        String fileName="/Users/shujaurrahman/Desktop/Sessional/file.txt";
//        try{
//            BufferedReader reader=new BufferedReader(new FileReader(fileName));
//            String line;
//            while((line=reader.readLine())!=null){
//                String[] parts=line.split(",");
//                if(parts.length==2 && parts[0].equals(username) && parts[1].equals(password)){
//                    return true;
//                }
//            }
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(pract::new);
//    }
//
//}
//



//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//public class pract {
//    public static void main(String[] args) {
//        String fileName="/Users/shujaurrahman/Desktop/Sessional/file.txt";
//        try{
//            BufferedReader reader=new BufferedReader(new FileReader(fileName));
//            String line;
//            Map<Character,Integer>charCount=new HashMap<>();
//            Map<String,Integer>wordCount= new HashMap<>();
//
//            while((line=reader.readLine())!=null){
//                //count character
//                for(char c :line.toCharArray()){
//                    if(Character.isLetter(c)){
//                        charCount.put(c,charCount.getOrDefault(c,0)+1);
//                    }
//                }
//
//                //count words
//                String[] words=line.split("\s");
//                for(String word:words){
//                    if(!word.isEmpty()){
//                        wordCount.put(word,wordCount.getOrDefault(word,0)+1);
//                    }
//                }
//            }
//            reader.close();
//            char maxchar=' ';
//            int maxCharCount=0;
//            for (Map.Entry<Character,Integer> entry:charCount.entrySet()){
//                if(entry.getValue()>maxCharCount){
//                    maxchar= entry.getKey();
//                    maxCharCount=entry.getValue();
//                }
//            }
//
//            String maxWord="";
//            int maxWordCount=0;
//            for (Map.Entry<String,Integer> entry:wordCount.entrySet()){
//                if(entry.getValue()>maxWordCount){
//                    maxWord= entry.getKey();
//                    maxWordCount=entry.getValue();
//                }
//            }
//            System.out.println("Character with maximum occurence: "+maxchar+"("+maxCharCount+")");
//            System.out.println("Character with maximum occurence: "+maxWord+"("+maxWordCount+")");
//        }
//
//        catch (IOException e) {
//            System.err.println("Error reading file"+ e.getMessage());
//        }
//    }
//
//}

//// Example: Using ActionListener with JButton
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class pract {
//    public static void main(String[] args) {
//        JFrame frame = new JFrame("Button Example");
//        JButton button = new JButton("Click me");
//        // Using anonymous inner class to handle button click event
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("Button clicked!");
//            }
//        });
//
//        frame.add(button);
//        frame.setSize(300, 200);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//    }
//}

//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class pract{
//    public static void main(String[] args) {
//        JFrame frame=new JFrame("Anonysmous Class");
//        JButton btn=new JButton("Click me ");
//
//
//        btn.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent e){
//                System.out.print("Button Clicked");
//            }
//
//        });
//
//        frame.add(btn);
//        frame.setSize(400,300);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//    }
//
//}

//
//class Bike{
//    private String make;
//    private String model;
//    private int year;
//    private String color;
//
//    public Bike(String make,String model,int year,String color){
//        this.make=make;
//        this.model=model;
//        this.year=year;
//        this.color=color;
//
//    }
//
//    public void setMake(String make){
//        this.make=make;
//    }
//    public String getMake(){
//        return make;
//    }
//    public void setModel(String model){
//        this.model=model;
//    }
//
//    public String getModel(){
//        return model;
//    }
//
//    public void setYear(int year){
//        this.year=year;
//    }
//    public int year(){
//        return year;
//    }
//
//    public void setColor(String color){
//        this.color=color;
//
//    }
//    public String getColor(){
//        return color;
//    }
//
//}
//
// class sportsBike extends Bike{
//    private int topSpeed;
//    public sportsBike(String make,String model,int year,String color,int topSpeed){
//        super(make,model,year,color);
//        this.topSpeed=topSpeed;
//    }
//
//    public void setTopspeed(int year){
//        this.topSpeed=topSpeed;
//    }
//
//    public int gettopspeed(){
//        return topSpeed;
//    }
//
//}
//
//public class pract {
//    public static void main(String[] args) {
//        sportsBike b1=new sportsBike("shuja","x",1999,"red",120);
//        sportsBike b2=new sportsBike("yusuf","y",1992,"blue",160);
//        sportsBike b3=new sportsBike("asad","z",1995,"yellow",180);
//
//        if(b1.getColor().equals("red")){
//            System.out.println("Bike red has make of the car:  "+b1.getMake()+" and model :"+b1.getModel());
//        } else if (b2.getColor().equals("red")) {
//            System.out.println("Bike red has make of the car:  "+b2.getMake()+" and model :"+b2.getModel());
//        }
//        else if(b3.getColor().equals("red")){
//            System.out.println("Bike red has make of the car:  "+b3.getMake()+" and model :"+b3.getModel());
//        }
//        else{
//            System.out.println("No bike with color red");
//        }
//    }
//}
//
//
//import java.util.Random;
//
//public class pract {
//    public static void main(String[] args) {
//        // Generate two random prime numbers between 2 and 100
//        int R1 = generateRandomPrime();
//        int R2 = generateRandomPrime();
//
//        // Find which prime number has the largest number of relative primes
//        int relativePrimesR1 = countRelativePrimes(R1);
//        int relativePrimesR2 = countRelativePrimes(R2);
//
//        // Print the results
//        System.out.println("Random Prime Number R1: " + R1);
//        System.out.println("Random Prime Number R2: " + R2);
//        System.out.println("Number of Relative Primes for R1: " + relativePrimesR1);
//        System.out.println("Number of Relative Primes for R2: " + relativePrimesR2);
//
//        if (relativePrimesR1 > relativePrimesR2) {
//            System.out.println("R1 has the largest number of relative primes.");
//        } else if (relativePrimesR1 < relativePrimesR2) {
//            System.out.println("R2 has the largest number of relative primes.");
//        } else {
//            System.out.println("Both R1 and R2 have the same number of relative primes.");
//        }
//    }
//
//    // Method to generate a random prime number between 2 and 100
//    private static int generateRandomPrime() {
//        Random random = new Random();
//        int num;
//        do {
//            num = random.nextInt(99) + 2; // Generate a random number between 2 and 100
//        } while (!isPrime(num)); // Repeat until a prime number is generated
//        return num;
//    }
//
//    // Method to check if a number is prime
//    private static boolean isPrime(int num) {
//        if (num <= 1) return false;
//        for (int i = 2; i <= Math.sqrt(num); i++) {
//            if (num % i == 0) return false;
//        }
//        return true;
//    }
////
////
//    // Method to count the number of relative primes for a given number
//    private static int countRelativePrimes(int num) {
//        int count = 0;
//        for (int i = 2; i < num; i++) {
//            if (gcd(num, i) == 1) { // Check if 'i' is relatively prime to 'num'
//                count++;
//            }
//        }
//        return count;
//    }
////
//    // Method to find the greatest common divisor (GCD) using Euclid's algorithm
//    private static int gcd(int a, int b) {
//        while (b != 0) {
//            int temp = b;
//            b = a % b;
//            a = temp;
//        }
//        return a;
//    }
//}

//
//import java.util.Random;
//
//public class pract {
//    public static void main(String[] args) {
//        int r1=genRandomPrime();
//        int r2=genRandomPrime();
//
//        int relp1=countRelativePrime(r1);
//        int relp2=countRelativePrime(r2);
//
//        System.out.println("Random prime number 1: "+r1);
//        System.out.println("Random prime number 2: "+r2);
//        System.out.println("Relative Random prime numbers from  r1: "+relp1);
//        System.out.println("Relative Random prime numbers from  r2: "+relp2);
//
//
//        if (relp1>relp2){
//            System.out.println("R1 has largest relative prime numbers");
//        }
//        else if(relp1<relp2){
//            System.out.println("R2 has largest relative prime numbers");
//        }
//        else{
//            System.out.println("Both have same");
//        }
//    }
//    public static int genRandomPrime(){
//        Random ran=new Random();
//        int num;
//        do{
//            num=ran.nextInt(99)+2;
//        }while(!isPrime(num));
//        return num;
//    }
//    public static boolean isPrime(int num){
//        if(num<2) return false;
//        for(int i=2;i<=Math.sqrt(num);i++){
//            if(num%i==0){
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public static int countRelativePrime(int num){
//        int count=0;
//        for(int i=0;i<=num;i++){
//            if(gcd(num,i)==1)
//                count++;
//        }
//        return count;
//    }
//    public static int gcd(int a,int b){
//        while(b!=0){
//            int temp=b;
//            b=a%b;
//            a=temp;
//        }
//        return a;
//    }
//}
//
//import java.util.Random;
//
//public class pract {
//
//    public static void main(String[] args) {
//        int r1=genP();
//        int r2=genP();
//
//        int rlp1=cR(r1);
//        int rlp2=cR(r2);
//        System.out.println("Random prime r1: "+r1);
//        System.out.println("Random prime r2: "+r2);
//        System.out.println("Relative Prime Number from r1: "+rlp1);
//        System.out.println("Relative Prime Number from r2: "+rlp2);
//
//        if(rlp1>rlp2){
//            System.out.println("R1 has largest relative primes.");
//        }else if(rlp2>rlp1){
//            System.out.println("R2 has largest relative primes.");
//        }
//        else{
//            System.out.println("Both Have same relative prime numbers");
//        }
//    }
//
//
//    public static int genP(){
//        Random ran=new Random();
//        int num;
//        do{
//            num=ran.nextInt(99)+2;
//        }while(!isPrime(num));
//        return num;
//    }
//    public static boolean isPrime(int num){
//        if(num<2) return  false;
//        for (int i=2;i<=Math.sqrt(num);i++){
//            if(num%i==0){
//                return false;
//            }
//        }
//        return true;
//    }
//    public static int cR(int num){
//        int count=0;
//        for(int i=2;i<=num;i++){
//            if(gcd(num,i)==1){
//                count++;
//            }
//        }
//        return count;
//    }
//    public static int gcd(int a,int b){
//        while(b!=0){
//            int temp=b;
//            b=a%b;
//            a=temp;
//        }
//        return a;
//    }
//}
//
//
//import java.util.LinkedList;
//import java.util.Scanner;
//
//public class pract {
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        LinkedList<String> stringList=new LinkedList<>();
//        LinkedList<Integer> intergerlist=new LinkedList<>();
//
//        System.out.println("Enter the Size of lists: ");
//        int size=sc.nextInt();
//        System.out.println("Enter string linked list elements");
//        for (int i=0;i<size;i++){
//            stringList.add(sc.next());
//        }
//        System.out.println("Enter Integer elements: ");
//        for (int i=0;i<size;i++){
//            intergerlist.add(sc.nextInt());
//        }
//        LinkedList<Object> combinedList=new LinkedList<>();
//        for (int i=0;i<size;i++){
//            combinedList.add(stringList.get(i));
//            combinedList.add(intergerlist.get(i));
//
//
//        }
//        System.out.println("Combined element of linked list are: ");
//        for (Object element:combinedList){
//            System.out.println(element+" ");
//        }
//        sc.close();
//
//    }
//}
//
//import java.util.LinkedList;
//import java.util.Scanner;
//
//public class pract {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        // Create two linked lists to store string and integer data
//        LinkedList<String> stringList = new LinkedList<>();
//        LinkedList<Integer> integerList = new LinkedList<>();
//
//        // Populate both linked lists with user-supplied data
//        System.out.println("Enter the size of the lists:");
//        int size = scanner.nextInt();
//        System.out.println("Enter string elements:");
//        for (int i = 0; i < size; i++) {
//            stringList.add(scanner.next());
//        }
//        System.out.println("Enter integer elements:");
//        for (int i = 0; i < size; i++) {
//            integerList.add(scanner.nextInt());
//        }
//
//        // Create a third linked list containing alternating string and integer elements
//        LinkedList<Object> combinedList = new LinkedList<>();
//        for (int i = 0; i < size; i++) {
//            combinedList.add(stringList.get(i));
//            combinedList.add(integerList.get(i));
//        }
//
//        // Print the combined linked list
//        System.out.println("Combined linked list:");
//        for (Object element : combinedList) {
//            System.out.print(element + " ");
//        }
//
//        scanner.close();
//    }
//}

//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//public class pract {
//    public static void main(String[] args) {
//        String fileName = "your_file_path.txt"; // Specify the path to your text file
//        Map<String, Integer> wordCounts = new HashMap<>();
//        Map<Character, Integer> charCounts = new HashMap<>();
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] words = line.split("\\s+");
//                for (String word : words) {
//                    wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
//                    for (char c : word.toCharArray()) {
//                        if (Character.isLetter(c)) {
//                            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
//                        }
//                    }
//                }
//            }
//
//            String maxWord = "";
//            int maxWordCount = 0;
//            for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
//                if (entry.getValue() > maxWordCount) {
//                    maxWord = entry.getKey();
//                    maxWordCount = entry.getValue();
//                }
//            }
//
//            char maxChar = ' ';
//            int maxCharCount = 0;
//            for (Map.Entry<Character, Integer> entry : charCounts.entrySet()) {
//                if (entry.getValue() > maxCharCount) {
//                    maxChar = entry.getKey();
//                    maxCharCount = entry.getValue();
//                }
//            }
//
//            System.out.println("Word with maximum occurrence: " + maxWord + " (" + maxWordCount + " times)");
//            System.out.println("Character with maximum occurrence: " + maxChar + " (" + maxCharCount + " times)");
//        } catch (IOException e) {
//            System.err.println("Error reading the file: " + e.getMessage());
//        }
//    }
//}

//import java.util.ArrayList;
//import java.util.List;
//
//public class LeaderElements {
//    public static void main(String[] args) {
//        int[] arr = {16, 17, 4, 3, 5, 2};
//
//        List<Integer> leaders = findLeaders(arr);
//
//        System.out.println("Leader elements in the array:");
//        for (int leader : leaders) {
//            System.out.print(leader + " ");
//        }
//    }
//
//    public static List<Integer> findLeaders(int[] arr) {
//        List<Integer> leaders = new ArrayList<>();
//        if (arr.length == 0) {
//            return leaders;
//        }
//
//        int maxFromRight = arr[arr.length - 1];
//        leaders.add(maxFromRight);
//
//        for (int i = arr.length - 2; i >= 0; i--) {
//            if (arr[i] > maxFromRight) {
//                maxFromRight = arr[i];
//                leaders.add(maxFromRight);
//            }
//        }
//
//        // Reverse the list to get the leaders in the original order
//        List<Integer> reversedLeaders = new ArrayList<>();
//        for (int i = leaders.size() - 1; i >= 0; i--) {
//            reversedLeaders.add(leaders.get(i));
//        }
//
//        return reversedLeaders;
//    }
//}

//
//import java.util.*;
//
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class pract{
//    public static void main(String[] args) {
//        String input = "Java program to find out instance of each character and word in a string";
//        Map<Character, Integer> charOccurrences = new HashMap<>();
//        Map<String, Integer> wordOccurrences = new HashMap<>();
//
//        // Count occurrences of each character
//        for (char c : input.toCharArray()) {
//            if (Character.isLetter(c)) {
//                charOccurrences.put(c, charOccurrences.getOrDefault(c, 0) + 1);
//            }
//        }
//
//        // Count occurrences of each word
//        String[] words = input.split("\\s+");
//        for (String word : words) {
//            wordOccurrences.put(word, wordOccurrences.getOrDefault(word, 0) + 1);
//        }
//
//        // Print character occurrences
//        System.out.println("Occurrences of each character:");
//        for (Map.Entry<Character, Integer> entry : charOccurrences.entrySet()) {
//            System.out.println("'" + entry.getKey() + "': " + entry.getValue());
//        }
//
//        // Print word occurrences
//        System.out.println("\nOccurrences of each word:");
//        for (Map.Entry<String, Integer> entry : wordOccurrences.entrySet()) {
//            System.out.println("'" + entry.getKey() + "': " + entry.getValue());
//        }
//    }
//}

//Swing database question

//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//public class pract {
//    class EmployeeGUI extends JFrame{
//        private JTextField EmpId;
//        private JButton deleteButton;
//        private JLabel msg;
//
//        public EmployeeGUI(){
//            setSize(400,400);
//            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            JPanel panel=new JPanel(new GridLayout(2,2));
//            JLabel Employ=new JLabel("Employ ID");
//            EmpId=new JTextField();
//            msg=new JLabel();
//            deleteButton=new JButton("Delete");
//            panel.add(Employ);
//            panel.add(EmpId);
//            panel.add(msg);
//            panel.add(deleteButton);
//            add(panel);
//            deleteButton.addActionListener(new ActionListener(){
//                public void actionPerformed(ActionEvent e){
//                    deleteEmploy();
//                }
//            });
//        }
//        private void deleteEmploy(){
//            String empId=EmpId.getText();
//            //delete empploy
//            try{
//                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","");
//                PreparedStatement ps=conn.prepareStatement("DELETE from Employee WHERE EmpID=?");
//                ps.setString(1,empId);
//                ps.executeUpdate();
//
//                conn.close();
//
//            }catch (SQLException e){
//                e.printStackTrace();
//            }
//
//            //Update employ
//
//            try{
//                Connection Conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","");
//                PreparedStatement ps=Conn.prepareStatement("UPDATE Department SET DMgrid=? WHERE DMgrid=?");
//                ps.setString(1,"000");
//                ps.setString(2,empId);
//                ps.executeUpdate();
//                msg.setText("Deleted Employee ID :"+empId+"Department Table updated");
//            }
//            catch (SQLException e){
//                e.printStackTrace();
//            }
//        }
//    }
//    public pract() {
//        SwingUtilities.invokeLater(() -> {
//            EmployeeGUI employeeGUI = new EmployeeGUI(); // Creating instance of EmployeeGUI
//            employeeGUI.setVisible(true); // Making the GUI visible
//        });
//    }
//    public static void main(String[] args) {
//        new pract();
//    }
//}
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//public class pract{
//    class EmployGUI extends JFrame{
//        private JTextField EmpID;
//        private JButton deleteButton;
//        private JLabel msg;
//
//
//        //constructor of employee GUI
//        public EmployGUI(){
//            setSize(400,400);
//            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//            JPanel panel=new JPanel(new GridLayout(2,2));
//            JLabel employeeLabel=new JLabel("Enter Employee ID");
//            EmpID=new JTextField();
//            msg=new JLabel();
//            deleteButton=new JButton("Delete");
//            panel.add(employeeLabel);
//            panel.add(EmpID);
//            panel.add(msg);
//            panel.add(deleteButton);
//            add(panel);
//            deleteButton.addActionListener(new ActionListener(){
//                public void actionPerformed(ActionEvent e){
//                    deleteEmploy();
//                }
//            });
//        }
//
//
//        //Delete Function for deleting employee using jdbc mysql
//        private void deleteEmploy(){
//            String empId=EmpID.getText();
//            try{
//                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","");
//                PreparedStatement ps=conn.prepareStatement("DELETE FROM Employee WHERE EmpId=?");
//                ps.setString(1,empId);
//                ps.executeUpdate();
//                conn.close();
//            }catch (SQLException e){
//                e.printStackTrace();
//            }
//            try{
//                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","");
//                PreparedStatement ps=conn.prepareStatement("UPDATE Department SET DMgrid=? WHERE DMgrid=?");
//                ps.setString(1,"000");
//                ps.setString(2,empId);
//                ps.executeUpdate();
//                conn.close();
//                msg.setText("Deleted Employ ID"+empId+" \n Updated Department Table ");
//            }catch (SQLException e){
//                e.printStackTrace();
//            }
//        }
//    }
//
//    //pract constructor which make gui obj
//    public pract(){
//        SwingUtilities.invokeLater(()->{
//                EmployGUI obj=new EmployGUI();
//                obj.setVisible(true);
//                }
//        );
//
//    }
//
//    //main method
//    public static void main(String[] args) {
//        new pract();
//    }
//}

//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//public class pract {
//    public class EmployGUI extends JFrame{
//        private JTextField EmpID;
//        private JButton deleteButton;
//        private JLabel msg;
//
//        public EmployGUI(){
//            setSize(400,400);
//            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//            JPanel panel=new JPanel(new GridLayout(2,2));
//            JLabel employLabel=new JLabel("Enter Employ ID");
//            EmpID=new JTextField();
//            msg=new JLabel();
//            deleteButton=new JButton("Delete");
//            panel.add(employLabel);
//            panel.add(EmpID);
//            panel.add(msg);
//            panel.add(deleteButton);
//            add(panel);
//
//            deleteButton.addActionListener(new ActionListener(){
//                public void actionPerformed(ActionEvent e ){
//                    deleteEmploy();
//                    msg.setText("Deleted Employd ID"+EmpID.getText()+" Updated Department Table for Foriegn Key concerns.");
//                }
//            });
//        }
//        private void deleteEmploy(){
//            String input=EmpID.getText();
//            try{
//                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","");
//                PreparedStatement ps=conn.prepareStatement("DELETE FROM Employee Where EmpID=?");
//                ps.setString(1,input);
//                ps.executeUpdate();
//                conn.close();
//            }catch (SQLException e){
//                e.printStackTrace();
//            }
//
//            try{
//                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","");
//                PreparedStatement ps=conn.prepareStatement("UPDATE Department SET DMgrid=? WHERE DMgrid=?");
//                ps.setString(1,"000");
//                ps.setString(2,input);
//                ps.executeUpdate();
//                conn.close();
//            }catch (SQLException e){
//                e.printStackTrace();
//            }
//        }
//
//    }
//    public pract(){
//       SwingUtilities.invokeLater(()->{
//                   EmployGUI obj=new EmployGUI();
//                   obj.setVisible(true);
//               }
//               );
//    }
//    public static void main(String[] args){
//        new pract();
//    }
//}


//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//public class pract implements ActionListener{
//    private JTextField EmpId;
//    private JButton deleteButton;
//    private JLabel displaymsg;
//
//    public pract(){
//        JFrame fr=new JFrame("Employ program");
//        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        fr.setSize(400,400);
//
//        JPanel panel=new JPanel(new GridLayout(2,2));
//        JLabel employLabel=new JLabel("Enter Employee ID");
//        EmpId=new JTextField();
//        displaymsg=new JLabel();
//        deleteButton=new JButton("Delete");
//        deleteButton.addActionListener(this);
//
//        panel.add(employLabel);
//        panel.add(EmpId);
//        panel.add(displaymsg);
//        panel.add(deleteButton);
//        fr.add(panel);
//        fr.setVisible(true);
//    }
//    public void actionPerformed(ActionEvent e){
//        deleteEmploy();
//        displaymsg.setText("Employee with ID "+EmpId.getText()+" deleted \n and Updated Department tabel for this employ.");
//    }
//    private void deleteEmploy(){
//            String input=EmpId.getText();
//            try{
//                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","");
//                PreparedStatement ps=conn.prepareStatement("DELETE FROM Employee Where EmpID=?");
//                ps.setString(1,input);
//                ps.executeUpdate();
//                conn.close();
//            }catch (SQLException e){
//                e.printStackTrace();
//            }
//
//            try{
//                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","");
//                PreparedStatement ps=conn.prepareStatement("UPDATE Department SET DMgrid=? WHERE DMgrid=?");
//                ps.setString(1,"000");
//                ps.setString(2,input);
//                ps.executeUpdate();
//                conn.close();
//            }catch (SQLException e){
//                e.printStackTrace();
//            }
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(pract::new);
//    }
//}



//import java.util.Scanner;
//import java.util.LinkedList;
//
//public class pract{
//
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//
//        LinkedList<String> stringlist=new LinkedList<>();
//        LinkedList<Integer> intergerList=new LinkedList<>();
//        System.out.println("Enter the Size of linked lists: ");
//        int size=sc.nextInt();
//        System.out.println("Enter the element of StringList: ");
//        for (int i=0;i<size;i++){
//            stringlist.add(sc.next());
//        }
//        System.out.println("Enter the element of IntegerList: ");
//        for (int i=0;i<size;i++){
//            intergerList.add(sc.nextInt());
//        }
//        LinkedList<Object> CombinedList=new LinkedList<>();
//        for (int i=0;i<size;i++){
//            CombinedList.add(stringlist.get(i));
//            CombinedList.add(intergerList.get(i));
//        }
//        System.out.println("Elements in Combined List are: ");
//        for (Object ele:CombinedList){
//            System.out.println(ele);
//        }
//    }
//
//}
