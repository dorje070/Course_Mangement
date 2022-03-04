package College;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling {
	// data or username 
	private String data;
	
	// writing username while login and create Account 
	public void WriteUsername(String username) {
		try {
			FileWriter myWriter = new FileWriter("filename.txt");
			myWriter.write(username);
			myWriter.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// Reading the username from the filename.txt file 
	public String ReadUsername(){
		try {
			File myObj = new File("filename.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        data = myReader.nextLine();
		        System.out.println(data);
		      }
		      myReader.close();
		}catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
	}
		
		return data;
	}
}
