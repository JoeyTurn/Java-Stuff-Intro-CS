/**  Joey Turnbull
  *  02/18/2020
  *  CSE142
  *  TA: Esther Chien
  *  Assignment #6
  *  
  *  This program does stuff with yaz files.
  *  This program allows for a user/file to convert from yzy commands (currently RANGE, CONVERT,
  *  and REPEAT) to "human" readable output
  *  
  *  RANGE: takes 3 ints, prints between int 1 and 2 by the 3rd int
  *  CONVERT: takes int and string, turns celcius into farenheit and vice versa
  *  REPEAT: takes strings and ints, prints the string an (following int) number of times
  *  
  *  Note: in comments yaz and yzy may be used interchangably; they mean the same thing*/

import java.util.*;
import java.io.*;

public class YazInterpreter {

   public static void main(String[] args) throws IOException {
      Scanner in = new Scanner(System.in);
      
      char ciqChar = 'q';
      
      makeHeader();
      
      //loop for the user to switch between console(interactions) and interpreting .yzy files
      do {
         System.out.print("(C)onsole YazInteractions, (I)nterpret .yzy program, (Q)uit? ");
         String usersInputCIQ = in.nextLine();
         
         if (usersInputCIQ.length() == 1)
            ciqChar = Character.toUpperCase(usersInputCIQ.charAt(0));
         else
            ciqChar = 'A'; // just setting it to A so i know it will fail everything
            
         if (ciqChar == 'C') {
            console(in);
         } else if (ciqChar == 'I') {
            interpret(in);
            in.nextLine(); //throws bad input
         }
         
      } while(ciqChar != 'Q');
   }
   
   //hopefully i spelled that right <-- idk when I wrote this but it's staying here
   //prints out the beginning lines of the program, the introduction
   public static void makeHeader() {
      System.out.println("Welcome to the YazInterpreter!");
      System.out.println("You may interpret a YazLang program and output");
      System.out.println("the results to a .txt file or enter console YazInteractions");
      System.out.println("mode to run single commands of YazLang.");
      System.out.println();
   }
   
   //essentially a method to sort which function the user/file is trying to call,
   //the method will call another method based on the keyword the user/file inputs
   //as is, only functions CONVERT, RANGE, and REPEAT exist
   //also, the method calls other methods with the keyword already eaten
   public static String change(String userString) {
      Scanner user = new Scanner(userString);
      
      String line = "";
      
      if (userString.startsWith("CONVERT")) {
         line = convert(user);
      } else if (userString.startsWith("RANGE")) {
         line = range(user);
      } else if (userString.startsWith("REPEAT")) {
         line = repeat(user);
      }
      return line;
   }
   
   //i seriously had to resubmit bc my caps lock doesnt work (CONVeRt)
   //Yaz CONVERT function, takes in an int and a String (really a char but whatever)
   //the string signifies whether the int the user inputs is in Farenheit (F) or Celcius (C)
   //returns a String with an int of the opposite temperature scale, along with the scale letter
   public static String convert(Scanner user) {
      String line = "";
      
      user.next(); //throws CONVERT
      int temp = user.nextInt();
      String cOrF = user.next();
      if (cOrF.equalsIgnoreCase("C")) {
         line = (int)(1.8*temp + 32) + "F";
      } else {
         line = (int)((temp-32)/1.8) + "C";
      }
      
      return line;
   }
   
   //Yaz RANGE function, takes in 3 ints: 1st is the lower inclusive bound, 2nd is the upper
   //exclusive bound, 3rd is the step amount
   //returns a String with all numbers from 1st int to 2nd int - 1 by step amount
   public static String range(Scanner user) {
      String line = "";
   
      user.next(); //throws RANGE
      int yourInt = user.nextInt();
      int last = user.nextInt();
      int by = user.nextInt();
      while (yourInt < last) {
         line += yourInt + " ";
         yourInt += by;
      }
      return line;
   }
   
   //Yaz REPEAT function, takes alternating Strings and ints, prints out the string 
   //without the quotes a number of times equal to the following int, also changes 
   //underscores into spaces
   //returns a String of what it repeated
   public static String repeat(Scanner user) {
      String line = "";
   
      user.next(); //throws REPEAT
      while (user.hasNext()) {
         String word = user.next();
         int times = user.nextInt();
         
         word = word.substring(1, word.length()-1);
         word = word.replace("_", " ");
         
         for (int i = 0; i < times; i++) {
            line += word;
         }
      }
      return line;
   }
   
   //user's console, aka interactions section; allows user to compute yaz functions without having
   //to write them into a file then interpret the file
   public static void console(Scanner in) {
      System.out.println("YazInteractions session. Type END to exit.");
      System.out.print("> ");
      String userString = in.nextLine();
      while(!(userString.equalsIgnoreCase("end"))) {
         System.out.println(change(userString));
         System.out.print("> ");
         userString = in.nextLine();
      }
      System.out.println();
   }
   
   //takes in a yzy file then using the change method, converts the yzy functions into
   //the correct output, then puts output into a file
   //the file read in must exist for this to work, (IE can't read a file that doesn't exist)
   //But, it will overwrite a file that does exist while writing
   public static void interpret(Scanner in) throws IOException {
      String fileName;
      
      System.out.print("Input file name: ");
      fileName = in.next();
      while ((new File(fileName)).exists() == false) {
         System.out.print("File not found. Try again: ");
         fileName = in.next();
      }
      Scanner file = new Scanner(new File(fileName));
      
      System.out.print("Output file name: ");
      String outputFileName = in.next();
      PrintStream writeFile = new PrintStream(outputFileName);
      while (file.hasNextLine()) {
         writeFile.print(change(file.nextLine()) + "\n");
      }
      writeFile.close();
      //I know for PrintWriter I have to close it, but I don't know for PrintStream
      //so I'll just do it in case
      System.out.println("YazLang program interpreted and output to .txt file!");
      System.out.println();
   }
}