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

public class Instructorinfo extends JFrame { // inhertiance the jframe of login
	
	// jpanel and TextField of instructor info 
	private JPanel contentPane;
	private JTextField UserName;  
	private JTextField UserID;
	private JTextField UserAge;
	private JTextField UserType;
	private JTextField UserEducation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Instructorinfo frame = new Instructorinfo();
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
	public Instructorinfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Instructor");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(181, 20, 84, 33);
		contentPane.add(lblNewLabel);
		
		JLabel InstrName = new JLabel("Name");
		InstrName.setFont(new Font("Tahoma", Font.BOLD, 12));
		InstrName.setBounds(65, 76, 45, 13);
		contentPane.add(InstrName);
		
		UserName = new JTextField();
		UserName.setBounds(158, 74, 145, 19);
		contentPane.add(UserName);
		UserName.setColumns(10);
		
		JLabel EmployeeID = new JLabel("Employee ID");
		EmployeeID.setFont(new Font("Tahoma", Font.BOLD, 12));
		EmployeeID.setBounds(65, 112, 84, 13);
		contentPane.add(EmployeeID);
		
		UserID = new JTextField();
		UserID.setBounds(158, 110, 145, 19);
		contentPane.add(UserID);
		UserID.setColumns(10);
		
		JLabel Age = new JLabel("Age");
		Age.setFont(new Font("Tahoma", Font.BOLD, 12));
		Age.setBounds(65, 149, 45, 13);
		contentPane.add(Age);
		
		UserAge = new JTextField();
		UserAge.setBounds(158, 147, 145, 19);
		contentPane.add(UserAge);
		UserAge.setColumns(10);
		
		JLabel Type = new JLabel("Type");
		Type.setFont(new Font("Tahoma", Font.BOLD, 12));
		Type.setBounds(65, 187, 45, 13);
		contentPane.add(Type);
		
		UserType = new JTextField();
		UserType.setBounds(158, 185, 145, 19);
		contentPane.add(UserType);
		UserType.setColumns(10);
		
		JLabel Education = new JLabel("Education");
		Education.setFont(new Font("Tahoma", Font.BOLD, 12));
		Education.setBounds(65, 220, 83, 13);
		contentPane.add(Education);
		
		UserEducation = new JTextField();
		UserEducation.setBounds(158, 218, 145, 19);
		contentPane.add(UserEducation);
		UserEducation.setColumns(10);
		
		final AccontHandling Achand = new AccontHandling();
		final FileHandling fileh = new FileHandling();
		final InstructorHandling inHand = new InstructorHandling();
		
		// next button and Action 
		JButton Next_btn = new JButton("Next");
		Next_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Name = UserName.getText();   // Getting the name from UserName TextField
				int EmployeeID = Integer.parseInt(UserID.getText()); // Getting the Id from UserID TextField
				int Age = Integer.parseInt(UserAge.getText()); // Getting the Type from UserAge TextField
				String Type = UserType.getText();  // Getting the Type from UserType TextField
				String Education = UserEducation.getText(); // Getting the Education from UserEducation TextField
				String username = fileh.ReadUsername();   // Read username from file which was written in Ceate Account 
				Achand.insertUserID(username, EmployeeID); // insert Id function from Account Handling
				// Instructor info HAS-A(Association) Instructor 
				Instructor Instru = new Instructor(Name, EmployeeID, Age, Type, Education);
				
				// insert instructor function from instructr handling 
				boolean exception = inHand.insertInstructor(Instru.getName(), Instru.getEmployeeID(), Instru.getAge(), Instru.getType(), Instru.getEducation());
				
				// if execption is false than open window of Instructor Account 
				if(!exception) {
					// Instructor info HAS-A(Association) Instructor Account
					InstructorAc InAc = new InstructorAc();
					InAc.setVisible(true);
				}
			}
		});
		Next_btn.setFont(new Font("Tahoma", Font.BOLD, 11));
		Next_btn.setBounds(319, 287, 85, 21);
		contentPane.add(Next_btn);
	}

}
