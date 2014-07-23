package mainClasses;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import auxillaryClasses.Message;
import auxillaryClasses.ServerHashKey;

public class MailServer {

	private final HashMap<ServerHashKey, Message> messages = new HashMap<>();

	private final HashMap<String, MailServerClient> users = new HashMap<>();

	public int addUserToList(String _name, String _email) {
		if (users.containsKey(_email)) {
			return 1;
		}

		MailServerClient newClient = new MailServerClient(_name, _email);
		users.put(_email, newClient);
		return 0;
	}

	public int removeUserFromList(String _email) {
		if (!users.containsKey(_email)) {
			return 1;
		} else {
			users.remove(_email);
		}
		return 0;
	}

	public Set<String> showEmails() {
		return this.users.keySet();
	}

	public String getUserName(String _email) {
		return users.get(_email).getUsername();
	}

	public HashMap<String, Message> viewSentMessagesFrom(String _email) {
		return users.get(_email).sentMessages;
	}

	public HashMap<String, Message> viewReceivedMessagesBy(String _email) {
		return users.get(_email).receivedMessages;
	}

	
	
	public void showMessages() {
		
		for (Entry<ServerHashKey, Message> entry : messages.entrySet()) {
		    System.out.println("Email: " + entry.getKey().recipientsAddress + " Text Messages: "
		        + entry.getValue().messagesText);
		}
	}
	
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
