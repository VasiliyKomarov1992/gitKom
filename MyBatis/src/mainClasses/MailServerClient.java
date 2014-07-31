package mainClasses;

import java.util.HashMap;
import java.util.Scanner;

import auxillaryClasses.Message;

public class MailServerClient {

	private final String name;
	private final String email;

	HashMap<String, Message> receivedMessages = new HashMap<>();
	HashMap<String, Message> sentMessages = new HashMap<>();
	private Scanner _scanner;

	public MailServerClient(String _name, String _email) {
		name = _name;
		email = _email;
	}

	public Message createMessage(String _recipientsAdress) {
		Message newMessage = new Message();
		_scanner = new Scanner(System.in);
		String serviceInformation;

		System.out
				.println("------------------------------------------------------------------");
		System.out.println("Message creating procedure from " + name
				+ " has been initated.");

		newMessage.recipientsAddress = _recipientsAdress;

		System.out.println(serviceInformation = "\n" + "\t"
				+ "This is test message from user: " + email + "; to: "
				+ newMessage.recipientsAddress + "." + "\n");

		System.out.println("Write the text of message: " + "\n");
		newMessage.messagesText = _scanner.nextLine() + "\n"
				+ serviceInformation;

		newMessage.sendersAddress = email;

		System.out
				.println("-------------------------------Done.-----------------------------");
		sentMessages.put(_recipientsAdress, newMessage);
		
		return newMessage;
	}

	public void receiveMessage(Message message) {
		receivedMessages.put(message.sendersAddress, message);
	}

	public String getUsername() {
		return this.email;
	}
}
