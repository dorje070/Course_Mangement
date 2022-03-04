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
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MarkAdop extends JFrame { // inhertiance the jframe of login
	
	// jpanel and table of Mark Ad operation
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JScrollPane scrollPane_1;
	private JButton btnload;
	
	//url, username and password of mysql 
	private String url = "jdbc:mysql://localhost:3306/College";
    private String username = "root";
    private String password = "dorje070";
    
    // textfield of Mark Ad operation 
    private JTextField AddtID;
    private JTextField AddName;
    private JTextField AddCourse;
    private JTextField AddModule1;
    private JTextField AddMark1;
    private JTextField AddModule2;
    private JTextField AddMark2;
    private JTextField AddModule3;
    private JTextField AddMark3;
    private JTextField AddModule4;
    private JTextField AddSemesterno;
    private JTextField AddMark4;
    
    //Mark Ad Operation HAS-A(Association) Semester handling 
    SemesterHandling shand = new SemesterHandling();
    private JLabel lblNewLabel_13;
    private JLabel lblNewLabel_14;
    private JTextField Cha_ID;
    private JLabel lblNewLabel_15;
    private JLabel lblNewLabel_16;
    private JTextField SetMark1;
    private JTextField Cha_No;
    private JLabel lblNewLabel_17;
    private JLabel lblNewLabel_18;
    private JTextField SetMark2;
    private JLabel lblNewLabel_19;
    private JTextField SetMark3;
    private JLabel lblNewLabel_20;
    private JTextField SetMark4;
    private JLabel lblNewLabel_21;
    private JTextField SetID;
    private JButton btnChageSeno;
    private JLabel lblNewLabel_22;
    private JLabel lblNewLabel_23;
    private JTextField Se2Module1;
    private JLabel lblNewLabel_24;
    private JTextField Se2Module2;
    private JLabel lblNewLabel_25;
    private JTextField Se2Module3;
    private JLabel lblNewLabel_26;
    private JTextField Se2ID;
    private JButton btnSe2;
    private JLabel lblNewLabel_27;
    private JTextField Se1Module1;
    private JLabel lblNewLabel_28;
    private JLabel lblNewLabel_29;
    private JTextField Se1Module2;
    private JLabel lblNewLabel_30;
    private JTextField Se1Module3;
    private JLabel lblNewLabel_31;
    private JTextField Se1Module4;
    private JLabel lblNewLabel_32;
    private JTextField Se1ID;
    private JButton btnSe1;
    private JLabel lblNewLabel_33;
    private JLabel lblNewLabel_34;
    private JLabel lblNew;
    private JTextField tDelId;
    private JButton btnDelete;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MarkAdop frame = new MarkAdop();
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
	public MarkAdop() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1388, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(858, 57, 487, 160);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(585, 278, 766, 201);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		// load button and Action 
		btnload = new JButton("Load Data");
		btnload.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		            //load the driver
		            Class.forName("com.mysql.jdbc.Driver");


		            //create the connection
		            Connection connect = DriverManager.getConnection(url,username,password);

		            //create the query
		            String query = "SELECT * FROM student";

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
				try{
		            //load the driver
		            Class.forName("com.mysql.jdbc.Driver");


		            //create the connection
		            Connection connect = DriverManager.getConnection(url,username,password);

		            //create the query
		            String query = "SELECT * FROM Semester";

		            //create the statement
		            Statement statement = connect.createStatement();
		            ResultSet set = statement.executeQuery(query);
		            table_1.setModel(DbUtils.resultSetToTableModel(set)); // using the DbUtils function which is store Resourse folder 
                                                                          // Add the buidling path of Resourse folder
		            
		            
		            
		            //close the statment
		            connect.close();

		        }catch (Exception exp){
		            System.out.println(exp);
		        }
				
			}
		});
		btnload.setBounds(1065, 27, 96, 21);
		contentPane.add(btnload);
		
		// Add button and Action 
		JButton btnAdd = new JButton("Add Semester");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Add_Id = Integer.parseInt(AddtID.getText());  // Getting Id from AddId TextField
				String ADD_Name = AddName.getText();             // Getting Name from AddName TextField
				String ADD_Course = AddCourse.getText();          // Getting Course from AddCourse TextField
				String Module1 = AddModule1.getText();            // Getting Module1 from AddModule1 TextField
				int Mark1 = Integer.parseInt(AddMark1.getText()); // Getting Mark1 from AddMark1 TextField
				String Module2 = AddModule2.getText();            // Getting Module2 from AddModule2 TextField
				int Mark2 = Integer.parseInt(AddMark2.getText()); /// Getting Mark2 from AddMark2 TextField
				String Module3 = AddModule3.getText();            // Getting Module3 from AddModule3TextField
				int Mark3 = Integer.parseInt(AddMark3.getText()); // Getting Mark3 from AddMark3 TextField
				String Module4 = AddModule4.getText();             // Getting Module4 from AddModule4 TextField
				int Mark4 = Integer.parseInt(AddMark4.getText());  // Getting Mark4 from AddMark4TextField
				int Semesterno = Integer.parseInt(AddSemesterno.getText()); // Getting Semesterno from AddSemesterno TextField
				
				// Mark Ad operation HAS-A(Association) Semester
				semester sem = new semester(Add_Id, ADD_Name, ADD_Course, Module1, Mark1, Module2, Mark2, Module3, Mark3, Module4, Mark4, Semesterno);
				
				// Insert function of Semester Handling 
				shand.insertSemester(sem.getStudentname(), sem.getRollno(), sem.getCourse(), sem.getModule1(), sem.getMark1(), sem.getModule2(), sem.getMark2(), sem.getModule3(), sem.getMark3(), sem.getModule4(), sem.getMark4(), sem.getSemesterno());
				
			}
		});
		btnAdd.setBounds(719, 159, 117, 21);
		contentPane.add(btnAdd);
		
		JLabel lblNewLabel = new JLabel("Add Semester");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(39, 30, 105, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Student ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(39, 59, 65, 13);
		contentPane.add(lblNewLabel_1);
		
		AddtID = new JTextField();
		AddtID.setBounds(114, 56, 96, 19);
		contentPane.add(AddtID);
		AddtID.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Student Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(244, 59, 93, 13);
		contentPane.add(lblNewLabel_2);
		
		AddName = new JTextField();
		AddName.setBounds(347, 56, 96, 19);
		contentPane.add(AddName);
		AddName.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Course");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(475, 59, 65, 13);
		contentPane.add(lblNewLabel_3);
		
		AddCourse = new JTextField();
		AddCourse.setBounds(559, 56, 96, 19);
		contentPane.add(AddCourse);
		AddCourse.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Module1");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(688, 59, 54, 13);
		contentPane.add(lblNewLabel_4);
		
		AddModule1 = new JTextField();
		AddModule1.setBounds(752, 56, 96, 19);
		contentPane.add(AddModule1);
		AddModule1.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Mark1");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(39, 97, 45, 13);
		contentPane.add(lblNewLabel_5);
		
		AddMark1 = new JTextField();
		AddMark1.setBounds(114, 94, 96, 19);
		contentPane.add(AddMark1);
		AddMark1.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Module2");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(260, 97, 54, 13);
		contentPane.add(lblNewLabel_6);
		
		AddModule2 = new JTextField();
		AddModule2.setBounds(347, 94, 96, 19);
		contentPane.add(AddModule2);
		AddModule2.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Mark2");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBounds(475, 97, 54, 13);
		contentPane.add(lblNewLabel_7);
		
		AddMark2 = new JTextField();
		AddMark2.setBounds(559, 94, 96, 19);
		contentPane.add(AddMark2);
		AddMark2.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Module3");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8.setBounds(683, 97, 59, 13);
		contentPane.add(lblNewLabel_8);
		
		AddModule3 = new JTextField();
		AddModule3.setBounds(752, 94, 96, 19);
		contentPane.add(AddModule3);
		AddModule3.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Mark3");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_9.setBounds(39, 133, 45, 13);
		contentPane.add(lblNewLabel_9);
		
		AddMark3 = new JTextField();
		AddMark3.setBounds(114, 130, 96, 19);
		contentPane.add(AddMark3);
		AddMark3.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Module4");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10.setBounds(260, 133, 77, 13);
		contentPane.add(lblNewLabel_10);
		
		AddModule4 = new JTextField();
		AddModule4.setBounds(347, 130, 96, 19);
		contentPane.add(AddModule4);
		AddModule4.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Semeter no");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11.setBounds(667, 133, 87, 13);
		contentPane.add(lblNewLabel_11);
		
		AddSemesterno = new JTextField();
		AddSemesterno.setBounds(752, 130, 96, 19);
		contentPane.add(AddSemesterno);
		AddSemesterno.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Mark4");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_12.setBounds(475, 133, 45, 13);
		contentPane.add(lblNewLabel_12);
		
		AddMark4 = new JTextField();
		AddMark4.setBounds(559, 130, 96, 19);
		contentPane.add(AddMark4);
		AddMark4.setColumns(10);
		
		lblNewLabel_13 = new JLabel("Change Semester");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_13.setBounds(39, 176, 117, 13);
		contentPane.add(lblNewLabel_13);
		
		lblNewLabel_14 = new JLabel("Student ID");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_14.setBounds(39, 200, 65, 13);
		contentPane.add(lblNewLabel_14);
		
		Cha_ID = new JTextField();
		Cha_ID.setBounds(134, 199, 96, 19);
		contentPane.add(Cha_ID);
		Cha_ID.setColumns(10);
		
		lblNewLabel_15 = new JLabel("Semester no");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_15.setBounds(39, 232, 85, 13);
		contentPane.add(lblNewLabel_15);
		
		lblNewLabel_16 = new JLabel("SetMark");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_16.setBounds(39, 336, 65, 13);
		contentPane.add(lblNewLabel_16);
		
		SetMark1 = new JTextField();
		SetMark1.setBounds(114, 361, 96, 19);
		contentPane.add(SetMark1);
		SetMark1.setColumns(10);
		
		Cha_No = new JTextField();
		Cha_No.setBounds(134, 228, 96, 19);
		contentPane.add(Cha_No);
		Cha_No.setColumns(10);
		
		lblNewLabel_17 = new JLabel("Mark1");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_17.setBounds(39, 364, 45, 13);
		contentPane.add(lblNewLabel_17);
		
		lblNewLabel_18 = new JLabel("Mark2");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_18.setBounds(39, 401, 45, 13);
		contentPane.add(lblNewLabel_18);
		
		SetMark2 = new JTextField();
		SetMark2.setBounds(114, 398, 96, 19);
		contentPane.add(SetMark2);
		SetMark2.setColumns(10);
		
		lblNewLabel_19 = new JLabel("Mark3");
		lblNewLabel_19.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_19.setBounds(39, 435, 45, 13);
		contentPane.add(lblNewLabel_19);
		
		SetMark3 = new JTextField();
		SetMark3.setBounds(114, 432, 96, 19);
		contentPane.add(SetMark3);
		SetMark3.setColumns(10);
		
		lblNewLabel_20 = new JLabel("Mark4");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_20.setBounds(39, 466, 45, 13);
		contentPane.add(lblNewLabel_20);
		
		SetMark4 = new JTextField();
		SetMark4.setBounds(114, 460, 96, 19);
		contentPane.add(SetMark4);
		SetMark4.setColumns(10);
		
		JButton btnsetMark = new JButton("Set 4 Marks ");
		btnsetMark.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Set_Mark1 = Integer.parseInt(SetMark1.getText());  // Getting the Mark1 from SetMark1 textfield
				int Set_Mark2 = Integer.parseInt(SetMark2.getText());  // Getting the Mark2 from SetMark2 textfield
				int Set_Mark3 = Integer.parseInt(SetMark3.getText());  // Getting the Mark3 from SetMark3 textfield
				int Set_Mark4 = Integer.parseInt(SetMark4.getText());  // Getting the Mark4 from SetMark4 textfield
				int Set_ID = Integer.parseInt(SetID.getText());        // Getting the student Id  from SetID textfield
				
				// calling set mark from student Handling 
				shand.SetMarks(Set_Mark1, Set_Mark2, Set_Mark3, Set_Mark4, Set_ID);
				
			}
		});
		btnsetMark.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnsetMark.setBounds(108, 520, 102, 21);
		contentPane.add(btnsetMark);
		
		lblNewLabel_21 = new JLabel("Student ID");
		lblNewLabel_21.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_21.setBounds(27, 494, 77, 13);
		contentPane.add(lblNewLabel_21);
		
		SetID = new JTextField();
		SetID.setBounds(114, 491, 96, 19);
		contentPane.add(SetID);
		SetID.setColumns(10);
		
		//button semester no and Action
		btnChageSeno = new JButton("change");
		btnChageSeno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ChaID = Integer.parseInt(Cha_ID.getText());  // Getting the student Id  from ChaID textfield
				int ChaNo = Integer.parseInt(Cha_No.getText());  // Getting the student Id  from ChaNo textfield
				shand.ChangeSemester(ChaNo, ChaID);      // semester Handling of Change semester function
			
			}
		});
		btnChageSeno.setBounds(134, 257, 85, 21);
		contentPane.add(btnChageSeno);
		
		lblNewLabel_22 = new JLabel("Change in Semester2");
		lblNewLabel_22.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_22.setBounds(274, 167, 138, 13);
		contentPane.add(lblNewLabel_22);
		
		lblNewLabel_23 = new JLabel("Module1");
		lblNewLabel_23.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_23.setBounds(260, 200, 59, 13);
		contentPane.add(lblNewLabel_23);
		
		Se2Module1 = new JTextField();
		Se2Module1.setBounds(334, 197, 96, 19);
		contentPane.add(Se2Module1);
		Se2Module1.setColumns(10);
		
		lblNewLabel_24 = new JLabel("Module2");
		lblNewLabel_24.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_24.setBounds(260, 232, 54, 13);
		contentPane.add(lblNewLabel_24);
		
		Se2Module2 = new JTextField();
		Se2Module2.setBounds(334, 232, 96, 19);
		contentPane.add(Se2Module2);
		Se2Module2.setColumns(10);
		
		lblNewLabel_25 = new JLabel("Module3");
		lblNewLabel_25.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_25.setBounds(260, 261, 54, 13);
		contentPane.add(lblNewLabel_25);
		
		Se2Module3 = new JTextField();
		Se2Module3.setBounds(334, 258, 96, 19);
		contentPane.add(Se2Module3);
		Se2Module3.setColumns(10);
		
		lblNewLabel_26 = new JLabel("Student ID");
		lblNewLabel_26.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_26.setBounds(244, 288, 70, 13);
		contentPane.add(lblNewLabel_26);
		
		Se2ID = new JTextField();
		Se2ID.setBounds(334, 285, 96, 19);
		contentPane.add(Se2ID);
		Se2ID.setColumns(10);
		
		btnSe2 = new JButton("Change");
		btnSe2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Module1 = Se2Module1.getText();  // Getting the Module1  from Se2Module1 textfield
				String Module2 = Se2Module2.getText();   // Getting the Module2  from Se2Module2 textfield
				String Module3 = Se2Module3.getText();     // Getting the Module3 from Se2Module3 textfield
				int StudentID = Integer.parseInt(Se2ID.getText());   // Getting the StudentID from Se2Id textfield
				
				// Calling semester handling setSemester2 function 
				shand.SetSemester2(Module1, Module2, Module3, StudentID);
			}
		});
		btnSe2.setBounds(347, 314, 85, 21);
		contentPane.add(btnSe2);
		
		lblNewLabel_27 = new JLabel("Module1");
		lblNewLabel_27.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_27.setBounds(260, 372, 65, 13);
		contentPane.add(lblNewLabel_27);
		
		Se1Module1 = new JTextField();
		Se1Module1.setBounds(334, 369, 96, 19);
		contentPane.add(Se1Module1);
		Se1Module1.setColumns(10);
		
		lblNewLabel_28 = new JLabel("New label");
		lblNewLabel_28.setBounds(260, 378, 45, -13);
		contentPane.add(lblNewLabel_28);
		
		lblNewLabel_29 = new JLabel("Module2");
		lblNewLabel_29.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_29.setBounds(260, 401, 54, 13);
		contentPane.add(lblNewLabel_29);
		
		Se1Module2 = new JTextField();
		Se1Module2.setBounds(334, 398, 96, 19);
		contentPane.add(Se1Module2);
		Se1Module2.setColumns(10);
		
		lblNewLabel_30 = new JLabel("Module3");
		lblNewLabel_30.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_30.setBounds(260, 435, 54, 13);
		contentPane.add(lblNewLabel_30);
		
		Se1Module3 = new JTextField();
		Se1Module3.setBounds(334, 432, 96, 19);
		contentPane.add(Se1Module3);
		Se1Module3.setColumns(10);
		
		lblNewLabel_31 = new JLabel("Module4");
		lblNewLabel_31.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_31.setBounds(260, 466, 54, 13);
		contentPane.add(lblNewLabel_31);
		
		Se1Module4 = new JTextField();
		Se1Module4.setBounds(334, 463, 96, 19);
		contentPane.add(Se1Module4);
		Se1Module4.setColumns(10);
		
		lblNewLabel_32 = new JLabel("Student ID");
		lblNewLabel_32.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_32.setBounds(244, 494, 70, 13);
		contentPane.add(lblNewLabel_32);
		
		Se1ID = new JTextField();
		Se1ID.setBounds(334, 491, 96, 19);
		contentPane.add(Se1ID);
		Se1ID.setColumns(10);
		
		btnSe1 = new JButton("Change");
		btnSe1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Se1_Module1 = Se1Module1.getText();   // Getting the Module1  from Se1Module1 textfield
				String Se1_Module2 = Se1Module2.getText();   // Getting the Module2  from Se1Module1 textfield
				String Se1_Module3 = Se1Module3.getText();   // Getting the Module3  from Se2Module1 textfield
				String Se1_Module4 = Se1Module4.getText();    // Getting the Module4  from Se1Module1 textfield
				int Se1_ID = Integer.parseInt(Se1ID.getText());   // Getting the student ID  from Se1ID textfield
				
				// Calling Semester handling SetSemeste1 function 
				shand.SetSemester1(Se1_Module1, Se1_Module2, Se1_Module3, Se1_Module4, Se1_ID);
			}
		});
		btnSe1.setBounds(347, 520, 85, 21);
		contentPane.add(btnSe1);
		
		lblNewLabel_33 = new JLabel("Change in Semester1");
		lblNewLabel_33.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_33.setBounds(260, 348, 138, 13);
		contentPane.add(lblNewLabel_33);
		
		lblNewLabel_34 = new JLabel("Delete Semester");
		lblNewLabel_34.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_34.setBounds(509, 176, 126, 13);
		contentPane.add(lblNewLabel_34);
		
		lblNew = new JLabel("Student Id");
		lblNew.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNew.setBounds(475, 202, 65, 13);
		contentPane.add(lblNew);
		
		tDelId = new JTextField();
		tDelId.setBounds(559, 198, 96, 19);
		contentPane.add(tDelId);
		tDelId.setColumns(10);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Deleteno = Integer.parseInt(tDelId.getText()); // Getting the Student ID from tDelID textfield
				shand.DeleteSemester(Deleteno); // Calling the Delete function of semester handling 
			}
		});
		btnDelete.setBounds(559, 228, 85, 21);
		contentPane.add(btnDelete);
	}
}
