package College;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class StudentAc extends JFrame { // inhertiance the jframe of login

	private JPanel contentPane;
	private ArrayList<String> Adlist = new ArrayList<String>();
	
	// Student Account HAS-A(Association) Account handling 
	private AccontHandling Achand = new AccontHandling();
	
	// Student Account HAS-A(Association) File Handling 
	private FileHandling fileh = new FileHandling();
	
	// Student Account HAS-A(Association) Student Handling 
	private StudentHandling Sthand = new StudentHandling();
	
	// Student Account HAS-A(Association) Semester Handling 
	private SemesterHandling Semhand = new SemesterHandling();
	
	// jtable of Student Account
	private JTable table;
	private int SemesterNO;
	
	// url username and password of mysql 
	private String url = "jdbc:mysql://localhost:3306/College";
    private String username = "root";
    private String password = "dorje070";
    private JTextField Module4;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentAc frame = new StudentAc();
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
	public StudentAc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String Username = fileh.ReadUsername();
		int UserID = Achand.ReadId(Username);
		Adlist = Sthand.ReadStud(UserID);
		
		// Student Account user 
		JLabel lblNewLabel = new JLabel("Student Account "+Adlist.get(1));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(132, 23, 250, 13);
		contentPane.add(lblNewLabel);
		
		// Name :  user
		JLabel lblName = new JLabel("Name : "+Adlist.get(1));
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblName.setBounds(58, 67, 126, 13);
		contentPane.add(lblName);
		
		
		// Roll no : user
		JLabel lblRollno = new JLabel("Roll no : "+Adlist.get(0) );
		lblRollno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRollno.setBounds(279, 67, 121, 13);
		contentPane.add(lblRollno);
		
		
		// Age :  user
		JLabel lblAge = new JLabel("Age : " +Adlist.get(2));
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAge.setBounds(472, 67, 107, 13);
		contentPane.add(lblAge);
		
		// Address : user
		JLabel lblAddress = new JLabel("Address : "+Adlist.get(3));
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddress.setBounds(58, 119, 126, 13);
		contentPane.add(lblAddress);
		
		// Course : user
		JLabel lbCourse = new JLabel("Course : "+Adlist.get(4));
		lbCourse.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbCourse.setBounds(279, 119, 121, 13);
		contentPane.add(lbCourse);
		
	
		JLabel lblNewLabel_6 = new JLabel("Semester Mark");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(289, 170, 93, 13);
		contentPane.add(lblNewLabel_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 213, 631, 40);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		// load button and Action 
		JButton btnLoad = new JButton("Load Semester");
		btnLoad.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		            //load the driver
		            Class.forName("com.mysql.jdbc.Driver");


		            //create the connection
		            Connection connect = DriverManager.getConnection(url,username,password);

		            //create the query
		            String query = "SELECT * FROM Semester WHERE studentID ="+Adlist.get(0);

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
		            String query = "SELECT * FROM Semester WHERE studentID ="+Adlist.get(0);

		            //create the statement
		            Statement statement = connect.createStatement();
		            ResultSet set = statement.executeQuery(query);
		            
		            while(set.next()){
		                System.out.println(set.getString("StudentID")+" "+set.getString("Studentname") + " " +set.getString("Course")+" "+ set.getString("Module1")+" "+set.getString("Mark1")+" "+set.getString("Module2")+" "+set.getString("Mark2")+" "+set.getString("Module3")+" "+set.getString("Mark3")+" "+set.getString("Module4")+" "+set.getString("Mark4")+" "+set.getString("Semesterno"));
		                SemesterNO = Integer.parseInt(set.getString("Semesterno")); // store th semester no 
		                 
		            }
		            
		            
		            //close the statment
		            connect.close();

		        }catch (Exception exp){
		            System.out.println(exp);
		        }
			}
		});
		btnLoad.setBounds(279, 272, 126, 21);
		contentPane.add(btnLoad);
		
		// choose button and Action 
		JButton btnChoose = new JButton("Choose");
		btnChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Module = Module4.getText();
				int Studentid = Integer.parseInt(Adlist.get(0)); // Getting the student id from Adlist
				// if the Semester is 2 than call the Choose function of Semester Handling 
				if(SemesterNO ==2) {
					Semhand.ChoseModule4(Module, Studentid);
				}else {
					JOptionPane.showMessageDialog(null, "Sorry you are no is Semester 2");
					// show dialog if the Semester is not 2
				}
				
			}
		});
		btnChoose.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnChoose.setBounds(573, 149, 85, 21);
		contentPane.add(btnChoose);
		
		JLabel lblNewLabel_7 = new JLabel("Module4");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBounds(472, 119, 64, 13);
		contentPane.add(lblNewLabel_7);
		
		Module4 = new JTextField();
		Module4.setBounds(563, 116, 96, 19);
		contentPane.add(Module4);
		Module4.setColumns(10);
	}
}
