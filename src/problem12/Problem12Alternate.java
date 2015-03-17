import java.util.Scanner;

public class Problem12Alternate {

   public static void main(String[] args) {
      System.out.println("What is your weird expression?");
      Scanner console = new Scanner(System.in);
      String expression = console.nextLine();
      System.out.println("Here's your expression expressed normally!");
      System.out.println(reorder(expression));
   }
   
   public static String reorder(String exp) {
      String newExp = "(";
      String operator = exp.substring(
      return newExp;
   }

}