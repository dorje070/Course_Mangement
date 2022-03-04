package College;



public class Instructor implements Staff {
	
	private String Name;  // instructor Name 
	private int Age;      // instructor Age 
	private int EmployeeID;  // Employee Id
	private String Type;     // instructor Type
	private String Education;  // instructor education level
	
	// Constructor of Instructor 
	Instructor(String Name){
		this.Name = Name;
	}
	
	// Second Constructor of Instructor 
	Instructor(String Name,int EmployeeID, int Age, String Type, String Education){
		this.EmployeeID = EmployeeID;
		this.Name = Name;
		this.Age = Age;
		this.Type =Type;
		this.Education = Education;
	}
	
	// Getter of Name
	public String getName() {
		return Name;
	}
	
	// Setter of Name
	public void setName(String name) {
		Name = name;
	}
	
	// Getter of Age
	public int getAge() {
		return Age;
	}
	
	// Setter of Age
	public void setAge(int age) {
		Age = age;
	}
	
	// Getter of Type
	public String getType() {
		return Type;
	}
	
	// Setter of Type
	public void setType(String type) {
		Type = type;
	}
	
	// Getter of education
	public String getEducation() {
		return Education;
	}
	
	// Setter of Education
	public void setEducation(String education) {
		Education = education;
	}
	
	// Getter of Employee ID
	public int getEmployeeID() {
		return EmployeeID;
	}
	
	// Setter of Employee ID
	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}

	
	
	
}
