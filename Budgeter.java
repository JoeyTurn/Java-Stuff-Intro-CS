/**  Joey Turnbull
  *  02/04/2020
  *  CSE142
  *  TA: Esther Chien
  *  Assignment #4
  *
  *  This program asks for monthly income and expenses, then prints out the net monthly income.
  *  Great description, don't see that elsewhere (kappa)
  *
  * v1.5 now with proper spacing (1.2)(haha nice try), income/expense is now just one method (1.3),
  * no random string defined (1.4), more taylor swift songs (blank space) (1.5) */

import java.util.*;

public class Budgeter {

   //class constant DAYS, used to change income per month and expense per month calculations
   public static final int DAYS = 31;
   
   //main method, getsIncome, getsExpenses, prints Income/Expenses per month, then prints savings
   //or spendings
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      printTopLines();
      double totalIncome = getTotalIncomeOrExpense(in, 0);
      int expenseType = getExpenseType(in);
      double totalIncorrectExpense = getTotalIncomeOrExpense(in, 1);
      double totalExpense = getCorrectExpense(expenseType, totalIncorrectExpense);
      printPerMonthAndTotals(totalIncome, totalExpense);
      printSpentOrSaved(totalIncome, totalExpense);
   }
   
   //prints blank line, so spacing is better in the I/O
   public static void blankLine() {
      System.out.println();
   }
   
   //prints lines at the top of the program, detailing the program's features
   public static void printTopLines() {
      System.out.println("This program asks for your monthly income and");
      System.out.println("expenses, then tells you your net monthly income.");
      blankLine();
   }
   
   //gets income value(s) if incomeOrExpense is falsy, gets expense if truthy (guess not ok java)
   //in is the System's keyboard, incomeOrExpense is either 0 or 1 and sets whether the program
   //prints income or expense in places of %s
   public static double getTotalIncomeOrExpense(Scanner in, int incomeOrExpense) {
      String incomeOrExpenseWord;
      if (incomeOrExpense == 0) {
         incomeOrExpenseWord = "income";
      } else {
         incomeOrExpenseWord = "expense";
      }
      double totalIncomeOrExpense = 0;
      System.out.printf("How many categories of %s? ", incomeOrExpenseWord);
      int incomeOrExpenseCategories = in.nextInt(); //rip do while
      //rip try catch, what if they have 0?
         for (int incomesOrExpenses = 1; incomesOrExpenses <= incomeOrExpenseCategories;
               incomesOrExpenses++) {
            System.out.printf("    Next %s amount? $", incomeOrExpenseWord);
            totalIncomeOrExpense += in.nextDouble();
         }
      blankLine();
      return (double) totalIncomeOrExpense;
   }
   
   //gets month/day type for later calculation
   //in is the System's keyboard
   public static int getExpenseType(Scanner in) {
      System.out.print("Enter 1) monthly or 2) daily expenses? ");
      int expenseType = in.nextInt();
      return expenseType;
   }
   
   //sets totalExpense to the correct value, give expenseType 
   //expenseType checks whether the user entered 1 or 2 when prompted (1 for month, 2 for day)
   //the paramater totalExpense is the sum of everything the user puts in under expense amounts
   //totalExpense is the same regardless of expenseType until it is returned
   public static double getCorrectExpense(int expenseType, double totalExpense) {
      if (expenseType == 2) {
         totalExpense *= DAYS;
      }
      return totalExpense;
   }
   
   //prints total income & expenses, as well as per month income & expenses
   //both variables are pretty self-explanitory
   public static void printPerMonthAndTotals(double totalIncome, double totalExpense) {
      System.out.printf("Total income = $%.2f ($%.2f/day) \n", totalIncome, (totalIncome/DAYS));
      System.out.printf("Total expenses = $%.2f ($%.2f/day)\n", totalExpense, (totalExpense/DAYS));
      blankLine();
   }
   
   /* prints out whether you've saved or spent more this month, then whether you're a (big)
    * saver/spender and a custom message
    * since we had to have a custom message for each, i decided against having a method that
    * modifies "You're a (big) (spender/saver)"
    * totalIncome and totalExpense are pretty self-explanitory */
   public static void printSpentOrSaved(double totalIncome, double totalExpense) {
      double incomeMinusExpense = totalIncome - totalExpense;
      if (incomeMinusExpense > 0) {
         System.out.printf("You earned $%.2f more than you spent this month.\n", 
                            incomeMinusExpense);
         if (incomeMinusExpense >= 250) {
            System.out.println("You're a big saver.");
            System.out.println("Want to give me some?");
         } else {
            System.out.println("You're a saver.");
            System.out.println("Time to invest!");
         }
      } else {
         System.out.printf("You spent $%.2f more than you earned this month.\n",
                           -1*incomeMinusExpense);
         if (incomeMinusExpense <= -250) {
            System.out.println("You're a big spender.");
            System.out.println("Better slow down there, bucko. Retirement isn't that far away.");
         } else {
            System.out.println("You're a spender.");
            System.out.println("Please pay for my textbooks instead.");
         }
      }
   }
}