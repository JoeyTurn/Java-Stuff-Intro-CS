import java.util.*;

class Dog {
   void bark() {
      System.out.println("Woof!");
   }
   String friend = "Human";
}

class Husky extends Dog {
   void bark(){
      super.bark();
   }
   
   String fur = "Black";
   
   void adorable(int age) {
   Random rn = new Random();
   int ri = (rn.nextInt(10)+1)*age;
      System.out.printf("Your husky is this adorable for its age: %d%n", ri);
   }
}

public class Lecture2 {
   
   static void up() {
      System.out.println("  /\\  ");
      System.out.println(" /  \\ ");
      System.out.println("/    \\ ");
   }
   static void down() {
      System.out.println("\\    /");
      System.out.println(" \\  / ");
      System.out.println("  \\/  ");
   }
   
   public static void main(String[] args) {
      Husky husky = new Husky();
      husky.bark();
      husky.adorable(10);
      System.out.println(husky.friend);
      /*for (int i = 1; i <= 2; i++) {
         up();
         down();
         System.out.println();
      }
      down();
      up();*/
   }
}
