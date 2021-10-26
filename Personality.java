/**  Joey Turnbull
  *  03/03/2020
  *  CSE142
  *  TA: Esther Chien
  *  Assignment #7
  *  
  *  This program processes a file of answers to the
  *  Keirsey Temperament Sorter. It converts the
  *  various A and B answers for each person into
  *  a sequence of B-percentages and then into a
  *  four-letter personality type. */
  
import java.util.*;
import java.io.*;
  
public class Personality {

   //class constant, corresponding to the # of factors being tested for
   public static final int DIMENSION = 4;
   
   public static void main(String[] args) throws IOException {
      Scanner in = new Scanner(System.in);
      
      intro();
      Scanner file = getFile(in);
      PrintStream out = getOutFile(in);
      readFile(file, out);
      
   }
   
   //This method produces the intro lines
   public static void intro() {
      System.out.println("This program processes a file of answers to the");
      System.out.println("Keirsey Temperament Sorter. It converts the");
      System.out.println("various A and B answers for each person into");
      System.out.println("a sequence of B-percentages and then into a");
      System.out.println("four-letter personality type.");
      System.out.println();
   }
   
   //This method gets the file name from the user, assuming it exists
   //returns a Scanner of the file recieved
   public static Scanner getFile(Scanner in) throws IOException {
      System.out.print("input file name? ");
      String fileName = in.next();
      return (new Scanner(new File(fileName)));
   }
   
   //This method gets the file name to output to from the user
   //returns a PrintStream of the file recieved
   public static PrintStream getOutFile(Scanner in) throws IOException {
      System.out.print("output file name? ");
      String outFileName = in.next();
      return (new PrintStream(new File(outFileName)));  
   }
   
   //Method that writes "name: [bPercents] type" to output file
   //Scanner file is the file being read in, PrintStream out is writing
   //to the output file
   //file should have a name line followed by a line of 'a', 'b', and/or '-' characters
   
   public static void readFile(Scanner file, PrintStream out) {
      while (file.hasNextLine()) {
      
         String name = file.nextLine();
         String charLine = file.nextLine(); //charLine is a line of 'a', 'b' and/or '-'
         
         int[] aCount = new int[DIMENSION];
         int[] bCount = new int[DIMENSION];
         
         for (int i = 0; i < charLine.length(); i++) {
            
            char aB = Character.toLowerCase(charLine.charAt(i));
            int qTypeIdentify = identifyType((i+1)%7);
            
            if (aB == 'a')
               aCount[qTypeIdentify]++;
            else if (aB == 'b')
               bCount[qTypeIdentify]++;
             
         } //ends for loop
         
         int[] bPercentage = calculateBPercent(aCount, bCount);
         String type = getType(bPercentage);
         
         out.println(name + ": " + Arrays.toString(bPercentage) + " = " + type);
         
      } //ends while loop
      
   } //ends method
   
   //based on the placement(parameter) in the 7 char substrings (wherein 1 is for the first
   //letter, 2-3 are for the second letter, 4-5 are for the third letter, and 
   //6-7(really 0) are for the last letter), it returns the type of question
   //ie. 1 -> 1st question, 5 -> 3rd question, 0 -> 4th question
   //all return values are question-1, so 1st question returns 0
   public static int identifyType(int questionType) {
      if (questionType == 0)
         return 3;
      else if (questionType == 1)
         return 0;
      else if (questionType <= 3)
         return 1;
      else if (questionType <= 5)
         return 2;
      else
         return 3;
   } 
   
   //based on the aCount and bCount arrays (parameters), this method returns
   //a new array which contains the percents of bCount per (aCount+bCount) for each index
   public static int[] calculateBPercent(int[] aCount, int[] bCount) {
      int[] bPercentage = new int[DIMENSION];
         for (int i = 0; i < DIMENSION; i++) {
            bPercentage[i] = (int)Math.round(100.0*bCount[i]/(double)(aCount[i]+bCount[i]));
         }
      return bPercentage;
   }
   
   //Creates the actual type letters
   //I or E, N or S, F or T, P or J (and all of them can be X)
   //1st letter in group if bPercentage[index] > 50,
   //2nd letter in group if bPercentage[index] < 50.
   //X if bPercentage == 50.
   //returns String with all 4 of the letters in order
   public static String getType(int[] bPercentage) {
      String type = "";
      
      if (bPercentage[0] > 50)
         type += "I";
      else if (bPercentage[0] < 50)
         type += "E";
      else
         type += "X";
         
      if (bPercentage[1] > 50)
         type += "N";
      else if (bPercentage[1] < 50)
         type += "S";
      else
         type += "X";
         
      if (bPercentage[2] > 50)
         type += "F";
      else if (bPercentage[2] < 50)
         type += "T";
      else
         type += "X";
         
      if (bPercentage[3] > 50)
         type += "P";
      else if (bPercentage[3] < 50)
         type += "J";
      else
         type += "X";
         
      return type;
   }
}