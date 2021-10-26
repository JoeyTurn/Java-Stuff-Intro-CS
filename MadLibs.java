import java.util.*;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;

/**  Joey Turnbull
  *  02/18/2020
  *  CSE142
  *  TA: Esther Chien
  *  Assignment #6
  *
  *  
  *  
  *  Note: java.util.* is imported above this comment, as it is has something to do with a mysterious thing called Arrays.*/
  
public class MadLibs {
   public static void main(String[] args) throws IOException {
      Scanner in = new Scanner(System.in);
      
      Scanner file;
      char cvqChar;
      
      makeHeader();
      
      do {
         System.out.print("(C)reate mad-lib, (V)iew mad-lib, (Q)uit? ");
         String usersInputCVQ = in.nextLine();
         cvqChar = Character.toUpperCase(usersInputCVQ.charAt(0));
         if (cvqChar == 'C') {
            file = getFile(in);
            createFile(file, in);
         } else if (cvqChar == 'V') {
            file = getFile(in);
            viewFile(file);
         }
         if (cvqChar != 'Q') {
            in.nextLine(); //throws away bad input
         }
      } while(cvqChar != 'Q');
   }
   //makes plank line
   public static void blankLine() {
      System.out.println();
   }
   //hopefully i spelled that right
   //prints out the beginning lines of the program, the introduction
   public static void makeHeader() {
      System.out.println("Welcome to the game of Mad Libs.");
      System.out.println("I will ask you to provide various words");
      System.out.println("and phrases to fill in a story.");
      System.out.println("The result will be written to an output file.");
      blankLine();
   }
   //
   public static Scanner getFile(Scanner in) throws IOException {
      String fileName;
      
      System.out.print("Input file name: ");
      fileName = in.next();
      while ((new File(fileName)).exists() == false) {
         System.out.print("File not found. Try again: ");
         fileName = in.next();
      }
      Scanner file = new Scanner(new File(fileName));
      return file;
   }
   //
   public static void createFile(Scanner file, Scanner in) throws IOException {
      System.out.print("Output file name: ");
      String outputFileName = in.next();
      FileWriter writeFile = new FileWriter(outputFileName);
      while (file.hasNextLine()) {
         String line = file.nextLine();
         while (line.contains("<")) {
            if (line.contains("<noun>")) {
               System.out.print("Please type a noun: ");
               String noun = in.nextLine();
               line = line.replaceAll("<noun>", noun);
            }
            if (line.contains("<adjective>")) {
               System.out.print("Please type an adjective: ");
               String adjective = in.nextLine();
               line = line.replaceAll("<adjective>", adjective);
            }
         writeFile.append(line + "\n");
         }
      }
      writeFile.close();
   }
   //
   public static void viewFile(Scanner file) {
      while (file.hasNextLine()) {
         String line = file.nextLine();
         System.out.println(line);
      }
      blankLine(); 
   }
}