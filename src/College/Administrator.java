package College;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class Administrator implements Staff{
	private String Name;      // Administrator Name
	private int Age;          // Administrator Age
	private int EmployeeID;   // Administrator Employee ID
	private String Type;      // Administrator Type (leader, Leacture, tutorial)
	private String Education; // Administrator Education level
	
	
	// Administrator Constructor
	public Administrator(String Name){
		this.Name =Name;
	}
	
	// Administrator Second Constructor
    public Administrator(String Name,int EmployeeID, int Age, String Type, String Education){
		this.Name = Name;
		this.Age = Age;
		this.EmployeeID = EmployeeID;
		this.Type = Type;
		this.Education = Education;
	}
	
    // getter of Name
	public String getName() {
		return Name;
	}
	
	// setter of Name
	public void setName(String name) {
		Name = name;
	}
	
	// getter of Age
	public int getAge() {
		return Age;
	}
	
	// setter of Age
	public void setAge(int age) {
		Age = age;
	}
	
	// getter of type
	public String getType() {
		return Type;
	}
	
	// setter of type
	public void setType(String type) {
		Type = type;
	}
	
	// getter of Education
	public String getEducation() {
		return Education;
	}
	
	// setter of Education
	public void setEducation(String education) {
		Education = education;
	}
	
	// getter of Employee ID
	public int getEmployeeID() {
		return EmployeeID;
	}
	
	// setter of Employee ID
	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}

	
	
	
	
	
	
}
