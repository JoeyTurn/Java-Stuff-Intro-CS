import java.util.*;
import java.io.*;
import java.awt.*;

public class CSE142Lectures {
   public static void main(String[] args) throws IOException {
      Scanner in = new Scanner(System.in);
      Random rand = new Random();
      Scanner file = new Scanner(new File("midterm.txt"));
      
      Week8.trashCan();
      //Week8.arrayPractice();
      //int[] a = {1, 3, 6};
      //Week8.arrayMystery(a);
      //System.out.println(Arrays.toString(a));
      //Week8.scoreAverage(file);
      //System.out.println(Week7.uniqueChars("abcde"));
      //Week7.payroll(new Scanner(new File("employees.txt")));
      //Week7.print5(file);
      //Week6.print5(file);
      //System.out.println(Week6.hashTag("#*(@R   #dsaf 1."));
      
      //System.out.println(Week5.acronym("self contained underwater breathing apparatus"));
      //System.out.println(Week5.countWords("Partyin' partyin' yeah   fun fun   fun fun"));
      //System.out.println(Week5.gotHeads2(1, rand));
      //System.out.println(Week5.containsE("joey is not gay"));
   }
}

class Week8 {
   public static void trashCan() {
      Point p1 = new Point(3, 5);
      Point p2 = new Point(3, 6);
      Point p3 = new Point();
      System.out.println(p1.getLocation());
      System.out.println(p3.getLocation());
   }
   
   public static void arrayMystery(int[] array) {
      for (int i = 0; i < array.length - 1; i++) {
         if (array[i] < array[i + 1]) {
            array[i] = array[i + 1];
         }
      }
   }
   
   public static void arrayPractice() {
      int[] arr = {6, 11, 0};
      System.out.println(Arrays.toString(arr));
      arrChange(arr);
      System.out.println(Arrays.toString(arr));
   }
   
   public static void arrChange(int[] arr) {
      for (int i = 0; i < 3; i++) {
         arr[i] *= 2;
      }
      System.out.println(Arrays.toString(arr));
   }

   public static void scoreAverage(Scanner in) {
      int[] scores = getScores(in);
      double mean = getMean(scores);
      double avg = (double)1/scores.length;
      numAbvAvg(scores, avg);
   }
   public static double getMean(int[] scores) {
      return 1;
   }
   public static int[] getScores(Scanner in) {
      int numScores = in.nextInt();
      int[] scores = new int[numScores];
      for (int i = 0; i < numScores; i++) {
         scores[i] = in.nextInt();
      }
      return scores;
   }
   public static void numAbvAvg(int[] scores, double avg) {
      int above = 0;
      for (int i = 0; i < scores.length; i++) {
         if (scores[i] >= avg)
            above++;
      }
      System.out.println(above);
   }
   /*public static int[] getCount(int[] scores) {
      int[] counts = new int[MAX_SCORE+1];
      
      for (int i = 0; i< scores.length; i++) {
         counts[scores[i]]++;
      }
      return counts; 
   } */
}

class Week7 {
   public static int uniqueChars(String s) {
      int unique = 0;
      String chrs = "";
      for (int i = 0; i < s.length()-1; i++) {
         String cS = s.substring(i, i+1);
         if (!(chrs.contains(cS))) {
            unique++;
            chrs += cS;
         }
      }
      String cS = s.substring(s.length()-1);
      if (!(chrs.contains(cS)))
         unique++;
      return unique;
   }
   public static void payroll(Scanner file) throws IOException {
      PrintStream out = new PrintStream(new File("bengaylol.txt"));
      while (file.hasNextLine()) {
         String employee = file.nextLine();
         process(employee, out);
      }
   }
   public static void process(String employee, PrintStream out) {
      if (employee.startsWith("Instructor")) {
         payInstructor(employee, out);
      } else if (employee.startsWith("TA")) {
         payTA(employee, out);
      } else if (employee.startsWith("Grader")) {
         payGrader(employee, out);
      }
   }
   public static void payInstructor(String employee, PrintStream out) {
      Scanner instructor = new Scanner(employee);
      String type = instructor.next();
      String name = instructor.next();
      double pay = instructor.nextDouble();
      
      out.printf("%s (%s) got paid $%.2f this week.\n", type, name, pay);
   }
   public static void payTA(String employee, PrintStream out) {
      Scanner ta = new Scanner(employee);
      String type = ta.next();
      String name = ta.next();
      int hours = 0;
      
      while (ta.hasNextInt()) {
         hours += ta.nextInt();
      }
      
      double pay = hours * 15.00;
      out.printf("%s (%s) got paid $%.2f this week.\n", type, name, pay);
   }
   public static void payGrader(String employee, PrintStream out) {
      Scanner grader = new Scanner(employee);
      String type = grader.next();
      String name = grader.next();
      int students = grader.nextInt();
      double num = grader.nextDouble();
      
      double pay = students * num;
      out.printf("%s (%s) got paid $%.2f this week.\n", type, name, pay);
   }
   public static void print5(Scanner in) {
      double max = Double.NEGATIVE_INFINITY;
      double min = Double.POSITIVE_INFINITY;
      
      while (in.hasNext()) {
         //System.out.print("Enter a number: ");
         if (in.hasNextDouble()) {
            double input = in.nextDouble();
            
            max = Math.max(max, input);
            min = Math.min(min, input);
         } else {
            String a = in.next();
         }
      }
      System.out.println("Min: " + min);
      System.out.println("Max: " + max);
   }
}

class Week6 {
   public static void print5(Scanner in) {
      double max = Double.NEGATIVE_INFINITY;
      double min = Double.POSITIVE_INFINITY;
      
      while (in.hasNextDouble()) {
         //System.out.print("Enter a number: ");
         double input = in.nextDouble();
         
         max = Math.max(max, input);
         min = Math.min(min, input);
      }
      System.out.println("Min: " + min);
      System.out.println("Max: " + max);
   }
   public static String hashTag(String user) {
      String ret = "#";
      if (user.charAt(0) != ' ') {
         ret += Character.toUpperCase(user.charAt(0));
         } else if (user.charAt(0) != ' ') {
            ret += Character.toLowerCase(user.charAt(0));
         }
      for (int i = 1; i <= user.length()-1; i++) {
         if (user.charAt(i) != ' ' && user.charAt(i-1) == ' ') {
            ret += Character.toUpperCase(user.charAt(i));
         } else if (user.charAt(i) != ' ') {
            ret += Character.toLowerCase(user.charAt(i));
         }
      }
      return ret;
   }
}


/*class Week5 {
   public static String acronym(String s) {
      String ret = "";
      while (str.hasNext()) {
         char a = str.next().charAt(0);
         a = Character.toUpperCase(a);
         ret = ret + a;
      }
      return ret;
   }
   public static int countHeads(int numFlips, Random rand) {
      int headCount = 0;
      for (int i = 1; i <= numFlips; i++) {
         int headsOrTails = rand.nextInt(2);
         if (headsOrTails == 0) {
            headCount++;
         }
      }
      return headCount;
   }
   public static boolean gotHeads(int numFlips, Random rand) {
      int heads = countHeads(numFlips, rand);
      return heads != 0;
   }
   public static boolean gotHeads2(int numFlips, Random rand) {
      for (int i = 1; i <= numFlips; i++) {
         int headsOrTails = rand.nextInt(2);
         if (headsOrTails == 0) {
            return true;
         }
      }
      return false;
   }
   public static boolean containsE(String str) {
      for (int i = 0; i <= str.length()-1; i++) {
         if (str.charAt(i) == 'e' || str.charAt(i) == 'E') {
            return true;
         }
      }
      return false;
   }
} */