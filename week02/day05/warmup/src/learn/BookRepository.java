package learn;

import java.lang.reflect.Array;
import java.rmi.NoSuchObjectException;
import java.util.ArrayList;
import java.util.Arrays;

public class BookRepository {

    public static ArrayList<Books> getAll() {

        return new ArrayList<>(Arrays.asList(
                new Books("To Kill a Mockingbird", "Harper", "Lee", "Fiction"),
                new Books("1984", "George", "Orwell", "Science Fiction"),
                new Books("The Lord of The Rings", "J.R.R.", "Tolkien", "Fiction"),
                new Books("The Great Gatsby", "F. Scott", "Fitzgerald", "Fiction"),
                new Books("Lord of the Flies", "William", "Golding", "Fiction")

        ));
    }
}
