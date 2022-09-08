package learn.streams;

import learn.streams.data.Repository;
import learn.streams.models.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        Repository repository = new Repository();
        List<Person> people = repository.getPeople();


        // TODO complete tasks...
        //TODO Who has a last name that starts with the letter "a"?
        //TODO filter for letter a with Streams



    }
}
