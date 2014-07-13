package emailClient;

public class MailTest {

	public static void main(String[] args) {
		
		MailServer server = new MailServer();
		
		MailUser client1 = new MailUser("Howard Finch ", "fin@gl.com");
		MailUser client2 = new MailUser("John Reese ", "reese@gl.com");
		MailUser client3 = new MailUser("Samina Shaw ", "saminshow@gl.com");
		
		server.addEmailClient(client1);
		server.addEmailClient(client2);
		server.addEmailClient(client3);

		server.iterates();
		
		
	}
	
}
