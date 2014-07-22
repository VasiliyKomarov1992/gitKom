package Mail;

import java.util.HashMap;

import mainClasses.MailServerClient;
import auxillaryClasses.Message;
import auxillaryClasses.ServerHashKey;

public class Server {

	private final HashMap<ServerHashKey, Message> messages = new HashMap<>();

	private final HashMap<String, MailServerClient> users = new HashMap<>();


//	public void showMessages() {
//		
//		for (Entry<ServerHashKey, Message> entry : messages.entrySet()) {
//		    System.out.println("Email: " + entry.getKey().recipientsAddress + " Text Messages: "
//		        + entry.getValue().messagesText);
//		}
//	}
	
//	public HashMap<ServerHashKey, Message> showAllMessages() {
//		return this.messages;
//	}

	public int sendMessage(String _sendersAdress, String _recipientsAdress) {
		if (!users.containsKey(_sendersAdress)) {
			return 1;
		}
		if (!users.containsKey(_recipientsAdress)) {
			return 2;
		}

		Message newMessage = users.get(_sendersAdress).createMessage(
				_recipientsAdress);

		users.get(_recipientsAdress).receiveMessage(newMessage);

		messages.put(new ServerHashKey(_sendersAdress, _recipientsAdress),
				newMessage);

		return 0;
	}
	
}
