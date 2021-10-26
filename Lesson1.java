import java.util.ArrayList;

public class Lesson1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("four");
        list.add("score");
        list.add("seven");
        list.add(2, "and");
        for (int i = 0; i <= list.size(); i++) {
            //System.out.print(list.get(i) + " ");
        }
        ArrayIntList list2 = new ArrayIntList();
        ArrayIntList list3 = new ArrayIntList();
        
        /*list2.size = 3;
        list2.elementData[0] = 1;
        list2.elementData[1] = 82;
        list2.elementData[1] = 97;
        */
       list2.add(1);
       list2.add(82);
       list2.add(97);
       list3.add(7);
       list3.add(-8);
       System.out.print(toString(list2));
    }
}

class ArrayIntList {
    int[] elementData;
    int size;
    
    //constructor
    public ArrayIntList() {
        elementData = new int[100];
        size = 0;
    }
    public void add(int value) {
        elementData[size] = value;
        size++;
    }
}