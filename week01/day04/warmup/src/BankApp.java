import java.util.Scanner;
public class BankApp {
    /* declare an initial accountBalance of $500
    *think about where you are going to need to access the accountBalance.
    * where should this variable be declared?
    * do we need to make it static?
*When the user runs the app it should print a menu asking if they want to deposit, withdraw, check balance, apply for credit or exit
* when a user deposits funds the deposited amount should be added to the accountBalance total
* if a user would like to withdraw fund we will need to check the balance first and make sure the withdrawal amount is not greater than the account total.
* if they can withdraw then we will need to subtract the withdrawal amount from the account total, otherwise we need to let them know they do not have enough money in their account
* check balance should print out the users account balance
*Apply for Credit
    // in order to qualify for credit the user must meet the following conditions:
    // They must make at least double the amount of the credit limit they are applying for.
    // They must be over 18
    // They must have a job
    // They must have more than $500 in their account
* */

    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        boolean exit = false;
        int accountBalance = 500;

        do{
            int choice = welcome(console);

            switch(choice) {
                case 1:
                    accountBalance = depositMoney(console, accountBalance);
                    break;
                case 2:
                    accountBalance = withdrawMoney(console, accountBalance);
                    break;
                case 3:
                    checkBalance(accountBalance);
                    break;
                case 4:
                    applyForCredit(console, accountBalance);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Sorry, that's not a valid option.");
            }
        } while(!exit);

        System.out.println();
        System.out.println("Thanks for banking with us! Goodbye.");

    } // this closes main method

    // welcome method that contains my name

    public static int welcome(Scanner console){
        System.out.println();
        System.out.println("Welcome to the Java Bank - What would you like to do today?");
        System.out.println("1. Deposit funds");
        System.out.println("2. Withdraw funds");
        System.out.println("3. Check balance");
        System.out.println("4. Apply for credit");
        System.out.println("5. Exit");

        System.out.print("Your Selection: ");
        int menuOption = Integer.parseInt(console.nextLine());
        return menuOption;
    }

    // deposit
    public static int depositMoney(Scanner console, int accountBalance) {
        System.out.println("How much money would you like to deposit?: ");
        int amount = Integer.parseInt(console.nextLine());
        accountBalance += amount;

        System.out.println();
        System.out.printf("You deposited $%s into your account, your updated balance is $%s. ", amount, accountBalance);
        System.out.println();
        return accountBalance;

    }

    // withdraw
    public static int withdrawMoney(Scanner console, int accountBalance){
        System.out.println("How much money would you like to withdraw?: ");
        int amount = Integer.parseInt(console.nextLine());
        if(accountBalance < amount){
            System.out.println("sorry, you don't have enough funds in your account to make that withdrawal.");
        } else {
            accountBalance -= amount;
            System.out.println();
            System.out.printf("You withdrew $%s from your account, your updated balance is $%s. ", amount, accountBalance);
            System.out.println();
        }

        return accountBalance;
    }

    // check balance
    public static void checkBalance(int accountBalance){
        System.out.println("Your account balance is: $" + accountBalance);

   }

    public static boolean applyForCredit(Scanner console, int accountBalance) {
        System.out.println("Thank you for interest in our credit program, in order to qualify we will need you to confirm a few details and answer a few questions.");
        System.out.println("Please confirm that you are 18 or older {true, false]: ");
        boolean ofAge = Boolean.parseBoolean(console.nextLine());

        if (!ofAge) {
            System.out.println("Sorry, you must be at least 18 years old to apply for credit.");
            return false;
        } else {
            System.out.println("What is the credit limit you would like to apply for?: ");
            int limit = Integer.parseInt(console.nextLine());
            System.out.println("What is your yearly income?: ");
            int income = Integer.parseInt(console.nextLine());
            System.out.println("Are you currently employed? [true/false]: ");
            boolean employed = Boolean.parseBoolean(console.nextLine());
            if(income > (limit * 2) && accountBalance > 500 && employed) {
                System.out.printf("Congratulations, You've qualified for a credit limit of $%s!", limit);
                System.out.println();
                return true;
            } else{
                System.out.println("Sorry, you do not qualify at this time");
                return false;
            }

        }
   }



} // this closes the class
