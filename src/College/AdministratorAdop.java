package College;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JButton;
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

public class AdministratorAdop extends JFrame {  // inhertiance the jframe of login 
	
	// Administrator operation of AdministratorAc 
	private JPanel contentPane;
	private JTable table;
	
	// password, username and url of my sql data
	private String url = "jdbc:mysql://localhost:3306/College";
    private String username = "root";
    private String password = "dorje070";
    
    // button, JTextField and label of Administrator operation
    private JButton btnAdd;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JTextField DelEID;
    private JLabel lblNewLabel_2;
    private JTextField User_name;
    private JButton btnDelete;
    
    
    private AdministratorHandling Adhand = new AdministratorHandling(); //AdministratorAdop HAS-A(Association) AdministratorHandling 
    private AccontHandling Achand = new AccontHandling();  //  AdministratorAdop HAS-A(Association) AccountHandling
    
    // button, JTextField and label of Administrator operation
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JTextField EmployeeID1;
    private JLabel lblNewLabel_5;
    private JTextField New_Name;
    private JButton btnName;
    private JLabel lblNewLabel_6;
    private JLabel lblNewLabel_7;
    private JLabel lblNewLabel_8;
    private JTextField Employee2;
    private JTextField New_Age;
    private JButton btnAge;
    private JLabel lblNewLabel_9;
    private JLabel lblNewLabel_10;
    private JTextField Employee3;
    private JTextField New_type;
    private JButton btnType;
    private JLabel lblNewLabel_11;
    private JLabel lblNewLabel_12;
    private JLabel lblNewLabel_13;
    private JTextField Employee4;
    private JTextField New_Education;
    private JLabel lblNewLabel_14;
    private JButton btnEducation;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministratorAdop frame = new AdministratorAdop();
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
	public AdministratorAdop() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 893, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(493, 45, 361, 379);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		// load button and Action 
		JButton btnLoad = new JButton("Load Administrator");
		btnLoad.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		            //load the driver
		            Class.forName("com.mysql.jdbc.Driver");


		            //create the connection
		            Connection connect = DriverManager.getConnection(url,username,password);

		            //create the query
		            String query = "SELECT * FROM Administrator";

		            //create the statement
		            Statement statement = connect.createStatement();
		            ResultSet set = statement.executeQuery(query);
		            table.setModel(DbUtils.resultSetToTableModel(set)); // using the DbUtils function which is store Resourse folder 
		                                                                // Add the buidling path of Resourse folder
		            
		            //close the statment
		            connect.close();

		        }catch (Exception exp){
		            System.out.println(exp);
		        }
			}
		});
		btnLoad.setBounds(609, 14, 154, 21);
		contentPane.add(btnLoad);
		
		// Add button and Action
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateAccount crAc = new CreateAccount();  // Administrator operation HAS-A(Association) Account
				crAc.setVisible(true);                     // open window of create Account 
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAdd.setBounds(649, 434, 85, 21);
		contentPane.add(btnAdd);
		
		lblNewLabel = new JLabel("Delete");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(58, 47, 68, 13);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Employee ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(24, 79, 78, 13);
		contentPane.add(lblNewLabel_1);
		
		DelEID = new JTextField();
		DelEID.setBounds(112, 76, 109, 19);
		contentPane.add(DelEID);
		DelEID.setColumns(10);
		
		lblNewLabel_2 = new JLabel("User Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(24, 114, 78, 13);
		contentPane.add(lblNewLabel_2);
		
		User_name = new JTextField();
		User_name.setBounds(112, 111, 109, 19);
		contentPane.add(User_name);
		User_name.setColumns(10);
		
		// button of Delete
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int DeleteId = Integer.parseInt(DelEID.getText()); // getting Id from DeleteId textfield
				String Username = User_name.getText();             // getting the username from textfield
				Adhand.DeleteAdministrator(DeleteId);              // using delete function of Administrator Handling 
				Achand.DeleteAccount(Username);                    // using delete function of Account Handling
			}
		});
		btnDelete.setBounds(122, 140, 85, 21);
		contentPane.add(btnDelete);
		
		lblNewLabel_3 = new JLabel("Change name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(58, 205, 95, 13);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Employee ID");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(24, 228, 78, 13);
		contentPane.add(lblNewLabel_4);
		
		EmployeeID1 = new JTextField();
		EmployeeID1.setBounds(125, 228, 96, 19);
		contentPane.add(EmployeeID1);
		EmployeeID1.setColumns(10);
		
		lblNewLabel_5 = new JLabel("New Name");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(24, 260, 72, 13);
		contentPane.add(lblNewLabel_5);
		
		New_Name = new JTextField();
		New_Name.setBounds(122, 257, 102, 19);
		contentPane.add(New_Name);
		New_Name.setColumns(10);
		
		// button of change Name
		btnName = new JButton("Change");
		btnName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NewName = New_Name.getText();                    // getting New name from New_Name textfield
				int Employee = Integer.parseInt(EmployeeID1.getText()); // getting Employee Id from EmployeeID1 textfield
				Adhand.ChangeAdministratorName(Employee, NewName);      // change New Name function of Asministrator Handling
			}
		});
		btnName.setBounds(122, 286, 85, 21);
		contentPane.add(btnName);
		
		lblNewLabel_6 = new JLabel("Change Age");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(294, 205, 85, 13);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Employee ID");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBounds(251, 228, 71, 13);
		contentPane.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("New Age");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8.setBounds(251, 260, 71, 13);
		contentPane.add(lblNewLabel_8);
		
		Employee2 = new JTextField();
		Employee2.setBounds(343, 225, 96, 19);
		contentPane.add(Employee2);
		Employee2.setColumns(10);
		
		New_Age = new JTextField();
		New_Age.setBounds(343, 257, 96, 19);
		contentPane.add(New_Age);
		New_Age.setColumns(10);
		
		// button of Change Age 
		btnAge = new JButton("Change");
		btnAge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int NewAge = Integer.parseInt(New_Age.getText());     // getting NewAge from the New_Age Textfield
				int Employee = Integer.parseInt(Employee2.getText()); // getting EmployeeID from EmployeeID TextField 
				Adhand.ChangeAdministratorAge(Employee, NewAge);      // Change Age function of Administrator Handling
				
			}
		});
		btnAge.setBounds(343, 286, 85, 21);
		contentPane.add(btnAge);
		
		lblNewLabel_9 = new JLabel("Change Type");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_9.setBounds(69, 345, 84, 13);
		contentPane.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("Employee ID");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10.setBounds(24, 366, 78, 13);
		contentPane.add(lblNewLabel_10);
		
		Employee3 = new JTextField();
		Employee3.setBounds(125, 363, 96, 19);
		contentPane.add(Employee3);
		Employee3.setColumns(10);
		
		New_type = new JTextField();
		New_type.setBounds(125, 392, 96, 19);
		contentPane.add(New_type);
		New_type.setColumns(10);
		
		// button of Change Employee 
		btnType = new JButton("Change");
		btnType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NewType = New_type.getText();                  // getting NewType from New_type TextField
				int Employee = Integer.parseInt(Employee3.getText()); // getting Employee Id from Employee3 TextField
				Adhand.ChangeAdministratorType(Employee, NewType);    // change Type function of Administrator Handling
			}
		});
		btnType.setBounds(136, 418, 85, 21);
		contentPane.add(btnType);
		
		lblNewLabel_11 = new JLabel("New Type");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11.setBounds(24, 398, 78, 13);
		contentPane.add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel("Change Education");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_12.setBounds(294, 345, 120, 13);
		contentPane.add(lblNewLabel_12);
		
		lblNewLabel_13 = new JLabel("Employee ID");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_13.setBounds(251, 366, 82, 13);
		contentPane.add(lblNewLabel_13);
		
		Employee4 = new JTextField();
		Employee4.setBounds(366, 363, 96, 19);
		contentPane.add(Employee4);
		Employee4.setColumns(10);
		
		New_Education = new JTextField();
		New_Education.setBounds(366, 392, 96, 19);
		contentPane.add(New_Education);
		New_Education.setColumns(10);
		
		lblNewLabel_14 = new JLabel("New Education");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_14.setBounds(251, 395, 105, 13);
		contentPane.add(lblNewLabel_14);
		
		// button of Change Education 
		btnEducation = new JButton("Change");
		btnEducation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NewEducation = New_Education.getText();                  // getting NewEducation from New_Education TextField
				int Employee = Integer.parseInt(Employee4.getText());           // getting Employee Id from Employee4 TextField
				Adhand.ChangeAdministratorEducation(Employee, NewEducation);    // Change Education from Administrator Handling 
			}
		});
		btnEducation.setBounds(377, 418, 85, 21);
		contentPane.add(btnEducation);
	}
}
