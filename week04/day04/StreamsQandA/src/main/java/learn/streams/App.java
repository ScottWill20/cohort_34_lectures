package learn.streams;

import learn.streams.data.Repository;
import learn.streams.models.Person;
import learn.streams.models.StateProvince;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        Repository repository = new Repository();
        List<Person> people = repository.getPeople();
        // System.out.println(people);

        // TODO complete tasks...
        // TODO Who has a last name that starts with the letter "a"?
        // TODO filter for letter a with Streams

        // FILTERING

        // imperative solution

//        // create a new collection
//        List<Person> peopleWithLastNameThatStartsWithA = new ArrayList<>();
//        // loop over that collection
//        for (Person person : people) {
//            // need a condition - if last name starts with a
//            if (person.getLastName().toLowerCase().charAt(0) == 'a') {
//                // add it to new collection
//                peopleWithLastNameThatStartsWithA.add(person);
//            }
//        }
//
//        for (Person person :peopleWithLastNameThatStartsWithA) {
//            System.out.println(person);
//        }

        // ew,gross

        // declarative solution - just the what

//        people.stream()
//                .filter(p -> p.getLastName().toLowerCase().charAt(0) == 'a')
//                .forEach(System.out::println);

//     // TODO filter those who live in california
//        // stream within a stream
        people.stream().filter(p -> p.getStatesProvinces().stream()
                // predicate - fancy name for method that takes an object
                .anyMatch(sp -> sp.getAbbreviation().equalsIgnoreCase("CA")))
                .forEach(System.out::println);


        // TODO order by last name, then first name
        // SORTING

        // returns a String
//        List<String> sortedPeopleName = people.stream()
//                // this is going to work because we are mapping Person to String and String implements comparable
//                .map(p -> String.format("%s %s",p.getLastName(),p.getFirstName()))
//                .sorted()
//                .collect(Collectors.toList());
//
//        for (String personName : sortedPeopleName) {
//            System.out.println(personName);
//        }
//
//        // map calls comparable so if we don't do a map, how can we do this?
//        // returns the whole object
//        List<Person> sortedPeople = people.stream()
//                .sorted(Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName))
//                .collect(Collectors.toList());
//
//        for (Person person : sortedPeople) {
//            System.out.println(person);
//        }
//
//        people.stream()
//                .sorted(Comparator.comparing(Person::getLastName).reversed())
//                .forEach(System.out::println);

        //  SORTING IS EXPENSIVE - filter first if you can


        // TODO index by last name
        // GROUPING
        // we take all records nd organize them into groups


//        Map<Character, List<Person>> groupedPeople = people.stream()
//                .collect(Collectors.groupingBy(person -> person.getLastName().toUpperCase().charAt(0)));
//        // this returns a HashMap
//        // putting our stream inside a list, so we can loop through our hashmap and view our results
//        for (Character key : groupedPeople.keySet()) {
//            System.out.println("All of the people whose last name starts with: " + key + "...");
//            for (Person person : groupedPeople.get(key)) {
//                System.out.println(person);
//            }
//        }

        // TODO get the average age here as well - so we can supply a second optional here
        // IntSummaryStatistics - check Oracle
//        Map<Character, IntSummaryStatistics> groupPeople = people.stream()
//                .collect(Collectors.groupingBy(
//                        person -> person.getLastName().toUpperCase().charAt(0),
//                        Collectors.summarizingInt(
//                                person -> LocalDate.now().getYear() - person.getBirthDate().getYear())));
//
//        for (Character key : groupPeople.keySet()) {
//            System.out.println("The average age of people whose last name starts with: " + key + "...");
//            IntSummaryStatistics agesSummary = groupPeople.get(key); // get all of the ages within the group of last name
//            System.out.println(agesSummary.getAverage());
//        }

        // FLAT MAP - we are collapsing values into a new List
        List<StateProvince> stateProvinces = people.stream()
                .flatMap(p -> p.getStatesProvinces().stream())
                        .collect(Collectors.toList());

        for (StateProvince stateProvince : stateProvinces) {
            // we have lost person here
            // we have mapped each person to their state province
            System.out.println(stateProvince);
        }




    } // this closes main


//    private boolean doesPersonLastNameStartWithA(Person person) {
//        return person.getLastName().toLowerCase().charAt(0) == 'a';
//    }


} // this closes class
