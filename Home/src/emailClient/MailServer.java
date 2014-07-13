package emailClient;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MailServer {
	
	List<Message> messageBox = new LinkedList<>();
	ArrayList<MailUser> mailAdressClient = new ArrayList<>();
	
	public void addEmailClient(MailUser client) {
		mailAdressClient.add(client);
	}
	
	public void saveMessages(Message textMessages) {
		messageBox.add(textMessages);
		dispatchMail(textMessages);
	}
	
	private void dispatchMail(Message textMessages) {
		
	}
	
	public void iterates() {
		for (MailUser elem : mailAdressClient) {
			System.out.println(elem.getNameEmail());
		}
	}
	
}
