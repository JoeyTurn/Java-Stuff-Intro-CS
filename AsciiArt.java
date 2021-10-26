/**  Joey Turnbull
  *  01/21/2020
  *  CSE142
  *  TA: Esther Chien
  *  Assignment #2 (Part 1)
  *
  *  This program will print out a stop sign in ASCII art.
  *  You can tell it's mine by how badly drawn it is.*/

public class AsciiArt {
   public static void main(String[] args) {
      top();
      middle();
      bottom();
   }
   //top and bottom of stop sign
   public static void horizontal() {
      //spacing
      for (int space = 1; space <= 9; space++) {
         System.out.print(" ");
      }
      //actual horizontal part
      for (int dash = 1; dash <= 18; dash++) {
         System.out.print("-");
      }
      //rip \n
      System.out.println();
   }
   //makes the top part
   public static void top() {
      horizontal();
      for (int line = 1; line <= 4; line++) {
         for (int space = 1; space <= 9-line; space++) {
            System.out.print(" ");
         }
         System.out.print("/");
         for (int space = 1; space <= 2*line+16; space++) {
            System.out.print(" ");
         }
         System.out.println("\\");
      }
   }
   //makes the bottom part
   public static void bottom() {
      for (int line = 1; line <= 4; line++) {
         for (int space = 1; space <= 4+line; space++) {
            System.out.print(" ");
         }
         System.out.print("\\");
         for (int space = 1; space <= 26-2*line; space++) {
            System.out.print(" ");
         }
         System.out.println("/");
      }
      horizontal();
   }
   //left part of main sign(not including characters)
   public static void verticalLeft() {
      //spacing
      for (int space = 1; space <= 5; space++) {
         System.out.print(" ");
      }
      //left vertical
      System.out.print("| ");
   }
   //right part of main sign
   public static void verticalRight() {
      //right vertical
      System.out.println("|");
   }
   //letters horizontal line
   public static void dash() {
      System.out.print("----- ");
   }
   //end of letters lines (besides last)
   public static void doubleVert() {
      verticalRight();
      verticalLeft();
   }
   //letters left bar
   public static void leftBar() {
      System.out.print("|     ");
   }
   //letters middle bar
   public static void middleBar() {
      System.out.print("  |   ");
   }
   //letters double bar on leftmost and rightmost sides
   public static void oBar() {
      System.out.print("|   | ");
   }
   //combines mid & oBar
   public static void midOBar() {
      middleBar();
      oBar();
   }
   //prints middle of stop sign, with lettering
   public static void middle() {
      verticalLeft();
      for (int dashes = 1; dashes <= 4; dashes++) {
         dash();
      }
      doubleVert();
      leftBar();
      midOBar();
      oBar();
      doubleVert();
      dash();
      midOBar();
      dash();
      doubleVert();
      System.out.print("    | ");
      midOBar();
      leftBar();
      doubleVert();
      dash();
      middleBar();
      dash();
      leftBar();
      verticalRight();
   }
}