package College;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class ModuleOp extends JFrame { // inhertiance the jframe of login
	// url, username and password of my sql
	private String url = "jdbc:mysql://localhost:3306/College";
    private String username = "root";
    private String password = "dorje070";
    
    // panel and textField
	private JPanel contentPane;
	private JTextField ModuleName;
	private JTextField Module_code;
	private JTextField Module_Lead;
	private JTextField Module_Lea;
	private JTextField Module_TU;
	
	// Module Operation HAS-A(Association) ModuleHandling 
	private ModuleHandling Mhand = new ModuleHandling();
	private JTable table;
	private JTextField NewName;
	private JTextField Change_Code1;
	private JTextField New_Code;
	private JTextField Change_Code2;
	private JTextField NewLeader;
	private JTextField Change_Code3;
	private JTextField New_leacture;
	private JTextField Change_Code4;
	private JTextField textTutorial;
	private JTextField Change_code5;
	private JTextField DeteCode;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModuleOp frame = new ModuleOp();
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
	public ModuleOp() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 929, 593);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLoad = new JButton("Load Module");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  try{
			            //load the driver
			            Class.forName("com.mysql.jdbc.Driver");


			            //create the connection
			            Connection connect = DriverManager.getConnection(url,username,password);

			            //create the query
			            String query = "SELECT * FROM Modules";

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
			}
		});
		btnLoad.setBounds(659, 23, 126, 21);
		contentPane.add(btnLoad);
		
		// Add button and Action 
		JButton Add_Btn = new JButton("Add");
		Add_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Module_name = ModuleName.getText();  // Getting the Module name from ModuleName Textfield
				int ModuleCo = Integer.parseInt(Module_code.getText()); // Getting the Module code from ModuleCo Textfield
				String Leader = Module_Lead.getText(); // Getting the Module leader from Module_leader Textfield
				String leacture = Module_Lea.getText(); // Getting the Module leacture from Module_LeaTextfield
				String Tutorial = Module_TU.getText(); // Getting the Module tutorial from Module_TU Textfield
				
				// Module Operation HAS-A(Association) Modules
				Modules mod = new Modules(Module_name, ModuleCo, Leader, leacture, Tutorial);
				
				// Calling Module Handling insert function 
				Mhand.insertModule(mod.getModulename(), mod.getModuleCode(), mod.getModuleLeader(), mod.getLecture(), mod.getTutorial());
			}
		});
		Add_Btn.setFont(new Font("Tahoma", Font.BOLD, 11));
		Add_Btn.setBounds(130, 234, 85, 21);
		contentPane.add(Add_Btn);
		
		JLabel MName = new JLabel("Module Name");
		MName.setBounds(24, 56, 84, 13);
		contentPane.add(MName);
		
		ModuleName = new JTextField();
		ModuleName.setBounds(131, 53, 96, 19);
		contentPane.add(ModuleName);
		ModuleName.setColumns(10);
		
		Module_code = new JTextField();
		Module_code.setBounds(131, 85, 96, 19);
		contentPane.add(Module_code);
		Module_code.setColumns(10);
		
		JLabel Mcode = new JLabel("ModuleCode");
		Mcode.setBounds(23, 88, 84, 13);
		contentPane.add(Mcode);
		
		Module_Lead = new JTextField();
		Module_Lead.setBounds(131, 120, 96, 19);
		contentPane.add(Module_Lead);
		Module_Lead.setColumns(10);
		
		JLabel Mleader = new JLabel("Module Leader");
		Mleader.setBounds(23, 123, 97, 13);
		contentPane.add(Mleader);
		
		Module_Lea = new JTextField();
		Module_Lea.setBounds(131, 159, 96, 19);
		contentPane.add(Module_Lea);
		Module_Lea.setColumns(10);
		
		Module_TU = new JTextField();
		Module_TU.setBounds(131, 195, 96, 19);
		contentPane.add(Module_TU);
		Module_TU.setColumns(10);
		
		JLabel MLeacture = new JLabel("Module Leacture");
		MLeacture.setBounds(23, 162, 97, 13);
		contentPane.add(MLeacture);
		
		JLabel Mtutorial = new JLabel("Module Tutorial");
		Mtutorial.setBounds(23, 198, 97, 13);
		contentPane.add(Mtutorial);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(495, 54, 420, 492);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel ChageNameLabel = new JLabel("Change Name");
		ChageNameLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		ChageNameLabel.setBounds(73, 302, 112, 13);
		contentPane.add(ChageNameLabel);
		
		JLabel NewNameLab = new JLabel("New Name");
		NewNameLab.setBounds(23, 328, 71, 13);
		contentPane.add(NewNameLab);
		
		NewName = new JTextField();
		NewName.setBounds(116, 325, 118, 19);
		contentPane.add(NewName);
		NewName.setColumns(10);
		
		JLabel CModuleCodelab = new JLabel("Module code");
		CModuleCodelab.setBounds(23, 362, 80, 13);
		contentPane.add(CModuleCodelab);
		
		Change_Code1 = new JTextField();
		Change_Code1.setBounds(116, 354, 118, 19);
		contentPane.add(Change_Code1);
		Change_Code1.setColumns(10);
		
		// change Name btn and Action 
		JButton ChangeName_btn = new JButton("Change Name");
		ChangeName_btn.setFont(new Font("Tahoma", Font.BOLD, 11));
		ChangeName_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String New_Name= NewName.getText();   // Getting the Module new name from NewName Textfield
				int OLdCode = Integer.parseInt(Change_Code1.getText());  // Getting the code  from OLdCode Textfield
				// calling Module change function for Module Handling 
				Mhand.ChangeModuleName(OLdCode, New_Name);
			}
		});
		ChangeName_btn.setBounds(116, 383, 118, 21);
		contentPane.add(ChangeName_btn);
		
		JLabel ChageCodelab = new JLabel("Change Code");
		ChageCodelab.setFont(new Font("Tahoma", Font.BOLD, 11));
		ChageCodelab.setBounds(354, 302, 80, 13);
		contentPane.add(ChageCodelab);
		
		JLabel NewCodelab = new JLabel("New Code");
		NewCodelab.setBounds(262, 328, 71, 13);
		contentPane.add(NewCodelab);
		
		JLabel CModuleCodelab2 = new JLabel("Module code");
		CModuleCodelab2.setBounds(262, 362, 92, 13);
		contentPane.add(CModuleCodelab2);
		
		New_Code = new JTextField();
		New_Code.setBounds(354, 325, 121, 19);
		contentPane.add(New_Code);
		New_Code.setColumns(10);
		
		Change_Code2 = new JTextField();
		Change_Code2.setBounds(354, 359, 121, 19);
		contentPane.add(Change_Code2);
		Change_Code2.setColumns(10);
		
		
		JButton btnNewcode = new JButton("Change Code");
		btnNewcode.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewcode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int NewCode = Integer.parseInt(New_Code.getText());  // Getting the Module new code from New_Code Textfield
				int OldCode = Integer.parseInt(Change_Code2.getText()); // Getting the old code from Change_Code Textfield
				
				// Module Handling function change Code
				Mhand.ChangeModuleCode(OldCode, NewCode);  
				
			}
		});
		btnNewcode.setBounds(354, 387, 121, 21);
		contentPane.add(btnNewcode);
		
		JLabel lblNewLabel = new JLabel("Change leader");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(73, 429, 112, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lbNewLeader = new JLabel("New Leader");
		lbNewLeader.setBounds(23, 455, 77, 13);
		contentPane.add(lbNewLeader);
		
		JLabel CModuleCode3 = new JLabel("Module Code");
		CModuleCode3.setBounds(23, 484, 77, 13);
		contentPane.add(CModuleCode3);
		
		NewLeader = new JTextField();
		NewLeader.setBounds(116, 452, 126, 19);
		contentPane.add(NewLeader);
		NewLeader.setColumns(10);
		
		Change_Code3 = new JTextField();
		Change_Code3.setBounds(116, 481, 126, 19);
		contentPane.add(Change_Code3);
		Change_Code3.setColumns(10);
		
		JButton btnLeader = new JButton("Change Leader");
		btnLeader.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLeader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String New_Leader = NewLeader.getText();  // Getting the Module new leader from NewLeader Textfield
				int oldCode = Integer.parseInt(Change_Code3.getText());  // Getting the code from Change_Code3 Textfield
				
				// Calling the Module leader function from Module handling 
				Mhand.ChangeModuleLeader(oldCode, New_Leader);
			}
		});
		btnLeader.setBounds(116, 510, 126, 21);
		contentPane.add(btnLeader);
		
		JLabel lblNewLeature = new JLabel("Change Leature");
		lblNewLeature.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLeature.setBounds(354, 433, 112, 13);
		contentPane.add(lblNewLeature);
		
		JLabel lblNewLabel_4 = new JLabel("New Leacture");
		lblNewLabel_4.setBounds(262, 459, 80, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel Module4lb = new JLabel("Module Code");
		Module4lb.setBounds(262, 482, 80, 13);
		contentPane.add(Module4lb);
		
		New_leacture = new JTextField();
		New_leacture.setBounds(351, 456, 124, 19);
		contentPane.add(New_leacture);
		New_leacture.setColumns(10);
		
		Change_Code4 = new JTextField();
		Change_Code4.setBounds(349, 479, 126, 19);
		contentPane.add(Change_Code4);
		Change_Code4.setColumns(10);
		
		JButton btnleacture = new JButton("Change Leacture");
		btnleacture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NewLeacture = New_leacture.getText();   // Getting the Module new Leacture from New_leacture Textfield
				int OldCode = Integer.parseInt(Change_Code4.getText()); // Getting the  code from Change_Code4 Textfield
				
				// calling the change Leacture from Module handling 
				Mhand.ChangeModuleLecture(OldCode, NewLeacture);
			}
		});
		btnleacture.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnleacture.setBounds(338, 510, 137, 21);
		contentPane.add(btnleacture);
		
		JLabel ChangeTUlb = new JLabel("Change Tutorial");
		ChangeTUlb.setFont(new Font("Tahoma", Font.BOLD, 11));
		ChangeTUlb.setBounds(351, 27, 103, 13);
		contentPane.add(ChangeTUlb);
		
		JLabel lbNewTutorial = new JLabel("New Tutorial");
		lbNewTutorial.setBounds(247, 56, 80, 13);
		contentPane.add(lbNewTutorial);
		
		textTutorial = new JTextField();
		textTutorial.setBounds(338, 53, 137, 19);
		contentPane.add(textTutorial);
		textTutorial.setColumns(10);
		
		JLabel LbModuleCode5 = new JLabel("Module Code");
		LbModuleCode5.setBounds(247, 91, 80, 13);
		contentPane.add(LbModuleCode5);
		
		Change_code5 = new JTextField();
		Change_code5.setBounds(338, 88, 137, 19);
		contentPane.add(Change_code5);
		Change_code5.setColumns(10);
		
		JButton btnNewTU = new JButton("Change Tutorial");
		btnNewTU.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewTU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NewTutorial = textTutorial.getText();    // Getting the Module new tutorial from New_Code Textfield
				int OldCode = Integer.parseInt(Change_code5.getText()); // Getting the  code from Change_Code5 Textfield
				
				// calling tutorial change function from Module handling 
				Mhand.ChangeModuleTutorial(OldCode, NewTutorial);
			}
		});
		btnNewTU.setBounds(349, 119, 126, 21);
		contentPane.add(btnNewTU);
		
		JButton Btndete = new JButton("Delete");
		Btndete.setFont(new Font("Tahoma", Font.BOLD, 11));
		Btndete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int DetCode = Integer.parseInt(DeteCode.getText()); // Getting the code from DeteCode Textfield
				Mhand.DeleteModule(DetCode); // Change Module Delete function from Module handling 
			}
		});
		Btndete.setBounds(380, 224, 85, 21);
		contentPane.add(Btndete);
		
		JLabel delModeCode = new JLabel("Module Code");
		delModeCode.setBounds(247, 198, 96, 13);
		contentPane.add(delModeCode);
		
		DeteCode = new JTextField();
		DeteCode.setBounds(354, 195, 112, 19);
		contentPane.add(DeteCode);
		DeteCode.setColumns(10);
		
		JLabel delLb = new JLabel("Delete Module");
		delLb.setFont(new Font("Tahoma", Font.BOLD, 11));
		delLb.setBounds(354, 172, 80, 13);
		contentPane.add(delLb);
	}
}
