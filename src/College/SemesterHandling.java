package College;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SemesterHandling {
	// url, username and password 
	private String url = "jdbc:mysql://localhost:3306/College";
    private String username = "root";
    private String password = "dorje070";
    
    // Create Semester table 
    public void createSemesterTable(){
        try{
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");

            //create the connection
            Connection connect = DriverManager.getConnection(url,username,password);

            //create the query
            String query = "CREATE TABLE Semester(StudentID int PRIMARY KEY AUTO_INCREMENT, Studentname varchar(50) NOT NULL, Course varchar(50),Module1 varchar(50), Mark1 int, Module2 varchar(50), Mark2 int, Module3 varchar(50), Mark3 int, Module4 varchar(50), Mark4 int, Semesterno int )";

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
    
    // insert data in Semester Table 
    public void insertSemester(String Name,int ID,String Course, String Module1, int Mark1, String Module2, int Mark2, String Module3, int Mark3, String Module4, int Mark4,int Semesterno){
        try{
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //create the connection
            Connection connect = DriverManager.getConnection(url,username,password);

            //create the query
            String query = "INSERT INTO Semester VALUES("+ID+",'"+Name+"','"+Course+"','"+Module1+"',"+Mark1+",'"+Module2+"',"+Mark2+",'"+Module3+"',"+Mark3+",'"+Module4+"',"+Mark4+","+Semesterno+");";
            
            Statement statement = connect.createStatement();
            statement.executeUpdate(query);

            System.out.println("Table Updated!!! ");

            //close the statment
            connect.close();

        }catch (Exception exp){
            System.out.println(exp);
        }

    }
    
    void ReadSemester(){
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

            while(set.next()){
                System.out.println(set.getString("StudentID")+" "+set.getString("Studentname") + " " +set.getString("Course")+" "+ set.getString("Module1")+" "+set.getString("Mark1")+" "+set.getString("Module2")+" "+set.getString("Mark2")+" "+set.getString("Module3")+" "+set.getString("Mark3")+" "+set.getString("Module4")+" "+set.getString("Mark4")+" "+set.getString("Semesterno"));
                
            }

            //close the statment
            connect.close();

        }catch (Exception exp){
            System.out.println(exp);
        }

    }
    
 // delete data in Semester Table 
    void DeleteSemester(int StudentID){
        try{
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");

            //create the connection
            Connection connect = DriverManager.getConnection(url,username,password);

            //create the query
            String query = "DELETE FROM Semester WHERE StudentID ="+StudentID;

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
    
 // set Mark  in Semester Table 
    void SetMarks(int Mark1, int Mark2, int Mark3, int Mark4, int ID) {
    	try{
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");

            //create the connection
            Connection connect = DriverManager.getConnection(url,username,password);

            //create the query
            String query = "UPDATE Semester SET Mark1 ="+Mark1+", Mark2 ="+Mark2+", Mark3 ="+Mark3+", Mark4 ="+Mark4+" WHERE StudentID ="+ID+";";

            //create the statement
            Statement statement = connect.createStatement();
            statement.executeUpdate(query);

            System.out.println("update the data ");

            //close the statment
            connect.close();

        }catch (Exception exp){
            System.out.println(exp);
        }
    }
    
 // Change semester no of Semester table with employee Id
    void ChangeSemester(int Semester_no, int ID) {
    	try{
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");

            //create the connection
            Connection connect = DriverManager.getConnection(url,username,password);

            //create the query
            String query = "UPDATE Semester SET Semesterno ="+Semester_no+",  Module4 = NULL WHERE StudentID ="+ID+";";

            //create the statement
            Statement statement = connect.createStatement();
            statement.executeUpdate(query);

            System.out.println("update the data ");

            //close the statment
            connect.close();

        }catch (Exception exp){
            System.out.println(exp);
        }
    }
    
    // Change semester2 Module table with employee Id
    void SetSemester2(String Module1, String Module2, String Module3, int ID) {
    	try{
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");

            //create the connection
            Connection connect = DriverManager.getConnection(url,username,password);

            //create the query
            String query = "UPDATE Semester SET Module1 = '"+Module1+"', Module2 = '"+Module2+"', Module3 ='"+Module3+"', Module4 = NULL WHERE StudentID ="+ID+";";

            //create the statement
            Statement statement = connect.createStatement();
            statement.executeUpdate(query);

            System.out.println("update the data ");

            //close the statment
            connect.close();

        }catch (Exception exp){
            System.out.println(exp);
        }
    }
    
    // Change semester1 Module table with employee Id
    void SetSemester1(String Module1, String Module2, String Module3, String Module4, int ID) {
    	try{
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");

            //create the connection
            Connection connect = DriverManager.getConnection(url,username,password);

            //create the query
            String query = "UPDATE Semester SET Module1 = '"+Module1+"', Module2 = '"+Module2+"', Module3 ='"+Module3+"', Module4 ='"+Module4+"' WHERE StudentID ="+ID+";";

            //create the statement
            Statement statement = connect.createStatement();
            statement.executeUpdate(query);

            System.out.println("update the data ");

            //close the statment
            connect.close();

        }catch (Exception exp){
            System.out.println(exp);
        }
    }
    
    // Change chose module4 with employee Id
    void ChoseModule4(String Module4, int ID) {
    	try{
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");

            //create the connection
            Connection connect = DriverManager.getConnection(url,username,password);

            //create the query
            String query = "UPDATE Semester SET Module4 = '"+Module4+"' WHERE StudentID ="+ID+";";

            //create the statement
            Statement statement = connect.createStatement();
            statement.executeUpdate(query);

            System.out.println("update the data ");

            //close the statment
            connect.close();

        }catch (Exception exp){
            System.out.println(exp);
        }
    }
}
