package College;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class AdministratorHandling  {
	// username, password and url of mysql database
	private String url = "jdbc:mysql://localhost:3306/College";
    private String username = "root";
    private String password = "dorje070";
    
    // Adlist for Storing the data
    private ArrayList<String> Adlist = new ArrayList<String>();
    
    // Creating the Administrator Table
    public void createAdministratorTable(){
        try{
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");

            //create the connection
            Connection connect = DriverManager.getConnection(url,username,password);

            //create the query
            String query = "CREATE TABLE Administrator(employeeID int PRIMARY KEY AUTO_INCREMENT, Name varchar(50) NOT NULL,Age int, Type varchar(50), Education varchar(50) )";

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
    
    // insert the data in Administrator table
    public boolean insertAdministrator(String Name,int ID, int Age, String Type, String Education){
    	boolean exception = false;
        try{
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //create the connection
            Connection connect = DriverManager.getConnection(url,username,password);

            //create the query
            String query = "INSERT INTO Administrator VALUES("+ID+",'"+Name+"',"+Age+",'"+Type+"','"+Education+"');";
            
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
   
    // Reading Administrator data from the Administrator Table
    void ReadEmployee(){
        try{
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");


            //create the connection
            Connection connect = DriverManager.getConnection(url,username,password);

            //create the query
            String query = "SELECT * FROM Administrator";

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
    
    // delete the row of Administrator with Employee ID
    void DeleteAdministrator(int ID){
        try{
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");

            //create the connection
            Connection connect = DriverManager.getConnection(url,username,password);

            //create the query
            String query = "DELETE FROM Administrator WHERE employeeID ="+ID;

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
    
    // Change the Administrator Name with Employee ID
    void ChangeAdministratorName(int ID, String NewName){
	       try{
	           //load the driver
	           Class.forName("com.mysql.jdbc.Driver");

	           //create the connection
	           Connection connect = DriverManager.getConnection(url,username,password);

	           //create the query
	           String query = "UPDATE Administrator set Name = '"+NewName+"' WHERE employeeID = "+ID;

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
    
    // Change Administrator ID with old Administrator ID
    void ChangeAdministratorID(int ID, int NewID){
        try{
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");

            //create the connection
            Connection connect = DriverManager.getConnection(url,username,password);

            //create the query
            String query = "UPDATE Administrator set employeeID = "+NewID+" WHERE employeeID = "+ID;

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
    
    // Change Administrator Age with Administartor ID
    void ChangeAdministratorAge(int ID, int NewAge){
        try{
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");

            //create the connection
            Connection connect = DriverManager.getConnection(url,username,password);

            //create the query
            String query = "UPDATE Administrator set Age = "+NewAge+" WHERE employeeID = "+ID;

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
    
    // Change Administrator Type with Administrator ID
    void ChangeAdministratorType(int ID, String NewType){
	       try{
	           //load the driver
	           Class.forName("com.mysql.jdbc.Driver");

	           //create the connection
	           Connection connect = DriverManager.getConnection(url,username,password);

	           //create the query
	           String query = "UPDATE Administrator set Type = '"+NewType+"' WHERE employeeID = "+ID;

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
    
    // Change Administrator Education with Administrator ID
    void ChangeAdministratorEducation(int ID, String NewEducation){
	       try{
	           //load the driver
	           Class.forName("com.mysql.jdbc.Driver");

	           //create the connection
	           Connection connect = DriverManager.getConnection(url,username,password);

	           //create the query
	           String query = "UPDATE Administrator set Education = '"+NewEducation+"' WHERE employeeID = "+ID;

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
    
    // Read the data row of Administrator table with UserID
    ArrayList<String> ReadAdmin(int UserID){
        try{
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");


            //create the connection
            Connection connect = DriverManager.getConnection(url,username,password);

            //create the query
            String query = "SELECT * FROM Administrator WHERE employeeID ="+UserID;

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
