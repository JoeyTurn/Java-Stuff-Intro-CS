import java.util.*;

public class EmployeeClient {
   public static void main(String[] args) {
      Employee ellie = new Employee();
      Server ben = new Server();
      
      System.out.println("Employee:");
      System.out.printf("     Works %d hours\n", ben.getHours());
      System.out.printf("     Earns %.2f per hour\n", ben.getHourlyRate());
      System.out.printf("    Gets %dd vacation days \n", ben.getVacationDays());
      System.out.println("");
      ben.collectTips(30.75);
   }
}