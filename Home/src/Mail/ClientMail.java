package Mail;

import java.util.HashMap;
import java.util.Scanner;

public class ClientMail {


	private final String name;
	private final String email;

	HashMap<String, Mess> receivedMessages = new HashMap<>();
	HashMap<String, Mess> sentMessages = new HashMap<>();
	private Scanner _scanner;

	public ClientMail(String _name, String _email) {
		name = _name;
		email = _email;
	}

	public Mess createMessage(String _recipientsAdress) {
		Mess newMessage = new Mess();
		_scanner = new Scanner(System.in);
		String serviceInformation;

		System.out
				.println("------------------------------------------------------------------");
		System.out.println("Message creating procedure from " + name
				+ " has been initated.");

		newMessage.recipientsAddress = _recipientsAdress;

		System.out.println(serviceInformation = "\n" + "\t"
				+ "This is test message from user: " + this.email + "; to: "
				+ newMessage.recipientsAddress + "." + "\n");

		System.out.println("Write the text of message: " + "\n");
		newMessage.messagesText = _scanner.nextLine() + "\n"
				+ serviceInformation;

		newMessage.sendersAddress = this.email;

		System.out
				.println("-------------------------------Done.-----------------------------");
		sentMessages.put(_recipientsAdress, newMessage);
		
		return newMessage;
	}

	public void receiveMessage(Mess message) {
		receivedMessages.put(message.sendersAddress, message);
	}

	public String getUsername() {
		return this.email;
	}
	
}
