package College;

import java.util.LinkedList;

public class Courses {
	
	private String Coursename; // Course name
	private String Module1;    // Module1 name
	private String Module2;    // Module2 name
	private String Module3;    // Module3 name
	private String Module4;    // Module4 name
	private String Module5;    // Module5 name
	private String Module6;    // Module6 name
	private String Module7;    // Module7 name 
	private String Module8;    // Module8 name
	
	// Course Constructor
	public Courses (String Coursename, String Module1, String Module2, String Module3, String Module4, String Module5, String Module6, String Module7) {
		this.Coursename = Coursename;
		this.setModule1(Module1);
		this.setModule2(Module2);
		this.setModule3(Module3);
		this.setModule4(Module4);
		this.setModule5(Module5);
		this.setModule6(Module6);
		this.setModule7(Module7);
		
			
	}
	
	// Getter of Course name
	public String getCoursename() {
		return Coursename;
	}
	
	// Setter of Course name
	public void setCoursename(String coursename) {
		Coursename = coursename;
	}
	
	// Getter of Module1
	public String getModule1() {
		return Module1;
	}
	
	// setter of Module1
	public void setModule1(String module1) {
		Module1 = module1;
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


	 // Getter of Module5
	public String getModule5() {
		return Module5;
	}


	// Setter of Module5
	public void setModule5(String module5) {
		Module5 = module5;
	}


	 // Getter of Module7
	public String getModule7() {
		return Module7;
	}


	// Setter of Module7
	public void setModule7(String module7) {
		Module7 = module7;
	}


	 // Getter of Module6
	public String getModule6() {
		return Module6;
	}


	// Setter of Module6
	public void setModule6(String module6) {
		Module6 = module6;
	}


	 // Getter of Module8
	public String getModule8() {
		return Module8;
	}


	// Setter of Module8
	public void setModule8(String module8) {
		Module8 = module8;
	}
	
	
	


}
