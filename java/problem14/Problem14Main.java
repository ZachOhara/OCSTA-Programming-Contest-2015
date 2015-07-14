package problem14;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem14Main {

	public static void main(String[] args) {  
		Scanner console = new Scanner(System.in);
		System.out.print("What is the width? ");
		int chatWidth = console.nextInt();

		ArrayList<String> abbreviations = new ArrayList<String>();
		ArrayList<String> expandedForm = new ArrayList<String>();

		System.out.println("Type in the abbreviations and expanded forms. Type '_' to exit");
		String input = "";
		int currentList = 0;
		while (true) {
			if (currentList%2 == 0) {
				input = console.next();
				if (input.equals("_")) break;
				abbreviations.add(input);
			}   
			else
				expandedForm.add(console.nextLine().trim());  
			currentList++;    
		}

		System.out.println(abbreviations);
		System.out.println(expandedForm);

		System.out.println("What is the message?");
		String message = console.next() + console.nextLine();

		console.close();
		int index;
		for (int i = 0; i < abbreviations.size(); i++) {
			do {
				index = message.indexOf(abbreviations.get(i));
				if (index != -1) {
					message = message.substring(0, index) + expandedForm.get(i)
							+ message.substring(index + abbreviations.get(i).length());
				}
			} while (index != -1);
		}

		String[] messageTokens = message.split(" ");
		String messageLine = "";
		//System.out.println(Arrays.toString(messageTokens));
		for (int i = 0; i < messageTokens.length; i++) {
			if (messageLine.length() + messageTokens[i].length() > chatWidth) {
				System.out.println(messageLine);
				messageLine = "";
			}
			messageLine += messageTokens[i] + " ";
			if (i == messageTokens.length - 1)
				System.out.println(messageLine);
		}

	}

}
