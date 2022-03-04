package College;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Studentinfo extends JFrame { // inhertiance the jframe of login
	
	// panel and textfield of student info 
	private JPanel contentPane;
	private JTextField UserName;
	private JTextField UserID;
	private JTextField UserAge;
	private JTextField UserAddress;
	private JTextField UserCourse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Studentinfo frame = new Studentinfo();
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
	public Studentinfo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 403, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(167, 10, 69, 28);
		contentPane.add(lblNewLabel);
		
		JLabel StdName = new JLabel("Name");
		StdName.setFont(new Font("Tahoma", Font.BOLD, 12));
		StdName.setBounds(60, 56, 45, 13);
		contentPane.add(StdName);
		
		UserName = new JTextField();
		UserName.setBounds(140, 53, 116, 19);
		contentPane.add(UserName);
		UserName.setColumns(10);
		
		JLabel Rollno = new JLabel("Roll no");
		Rollno.setFont(new Font("Tahoma", Font.BOLD, 12));
		Rollno.setBounds(60, 94, 45, 13);
		contentPane.add(Rollno);
		
		UserID = new JTextField();
		UserID.setBounds(140, 91, 116, 19);
		contentPane.add(UserID);
		UserID.setColumns(10);
		
		JLabel Age = new JLabel("Age");
		Age.setFont(new Font("Tahoma", Font.BOLD, 12));
		Age.setBounds(60, 127, 45, 13);
		contentPane.add(Age);
		
		UserAge = new JTextField();
		UserAge.setBounds(140, 124, 116, 19);
		contentPane.add(UserAge);
		UserAge.setColumns(10);
		
		JLabel Address = new JLabel("Address");
		Address.setFont(new Font("Tahoma", Font.BOLD, 12));
		Address.setBounds(60, 165, 70, 13);
		contentPane.add(Address);
		
		UserAddress = new JTextField();
		UserAddress.setBounds(140, 163, 116, 19);
		contentPane.add(UserAddress);
		UserAddress.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Course");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(60, 203, 45, 13);
		contentPane.add(lblNewLabel_5);
		
		UserCourse = new JTextField();
		UserCourse.setBounds(140, 200, 116, 19);
		contentPane.add(UserCourse);
		UserCourse.setColumns(10);
		// Student info HAS-A(Association) Account handling  
		final AccontHandling Achand = new AccontHandling();
		
		// Student info HAS-A(Association) File handling 
		final FileHandling fileh = new FileHandling();
		
		// Student info HAS-A(Association) student handling 
		final StudentHandling stdh = new StudentHandling();
		JButton btnNewButton = new JButton("Next");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Name = UserName.getText();  // Getting UserName from UserName TextField
				int Rollno =  Integer.parseInt(UserID.getText()); // Getting Rollno from UserID TextField
				int Age =  Integer.parseInt(UserAge.getText());  // Getting Age from UserAge TextField
				String Address = UserAddress.getText();         // Getting Address from UserAddress TextField
				String Course = UserCourse.getText();         // Getting Course from UserCourse TextField
				String Username = fileh.ReadUsername();    // Reading username from file which was written in create Account
				Achand.insertUserID(Username, Rollno);     // insert ID function of Account handling 
				
				// Student info HAS-A(Association) Student
				Students stds = new Students(Name, Rollno, Age, Address, Course);
				
				// insert student function from student handling 
				boolean execption = stdh.insertStudent(stds.getName(), stds.getRollno(), stds.getAge(), stds.getAddress(), stds.getCourseName());
				// if execption is false the open the window of Student Accout
				if(!execption) {
					// Student info HAS-A(Association) Student Account
					StudentAc StAc = new StudentAc();
					StAc.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(263, 248, 85, 21);
		contentPane.add(btnNewButton);
	}
}
