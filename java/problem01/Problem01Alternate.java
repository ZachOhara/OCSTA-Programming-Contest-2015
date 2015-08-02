package problem01;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem01Alternate {

	public static void main(String[] asdf) {
		Scanner console = new Scanner(System.in);
		String words = console.nextLine();
		String number = console.nextLine();
		console.close();
		String[] wordsArr = words.split(" ");
		String[] numbersArr = new String[wordsArr.length];
		for (int i = 0; i < numbersArr.length; i++) {
			numbersArr[i] = Problem01Alternate.toNumber(wordsArr[i]);
		}
		ArrayList<String> workingWords = new ArrayList<String>();
		for (int i = 0; i < numbersArr.length; i++) {
			if (number.indexOf(numbersArr[i]) != -1) {
				workingWords.add(wordsArr[i]);
			}
		}
		if (workingWords.size() == 0) {
			System.out.println("No codewords found");
		} else {
			for (String i : workingWords) {
				System.out.print(i + " ");
			}
		}
	}

	public static String toNumber(String s) {
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.substring(i, i + 1).equals("A") || s.substring(i, i + 1).equals("B")
					|| s.substring(i, i + 1).equals("C")) {
				result += "2";
			}
			if (s.substring(i, i + 1).equals("D") || s.substring(i, i + 1).equals("E")
					|| s.substring(i, i + 1).equals("F")) {
				result += "3";
			}
			if (s.substring(i, i + 1).equals("G") || s.substring(i, i + 1).equals("H")
					|| s.substring(i, i + 1).equals("I")) {
				result += "4";
			}
			if (s.substring(i, i + 1).equals("J") || s.substring(i, i + 1).equals("K")
					|| s.substring(i, i + 1).equals("L")) {
				result += "5";
			}
			if (s.substring(i, i + 1).equals("M") || s.substring(i, i + 1).equals("N")
					|| s.substring(i, i + 1).equals("O")) {
				result += "6";
			}
			if (s.substring(i, i + 1).equals("P") || s.substring(i, i + 1).equals("Q")
					|| s.substring(i, i + 1).equals("R") || s.substring(i, i + 1).equals("S")) {
				result += "7";
			}
			if (s.substring(i, i + 1).equals("T") || s.substring(i, i + 1).equals("U")
					|| s.substring(i, i + 1).equals("V")) {
				result += "8";
			}
			if (s.substring(i, i + 1).equals("W") || s.substring(i, i + 1).equals("X")
					|| s.substring(i, i + 1).equals("Y") || s.substring(i, i + 1).equals("Z")) {
				result += "9";
			}
		}
		return result;
	}

}
