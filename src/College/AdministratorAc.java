package College;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AdministratorAc extends JFrame { // inhertiance the jframe of login 
	
	// Account of Administrator user
	private JPanel contentPane;
	private ArrayList<String> Adlist = new ArrayList<String>(); // Arraylist for Store the data of User
	private AccontHandling Achand = new AccontHandling(); // AdministratorAc HAS-A(Association) AccountHandling
	private FileHandling fileh = new FileHandling();      // AdministratorAc HAS-A (Association) FileHandling
	private AdministratorHandling Adha = new AdministratorHandling();  // AdministratorAc HAS-A (Association) AdministratorHandling
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministratorAc frame = new AdministratorAc();
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
	public AdministratorAc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		// label of Welcome User
		String Username = fileh.ReadUsername();  //  Reading the written username from Login and createAccoount
		int UserId = Achand.ReadId(Username);    //  Reading userId from the Account table of course database 
		Adlist = Adha.ReadAdmin(UserId);         //  Reading the all data of UserID Administrator table of course database
		System.out.println(Adlist);
		JLabel lblNewLabel = new JLabel("welcome "+Adlist.get(1)); // welcome User
		
		lblNewLabel.setBounds(183, 25, 110, 13);
		contentPane.add(lblNewLabel);
		
		// button of Module
		JButton btnModule = new JButton("Module");
		btnModule.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModuleOp MoOP = new ModuleOp();  //  AdministratorAc HAS-A(Association) Module opreation
				MoOP.setVisible(true);           //  Module operation window open
			}
		});
		btnModule.setBounds(53, 67, 85, 21);
		contentPane.add(btnModule);
		
		// button of Course
		JButton btnCourse = new JButton("Course");
		btnCourse.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CourseOp CouOp = new CourseOp(); //  AdministratorAc HAS-A(Association) Course opreation
				CouOp.setVisible(true);          //  Course operation window open
			}
		});
		btnCourse.setBounds(183, 67, 85, 21);
		contentPane.add(btnCourse);
		
		// button of Student
		JButton btnStudent = new JButton("Student");
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentAdop Stop = new StudentAdop(); //  AdministratorAc HAS-A(Association) Student Ad opreation
				Stop.setVisible(true);                //  student Ad operation window open
			}
		});
		btnStudent.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnStudent.setBounds(323, 67, 85, 21);       
		contentPane.add(btnStudent);
		
		// button of Instructor
		JButton btnInstructor = new JButton("Instructor");
		btnInstructor.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnInstructor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InstructorAdop Inop = new InstructorAdop(); //  AdministratorAc HAS-A(Association) Instructor Ad opreation
				Inop.setVisible(true);                      //  Instructor Ad op window open
			}
		});
		btnInstructor.setBounds(53, 124, 103, 21);
		contentPane.add(btnInstructor);
		
		// button of Administrator 
		JButton Administratorbtn = new JButton("Administrator");
		Administratorbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdministratorAdop Adop = new AdministratorAdop(); //  AdministratorAc HAS-A(Association) Administratot Ad opreation
				Adop.setVisible(true);                            //  Administraor Ad operation Window open
			}
		});
		Administratorbtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		Administratorbtn.setBounds(183, 124, 110, 21);
		contentPane.add(Administratorbtn);
		
		// button of Remark
		JButton btnRemark = new JButton("Remark");
		btnRemark.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRemark.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MarkAdop mkop = new MarkAdop();    //  AdministratorAc HAS-A(Association) ReMark Ad opreation
				mkop.setVisible(true);             //  ReMark opration window open
			}
		});
		btnRemark.setBounds(323, 124, 85, 21);
		contentPane.add(btnRemark);
	}

}
