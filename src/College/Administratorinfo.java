package College;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Administratorinfo extends JFrame {  // inhertance of Jframe of login

	private JPanel contentPane;           // content plane of Administrator info
	private JTextField UserName;          // TextField of UserName 
	private JTextField UserID;            // TextField of UserId
	private JTextField UserAge;           // TextField of UserAge
	private JTextField UserType;          // TextField of UserType
	private JTextField UserEducation;     // TextField of UserEducation

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administratorinfo frame = new Administratorinfo();
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
	public Administratorinfo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 349, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Administrator");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(169, 10, 98, 37);
		contentPane.add(lblNewLabel);
		
		JLabel AdminName = new JLabel("Name");
		AdminName.setFont(new Font("Tahoma", Font.BOLD, 12));
		AdminName.setBounds(38, 67, 45, 13);
		contentPane.add(AdminName);
		
		UserName = new JTextField();
		UserName.setBounds(149, 65, 147, 19);
		contentPane.add(UserName);
		UserName.setColumns(10);
		
		JLabel EmployeeID = new JLabel("Empoyee ID");
		EmployeeID.setFont(new Font("Tahoma", Font.BOLD, 12));
		EmployeeID.setBounds(38, 105, 80, 13);
		contentPane.add(EmployeeID);
		
		UserID = new JTextField();
		UserID.setBounds(149, 103, 147, 19);
		contentPane.add(UserID);
		UserID.setColumns(10);
		
		JLabel Age = new JLabel("Age");
		Age.setFont(new Font("Tahoma", Font.BOLD, 12));
		Age.setBounds(38, 145, 45, 13);
		contentPane.add(Age);
		
		UserAge = new JTextField();
		UserAge.setBounds(149, 143, 147, 19);
		contentPane.add(UserAge);
		UserAge.setColumns(10);
		
		JLabel Type = new JLabel("Type");
		Type.setFont(new Font("Tahoma", Font.BOLD, 12));
		Type.setBounds(38, 182, 45, 13);
		contentPane.add(Type);
		
		UserType = new JTextField();
		UserType.setBounds(149, 179, 147, 19);
		contentPane.add(UserType);
		UserType.setColumns(10);
		
		JLabel Education = new JLabel("Education");
		Education.setFont(new Font("Tahoma", Font.BOLD, 12));
		Education.setBounds(38, 221, 80, 13);
		contentPane.add(Education);
		
		UserEducation = new JTextField();
		UserEducation.setBounds(149, 218, 147, 19);
		contentPane.add(UserEducation);
		UserEducation.setColumns(10);
		
		final AccontHandling Achand = new AccontHandling();
		final FileHandling fileh = new FileHandling();
		final AdministratorHandling AdHand = new  AdministratorHandling();
		
		// Next button and Action
		JButton Next_btn = new JButton("Next");
		Next_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Name = UserName.getText();                       // Getting Name from the UserName TextField
				int EmployeeID = Integer.parseInt(UserID.getText());    // Getting Employee ID from the Employee TextField 
				int Age = Integer.parseInt(UserAge.getText());          // Getting Age from UserAge TextField
				String Type = UserType.getText();                       // Getting Type from UserType TextField
				String Education = UserEducation.getText();             // Getting Education from UserEducation TextField 
				String username = fileh.ReadUsername();                 // Reading the written Username from Create Account
				Achand.insertUserID(username, EmployeeID);              // Insert the Employee Id into Account table User Id
				Administrator Admin = new Administrator(Name, EmployeeID, Age, Type, username);  // Administratorinfo HAS-A(Association) Administrator
				
				// calling Administrator Handling insert function 
				boolean exception = AdHand.insertAdministrator(Admin.getName(), Admin.getEmployeeID(), Admin.getAge(), Admin.getType(), Admin.getEducation());
				// check the exception while inserting the data 
				if(!exception) {                          
					AdministratorAc AdminAc = new AdministratorAc();  //Administratorinfo HAS-A(Association) Administrator Account
					AdminAc.setVisible(true);  // open the Administrator Account window
				}
			}
		});
		Next_btn.setFont(new Font("Tahoma", Font.BOLD, 11));
		Next_btn.setBounds(206, 279, 85, 21);
		contentPane.add(Next_btn);
	}
}
