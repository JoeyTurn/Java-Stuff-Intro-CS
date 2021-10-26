import java.util.Scanner;

public class drivingW3 {
   public static void main(String[] args) {
      
      Scanner in = new Scanner(System.in);
      
      System.out.print("Enter the type of your vehicle:");
      String type = in.nextLine().toLowerCase();
      
      try {
         if (type == "car") {
            System.out.print("Enter the model of your car: ");
            String model = in.nextLine();
            System.out.print("Enter the brand of your car: ");
            String brand = in.nextLine();
            
            Car userCar = new Car(model);
               
         }
      } catch (Exception e) {
         System.out.println("Something went wrong here.");
      }
   }
}

class Vehicle {
   protected String brand;
   public Vehicle(String b) {
      brand = b;
   }
   
}

class Car extends Vehicle {
   private String brand, modelName;
   public void Car(String m) {
      brand = super.brand;
      modelName = m;
   }
   public void honk() {
      System.out.println("Get out of the way!");
   }
}

class Plane extends Vehicle {
   
}