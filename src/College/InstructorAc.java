package College;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InstructorAc extends JFrame { // inhertiance the jframe of login 
	
	// panel of Instructor Account 
	private JPanel contentPane;
	private InstructorHandling Inhand = new InstructorHandling(); // Instructor Account HAS-A(Association) Instructor Handling 
	private FileHandling fileh = new FileHandling();              // Instructor Account HAS-A(Association) File Handling 
	private AccontHandling Achand = new AccontHandling();         // INstructor Account HAS-A(Association) Account Handling 
	private ArrayList<String> Adlist = new ArrayList<String>();   // Arraylist for storing the data
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InstructorAc frame = new InstructorAc();
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
	public InstructorAc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		String UserName = fileh.ReadUsername();
		int UserID = Achand.ReadId(UserName);
		Adlist = Inhand.ReadInstr(UserID);
		
		// Instructor Account user
		JLabel lblNewLabel = new JLabel("Instructor Account "+Adlist.get(1));  // getting the user name
		
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(127, 10, 261, 24);
		contentPane.add(lblNewLabel);
		
		// Name : user
		JLabel NameLb = new JLabel("Name : "+Adlist.get(1));   // getting the user name 
		NameLb.setBounds(38, 51, 116, 13);
		contentPane.add(NameLb);
		
		// Age :  user 
		JLabel lblAge = new JLabel("Age : "+Adlist.get(2));  // getting the user Age 
		lblAge.setBounds(186, 51, 90, 13);
		contentPane.add(lblAge);
		
		// Type : user
		JLabel lblType = new JLabel("Type : "+Adlist.get(3));  // getting the user Type 
		lblType.setBounds(333, 51, 90, 13);
		contentPane.add(lblType);
		
		// Employee ID : user
		JLabel lblID = new JLabel("Employee ID : "+Adlist.get(0)); // getting the user employee id 
		lblID.setBounds(38, 86, 116, 13);
		contentPane.add(lblID);
		
		// Education : user
		JLabel lblEducation = new JLabel("Education : "+Adlist.get(4));  // getting the user education level
		lblEducation.setBounds(186, 86, 110, 13);
		contentPane.add(lblEducation);
		
		// buuton Set Mark and Action 
		JButton btnSetMark = new JButton("Set Mark");
		btnSetMark.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MarkAdop MarkSet = new MarkAdop();  // Instructor Account HAS-A(Association) Mark Ad operation  
				MarkSet.setVisible(true);    // open the Mark set Window 
			}
		});
		btnSetMark.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSetMark.setBounds(333, 82, 85, 21);
		contentPane.add(btnSetMark);
	}

}
