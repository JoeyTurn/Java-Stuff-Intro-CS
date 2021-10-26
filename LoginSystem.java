import java.util.*;
public class LoginSystem {
   public static final String REAL_PASSWORD = "CSE142_Rocks!";
   
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      
      String userPass;
      
      System.out.print("Enter your full name: ");
      String fullName = in.nextLine();
      System.out.printf("Welcome %s\n", fullName);
      System.out.print("Please enter the password: ");
      userPass = in.nextLine();
      while (!(userPass.equals(REAL_PASSWORD))) {
         System.out.println("Sorry, that's not it...");
         System.out.print("Try again: ");
         userPass = in.nextLine();
      }
   }
}