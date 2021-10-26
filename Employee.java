public class Employee {
   public int getHours() {
      return 40;
   }
   
   public double getHourlyRate() {
      return 50.0;
   }
   
   public int getVacationDays() {
      return 10;
   }
}

class Server extends Employee {
   public void collectTips(double amount) {
      System.out.printf("Ca-ching!! $%.2f", amount);
   }
}