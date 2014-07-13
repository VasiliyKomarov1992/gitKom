package emailClient;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class MailUser {

	private List mailInbox;
	private List mailOutbox;
	private String _name;
	private String _email;
	
	public MailUser(String name, String email) {
		_name = name;
		_email = email;
	}
	
	
	public Message createMessage() {
		
		String senderAdress;
		String receiverAdress;
		String textMessages;
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				Scanner scanner = new Scanner(System.in);
				while (true) {
					if (scanner.hasNext()) {
						String text = scanner.nextLine();
						sendMessage(text);
					}
				}
			}
		}).start();
		Message newMessage = new Message(senderAdress, receiverAdress, textMessages);
	}
	
	public void sendMessage(String text) {
		System.out.println(_name + _email + " " + text);
		mailOutbox.add(text);
	}
	
	public void takeMessage(Message receivedMsg) {
		mailInbox.add(receivedMsg);
	}
	
	public String getNameEmail() {
		return _name + " " + _email;
	}
}
