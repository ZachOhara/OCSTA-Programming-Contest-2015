package problem12;

import java.util.Scanner;

public class Problem12Alternate {

	public static void main(String[] args) {
		System.out.println("What is your weird expression?");
		Scanner console = new Scanner(System.in);
		String expression = console.nextLine();
		console.close();
		System.out.println("Here's your expression expressed normally!");
		System.out.println(reorder(expression));
	}

	public static String reorder(String exp) {
		if (exp.length() == 1)
			return exp;
		//String newExp = "(";
		String operator = exp.substring(1, 2);
		String firstSubExp = "";
		String secondSubExp = "";
		if (exp.substring(3, 4).equals("(")) {
			firstSubExp = exp.substring(3, findEndOfExpression(exp, 3) + 1);
		}
		else {
			firstSubExp = exp.substring(3, 4);
		}
		if (exp.substring(firstSubExp.length() + 4, firstSubExp.length() + 5).equals("(")) {
			secondSubExp = exp.substring(firstSubExp.length() + 4, findEndOfExpression(exp, firstSubExp.length() + 4) + 1);
		}
		else {
			secondSubExp = exp.substring(firstSubExp.length() + 4, firstSubExp.length() + 5);
		}   
		return "(" + reorder(firstSubExp) + " " + operator + " " + reorder(secondSubExp) + ")";
	}

	public static int findEndOfExpression(String exp, int first) {
		int stack = 1;
		for (int i = first + 1; i < exp.length(); i++) {
			if (exp.substring(i, i+1).equals("(")) {
				stack++;  
			}
			else if (exp.substring(i, i+1).equals(")")) {
				stack--;
			}
			if (stack == 0) {
				return i;
			}         
		}    
		return -1;    
	}   

}