package College;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class StudentAdop extends JFrame { // inhertiance the jframe of login

	private JPanel contentPane;
	private JTable table;
	
	// url username and password from mysql 
	private String url = "jdbc:mysql://localhost:3306/College";
    private String username = "root";
    private String password = "dorje070";
    private JTextField DelStdsId;
    private JTextField DelUser;
    
    // StudentAdop HAS-A(Association) Student handling 
    private StudentHandling Shand = new StudentHandling();
    
 // StudentAdop HAS-A(Association)
    private  AccontHandling Ahand = new  AccontHandling();
    
    // textfield of Student 
    private JTextField NewName;
    private JTextField Rollno1;
    private JTextField NewAge;
    private JTextField NewAddress;
    private JTextField Rollno3;
    private JTextField Rollno2;
    private JTextField NewCourse;
    private JTextField Rollno4;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentAdop frame = new StudentAdop();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StudentAdop() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 827, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Add button and Action 
		JButton Addbtn = new JButton("Add");
		Addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// StudentAdop HAS-A(Association) Creating Account 
				CreateAccount CrAc = new CreateAccount();
				// open the window of create account 
				CrAc.setVisible(true);
			}
		});
		Addbtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		Addbtn.setBounds(643, 378, 85, 21);
		contentPane.add(Addbtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(512, 52, 278, 310);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnLoad = new JButton("Load Data");
		btnLoad.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		            //load the driver
		            Class.forName("com.mysql.jdbc.Driver");


		            //create the connection
		            Connection connect = DriverManager.getConnection(url,username,password);

		            //create the query
		            String query = "SELECT * FROM student";

		            //create the statement
		            Statement statement = connect.createStatement();
		            ResultSet set = statement.executeQuery(query);
		            table.setModel(DbUtils.resultSetToTableModel(set));// using the DbUtils function which is store Resourse folder 
                                                                        // Add the buidling path of Resourse folder
		            
		            
		            
		            //close the statment
		            connect.close();

		        }catch (Exception exp){
		            System.out.println(exp);
		        }
			}
		});
		btnLoad.setBounds(576, 21, 111, 21);
		contentPane.add(btnLoad);
		
		JLabel lblNewLabel = new JLabel("Delete Student");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(64, 62, 96, 13);
		contentPane.add(lblNewLabel);
		
		DelStdsId = new JTextField();
		DelStdsId.setBounds(124, 85, 96, 19);
		contentPane.add(DelStdsId);
		DelStdsId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Student Rollno");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(26, 85, 85, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("user name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(36, 117, 66, 13);
		contentPane.add(lblNewLabel_2);
		
		DelUser = new JTextField();
		DelUser.setBounds(124, 114, 96, 19);
		contentPane.add(DelUser);
		DelUser.setColumns(10);
		
		// delete button and Action 
		JButton btndelete = new JButton("Delete");
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int DelStudent = Integer.parseInt(DelStdsId.getText()); // Getting the Student iD  from DelSydsId Textflied
				String Delusername = DelUser.getText();  // Getting the username from DelUser Textflied
				Shand.DeleteStudent(DelStudent); // delete function of Student Handling 
				Ahand.DeleteAccount(Delusername); // delete function of Account handling 
			}
		});
		btndelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btndelete.setBounds(124, 145, 85, 21);
		contentPane.add(btndelete);
		
		JLabel lblNewLabel_3 = new JLabel("Change Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(64, 185, 96, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New Name");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(11, 211, 66, 13);
		contentPane.add(lblNewLabel_4);
		
		NewName = new JTextField();
		NewName.setBounds(102, 208, 96, 19);
		contentPane.add(NewName);
		NewName.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Change Age");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(51, 300, 109, 13);
		contentPane.add(lblNewLabel_5);
		
		Rollno1 = new JTextField();
		Rollno1.setBounds(102, 234, 96, 19);
		contentPane.add(Rollno1);
		Rollno1.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Roll no");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(11, 234, 66, 13);
		contentPane.add(lblNewLabel_6);
		
		NewAge = new JTextField();
		NewAge.setBounds(102, 320, 96, 19);
		contentPane.add(NewAge);
		NewAge.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Change Address");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_9.setBounds(301, 185, 111, 13);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("New Address");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10.setBounds(251, 211, 85, 13);
		contentPane.add(lblNewLabel_10);
		
		NewAddress = new JTextField();
		NewAddress.setBounds(346, 208, 96, 19);
		contentPane.add(NewAddress);
		NewAddress.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Roll no");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11.setBounds(251, 237, 66, 13);
		contentPane.add(lblNewLabel_11);
		
		Rollno3 = new JTextField();
		Rollno3.setBounds(346, 237, 96, 19);
		contentPane.add(Rollno3);
		Rollno3.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("New Age");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_12.setBounds(11, 323, 66, 13);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_7 = new JLabel("Roll no");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBounds(11, 349, 66, 13);
		contentPane.add(lblNewLabel_7);
		
		Rollno2 = new JTextField();
		Rollno2.setBounds(102, 349, 96, 19);
		contentPane.add(Rollno2);
		Rollno2.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("change Course");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8.setBounds(301, 300, 89, 13);
		contentPane.add(lblNewLabel_8);
		
		NewCourse = new JTextField();
		NewCourse.setBounds(366, 320, 96, 19);
		contentPane.add(NewCourse);
		NewCourse.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("New Course");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_13.setBounds(251, 323, 85, 13);
		contentPane.add(lblNewLabel_13);
		
		Rollno4 = new JTextField();
		Rollno4.setBounds(366, 349, 96, 19);
		contentPane.add(Rollno4);
		Rollno4.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("Roll no");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_14.setBounds(251, 349, 45, 13);
		contentPane.add(lblNewLabel_14);
		
		JButton btnName = new JButton("Change");
		btnName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String New_name = NewName.getText();  // Getting the New name  from NewName Textfield
				int Roll_no = Integer.parseInt(Rollno1.getText()); // Getting the Roll no  from Rollno1 Textfield
				Shand.ChangeStudentName(Roll_no, New_name); // change name function from student handling 
			}
		});
		btnName.setBounds(102, 263, 85, 21);
		contentPane.add(btnName);
		
		JButton btnAge = new JButton("Change");
		btnAge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int New_Age = Integer.parseInt(NewAge.getText());  // Getting the New Age from NewAge Textfield
				int Roll_no = Integer.parseInt(Rollno2.getText()); // Getting the Roll no  from Rollno2 Textfield
				Shand.ChangeStudentAge(Roll_no, New_Age); // change age function from Student handling 
			}
		});
		btnAge.setBounds(102, 378, 85, 21);
		contentPane.add(btnAge);
		
		JButton btnAddress = new JButton("Change");
		btnAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String New_Address = NewAddress.getText(); // Getting the New Address from NewAddress Textfield
				int Roll_no = Integer.parseInt(Rollno3.getText());// Getting the Roll no  from Rollno3 Textfield
				Shand.ChangeStudentAddress(Roll_no, New_Address);   // change Address from Student handling 
			}
		});
		btnAddress.setBounds(357, 266, 85, 21);
		contentPane.add(btnAddress);
		
		JButton btnCourse = new JButton("Change");
		btnCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String CourseName = NewCourse.getText();  // Getting the Course name  from NewCourse Textfield
				int Roll_no = Integer.parseInt(Rollno4.getText()); // Getting the Roll no  from Rollno4 Textfield
				Shand.ChangeStudentCourse(Roll_no, CourseName);  // change Course from the Student handling
			}
		});
		btnCourse.setBounds(377, 378, 85, 21);
		contentPane.add(btnCourse);
	}
}
