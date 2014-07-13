package emailClient;

public class MailTest {

	public static void main(String[] args) {
		
		MailServer server = new MailServer();
		
		User client1 = new User("Howard Finch ", "fin@gl.com");
		User client2 = new User("John Reese ", "reese@gl.com");
		User client3 = new User("Samina Shaw ", "saminshow@gl.com");
		
		server.addEmailClient(client1);
		server.addEmailClient(client2);
		server.addEmailClient(client3);

		server.iterates();
		
		
	}
	
}
