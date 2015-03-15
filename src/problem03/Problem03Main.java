package problem03;

import java.util.*;

public class Problem03Main {

	public static void main(String[] args) {
		RationalNumber n = new RationalNumber(2, 2);
		RationalNumber a = new RationalNumber(1, 2);
		System.out.println(n.simplify());
		
//		while (true) { //continue until user stops program
//			System.out.println("Type an expression.");
//			Scanner console = new Scanner(System.in);
//			ArrayList<String> tokens = new ArrayList<String>();
//			String expression = console.nextLine();
//			String[] tokensArr = expression.split(" ");
//			for (String i : tokensArr)
//				tokens.add(i);
//			RationalNumber current = new RationalNumber();
//			RationalNumber total = new RationalNumber();
//			for (String i : tokens) {
//				if (i.length() > 1) {
//					current = new RationalNumber(Integer.parseInt(i.substring(0,i.indexOf("/"))), Integer.parseInt(i.substring(i.indexOf("/")+1)));
//					System.out.println(current);
//				}
//				else {
//					if (i.equals("+"))
//						total = total.add(current);
//					else if (i.equals("-"))
//						total = total.subtract(current);
//					else if (i.equals("*"))
//						total = total.multiply(current);
//					else if (i.equals("/"))
//						total = total.divide(current);
//				}
//			}
//			System.out.print(total);
//						
//		
//		}
	}

	
	public static int count(String a, String regex) {
		int c = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.substring(i, i+1).equals(regex))
				c++;
		}
		return c;
	}

}
