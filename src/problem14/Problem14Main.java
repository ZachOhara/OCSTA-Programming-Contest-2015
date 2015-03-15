package problem14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Problem14Main {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("What is the width? ");
		int chatWidth = console.nextInt();
		System.out.print("How many abbreviations? ");
		int numberOfAbbr = console.nextInt();
		
		ArrayList<String> abbreviations = new ArrayList<String>();
		ArrayList<String> expandedForm = new ArrayList<String>();
		for (int i = 0; i < numberOfAbbr; i++) {
			System.out.print("Abbreviation: ");
			abbreviations.add(console.next());
			System.out.print("Expanded form: ");
			expandedForm.add(console.next() + console.nextLine());
		}

		System.out.println("What is the message?");
		String message = console.next() + console.nextLine();
		
		console.close();
		int index;
		for (int i = 0; i < numberOfAbbr; i++) {
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
