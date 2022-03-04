package College;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class InstructorHandling {
	// url, username and password of My sql 
	private String url = "jdbc:mysql://localhost:3306/College";
    private String username = "root";
    private String password = "dorje070";
    
    private ArrayList<String> Adlist = new ArrayList<String>();
    
    // Create the Instructor Table 
    public void createInstructorTable(){
        try{
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");

            //create the connection
            Connection connect = DriverManager.getConnection(url,username,password);

            //create the query
            String query = "CREATE TABLE Instructor(employeeID int PRIMARY KEY AUTO_INCREMENT, Name varchar(50) NOT NULL,Age int, Type varchar(50), Education varchar(50) )";

            //create the statement
            Statement statement = connect.createStatement();
            statement.executeUpdate(query);

            System.out.println("Table created ");

            //close the statment
            connect.close();

        }catch (Exception exp){
            System.out.println(exp);
        }

    }
    
    // insert the Data to Instructor table 
    public boolean insertInstructor(String Name,int ID, int Age, String Type, String Education){
    	boolean exception = false ;
        try{
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //create the connection
            Connection connect = DriverManager.getConnection(url,username,password);

            //create the query
            String query = "INSERT INTO Instructor VALUES("+ID+",'"+Name+"',"+Age+",'"+Type+"','"+Education+"');";
            
            Statement statement = connect.createStatement();
            statement.executeUpdate(query);

            System.out.println("Table Updated!!! ");

            //close the statment
            connect.close();

        }catch (Exception exp){
            System.out.println(exp);
            JOptionPane.showMessageDialog(null, exp);
            exception = true;
        }
        return exception;
    }
    
    // Reading the data of the Instructor table 
    void ReadInstructor(){
        try{
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");


            //create the connection
            Connection connect = DriverManager.getConnection(url,username,password);

            //create the query
            String query = "SELECT * FROM Instructor";

            //create the statement
            Statement statement = connect.createStatement();
            ResultSet set = statement.executeQuery(query);

            while(set.next()){
                System.out.println(set.getString("employeeID")+" "+set.getString("Name") + " " +set.getString("Age")+" "+ set.getString("Type")+" "+set.getString("Education"));
                
            }

            //close the statment
            connect.close();

        }catch (Exception exp){
            System.out.println(exp);
        }

    }
    
    // delete the row of Instructor Table 
    void DeleteInstructor(int ID){
        try{
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");

            //create the connection
            Connection connect = DriverManager.getConnection(url,username,password);

            //create the query
            String query = "DELETE FROM Instructor WHERE employeeID ="+ID;

            //create the statement
            Statement statement = connect.createStatement();
            statement.executeUpdate(query);

            System.out.println("deleted the data ");

            //close the statment
            connect.close();

        }catch (Exception exp){
            System.out.println(exp);
        }

    }
    
    // Change instructor Name of Instructor Table  with Employee Id 
    void ChangeInstructorName(int ID, String NewName){
	       try{
	           //load the driver
	           Class.forName("com.mysql.jdbc.Driver");

	           //create the connection
	           Connection connect = DriverManager.getConnection(url,username,password);

	           //create the query
	           String query = "UPDATE Instructor set Name = '"+NewName+"' WHERE employeeID = "+ID;

	           //create the statement
	           Statement statement = connect.createStatement();
	           statement.executeUpdate(query);

	           System.out.println("Complete the Change ");

	           //close the statment
	           connect.close();

	       }catch (Exception exp){
	           System.out.println(exp);
	       }

	   }
    
    // Change Employee Id of Instructor table with old Employee ID 
    void ChangeInstructorID(int ID, int NewID){
        try{
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");

            //create the connection
            Connection connect = DriverManager.getConnection(url,username,password);

            //create the query
            String query = "UPDATE Instructor set employeeID = "+NewID+" WHERE employeeID = "+ID;

            //create the statement
            Statement statement = connect.createStatement();
            statement.executeUpdate(query);

            System.out.println("Complete the Change ");

            //close the statment
            connect.close();

        }catch (Exception exp){
            System.out.println(exp);
        }

    }
    
    // Change Instructor Age of Insructor table with Employee Id 
    void ChangeInstructorAge(int ID, int NewAge){
        try{
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");

            //create the connection
            Connection connect = DriverManager.getConnection(url,username,password);

            //create the query
            String query = "UPDATE Instructor set Age = "+NewAge+" WHERE employeeID = "+ID;

            //create the statement
            Statement statement = connect.createStatement();
            statement.executeUpdate(query);

            System.out.println("Complete the Change ");

            //close the statment
            connect.close();

        }catch (Exception exp){
            System.out.println(exp);
        }

    }
    
 // Change Instructor Type of Insructor table with Employee Id 
    void ChangeInstructorType(int ID, String NewType){
	       try{
	           //load the driver
	           Class.forName("com.mysql.jdbc.Driver");

	           //create the connection
	           Connection connect = DriverManager.getConnection(url,username,password);

	           //create the query
	           String query = "UPDATE Instructor set Type = '"+NewType+"' WHERE employeeID = "+ID;

	           //create the statement
	           Statement statement = connect.createStatement();
	           statement.executeUpdate(query);

	           System.out.println("Complete the Change ");

	           //close the statment
	           connect.close();

	       }catch (Exception exp){
	           System.out.println(exp);
	       }

	   }
 
 // Change Instructor Education of Insructor table with Employee Id 
 void ChangeInstructorEducation(int ID, String NewEducation){
	       try{
	           //load the driver
	           Class.forName("com.mysql.jdbc.Driver");

	           //create the connection
	           Connection connect = DriverManager.getConnection(url,username,password);

	           //create the query
	           String query = "UPDATE Instructor set Education = '"+NewEducation+"' WHERE employeeID = "+ID;

	           //create the statement
	           Statement statement = connect.createStatement();
	           statement.executeUpdate(query);

	           System.out.println("Complete the Change ");

	           //close the statment
	           connect.close();

	       }catch (Exception exp){
	           System.out.println(exp);
	       }

	   }
 
//Change Instructor data in Arraylist of Insructor table with Employee Id 
 ArrayList<String> ReadInstr(int UserID){
     try{
         //load the driver
         Class.forName("com.mysql.jdbc.Driver");


         //create the connection
         Connection connect = DriverManager.getConnection(url,username,password);

         //create the query
         String query = "SELECT * FROM Instructor WHERE employeeID ="+UserID;

         //create the statement
         Statement statement = connect.createStatement();
         ResultSet set = statement.executeQuery(query);

         while(set.next()){
             System.out.println(set.getString("employeeID")+" "+set.getString("Name") + " " +set.getString("Age")+" "+ set.getString("Type")+" "+set.getString("Education"));
             Adlist.add(set.getString("employeeID"));
             Adlist.add(set.getString("Name"));
             Adlist.add(set.getString("Age"));
             Adlist.add(set.getString("Type"));
             Adlist.add(set.getString("Education"));
            
         }
         
         //close the statment
         connect.close();

     }catch (Exception exp){
         System.out.println(exp);
     }
		return Adlist;

 }
}
