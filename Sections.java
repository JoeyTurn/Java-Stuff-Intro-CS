import java.util.*;

public class Sections {
   public static void main(String[] args) {
      Random rand = new Random();
      Section5.showTwos(10);
      Section5.randomWalk(rand);
   }
}

class Section5 {
   public static void showTwos(int x) {
      System.out.print(x + " = ");
      while (x%2 == 0) {
         System.out.print("2 * ");
         x /= 2;
      }
      System.out.println(x);
   }
   public static void randomWalk(Random rand) {
      int pos = 0;
      int maxPos = pos;
      do {
         System.out.printf("position = %d\n", pos);
         int randNum = rand.nextInt(3);
         if (randNum == 0)
            pos += 1;
         else if (randNum == 1)
            pos -= 1;
         if (maxPos < pos)
            maxPos = pos;
      } while(Math.abs(pos) < 3);
      System.out.printf("position = %d\n", pos);
      System.out.printf("max position = %d\n", maxPos);
   }
   public static void arrayMystery(int[] array) {
    for (int i = 0; i < array.length - 1; i++) {
        if (array[i] < array[i + 1]) {
            array[i] = array[i + 1];
        }
    }
}
}