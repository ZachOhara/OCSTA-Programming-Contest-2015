package problem01;

import java.util.Scanner;

public class Problem01Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner console = new Scanner(System.in);
		String wordToken = "";
		System.out.println("What are the words to look for? ");
		String nextToken = "";
		do{
			wordToken += nextToken;
			nextToken = console.next();
		}while(!(nextToken.equals("_")));
		String[] codewords = wordToken.split(" "); //splitting words into array
		String[] codeToNumber = new String[codewords.length];
		for(int i = 0; i < codewords.length; i++){
			codeToNumber[i] = toNumber(codewords[i]);
		}
		System.out.print("What are the numbers to search in? ");
		String numberToken = console.next() + console.next() + console.nextLine();
		String[] numbers = new String[numberToken.length()/10];
		for(int k = 0; k < numberToken.length(); k+=10){ //splitting numbers
			numbers[k/10] = numberToken.substring(k, k+10);
		}
		for(String num : numbers){
			System.out.print(num + " contains...");
			boolean found = false;
			for(String code : codeToNumber){
				if(num.indexOf(code) != -1){
					found = true;
					System.out.println(code);
				}
			}
			if(!found)
				System.out.println("...no codewords.");
		}
	}
	
	public static String toNumber(String s){
		String result = "";
		for(int i = 0; i < s.length()-1; i++)
		{
			if(s.substring(i,i+1).equals("A") || s.substring(i,i+1).equals("B") || s.substring(i,i+1).equals("C"))
				result += "2";
			if(s.substring(i,i+1).equals("D") || s.substring(i,i+1).equals("E") || s.substring(i,i+1).equals("F"))
				result += "3";
			if(s.substring(i,i+1).equals("G") || s.substring(i,i+1).equals("H") || s.substring(i,i+1).equals("I"))
				result += "4";
			if(s.substring(i,i+1).equals("J") || s.substring(i,i+1).equals("K") || s.substring(i,i+1).equals("L"))
				result += "5";
			if(s.substring(i,i+1).equals("M") || s.substring(i,i+1).equals("N") || s.substring(i,i+1).equals("O"))
				result += "6";
			if(s.substring(i,i+1).equals("P") || s.substring(i,i+1).equals("Q") || s.substring(i,i+1).equals("R") || s.substring(i,i+1).equals("S"))
				result += "7";
			if(s.substring(i,i+1).equals("T") || s.substring(i,i+1).equals("U") || s.substring(i,i+1).equals("V"))
				result += "8";
			if(s.substring(i,i+1).equals("W") || s.substring(i,i+1).equals("X") || s.substring(i,i+1).equals("Y") || s.substring(i,i+1).equals("Z"))
				result += "9";
		}
		return result;
	}

}
