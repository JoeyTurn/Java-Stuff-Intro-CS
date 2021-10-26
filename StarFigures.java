public class StarFigures {
   public static void main(String[] args) {
      top();
      System.out.println();
      top();
      five();
      five();
      System.out.println();
      one();
      one();
      one();
      top();
   }
   public static void five(){
      System.out.println("*****");
   }
   public static void two(){
      System.out.println(" * * ");
   }
   public static void one(){
      System.out.println("  *  ");
   }
   public static void top() {
      five();
      five();
      two();
      one();
      two();
   }
}