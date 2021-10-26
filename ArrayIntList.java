public class ArrayIntList {
   int[] elementData;
   int size;
   
   public ArrayIntList() {
      elementData = new int[10];
      size = 0
   }
   
   
   public void add(int num) {
      elementData[size] = num;
      size++;
   }
   
}