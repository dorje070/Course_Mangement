package College;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DataHandling {
	// url , username and password of mysql 
	private String url = "jdbc:mysql://localhost:3306";
    private String username = "root";
    private String password = "dorje070";
    
    // create the College database
    public void createBase(){
        try {
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");

            //create the connection
           Connection connect = DriverManager.getConnection(url,username,password);

           // create the query
            String query = "CREATE DATABASE College";

           //create the statement
            Statement statement = connect.createStatement();
            int value = statement.executeUpdate(query);
            System.out.println(value);
            System.out.println("Database Created!!!");

            //close the connection
            connect.close();

        }catch (ClassNotFoundException exp){
            System.out.println(exp);

        }catch (SQLException e){
            System.out.println(e);

        }

    }
    
    // use the College database
    public void useBase() {
    	try {
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //create the connection
           Connection connect = DriverManager.getConnection(url,username,password);

           // create the query
            String query = "use College";

           //create the statement
            Statement statement = connect.createStatement();
            int value = statement.executeUpdate(query);
            System.out.println(value);
            System.out.println("use College database");

            //close the connection
            connect.close();

        }catch (ClassNotFoundException exp){
            System.out.println(exp);

        }catch (SQLException e){
            System.out.println(e);

        }

    }
    
    
    
 
   
   
}


