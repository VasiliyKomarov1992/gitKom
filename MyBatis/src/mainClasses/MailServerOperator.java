package mainClasses;

import java.util.Scanner;

public class MailServerOperator {
	MailServer server = new MailServer();

	@SuppressWarnings("resource")
	public void menu() {
		while (true) {
			Scanner scanner = new Scanner(System.in);

			System.out.println("\n" + "Mail server menu:");
			System.out.println("Type 1 to write new message;" + "\n"
					+ "Type 2 to add new user to list" + "\n"
					+ "Type 3 to view all users" + "\n"
					+ "Type 4 to view all messages on server" + "\n"
					+ "Type 5 to add 3 test users" + "\n"
					+ "Type 6 to view all messages from one user");
			System.out.println("Type 0 to exit.");
			if (scanner.hasNextInt()) {
				switch (scanner.nextInt()) {
				case 1: {
					createMessage();
					break;
				}
				case 2: {
					addUser();
					break;
				}
				case 3: {
					showAllUsers(false);
					break;
				}
				case 4: {
					viewAllMessages();
					break;
				}
				case 5: {
					add3TestUsers();
					break;
				}
				case 6: {
					showMessagesFromOneUser();
				}

				// case 11: {
				// viewKeyset();
				// break;
				// }
				case 0: {
					return;
				}
				default:
					System.out.println("/ / /");
				}
			} else {
				System.out.println("Error. Only numbers are permitted.");
			}
		}
	}

	private void showMessagesFromOneUser() {
		Scanner sc = new Scanner(System.in);
		String sendersAdress = "";

		showAllUsers(true);

	}

	private void viewAllMessages() {
		server.showMessages();
	}

	@SuppressWarnings("resource")
	private void addUser() {
		System.out
				.print("User adding in progress. Please, type new user's e-mail:");
		Scanner sc = new Scanner(System.in);
		String usrEmail = sc.nextLine();
		System.out.print("Please, type new user's name:");
		String usrName = sc.nextLine();

		if (server.addUserToList(usrName, usrEmail) == 0) {
			System.out.println("Done.");
		} else {
			System.out.println("User with this e-mail address already exists.");
		}
	}

	private void showAllUsers(boolean justViewList) {
		int i = 1;
		if (!justViewList) {
			System.out.println("There are "
					+ Integer.toString(server.showEmails().size()) + " users:");
		}

		//		, with name " + server.getUserName(usersEmail) + "; 
		
		for (String usersEmail : server.showEmails()) {
			System.out.println("User #" + Integer.toString(i) + "e-mail:"
					+ usersEmail + ";");
			i++;
		}

	}

	@SuppressWarnings("resource")
	private void createMessage() {

		if (server.showEmails().size() < 2) {
			System.out
					.println("There must be minimum 2 clients to send messages."
							+ "\n");
			return;
		}

		Scanner sc = new Scanner(System.in);
		String sendersAdress = "";
		String recipientsAdress = "";

		showAllUsers(true);
		do {
			if (!sendersAdress.equals("")) {
				System.out
						.println("Sender's address is invalid. Type exicting address");
			}

			System.out.print("Please, type sender's e-mail adress: ");
			sendersAdress = sc.nextLine();
		} while (!server.showEmails().contains(sendersAdress));

		do {
			if (!recipientsAdress.equals("")) {
				System.out
						.println("Recipient's address is invalid. Type exicting address");
			}

			System.out.print("Please, type recipient's e-mail adress: ");
			recipientsAdress = sc.nextLine();
		} while (!server.showEmails().contains(recipientsAdress));

		if (server.sendMessage(sendersAdress, recipientsAdress) == 0) {
			System.out.println("Message sent.");
		} else {
			System.out.println("Message not sent.");
		}
	}

	private void add3TestUsers() {
		for (int i = 0; i < 3; i++) {
			server.addUserToList("usr" + Integer.toString(i + 1), "usr"
					+ Integer.toString(i + 1) + "em@gm.com");
		}
	}

	// private void viewKeyset() {
	// int i = 0;
	// for (String key : server.viewEmails()) {
	// System.out.println("Key #" + Integer.toString(i) + " = " + key);
	// }
	// }
}
