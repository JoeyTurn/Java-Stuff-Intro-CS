/**  Joey Turnbull
  *  29/09/2021
  *  CSE143
  *  Lesson #1
  *  
  *  collection: an ovject that stores data;
  *  objects stored are called elements (typ operations are
  *  add, remove, clear, contains, size*/

import java.util.*; //needs this for basically everything

public class Lesson1CSE143 {
   
   public static void main(String[] args) {
   
      /*String[] arr = new String[50];
      arr[0] = "According";
      System.out.println(Arrays.toString(arr));*/
      
      ArrayList<String> list = new ArrayList<String>();
      
      list.add("According");
      list.add("to");
      list.add("some");
      list.add("known");
      list.add("laws");
      list.add("of");
      list.add("aviation");
      
      System.out.println(list);
      
      list.remove(2);
      
      list.add(2, "all");
      
      System.out.println(list);
   }
}