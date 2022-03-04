package College;

import java.io.File;


// interface class 
public interface Staff {
	public String Name = "Null";
	public int Age = 0;
	public int EmployeeID = 0;
	public String Type = "Null";
	public String Education = "Null";
	
	
	// abstract function
	
	public void setName(String Name);
	
	public void setAge(int Age);
	
	public void setType(String Type);
	
	public void setEmployeeID(int EmployeeID);
	
	public void setEducation(String Education);

	
	
	
	public String getName();
	
	public int getAge();
	
	public String getType();
	
    public int getEmployeeID();
	
	public String getEducation();
	
	




	
	
}
