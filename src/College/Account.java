package College;

public class Account {
	private String username; //Account Username
	private String password; // Account password
	private String type;  //Account Type
	private int userID;  // Account userID
	
	//Account Constructor
	Account(String Username, String password, String type, int userID){
		this.username = Username;
		this.password = password;
		this.type = type;
		this.userID = userID;
	}
	
	//Account second Constructor
	Account(String Username, String password, String type){
		this.username = Username;
		this.password = password;
		this.type = type;
	
	}
	
	// getter of Username
	public String getUsername() {
		return username;
	}
	
	// setter of Username
	public void setUsername(String username) {
		this.username = username;
	}
	
	// getter of password
	public String getPassword() {
		return password;
	}
	
	// setter of password
	public void setPassword(String password) {
		this.password = password;
	}
	
	// getter of type
	public String getType() {
		return type;
	}
	
	// setter of type
	public void setType(String type) {
		this.type = type;
	}
	
	// getter of UserID
	public int getUserID() {
		return userID;
	}
	// setter of UserID
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
}
