package College;

import java.util.HashMap;

public class Students {
	private String Name;
	private int Rollno;
	private int Age;
	private String Address;
	private String CourseName;
	private HashMap<String, Integer> Semester = new HashMap<String, Integer>();
	
	Students (String Name, int Rollno, int Age, String Address, String CourseName){
		this.Name =Name;
		this.Rollno = Rollno;
		this.Age = Age;
		this.Address = Address;
		this.CourseName = CourseName;
	}
	
	public String getName() {
		return Name;
	}
	
	
	public void setName(String name) {
		Name = name;
	}
	
	public int getRollno() {
		return Rollno;
	}
	
	public void setRollno(int rollno) {
		Rollno = rollno;
	}


	public int getAge() {
		return Age;
	}


	public void setAge(int age) {
		Age = age;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public String getCourseName() {
		return CourseName;
	}


	public void setCourseName(String courseName) {
		CourseName = courseName;
	}


	public HashMap<String, Integer> getSemester() {
		return Semester;
	}


	public void setSemester(HashMap<String, Integer> semester) {
		Semester = semester;
	}
	
	

}
