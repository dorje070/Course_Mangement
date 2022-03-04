package College;

public class main {
	//please run th proagram from login class
	
	// reading the data only or test 
    public static void main(String[] args) {
        DataHandling handing = new DataHandling();
        
        StudentHandling sthand = new StudentHandling();
     
        sthand.ReadStudent();
       
        
        AdministratorHandling Adhand = new AdministratorHandling();

        Adhand.ReadEmployee();
        
        
        InstructorHandling Inhand = new InstructorHandling();
  
        Inhand.ReadInstructor();
        
        
        ModuleHandling Mohand = new ModuleHandling();

        Mohand.ReadModules();
        
        
        CourseHandling Cohand = new CourseHandling();

        Cohand.ReadCourse();
        
        SemesterHandling sehand = new SemesterHandling();

        sehand.ReadSemester();
        
        AccontHandling athand = new AccontHandling();
       
        athand.ReadAccount();
        
    }
}
