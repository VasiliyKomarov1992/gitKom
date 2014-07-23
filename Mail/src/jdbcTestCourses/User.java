package jdbcTestCourses;

public class User { //	POJO - plain old java Object 
	//	java bean

	/*
	 * User.name
	 * User.password
	 * User.email
	 */
// если метод начинается с get6 то это getter6  соотвественно так же и set
	
	String name;
	String password;
	String email;
	
	public User(String name, String password, String email) {
		this.name = name;
		this.password = password;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
