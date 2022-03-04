package College;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ModuleHandling {
	// url username and password of Module handling 
	private String url = "jdbc:mysql://localhost:3306/College";
    private String username = "root";
    private String password = "dorje070";
    
    // Create Module table 
    public void createModuleTable(){
        try{
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");

            //create the connection
            Connection connect = DriverManager.getConnection(url,username,password);

            //create the query
            String query = "CREATE TABLE Modules(ModuleCode int PRIMARY KEY AUTO_INCREMENT, Modulename varchar(50) NOT NULL, ModuleLeader varchar(50), Lecture varchar(50), Tutorial varchar(50) )";

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
    
    // insert Fuction 
    public void insertModule(String Name,int Code, String Leader, String Lecture, String Tutorial){
        try{
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //create the connection
            Connection connect = DriverManager.getConnection(url,username,password);

            //create the query
            String query = "INSERT INTO Modules VALUES("+Code+",'"+Name+"','"+Leader+"','"+Lecture+"','"+Tutorial+"');";
            
            Statement statement = connect.createStatement();
            statement.executeUpdate(query);

            System.out.println("Table Updated!!! ");

            //close the statment
            connect.close();

        }catch (Exception exp){
            System.out.println(exp);
        }

    }
    
    // Read data from Module table
    void ReadModules(){
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

            while(set.next()){
                System.out.println(set.getString("ModuleCode")+" "+set.getString("Modulename") + " " +set.getString("ModuleLeader")+" "+ set.getString("Lecture")+" "+set.getString("Tutorial"));
                
            }

            //close the statment
            connect.close();

        }catch (Exception exp){
            System.out.println(exp);
        }

    }
    
    // delete data from the Module table 
    void DeleteModule(int Code){
        try{
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");

            //create the connection
            Connection connect = DriverManager.getConnection(url,username,password);

            //create the query
            String query = "DELETE FROM Modules WHERE ModuleCode ="+Code;

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
    
    // Change name of Module table 
    void ChangeModuleName(int Code, String NewName){
	       try{
	           //load the driver
	           Class.forName("com.mysql.jdbc.Driver");

	           //create the connection
	           Connection connect = DriverManager.getConnection(url,username,password);

	           //create the query
	           String query = "UPDATE Modules set Modulename = '"+NewName+"' WHERE ModuleCode = "+Code;

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
    
    // change Code of module table 
    void ChangeModuleCode(int Code, int NewCode){
        try{
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");

            //create the connection
            Connection connect = DriverManager.getConnection(url,username,password);

            //create the query
            String query = "UPDATE Modules set ModuleCode = "+NewCode+" WHERE ModuleCode = "+Code;

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
    
    // change of module leader of module table
    void ChangeModuleLeader(int Code, String Newleader){
	       try{
	           //load the driver
	           Class.forName("com.mysql.jdbc.Driver");

	           //create the connection
	           Connection connect = DriverManager.getConnection(url,username,password);

	           //create the query
	           String query = "UPDATE Modules set ModuleLeader = '"+Newleader+"' WHERE ModuleCode = "+Code;

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
    
    // change of module leacture of module table
    void ChangeModuleLecture(int Code, String Newleader){
	       try{
	           //load the driver
	           Class.forName("com.mysql.jdbc.Driver");

	           //create the connection
	           Connection connect = DriverManager.getConnection(url,username,password);

	           //create the query
	           String query = "UPDATE Modules set Lecture = '"+Newleader+"' WHERE ModuleCode = "+Code;

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
    
    // change of module Tutorial of module table
    void ChangeModuleTutorial(int Code, String NewTutorial){
	       try{
	           //load the driver
	           Class.forName("com.mysql.jdbc.Driver");

	           //create the connection
	           Connection connect = DriverManager.getConnection(url,username,password);

	           //create the query
	           String query = "UPDATE Modules set Tutorial = '"+NewTutorial+"' WHERE ModuleCode = "+Code;

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
