/**  Joey Turnbull
  *  01/21/2020
  *  CSE142
  *  TA: Esther Chien
  *  Assignment #2 (Part 2)
  *
  *  This program will print out a space needle based on the "CONSTANT" int set, with the standard size being 4.*/

public class SpaceNeedle {

   //class CONSTANT, change CONSTANT to change size; nothing below 2
   //rip globals
   public static final int CONSTANT = 4;
   
   //main method, to make needle: keep method calls as is
   public static void main(String[] args) {
      makeTop();
      makeBulb();
      makeMiddle();
      makeBase();
   }
   
   //makes pipes at top + center, with correct spacing
   public static void makeTop() {
      //makes lines based on size
      for (int line = 1; line <= CONSTANT; line++) {
         //makes space
         for (int space = 1; space <= 3*CONSTANT; space++) {
            System.out.print(" ");
         }
         //makes pipes
         System.out.println("||");
      }
   }
   
   //makes base structure seen at bottom, with correct spacing
   public static void makeBase() {
      //makes lines based off CONSTANT int EXCEPT for the last one of the base
      for (int line = 1; line <= CONSTANT; line++) {
         //makes space
         for (int space = 1; space <= 3*(CONSTANT - line); space++) {
            System.out.print(" ");
         }
         //begins base structure for the line
         System.out.print("__/");
         //prints left side colons
         for (int colon = 1; colon <= 3*(line-1); colon++) {
            System.out.print(":");
         }
         //ends left side, starts right side
         System.out.print("||");
         //prints right side colons
         for (int colon = 1; colon <= 3*(line-1); colon++) {
            System.out.print(":");
         }
         //ends base structure for the line
         System.out.println("\\__");
      }
      
      //begins final line of base structure; always here no matter size
      System.out.print("|");
      //fills in double quotes for final line of base structure
      for (int line = 1; line <= 6*CONSTANT; line++) {
         System.out.print("\"");
      }
      //ends final line of base structure
      System.out.println("|");
   }
   
   //makes the "bulb of the space needle (the structure between the very top and the middle), with correct spacing
   public static void makeBulb() {
      //top half of the bulb is the same as the base of the space needle
      makeBase();
      
      //starts making bottom half of the bulb
      //makes lines based off CONSTANT int
      for (int line = 1; line <= CONSTANT; line++) {
         //makes space
         for (int space = 1; space <= 2*(line-1); space++) {
            System.out.print(" ");
         }
         //begins bottom half structure line
         System.out.print("\\_");
         //makes inner part of the lines for bottom half, based on size
         for (int hat = 1; hat <= 3*CONSTANT + 1 - 2*line; hat++) {
            System.out.print("/\\");
         }
         //ends bottom half structure line
         System.out.println("_/");
      }
   }
   
   //makes middle section of the space needle, with proper spacing
   public static void makeMiddle() {
      //top section is the same as the first lines of the middle section
      makeTop();
      //begins other part of the middle section
      //makes lines based off of size
      for (int line = 1; line <= CONSTANT*CONSTANT; line++) {
         //makes space
         for (int space = 1; space <= 2*CONSTANT + 1; space++) {
            System.out.print(" ");
         }
         //true start to the middle section (so everything after spacing)
         System.out.print("|");
         //makes left percent signs based on CONSTANT
         for (int percent = 1; percent <= CONSTANT - 2; percent++) {
            System.out.print("%");
         }
         //makes center section (the pipes)
         System.out.print("||");
         //makes right percent signs based on CONSTANT
         for (int percent = 1; percent <= CONSTANT - 2; percent++) {
            System.out.print("%");
         }
         //ends line
         System.out.println("|");
      }
   }
}