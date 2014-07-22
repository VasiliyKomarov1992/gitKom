package example1;

public class User {

	String name;
	String password;
	String email;
	
	@Override
	public String toString() {
		return "[" + name + "," + password + ", " + email + "]";
	}
	
}
