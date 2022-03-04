package College;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InstructorAdop extends JFrame { // inhertiance the jframe of login
	
	// Jpanel and table of Instructor operation
	private JPanel contentPane;
	private JTable table;
	
	// url, username and password of mysql 
	private String url = "jdbc:mysql://localhost:3306/College";
    private String username = "root";
    private String password = "dorje070";
    
    private JTextField DelID;
    private JTextField UserName;
    
    // Instructor operation HAS-A(Association) Instructor Handling 
    private InstructorHandling  InHand = new InstructorHandling();
    
    // Instructor operation HAS-A(Association) Account Handling 
    private AccontHandling Ahand =new AccontHandling();
    
    // textfield of Instructor operation
    private JTextField EmployeeID1;
    private JTextField New_Name;
    private JTextField EmployeeID2;
    private JTextField New_Age;
    private JTextField EmployeeID3;
    private JTextField New_Type;
    private JTextField EmployeeID4;
    private JTextField NewEducation;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InstructorAdop frame = new InstructorAdop();
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
	public InstructorAdop() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 854, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(480, 41, 337, 407);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		// load btn and Action 
		JButton btnload = new JButton("load Instructor");
		btnload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		            //load the driver
		            Class.forName("com.mysql.jdbc.Driver");


		            //create the connection
		            Connection connect = DriverManager.getConnection(url,username,password);

		            //create the query
		            String query = "SELECT * FROM Instructor";

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
		btnload.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnload.setBounds(588, 10, 124, 21);
		contentPane.add(btnload);
		
		// Add button and Action
		JButton Addbtn = new JButton("Add");
		Addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateAccount CrAc = new CreateAccount();  // Instructor Account HAS-A(Association) Create Account 
				CrAc.setVisible(true);                    // open the window of Create Account 
			}
		});
		Addbtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		Addbtn.setBounds(627, 458, 85, 21);
		contentPane.add(Addbtn);
		
		JLabel lblNewLabel = new JLabel("Delete");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(78, 50, 77, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Employee ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(21, 73, 71, 13);
		contentPane.add(lblNewLabel_1);
		
		// Delete button And Action 
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int DeteID = Integer.parseInt(DelID.getText()); // Get Employee Id from DelID textfield
				String User_name = UserName.getText();   // Get user_name from Username Textfield
				InHand.DeleteInstructor(DeteID);         // calling the Delete function from the Instructor Handling 
				Ahand.DeleteAccount(User_name);          // calling the Delete function from the Account Handling 
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDelete.setBounds(125, 135, 85, 21);
		contentPane.add(btnDelete);
		
		// change Name button and Action 
		JButton btnName = new JButton("Change");
		btnName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NewName = New_Name.getText();        // Getting NewName from the New_Name textfield
				int EmployeeID = Integer.parseInt(EmployeeID1.getText());  // Getting the Employee Id from the EmployeeID1
				InHand.ChangeInstructorName(EmployeeID, NewName);  // Change New Name from Instructor Handling 
			}
		});
		btnName.setBounds(125, 265, 85, 21);
		contentPane.add(btnName);
		
		DelID = new JTextField();
		DelID.setBounds(114, 70, 96, 19);
		contentPane.add(DelID);
		DelID.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("User name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(21, 104, 71, 13);
		contentPane.add(lblNewLabel_2);
		
		UserName = new JTextField();
		UserName.setBounds(114, 99, 96, 19);
		contentPane.add(UserName);
		UserName.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Employee ID");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(21, 210, 71, 13);
		contentPane.add(lblNewLabel_3);
		
		EmployeeID1 = new JTextField();
		EmployeeID1.setBounds(125, 207, 96, 19);
		contentPane.add(EmployeeID1);
		EmployeeID1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("New Name");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(21, 239, 65, 13);
		contentPane.add(lblNewLabel_4);
		
		New_Name = new JTextField();
		New_Name.setBounds(124, 236, 96, 19);
		contentPane.add(New_Name);
		New_Name.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Change Name");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(69, 184, 86, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Change Age");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_6.setBounds(325, 184, 71, 13);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Employee ID");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_7.setBounds(277, 210, 73, 13);
		contentPane.add(lblNewLabel_7);
		
		EmployeeID2 = new JTextField();
		EmployeeID2.setBounds(360, 207, 96, 19);
		contentPane.add(EmployeeID2);
		EmployeeID2.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("New Age");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8.setBounds(275, 239, 67, 13);
		contentPane.add(lblNewLabel_8);
		
		New_Age = new JTextField();
		New_Age.setBounds(360, 236, 96, 19);
		contentPane.add(New_Age);
		New_Age.setColumns(10);
		
		// Change Age button and Action 
		JButton btnAge = new JButton("Change");
		btnAge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int NewAge = Integer.parseInt(New_Age.getText());  // getting the New Age from New_Age textfield
				int EmployeeID = Integer.parseInt(EmployeeID2.getText());  // Getting the Employee Id from EmployeeID2
				InHand.ChangeInstructorAge(EmployeeID, NewAge);  // calling change Age from the Instructor Handling 
			}
		});
		btnAge.setBounds(371, 265, 85, 21);
		contentPane.add(btnAge);
		
		JLabel lblNewLabel_9 = new JLabel("Change Type");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_9.setBounds(69, 311, 96, 13);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Employee ID");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10.setBounds(21, 341, 71, 13);
		contentPane.add(lblNewLabel_10);
		
		EmployeeID3 = new JTextField();
		EmployeeID3.setBounds(125, 338, 96, 19);
		contentPane.add(EmployeeID3);
		EmployeeID3.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("New Type");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11.setBounds(21, 375, 71, 13);
		contentPane.add(lblNewLabel_11);
		
		New_Type = new JTextField();
		New_Type.setBounds(125, 372, 96, 19);
		contentPane.add(New_Type);
		New_Type.setColumns(10);
		
		// Change Type and Action 
		JButton btnType = new JButton("Change");
		btnType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int EmployeeID = Integer.parseInt(EmployeeID3.getText()); // Getting the EmployeeId from the EmployeeID3
				String NewType = New_Type.getText();       // Getting New Type from New_type Textfield
				InHand.ChangeInstructorType(EmployeeID, NewType);  // Caling change Type from the Instructor Handling 
			}
		});
		btnType.setBounds(125, 401, 85, 21);
		contentPane.add(btnType);
		
		JLabel lblNewLabel_12 = new JLabel("Change Education");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_12.setBounds(308, 311, 103, 13);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Employee ID");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_13.setBounds(250, 341, 73, 13);
		contentPane.add(lblNewLabel_13);
		
		EmployeeID4 = new JTextField();
		EmployeeID4.setBounds(360, 338, 96, 19);
		contentPane.add(EmployeeID4);
		EmployeeID4.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("New Education");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_14.setBounds(250, 375, 100, 13);
		contentPane.add(lblNewLabel_14);
		
		NewEducation = new JTextField();
		NewEducation.setBounds(360, 372, 96, 19);
		contentPane.add(NewEducation);
		NewEducation.setColumns(10);
		
		// change Education and Action 
		JButton btnEducation = new JButton("Change");
		btnEducation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int EmployeeID = Integer.parseInt(EmployeeID4.getText()); // Getting Employee Id form the EmployeeID4  Textfield
				String New_Education = NewEducation.getText();    // Getting the New Education from NewEducation  Textfield
				InHand.ChangeInstructorEducation(EmployeeID, New_Education);  // Calling change Education from Instructor Handling 
			}
		});
		btnEducation.setBounds(371, 401, 85, 21);
		contentPane.add(btnEducation);
	}
}
