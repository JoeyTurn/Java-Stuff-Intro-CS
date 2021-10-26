public class Lecture4 {

   public static final int SIZE = 6;
   
   public static void main(String[] agrs) {
      drawTop();
      drawBodyTop();
      drawBodyBottom();
      drawTop();
   }
   public static void drawTop() {
      System.out.print("#");
      for (int i = 1; i <= SIZE*4; i++) {
         System.out.print("=");
      }
      System.out.println("#");
   }
   public static void drawBodyTop() {
      for (int i = 1; i <= SIZE; i++) {
         System.out.print("|");
         for (int j = 1; j <= 2*(SIZE-i); j++) {
            System.out.print(" ");
         }
         System.out.print("<>");
         for (int j = 1; j <= 4*i-4; j++) {
            System.out.print(".");
         }
         System.out.print("<>");
         for (int j = 1; j <= 2*(SIZE-i); j++) {
            System.out.print(" ");
         }
         System.out.println("|");
      }
   }
   public static void drawBodyBottom() {
      for (int i = SIZE; i >= 1; i--) {
         System.out.print("|");
         for (int j = 1; j <= 2*(SIZE-i); j++) {
            System.out.print(" ");
         }
         System.out.print("<>");
         for (int j = 1; j <= 4*i-4; j++) {
            System.out.print(".");
         }
         System.out.print("<>");
         for (int j = 1; j <= 2*(SIZE-i); j++) {
            System.out.print(" ");
         }
         System.out.println("|");
      }
   }
}