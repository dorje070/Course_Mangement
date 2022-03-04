package College;

import java.util.HashMap;

public class semester {
	
	private String Studentname; // Student Name 
	private int Rollno;        // Student Mark 
	private String Module1;    // Module1 Name
	private int Mark1;         // Mark1
	private String Module2;    // Module1 Name
	private int Mark2;        // Mark2
	private String Module3;   // Module1 Name
	private int Mark3;         // Mark3
	private String Module4;  // Module1 Name
	private int Mark4;         // Mark4
	private String Course;    // course Name 
	private int Semesterno;   // semester no
	
	// Constructor of Semester 
	semester(int Rollno, String Studentname, String Course, String Module1, int Mark1, String Module2, int Mark2, String Module3, int Mark3, String Module4, int Mark4, int Semesterno){
		this.Rollno = Rollno;
		this.Studentname = Studentname;
		this.Course = Course;
		this.Module1 = Module1;
		this.Mark1 = Mark1;
		this.Module2 = Module2;
		this.Mark2 = Mark2;
		this.Module3 = Module3;
		this.Mark3 = Mark3;
		this.Module4 = Module4;
		this.Semesterno = Semesterno;
	}
	
	// Getter of student Name
	public String getStudentname() {
		return Studentname;
	}
	
	public void setStudentname(String studentname) {
		Studentname = studentname;
	}
	
	// Getter of Roll no
	public int getRollno() {
		return Rollno;
	}
	
	// Setter of Rollno
	public void setRollno(int rollno) {
		Rollno = rollno;
	}
	
	// Getter of Course
	public String getCourse() {
		return Course;
	}
	
	// Setter of Course
	public void setCourse(String course) {
		Course = course;
	}
	
	// Getter of Module1
	public String getModule1() {
		return Module1;
	}
	
	// Setter of Module1
	public void setModule1(String module1) {
		Module1 = module1;
	}
	
	// Getter of Mark1
	public int getMark1() {
		return Mark1;
	}
	
	// Setter of Mark1
	public void setMark1(int mark1) {
		Mark1 = mark1;
	}
	
	// Getter of Mark2
	public int getMark2() {
		return Mark2;
	}
	
	// Setter of Mark2
	public void setMark2(int mark2) {
		Mark2 = mark2;
	}
	
	// Getter of Module2
	public String getModule2() {
		return Module2;
	}
	
	// Setter of Module2
	public void setModule2(String module2) {
		Module2 = module2;
	}
	
	// Getter of Module3
	public String getModule3() {
		return Module3;
	}
	
	// Setter of Module3
	public void setModule3(String module3) {
		Module3 = module3;
	}
	
	// Getter of Module4
	public String getModule4() {
		return Module4;
	}
	
	// Setter of Module4
	public void setModule4(String module4) {
		Module4 = module4;
	}
	
	// Getter of Mark3
	public int getMark3() {
		return Mark3;
	}
	
	// Setter of Mark3
	public void setMark3(int mark3) {
		Mark3 = mark3;
	}
	
	// Getter of Mark4
	public int getMark4() {
		return Mark4;
	}
	public void setMark4(int mark4) {
		Mark4 = mark4;
	}
	
	// Getter of semester no
	public int getSemesterno() {
		return Semesterno;
	}
	
	// Setter of Semester no
	public void setSemesterno(int semesterno) {
		Semesterno = semesterno;
	}
	
	
}
