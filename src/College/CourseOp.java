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
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class CourseOp extends JFrame {  // inhertiance the jframe of login 
	// username, password and url of mysql database
	private String url = "jdbc:mysql://localhost:3306/College";
    private String username = "root";
    private String password = "dorje070";
    
    // content pane and table of Course operation
	private JPanel contentPane;
	private JTable table;
	private CourseHandling Chand = new CourseHandling();
	private JTextField Module1;
	private JTextField Module5;
	private JTextField Module2;
	private JTextField Module6;
	private JTextField Module3;
	private JTextField Module7;
	private JTextField Module4;
	private JTextField CourseName;
	private JTextField Cha_Module1;
	private JTextField oldName1;
	private JTextField Cha_Module2;
	private JTextField oldName2;
	private JTextField Cha_Module3;
	private JTextField oldName3;
	private JTextField Cha_Module4;
	private JTextField oldName4;
	private JTextField Cha_Module5;
	private JTextField OldName5;
	private JTextField Cha_Module6;
	private JTextField Old_Name6;
	private JTextField Cha_Module7;
	private JTextField OldName7;
	private JTextField DetName;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourseOp frame = new CourseOp();
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
	public CourseOp() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1321, 668);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(688, 60, 583, 545);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		// load button and action 
		JButton loadBtn = new JButton("Load Course");
		loadBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		            //load the driver
		            Class.forName("com.mysql.jdbc.Driver");


		            //create the connection
		            Connection connect = DriverManager.getConnection(url,username,password);

		            //create the query
		            String query = "SELECT * FROM Course";

		            //create the statement
		            Statement statement = connect.createStatement();
		            ResultSet set = statement.executeQuery(query);
		            table.setModel(DbUtils.resultSetToTableModel(set)); // set table with DbUtils function of Resourse folder
		                                                                // Resourse folder contain r2xml.jar and connect build path the jar
		            
		            //close the statment
		            connect.close();

		        }catch (Exception exp){
		            System.out.println(exp);
		        }
			}
		});
		loadBtn.setBounds(913, 21, 123, 21);
		contentPane.add(loadBtn);
		
		JLabel lblModule1 = new JLabel("Module1");
		lblModule1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblModule1.setBounds(10, 50, 72, 13);
		contentPane.add(lblModule1);
		
		Module1 = new JTextField();
		Module1.setBounds(92, 47, 96, 19);
		contentPane.add(Module1);
		Module1.setColumns(10);
		
		Module5 = new JTextField();
		Module5.setBounds(326, 47, 96, 19);
		contentPane.add(Module5);
		Module5.setColumns(10);
		
		JLabel lbModule5 = new JLabel("Module5");
		lbModule5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbModule5.setBounds(231, 50, 62, 13);
		contentPane.add(lbModule5);
		
		JLabel lblModule2 = new JLabel("Module2");
		lblModule2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblModule2.setBounds(10, 80, 72, 13);
		contentPane.add(lblModule2);
		
		Module2 = new JTextField();
		Module2.setBounds(92, 76, 96, 19);
		contentPane.add(Module2);
		Module2.setColumns(10);
		
		JLabel lbModule6 = new JLabel("Module6");
		lbModule6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbModule6.setBounds(231, 80, 62, 13);
		contentPane.add(lbModule6);
		
		Module6 = new JTextField();
		Module6.setBounds(326, 76, 96, 19);
		contentPane.add(Module6);
		Module6.setColumns(10);
		
		JLabel lbModule3 = new JLabel("Module3");
		lbModule3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbModule3.setBounds(10, 108, 62, 13);
		contentPane.add(lbModule3);
		
		Module3 = new JTextField();
		Module3.setBounds(92, 105, 96, 19);
		contentPane.add(Module3);
		Module3.setColumns(10);
		
		JLabel lblModule7 = new JLabel("Module7");
		lblModule7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblModule7.setBounds(231, 108, 62, 13);
		contentPane.add(lblModule7);
		
		Module7 = new JTextField();
		Module7.setBounds(326, 100, 96, 19);
		contentPane.add(Module7);
		Module7.setColumns(10);
		
		JLabel lbModule4 = new JLabel("Module4");
		lbModule4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbModule4.setBounds(10, 141, 62, 13);
		contentPane.add(lbModule4);
		
		Module4 = new JTextField();
		Module4.setBounds(92, 138, 96, 19);
		contentPane.add(Module4);
		Module4.setColumns(10);
		
		// Add button and Action
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String module1St = Module1.getText(); // Getting Module1 from the Module1 TextField
				String module2St = Module2.getText(); // Getting Module2 from the Module2 TextField
				String module3St = Module3.getText(); // Getting Module3 from the Module3 TextField
				String module4St = Module4.getText(); // Getting Module4 from the Module4 TextField 
				String module5St = Module5.getText(); // Getting Module5 from the Module5 TextField
				String module6St = Module6.getText(); // Getting Module6 from the Module6 TextField
				String module7St = Module7.getText(); // Getting Module7 from the Module7 TextField
				String Name = CourseName.getText();   // Getting Course name from the CourseName TextField
				// CourseOp HAS-A(Association) Course
				Courses course = new Courses(Name, module1St, module2St, module3St, module4St, module5St, module6St, module7St);
				// calling insert Course function from Course Handling
				Chand.insertCourse(course.getCoursename(), course.getModule1(), course.getModule2(), course.getModule3(), course.getModule4(), course.getModule5(), course.getModule6(), course.getModule7());
			}
		});
		btnAdd.setBounds(92, 178, 85, 21);
		contentPane.add(btnAdd);
		
		JLabel lblNewLabel = new JLabel("Course name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(231, 141, 85, 13);
		contentPane.add(lblNewLabel);
		
		CourseName = new JTextField();
		CourseName.setBounds(326, 138, 96, 19);
		contentPane.add(CourseName);
		CourseName.setColumns(10);
		
		JLabel lbChaModule1 = new JLabel("Module1");
		lbChaModule1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbChaModule1.setBounds(10, 268, 58, 13);
		contentPane.add(lbChaModule1);
		
		Cha_Module1 = new JTextField();
		Cha_Module1.setBounds(112, 265, 96, 19);
		contentPane.add(Cha_Module1);
		Cha_Module1.setColumns(10);
		
		JLabel Cha_Name1 = new JLabel("Course name");
		Cha_Name1.setFont(new Font("Tahoma", Font.BOLD, 11));
		Cha_Name1.setBounds(10, 291, 92, 13);
		contentPane.add(Cha_Name1);
		
		oldName1 = new JTextField();
		oldName1.setBounds(112, 288, 96, 19);
		contentPane.add(oldName1);
		oldName1.setColumns(10);
		
		// Change Module1 btn and Action
		JButton btnChange1 = new JButton("Change");
		btnChange1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NewModule1 = Cha_Module1.getText();  // Getting the New Module1 from Cha_Module1 TextField
				String CName = oldName1.getText();          // Getting Course name from the OldName1 TextField
				Chand.ChangeModule1(NewModule1, CName);     // Calling ChangeModule1 function from Course Handling 
			}
		});
		btnChange1.setBounds(103, 317, 85, 21);
		contentPane.add(btnChange1);
		
		JLabel lblNewModule1 = new JLabel("Change Module1");
		lblNewModule1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewModule1.setBounds(92, 242, 105, 13);
		contentPane.add(lblNewModule1);
		
		JLabel lblNewLabel_1 = new JLabel("Module2");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(231, 268, 62, 13);
		contentPane.add(lblNewLabel_1);
		
		Cha_Module2 = new JTextField();
		Cha_Module2.setBounds(326, 265, 96, 19);
		contentPane.add(Cha_Module2);
		Cha_Module2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Course name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(231, 291, 81, 13);
		contentPane.add(lblNewLabel_2);
		
		oldName2 = new JTextField();
		oldName2.setBounds(326, 288, 96, 19);
		contentPane.add(oldName2);
		oldName2.setColumns(10);
		
		// Change Module2 btn and Action
		JButton btnChange2 = new JButton("Change");
		btnChange2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String CHModule2 = Cha_Module2.getText(); // Getting the New Module2 from Cha_Module2 TextField
				String oldName = oldName2.getText();      // Getting Course name from the OldName2 TextField
				Chand.ChangeModule2(CHModule2, oldName);  // Calling ChangeModule2 function from Course Handling 
			}
		});
		btnChange2.setBounds(337, 317, 85, 21);
		contentPane.add(btnChange2);
		
		JLabel lbChange2 = new JLabel("Change Module2");
		lbChange2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbChange2.setBounds(279, 242, 115, 13);
		contentPane.add(lbChange2);
		
		JLabel lblNewLabel_3 = new JLabel("Module3");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(443, 268, 72, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Change Module3");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(512, 242, 105, 13);
		contentPane.add(lblNewLabel_4);
		
		Cha_Module3 = new JTextField();
		Cha_Module3.setBounds(549, 265, 96, 19);
		contentPane.add(Cha_Module3);
		Cha_Module3.setColumns(10);
		
		oldName3 = new JTextField();
		oldName3.setBounds(549, 288, 96, 19);
		contentPane.add(oldName3);
		oldName3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Course name");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(443, 291, 96, 13);
		contentPane.add(lblNewLabel_5);
		
		// Change Module3 btn and Action
		JButton btnchange3 = new JButton("Change");
		btnchange3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String chModule3 = Cha_Module3.getText();   // Getting the New Module3 from Cha_Module3 TextField
				String oldName = oldName3.getText();        // Getting Course name from the OldName3 TextField
				Chand.ChangeModule3(chModule3, oldName);    // Calling ChangeModule3 function from Course Handling 
			}
		});
		btnchange3.setBounds(549, 317, 85, 21);
		contentPane.add(btnchange3);
		
		JLabel lblNewLabel_6 = new JLabel("Change Module4");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(78, 359, 110, 13);
		contentPane.add(lblNewLabel_6);
		
		
		Cha_Module4 = new JTextField();
		Cha_Module4.setBounds(112, 382, 96, 19);
		contentPane.add(Cha_Module4);
		Cha_Module4.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Module4");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBounds(10, 385, 75, 13);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Course name");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8.setBounds(10, 408, 92, 13);
		contentPane.add(lblNewLabel_8);
		
		oldName4 = new JTextField();
		oldName4.setBounds(112, 411, 96, 19);
		contentPane.add(oldName4);
		oldName4.setColumns(10);
		
		// Change Module4 btn and Action
		JButton btnChange4 = new JButton("change");
		btnChange4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cHModule4 = Cha_Module4.getText();  // Getting the New Module4 from Cha_Module4 TextField
				String OldName = oldName4.getText();       // Getting Course name from the OldName4 TextField
				Chand.ChangeModule4(cHModule4, OldName);   // Calling ChangeModule4 function from Course Handling 
				
			}
		});
		btnChange4.setBounds(112, 440, 85, 21);
		contentPane.add(btnChange4);
		
		JLabel lblNewLabel_9 = new JLabel("Change Module5");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_9.setBounds(307, 359, 115, 13);
		contentPane.add(lblNewLabel_9);
		
		Cha_Module5 = new JTextField();
		Cha_Module5.setBounds(336, 382, 96, 19);
		contentPane.add(Cha_Module5);
		Cha_Module5.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Module5");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10.setBounds(231, 385, 63, 13);
		contentPane.add(lblNewLabel_10);
		
		OldName5 = new JTextField();
		OldName5.setBounds(337, 405, 96, 19);
		contentPane.add(OldName5);
		OldName5.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Course name");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11.setBounds(231, 414, 85, 13);
		contentPane.add(lblNewLabel_11);
		
		// Change Module5 btn and Action
		JButton btnChange5 = new JButton("Change");
		btnChange5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String CHModule5 = Cha_Module5.getText();  // Getting the New Module5 from Cha_Module5 TextField
				String oldName = OldName5.getText();       // Getting Course name from the OldName5 TextField
				Chand.ChangeModule5(CHModule5, oldName);   // Calling ChangeModule5 function from Course Handling 
			}
		});
		btnChange5.setBounds(347, 440, 85, 21);
		contentPane.add(btnChange5);
		
		Cha_Module6 = new JTextField();
		Cha_Module6.setBounds(549, 382, 96, 19);
		contentPane.add(Cha_Module6);
		Cha_Module6.setColumns(10);
		
		Old_Name6 = new JTextField();
		Old_Name6.setBounds(549, 411, 96, 19);
		contentPane.add(Old_Name6);
		Old_Name6.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Module6");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_12.setBounds(454, 385, 85, 13);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Course name");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_13.setBounds(454, 414, 85, 13);
		contentPane.add(lblNewLabel_13);
		
		// Change Module6 btn and Action
		JButton Change6 = new JButton("Change");
		Change6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String neModule6 = Cha_Module6.getText();    // Getting the New Module6 from Cha_Module6 TextField
				String oldName = Old_Name6.getText();        // Getting Course name from the OldName6 TextField
				Chand.ChangeModule6(neModule6, oldName);     // Calling ChangeModule6 function from Course Handling
			}
		});
		Change6.setBounds(560, 440, 85, 21);
		contentPane.add(Change6);
		
		JLabel lblNewLabel_14 = new JLabel("Change Module6");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_14.setBounds(512, 359, 105, 13);
		contentPane.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Change Module7");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_15.setBounds(72, 483, 105, 13);
		contentPane.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Module7");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_16.setBounds(20, 509, 62, 13);
		contentPane.add(lblNewLabel_16);
		
		Cha_Module7 = new JTextField();
		Cha_Module7.setBounds(112, 506, 96, 19);
		contentPane.add(Cha_Module7);
		Cha_Module7.setColumns(10);
		
		OldName7 = new JTextField();
		OldName7.setBounds(112, 535, 96, 19);
		contentPane.add(OldName7);
		OldName7.setColumns(10);
		
		JLabel lblNewLabel_17 = new JLabel("Course name");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_17.setBounds(10, 538, 92, 13);
		contentPane.add(lblNewLabel_17);
		
		// Change Module7 btn and Action
		JButton Change7 = new JButton("Change");
		Change7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String CHModule7 = Cha_Module7.getText();    // Getting the New Module7 from Cha_Module7 TextField
				String OldName = OldName7.getText();         // Getting Course name from the OldName7 TextField
				Chand.ChangeModule7(CHModule7, OldName);     // Calling ChangeModule7 function from Course Handling
			}
		});
		Change7.setBounds(123, 568, 85, 21);
		contentPane.add(Change7);
		
		JLabel lblNewLabel_18 = new JLabel("Delete Course");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_18.setBounds(279, 483, 103, 13);
		contentPane.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("Insert Data");
		lblNewLabel_19.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_19.setBounds(92, 25, 97, 13);
		contentPane.add(lblNewLabel_19);
		
		JLabel lblNewLabel_21 = new JLabel("Course name");
		lblNewLabel_21.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_21.setBounds(231, 509, 85, 13);
		contentPane.add(lblNewLabel_21);
		
		DetName = new JTextField();
		DetName.setBounds(326, 506, 96, 19);
		contentPane.add(DetName);
		DetName.setColumns(10);
		// Delete btn and Action
		JButton DEtebtn = new JButton("Delete");
		DEtebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String DELName = DetName.getText();  // Getting Course Name from the DetName TextFlied
				Chand.deleteCourse(DELName);         // Delete Course from the Course handling
			}
		});
		DEtebtn.setBounds(326, 534, 85, 21);
		contentPane.add(DEtebtn);
	}

}
