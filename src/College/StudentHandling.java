package College;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class StudentHandling {
	// url, username and password of mysql
	private String url = "jdbc:mysql://localhost:3306/College";
    private String username = "root";
    private String password = "dorje070";
    
    private ArrayList<String> Adlist = new ArrayList<String>();
    
    //create table of Student 
	public void createStudentTable(){
        try{
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");

            //create the connection
            Connection connect = DriverManager.getConnection(url,username,password);

            //create the query
            String query = "CREATE TABLE student(studentID int PRIMARY KEY AUTO_INCREMENT, StudentName varchar(50) NOT NULL,Age int, Address varchar(50), Course varchar(50) )";

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
    
    // Insert data in student table 
   public boolean  insertStudent(String Name, int Rollno, int Age, String Address, String Course){
	   boolean exception = false;
        try{
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //create the connection
            Connection connect = DriverManager.getConnection(url,username,password);

            //create the query
            String query = "INSERT INTO student VALUES("+Rollno+",'"+Name+"',"+Age+",'"+Address+"','"+Course+"');";
            
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
   
   // Read the data from student table 
   void ReadStudent(){
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

           while(set.next()){
               System.out.println(set.getString("studentID")+" "+set.getString("StudentName") + " " +set.getString("Age")+" "+ set.getString("Address")+" "+set.getString("Course"));
               
           }

           //close the statment
           connect.close();

       }catch (Exception exp){
           System.out.println(exp);
       }

   }
   
   
   // delete row of student table 
   void DeleteStudent(int Rollno){
       try{
           //load the driver
           Class.forName("com.mysql.jdbc.Driver");

           //create the connection
           Connection connect = DriverManager.getConnection(url,username,password);

           //create the query
           String query = "DELETE FROM student WHERE studentID ="+Rollno;

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
   
   // Change Name of Student table with Rollno 
   void ChangeStudentName(int Rollno, String NewName){
       try{
           //load the driver
           Class.forName("com.mysql.jdbc.Driver");

           //create the connection
           Connection connect = DriverManager.getConnection(url,username,password);

           //create the query
           String query = "UPDATE student set StudentName = '"+NewName+"' WHERE studentID = "+Rollno;

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
   
   // Change Age of Student table with Rollno 
   void ChangeStudentAge(int Rollno, int NewAge){
       try{
           //load the driver
           Class.forName("com.mysql.jdbc.Driver");

           //create the connection
           Connection connect = DriverManager.getConnection(url,username,password);

           //create the query
           String query = "UPDATE student set Age = "+NewAge+" WHERE studentID = "+Rollno;

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
   
   // Change ID of Student table with Rollno 
   void ChangeStudentID(int Rollno, int NewID){
       try{
           //load the driver
           Class.forName("com.mysql.jdbc.Driver");

           //create the connection
           Connection connect = DriverManager.getConnection(url,username,password);

           //create the query
           String query = "UPDATE student set studentID = "+NewID+" WHERE studentID = "+Rollno;

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
   
   // Change Address of Student table with Rollno 
   void ChangeStudentAddress(int Rollno, String NewAddress){
       try{
           //load the driver
           Class.forName("com.mysql.jdbc.Driver");

           //create the connection
           Connection connect = DriverManager.getConnection(url,username,password);

           //create the query
           String query = "UPDATE student set Address = '"+NewAddress+"' WHERE studentID = "+Rollno;

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
   
   // Change Course of Student table with Rollno 
   void ChangeStudentCourse(int Rollno, String NewCourse){
       try{
           //load the driver
           Class.forName("com.mysql.jdbc.Driver");

           //create the connection
           Connection connect = DriverManager.getConnection(url,username,password);

           //create the query
           String query = "UPDATE student set Course = '"+NewCourse+"' WHERE studentID = "+Rollno;

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
   
   // read data of Student table with Rollno 
   ArrayList<String> ReadStud(int UserID){
	     try{
	         //load the driver
	         Class.forName("com.mysql.jdbc.Driver");


	         //create the connection
	         Connection connect = DriverManager.getConnection(url,username,password);

	         //create the query
	         String query = "SELECT * FROM student WHERE studentID ="+UserID;

	         //create the statement
	         Statement statement = connect.createStatement();
	         ResultSet set = statement.executeQuery(query);

	         while(set.next()){
	             System.out.println(set.getString("studentID")+" "+set.getString("StudentName") + " " +set.getString("Age")+" "+ set.getString("Address")+" "+set.getString("Course"));
	             Adlist.add(set.getString("studentID"));
	             Adlist.add(set.getString("StudentName"));
	             Adlist.add(set.getString("Age"));
	             Adlist.add(set.getString("Address"));
	             Adlist.add(set.getString("Course"));
	            
	         }
	         
	         //close the statment
	         connect.close();

	     }catch (Exception exp){
	         System.out.println(exp);
	     }
			return Adlist;

	 }
}
