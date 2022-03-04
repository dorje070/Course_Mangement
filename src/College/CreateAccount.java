package College;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLClientInfoException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JPasswordField;
import java.awt.Font;

public class CreateAccount extends JFrame { // inhertiance the jframe of login 
	
	// TextField Panel and Checkbox of Create Account 
	private JPanel contentPane;
	private JTextField textFieldUN;

	private JCheckBox AdministratorCheck ;
	private JCheckBox InstructorCheck;
	private JCheckBox StudentCheck;
	
	private boolean repeat;
	private JPasswordField passwordField;
	

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccount frame = new CreateAccount();
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
	@SuppressWarnings("deprecation")
	public CreateAccount() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("username");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(57, 27, 74, 13);
		contentPane.add(lblNewLabel);
		
		textFieldUN = new JTextField();
		textFieldUN.setBounds(165, 24, 102, 26);
		contentPane.add(textFieldUN);
		textFieldUN.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(57, 80, 74, 18);
		contentPane.add(lblNewLabel_1);
		
		AdministratorCheck = new JCheckBox("Administrator");
		
		// Check box of Administrator and Action
		AdministratorCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(AdministratorCheck.isEnabled()) {   // if Administrator box is selected 
					InstructorCheck.setEnabled(false);  // set Instructor box enable false 
					StudentCheck.setEnabled(false);    // set Student box enable false
				}else {
					InstructorCheck.setEnabled(true);  // set Instructor box enable true
					StudentCheck.setEnabled(true);     // set Student box enable true
				}
				
			}
		});
		
		AdministratorCheck.setBounds(57, 146, 93, 21);
		
		contentPane.add(AdministratorCheck);
		
		// Check box of Instructor and Action
		InstructorCheck = new JCheckBox("Instructor");
		InstructorCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(InstructorCheck.isEnabled()) {         // if Instructor box is selected 
					AdministratorCheck.setEnabled(false);  // set Administrator box enable false 
					StudentCheck.setEnabled(false);        // set Student box enable false
				}else {
					AdministratorCheck.setEnabled(true);   // set Administrator box enable true
					StudentCheck.setEnabled(true);         // set Student box enable true
				}
			}
		});
		InstructorCheck.setBounds(197, 146, 93, 21);
		contentPane.add(InstructorCheck);
		
		// Check box of Student and Action
		StudentCheck = new JCheckBox("Student");
		StudentCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(StudentCheck.isEnabled()) {
					AdministratorCheck.setEnabled(false); // set Administrator box enable false 
					InstructorCheck.setEnabled(false);    // set Instructor box enable false 
				}else {
					AdministratorCheck.setEnabled(true);  // set Administrator box enable true
					InstructorCheck.setEnabled(true);    // set Instructor box enable true
				}
			}
		});
		StudentCheck.setBounds(319, 146, 93, 21);
		contentPane.add(StudentCheck);
		
		final AccontHandling Achand = new AccontHandling();  // Create Account HAS-A(Association) Account handling
		 final FileHandling fileh = new  FileHandling();     // Create Account HAS-A(Association) File handling
		 
		 // Btn Next and Action
		JButton btnNext = new JButton("Next");               
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(AdministratorCheck.isSelected()) { // if Adminstrator is Selected 
				
					String userName = textFieldUN.getText();  // Getting the username TextFieldUN TextField
				    String password = passwordField.getText();  // Getting the password from PasswordField
				    
				    // Create Account HAS-A(Association) Account
				    Account acc = new Account(userName, password, "Administrator"); 
				    
				    // Insert Account from Account handling 
				    Achand.insertAccount(acc.getUsername(), acc.getPassword(), acc.getType());
				    fileh.WriteUsername(userName); // Writing the Username in file from file handling 
				    Achand.ReadAccount();          //  Reading Account 
				    
				    // create Account HAS-A(Association) Administrator ifo 
				    Administratorinfo Ainfo = new Administratorinfo(); 
				    System.out.println("Admin true "+userName+ " "+password+" ");
				    // open the Administrator window 
				    Ainfo.setVisible(true);
				    
				    
				}else if(InstructorCheck.isSelected()) {       // if Instructor check is selected 
					String userName = textFieldUN.getText();  // Getting the username TextFieldUN TextField
					 String password = passwordField.getText();  // Getting the password from PasswordField
					 
					// Create Account HAS-A(Association) Account
					 Account acc = new Account(userName, password, "Instructor");
					 
					// Insert Account from Account handling 
					 Achand.insertAccount(acc.getUsername(), acc.getPassword(), acc.getType());
					 fileh.WriteUsername(userName);  // Writing the Username in file from file handling 
					 
					 // Create Account HAS-A(Association) Instructor info
					 Instructorinfo inSfo = new Instructorinfo();
					System.out.println("Instruc true "+userName+ " "+password+" ");
					
					// open the Instructor info window
					inSfo.setVisible(true);
					Achand.ReadAccount();
				}else if(StudentCheck.isSelected()) {
					String userName = textFieldUN.getText();   // Getting the username TextFieldUN TextField
					 String password = passwordField.getText();  // Getting the password from PasswordField
					 
					// Create Account HAS-A(Association) Account
					 Account acc = new Account(userName, password, "Student");
					 
					// Insert Account from Account handling 
					 Achand.insertAccount(acc.getUsername(), acc.getPassword(), acc.getType());
					 fileh.WriteUsername(userName);         // Writing the Username in file from file handling 
					 
					 // Create Account HAS-A(Association) Student info
					 Studentinfo stdfo = new Studentinfo();
					 
					 // open window of Student info
					 stdfo.setVisible(true);
					System.out.println("Student is true "+userName+ " "+password);
					Achand.ReadAccount();
				}
			}
		});
		btnNext.setBounds(176, 203, 85, 21);
		contentPane.add(btnNext);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(165, 72, 102, 26);
		contentPane.add(passwordField);
	}
}
