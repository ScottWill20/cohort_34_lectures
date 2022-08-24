import java.awt.*;
import java.util.Scanner;

public class warmup {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        boolean calculating = true;

        while(calculating) {

            System.out.println("Please enter the first number to compute: ");
            int first = Integer.parseInt(console.nextLine());
            System.out.println("Please enter the second number to compute: ");
            int second = Integer.parseInt(console.nextLine());
            System.out.println("Please enter the desired operation: \n[0] - add \n[1] - subtract \n[2] - multiply \n[3] - divide");
            int operator = Integer.parseInt(console.nextLine());

            switch (operator) {
                case 0:
                    System.out.println(first + " + " + second + " = " + addnums(first, second));
                    break;
                case 1:
                    System.out.println(first + " - " + second + " = " + subnums(first, second));
                    break;
                case 2:
                    System.out.println(first + " * " + second + " = " + multnums(first, second));
                    break;
                case 3:
                    System.out.println(first + " / " + second + " = " + divnums(first, second));
                    break;
            }
            System.out.println("Would you like to do another equation?: [yes] or [no]");
            String answer = console.nextLine();
            if(answer.equalsIgnoreCase("no")) {
                calculating = false;
            }
        }
        System.out.println("Thank you!!");
    }
    //Switch case based on operator
    // add case

    public static int addnums (int x, int y) {
        return (x+y);
    }
    public static int subnums (int x, int y) {
        return (x-y);
    }
    public static int multnums (int x, int y) {
        return (x*y);
    }
    public static int divnums (int x, int y) {
        return (x/y);
    }


    // mult case
    // div case
    // sub case
}
