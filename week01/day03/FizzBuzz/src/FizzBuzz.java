import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        System.out.print("please input a number: ");

        int n = Integer.parseInt(console.nextLine());

        for (int i = 1; i < n + 1; i++) {
            if ((i % 3 == 0) && (i % 5 == 0)) {
                System.out.println("fizzbuzz");
            } else if (i % 5 == 0) {
                System.out.println("buzz");
            } else if (i % 3 == 0) {
                System.out.println("fizz");
            } else {
                System.out.println(i);
            }
        }
    }
}
