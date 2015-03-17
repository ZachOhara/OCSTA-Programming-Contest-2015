package problem03;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem03Main {

	public static void main(String[] args) {
      
//       RationalNumber total = new RationalNumber(12, 3);
//       System.out.println(total);
//       total = total.multiply(new RationalNumber(7, 8));
//       System.out.println(total);
//       total = total.subtract(new RationalNumber(133, 11));
//       System.out.println(total);
//       total = total.multiply(new RationalNumber(4, 6));
//       System.out.println(total);

      System.out.println("Type an expression.");
		Scanner console = new Scanner(System.in);
		ArrayList<String> tokens = new ArrayList<String>();
		String expression = console.nextLine();
		String[] tokensArr = expression.split(" ");
		for (String i : tokensArr)
			tokens.add(i);
		RationalNumber current = new RationalNumber();
		RationalNumber total = new RationalNumber(Integer.parseInt(tokens.get(0).substring(0,tokens.get(0).indexOf("/"))),
            Integer.parseInt(tokens.get(0).substring(tokens.get(0).indexOf("/")+1)));
		console.close();
      String currentOp = "";
		for (int index = 1; index < tokens.size(); index++) {
         String i = tokens.get(index);
			if (i.length() > 1) {
				current = new RationalNumber(Integer.parseInt(i.substring(0,i.indexOf("/"))), Integer.parseInt(i.substring(i.indexOf("/")+1)));
            if (currentOp.equals("+"))
               total = total.add(current);
            if (currentOp.equals("-"))
               total = total.subtract(current);
            if (currentOp.equals("*"))
               total = total.multiply(current);
            if (currentOp.equals("/"))
               total = total.divide(current);         
			}
			else {
            currentOp = i;   
			}
		}
		System.out.println(total);
						
		
		
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
