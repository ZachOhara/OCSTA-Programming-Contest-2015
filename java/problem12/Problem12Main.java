package problem12;

import java.util.Scanner;

public class Problem12Main {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		console.close();
		System.out.print("What is the LISP expression? ");
		String expression = console.nextLine();
		expression = Problem12Main.reorder(expression);
		System.out.println("New expression in non-alien terms: " + expression);
	}

	public static String reorder(String s) {
		String operator = s.substring(1, 2);
		String term1 = s.substring(3, 4);
		int startParen = 3;
		int endParen = 3;
		if (term1.equals("(")) {
			int newParen = 0;
			for (int i = startParen + 1; i < s.length(); i++) {
				String charAt = s.substring(i, i + 1);
				if (charAt.equals("(")) {
					newParen++;
				} else if (charAt.equals(")") && newParen > 0) {
					newParen--;
				} else if (charAt.equals(")") && newParen == 0) {
					endParen = i;
					term1 = Problem12Main.reorder(s.substring(startParen, endParen + 1));
					newParen = 1000;
				}
			}
		}
		System.out.println(term1);
		startParen = endParen + 1;
		endParen++;
		String term2 = s.substring(startParen, endParen);
		if (term2.equals("(")) {
			int newParen = 0;
			for (int i = startParen + 1; i < s.length(); i++) {
				String charAt = s.substring(i, i + 1);
				if (charAt.equals("(")) {
					newParen++;
				} else if (charAt.equals(")") && newParen > 0) {
					newParen--;
				} else if (charAt.equals(")") && newParen == 0) {
					endParen = i;
					term2 = Problem12Main.reorder(s.substring(startParen, endParen + 1));
				}
			}
		}
		return "(" + term1 + operator + term2 + ")";
	}
}
