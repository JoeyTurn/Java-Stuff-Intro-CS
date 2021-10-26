/** Joey Turnbull
  *  0/14/2020
  *  CSE142
  *  TA: Esther Chien
  *  Assignment #1
  *
  *  This program will print lines to simulate playing a song about an old woman.
  *  wait the class hasn't learned about multiline comments yet o.O */

public class Song {

   //rip println's in main
   //main prints out each verse of the song, of which can be found in their own methods
   public static void main(String[] args) {
      v1();
      v2();
      v3();
      v4();
      v5();
      v6();
      v7();
   }
   
   //prints everything from swallowed fly onwards
   public static void fly() {
      System.out.println("I don't know why she swallowed that fly,"); 
      System.out.println("Perhaps she'll die.");
      System.out.println(); //It's literally just /n but i'm not allowed to use that so instead its a blank println
   }
   
   //prints everything from swallowed spider onwards
   public static void spider() {
      System.out.println("She swallowed the spider to catch the fly,"); 
      fly();
   }
   
   //prints everything from bird spider onwards
   public static void bird() {
      System.out.println("She swallowed the bird to catch the spider,"); 
      spider();
   }
   
   //prints everything from swallowed cat onwards
   public static void cat() {
      System.out.println("She swallowed the cat to catch the bird,"); 
      bird();
   }
   
   //prints everything from swallowed dog onwards
   public static void dog() {
      System.out.println("She swallowed the dog to catch the cat,"); 
      cat();
   }
   
   //prints everything from swallowed eagle onwards
   public static void eagle() {
      System.out.println("She swallowed the eagle to catch the dog,"); 
      dog();
   }
   
   //verse 1
   public static void v1() {
      System.out.println("There was an old woman who swallowed a fly.");
      fly();
   }
   //verse 2
   public static void v2() {
      System.out.println("There was an old woman who swallowed a spider,");
      System.out.println("That wriggled and iggled and jiggled inside her.");
      spider();
   }
   //verse 3
   public static void v3() {
      System.out.println("There was an old woman who swallowed a bird,");
      System.out.println("How absurd to swallow a bird.");
      bird();
   }
   //verse 4
   public static void v4() {
      System.out.println("There was an old woman who swallowed a cat,"); 
      System.out.println("Imagine that to swallow a cat.");
      cat();
   }
   //verse 5
   public static void v5() {
      System.out.println("There was an old woman who swallowed a dog,"); 
      System.out.println("What a hog to swallow a dog.");
      dog();
   }
   //verse 6
   public static void v6() {
      System.out.println("There was an old woman who swallowed a eagle,"); //my verse
      System.out.println("How illegal to eat an eagle."); //not 8 syllables >:( there's no way to make it work
      eagle();
   }
   //verse 7, ending
   public static void v7() {
      System.out.println("There was an old woman who swallowed a horse,");
      System.out.println("She died of course.");
   }
}