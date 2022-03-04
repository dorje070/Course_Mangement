package College;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Login {
	// Main function 
	
	// url and username ,password and url of mysql 
	private String url = "jdbc:mysql://localhost:3306/College";
    private String username = "root";
    private String password = "dorje070";

	private JFrame frame;
	
	
	private JTextField textFieldUN;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private Account acc;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// Login HAS-A(Association) Data Handling 
		DataHandling handing = new DataHandling();
		handing.createBase();  // Create the base with Data Handling 
		
		// Login HAS-A(Association) Student Handling 
		StudentHandling sthand = new StudentHandling();
		sthand.createStudentTable(); // Create Student table 
		
		// Login HAS-A(Association) Administrator Handling 
		AdministratorHandling Adhand = new AdministratorHandling();
		Adhand.createAdministratorTable(); // Create Administrator table 
		
		// Login HAS-A(Association) Instructor Handling 
		InstructorHandling Inhand = new InstructorHandling();
		Inhand.createInstructorTable();  // Create Instructor Table 
		
		// Login HAS-A(Association) Module Handling 
		ModuleHandling Mohand = new ModuleHandling();
		Mohand.createModuleTable();  // Create Module table 
		
		// Login HAS-A(Association) Course Handling 
		CourseHandling Cohand = new CourseHandling();
		Cohand.createCourseTable(); // Create Course table 
		
		// Login HAS-A(Association) Semester handling 
		SemesterHandling sehand = new SemesterHandling();
		sehand.createSemesterTable(); // Create Semester table 
		
		// Login HAS-A(Association) Account handling 
		AccontHandling athand = new AccontHandling();
        athand.createAccountTable();  // Create Account table 
        
        
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("username");
		lblNewLabel.setBounds(217, 55, 58, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(217, 110, 58, 21);
		frame.getContentPane().add(lblNewLabel_1);
		
		textFieldUN = new JTextField();
		textFieldUN.setBounds(298, 56, 96, 19);
		frame.getContentPane().add(textFieldUN);
		textFieldUN.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(298, 111, 96, 19);
		frame.getContentPane().add(passwordField);
		
		// Create Button and Action 
		JButton btncreate = new JButton("Create Account");
		Image img3 = new ImageIcon(this.getClass().getResource("/Create.png")).getImage(); // import Create png
		btncreate.setIcon(new ImageIcon(img3));  // display the image 
		btncreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				// Login HAS-A(Association) Create Account 
				CreateAccount creaAcc = new CreateAccount();
				creaAcc.setVisible(true); // Open the Window of Create Account 
			}
		});
		btncreate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btncreate.setBounds(255, 213, 156, 21);
		frame.getContentPane().add(btncreate);
		
		// Login button and Action 
		JButton btnLogin = new JButton("Login");
		Image img1 = new ImageIcon(this.getClass().getResource("/ok.png")).getImage();  // import ok png 
		btnLogin.setIcon(new ImageIcon(img1));   // display the image 
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Reading the data fom Account table 
					try{
						//load the driver
						Class.forName("com.mysql.jdbc.Driver");


			            //create the connection
			            Connection connect = DriverManager.getConnection(url,username,password);

			            //create the query
			            String query = "SELECT * FROM Account";

			            //create the statement
			            Statement statement = connect.createStatement();
			            ResultSet set = statement.executeQuery(query);
			            
			            FileHandling  fileh = new FileHandling();
			            
			            while(set.next()){
			                System.out.println(set.getString("username")+" "+set.getString("password") + " "+ set.getString("Type"));
			             
			                // Login HAS-A(Association) Account 
			                 acc = new Account(set.getString("username"),set.getString("password"),set.getString("Type"));
			                 
			                String userName = textFieldUN.getText(); // Getting Name from TexTFieldUN TextField
			                String type = acc.getType();             // Getting Type from acc TextField
			                String pass = passwordField.getText();   // Getting password from PasswordField 
			                
			                // Checking the username , password and type
			                if(userName.equals(acc.getUsername())&& pass.equals(acc.getPassword())&&type.equals("Administrator")){
			                	fileh.WriteUsername(userName); // Write the username from fileHandling 
			                	System.out.println("correct"); 
			                	// Login HAS-A(Association) Administrator Account 
			                	AdministratorAc AdmAc = new AdministratorAc();
			                	AdmAc.setVisible(true); // Open the Window of  Administrator Account 
			            	
			                	frame.dispose(); // dispose login
			                	
			                }else if(userName.equals(acc.getUsername())&& pass.equals(acc.getPassword())&&type.equals("Instructor")){
			                	fileh.WriteUsername(userName); // Write the username from fileHandling 
			                	frame.dispose(); // dispose login
			                	// Login HAS-A(Association) Instructor Account 
			                	InstructorAc inSAc = new InstructorAc();
			                	inSAc.setVisible(true); // Open the Window of Instructor Account 
			       
			                }else if(userName.equals(acc.getUsername())&& pass.equals(acc.getPassword())&&type.equals("Student")) {
			                	fileh.WriteUsername(userName); // Write the username from fileHandling 
			                	frame.dispose();  // dispose login
			                	// Login HAS-A(Association) Student Account 
			                	 StudentAc stdAc = new StudentAc();
								 stdAc.setVisible(true); // Open the Window of Student Account 
			                }
		
			            }
			            //close the statment
			            connect.close();
			        }catch (Exception exp){
			            JOptionPane.showMessageDialog(null, exp);
			        }
			}
		});
		btnLogin.setBounds(285, 162, 96, 21);
		frame.getContentPane().add(btnLogin);
		
		lblNewLabel_2 = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/Login.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img2));
		
		lblNewLabel_2.setBounds(31, 55, 136, 167);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("OR");
		lblNewLabel_3.setBounds(331, 193, 45, 13);
		frame.getContentPane().add(lblNewLabel_3);
	}
}
