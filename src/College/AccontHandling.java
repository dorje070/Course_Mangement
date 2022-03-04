package College;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class AccontHandling {
	//userName, password and Url of sql data
	private String url = "jdbc:mysql://localhost:3306/College";
    private String username = "root";
    private String password = "dorje070";
    int Id;
    
    // Create the Table of Account
    public void createAccountTable(){
        try{
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");

            //create the connection
            Connection connect = DriverManager.getConnection(url,username,password);

            //create the query
            String query = "CREATE TABLE Account(username varchar(50) PRIMARY KEY, password varchar(50) NOT NULL, Type varchar(50), userID Int )";

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

    // insert data in Account table
    public void insertAccount(String UserName,String Password, String Type){
        try{
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //create the connection
            Connection connect = DriverManager.getConnection(url,username,password);

            //create the query
            String query = "INSERT INTO Account VALUES('"+UserName+"','"+Password+"','"+Type+"', NULL);";
            
            Statement statement = connect.createStatement();
            statement.executeUpdate(query);

            System.out.println("Table Updated!!! ");

            //close the statment
            connect.close();

        }catch (Exception exp){
            JOptionPane.showMessageDialog(null, exp);
            System.exit(0);
        }

    }
    
    // Reading the Account table
    void ReadAccount(){
        try{
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");


            //create the connection
            Connection connect = DriverManager.getConnection(url,username,password);

            //create the query
            String query = "SELECT * FROM Account";

            //create the statement
            Statement statement = connect.createStatement();
            ResultSet set = statement.executeQuery(query);

            while(set.next()){
                System.out.println(set.getString("username")+" "+set.getString("password") + " "+ set.getString("Type")+" "+set.getInt("userID"));
                
            }

            //close the statment
            connect.close();

        }catch (Exception exp){
            System.out.println(exp);
        }

    }
    
    //Delete the row of Account table with Username
    void DeleteAccount(String userName){
        try{
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");

            //create the connection
            Connection connect = DriverManager.getConnection(url,username,password);

            //create the query
            String query = "DELETE FROM Account WHERE username = '"+userName+"'";

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
    
    // insert the userID with username
    void insertUserID(String userName, int UserID){
        try{
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");

            //create the connection
            Connection connect = DriverManager.getConnection(url,username,password);

            //create the query
            String query = "UPDATE Account set userID ="+UserID+" WHERE username ='"+userName+"'";

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
    
    // Reading the id with Username
    public int ReadId(String UserName) {
    	
    	try{
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");


            //create the connection
            Connection connect = DriverManager.getConnection(url,username,password);

            //create the query
            String query = "SELECT * FROM Account WHERE username ='"+UserName+"'";

            //create the statement
            Statement statement = connect.createStatement();
            ResultSet set = statement.executeQuery(query);

            while(set.next()){
                System.out.println(set.getInt("userID"));
                Id= set.getInt("userID");
            }

            //close the statment
            connect.close();

        }catch (Exception exp){
            System.out.println(exp);
        }
    	return Id;
    }
}
