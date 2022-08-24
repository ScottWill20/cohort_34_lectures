import java.util.Scanner;

public class app {
    public static void main(String[] args) {

        // top 10 Fav movies

        Scanner console = new Scanner(System.in); // Standard input, sometimes called stdin

//        String movie1 = "Star Wars";
//        String movie2 = "Toy Story";
//        String movie3 = "Toy Story 2";
//        String movie4 = "Toy Story 3";
//        String movie5 = "Toy Story 4";
//        String movie6 = "Toy Story 5";
//        String movie7 = "Toy Story 6";
//        String movie8 = "Toy Story 7";
//        String movie9 = "Toy Story 8";
//        String movie10 = "Toy Story 9";
//
//        System.out.println(movie1);
//        System.out.println(movie2);
//        System.out.println(movie3);
//        System.out.println(movie4);
//        System.out.println(movie5);
//        System.out.println(movie6);
//        System.out.println(movie7);
//        System.out.println(movie8);
//        System.out.println(movie9);
//        System.out.println(movie10);

        // Java doesn't understand that these variables are related to each other

        // Enter arrays:

        System.out.println("Hello to the Fav Movies app!");

        System.out.println("How many movies would you like to track?: ");
        int numberOfMovies = Integer.parseInt(console.nextLine());

        String[] movies = new String[numberOfMovies]; // number can be user input as well

        // What is the value of each element or item in our array?
            // null

        System.out.printf("Which movie do you want to view? [1 - %s]", movies.length);
        int movieIndex = Integer.parseInt(console.nextLine()) -1;

        // make sure that the movie index is valid
        // negative check
        // use do while loop to cycle invalid selections

        if (movieIndex < 0 || movieIndex >= movies.length) {
            System.out.println("Oops! That movie doesn't exist");
        } else {
            System.out.println(movies[movieIndex]); // this will tell us how many elements or items the array contains
        }

        movies[0] = "Star Wars"; // set first element at index 0 as Star Wars



        for(int index = 0; index < movies.length; index ++) {
            // System.out.println(index); // will print each index
            String movie = movies[index]; // get a value

            if(movie == null) {
                movie = "N/A"; // change the display without changing the array
            }

            System.out.printf("Movie index %s: %s%n", index +1, movie); // will print each value
        }                                                //  ^ will remove 0 from user perspective


    }
}
