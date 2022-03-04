package College;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CourseHandling {
	// username, password and url of mysql database
	private String url = "jdbc:mysql://localhost:3306/College";
    private String username = "root";
    private String password = "dorje070";
    
	// create the Course table
	public void createCourseTable(){
        try{
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");

            //create the connection
            Connection connect = DriverManager.getConnection(url,username,password);

            //create the query
            String query = "CREATE TABLE Course (Coursename varchar(50) PRIMARY KEY, Module1 varchar(50) , Module2 varchar(50), Module3 varchar(50), Module4 varchar(50), Module5 varchar(50), Module6 varchar(50), Module7 varchar(50), Module8 varchar(50) )";

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
	
	// insert data into Course table
	public void insertCourse(String Coursename, String Module1, String Module2, String Module3, String Module4, String Module5, String Module6, String Module7){
        try{
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //create the connection
            Connection connect = DriverManager.getConnection(url,username,password);

            //create the query
            String query = "INSERT INTO Course VALUES('"+Coursename+"','"+Module1+"','"+Module2+"','"+Module3+"','"+Module4+"','"+Module5+"','"+Module6+"','"+Module7+"', NULL);";
            
            Statement statement = connect.createStatement();
            statement.executeUpdate(query);

            System.out.println("Table Updated!!! ");

            //close the statment
            connect.close();

        }catch (Exception exp){
            System.out.println(exp);
        }

    }
	
	// Read data of Course table
	void ReadCourse(){
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

            while(set.next()){
                System.out.println(set.getString("Coursename")+" "+set.getString("Module1") + " " +set.getString("Module2")+" "+ set.getString("Module3")+" "+set.getString("Module4")+" "+set.getString("Module5")+" "+set.getString("Module6")+" "+set.getString("Module7")+" "+set.getString("Module8"));
                
            }

            //close the statment
            connect.close();

        }catch (Exception exp){
            System.out.println(exp);
        }

    }
	
	
	// set Module8 of course table 
	void ChoseModule(String Module8, String Coursename){
		  try{
	           //load the driver
	           Class.forName("com.mysql.jdbc.Driver");

	           //create the connection
	           Connection connect = DriverManager.getConnection(url,username,password);

	           //create the query
	           String query = "UPDATE Course set Module8 = '"+Module8+"' WHERE Coursename = '"+Coursename+"'";

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
	
	// set the Module 1 of course table
	void ChangeModule1(String Module1, String Coursename){
		  try{
	           //load the driver
	           Class.forName("com.mysql.jdbc.Driver");

	           //create the connection
	           Connection connect = DriverManager.getConnection(url,username,password);

	           //create the query
	           String query = "UPDATE Course set Module1 = '"+Module1+"' WHERE Coursename = '"+Coursename+"'";

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
	
	// set the Module 2 of course table
	void ChangeModule2(String Module, String Coursename){
		  try{
	           //load the driver
	           Class.forName("com.mysql.jdbc.Driver");

	           //create the connection
	           Connection connect = DriverManager.getConnection(url,username,password);

	           //create the query
	           String query = "UPDATE Course set Module2 = '"+Module+"' WHERE Coursename = '"+Coursename+"'";

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
	
	// set the Module3 of course table
	void ChangeModule3(String Module, String Coursename){
		  try{
	           //load the driver
	           Class.forName("com.mysql.jdbc.Driver");

	           //create the connection
	           Connection connect = DriverManager.getConnection(url,username,password);

	           //create the query
	           String query = "UPDATE Course set Module3 = '"+Module+"' WHERE Coursename = '"+Coursename+"'";

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
	
	// set the Module4 of course table
	void ChangeModule4(String Module, String Coursename){
		  try{
	           //load the driver
	           Class.forName("com.mysql.jdbc.Driver");

	           //create the connection
	           Connection connect = DriverManager.getConnection(url,username,password);

	           //create the query
	           String query = "UPDATE Course set Module4 = '"+Module+"' WHERE Coursename = '"+Coursename+"'";

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
	
	// set the Module5 of course table
	void ChangeModule5(String Module, String Coursename){
		  try{
	           //load the driver
	           Class.forName("com.mysql.jdbc.Driver");

	           //create the connection
	           Connection connect = DriverManager.getConnection(url,username,password);

	           //create the query
	           String query = "UPDATE Course set Module5 = '"+Module+"' WHERE Coursename = '"+Coursename+"'";

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
	
	// set the Module6 of course table
	void ChangeModule6(String Module, String Coursename){
		  try{
	           //load the driver
	           Class.forName("com.mysql.jdbc.Driver");

	           //create the connection
	           Connection connect = DriverManager.getConnection(url,username,password);

	           //create the query
	           String query = "UPDATE Course set Module6 = '"+Module+"' WHERE Coursename = '"+Coursename+"'";

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
	
	// set the Module7 of course table
	void ChangeModule7(String Module, String Coursename){
		  try{
	           //load the driver
	           Class.forName("com.mysql.jdbc.Driver");

	           //create the connection
	           Connection connect = DriverManager.getConnection(url,username,password);

	           //create the query
	           String query = "UPDATE Course set Module7 = '"+Module+"' WHERE Coursename = '"+Coursename+"'";

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
	
	// delete the row of course with course name
	void deleteCourse(String Coursename){
		  try{
	           //load the driver
	           Class.forName("com.mysql.jdbc.Driver");

	           //create the connection
	           Connection connect = DriverManager.getConnection(url,username,password);

	           //create the query
	           String query = "DELETE FROM Course WHERE Coursename = '"+Coursename+"'";

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
}
