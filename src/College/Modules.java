package College;

public class Modules {
	private String Modulename;  // Module Name 
	private int ModuleCode;    // Module Code 
	private String ModuleLeader;  // Module Leader
	private String Lecture;   // Module Leacture
	private String Tutorial;  // Module Tutorial
	
	// Constructor of Module 
	public Modules(String Modulename, int ModuleCode, String ModuleLeader, String Lecture, String Tutorial) {
		this.Modulename = Modulename;
		this.ModuleCode = ModuleCode;
		this.ModuleLeader = ModuleLeader;
		this.Lecture = Lecture;
		this.Tutorial = Tutorial;
	}
	
	// Getter of Modulename
	public String getModulename() {
		return Modulename;
	}
	
	// setter of Module name 
	public void setModulename(String modulename) {
		Modulename = modulename;
	}
	
	// Getter of Module code
	public int getModuleCode() {
		return ModuleCode;
	}
	
	// setter of Module name 
	public void setModuleCode(int moduleCode) {
		ModuleCode = moduleCode;
	}
	
	// Getter of Module Leader
	public String getModuleLeader() {
		return ModuleLeader;
	}
	
	// setter of Module name 
	public void setModuleLeader(String moduleLeader) {
		ModuleLeader = moduleLeader;
	}
	
	// Getter of Leacture
	public String getLecture() {
		return Lecture;
	}
	
	// setter of Module name 
	public void setLecture(String lecture) {
		Lecture = lecture;
	}
	
	// Getter of  Tutorial 
	public String getTutorial() {
		return Tutorial;
	}
	
	// setter of Module name 
	public void setTutorial(String tutorial) {
		Tutorial = tutorial;
	}
	
	
}
