# Streams API

## TODO

* [x] Write up outline
* [x] Review the Streams exercises instructors key
* [x] Add `currentStateProvince` field to the `Person` model
* [x] Create CSV file to facilitate data manipulation discussions
* [x] Write up some of the solutions to the below listed tasks
* [x] Post ZIP of project so students can follow along

## Why do we need to manipulate data?

* Gain insights about our data
* Make better decisions

_Any other reasons why we manipulate data?_

## Data Manipulation Without Streams

**You can download the project in Teams if you want to follow along!**

* We provide value to our users by saving them time
* One way that we can do that is to automate the process of manipulating data
* Imperative solutions
* Review our data set
    * People and states/provinces

### Tasks

* [ ] Filter
    * Who has a last name that starts with the letter "a"?
    * Who was born after the year 1990?
    * Who has lived in the state of California?
* [ ] Sort
    * Order by last name, then first name
    * Order by age
    * Order by the number of states that each person has lived in
* [ ] Transform
    * Create a list of full names
    * Create a list of the unique birth years
    * Create a list of the unique states
* [ ] Aggregate
    * How many people have lived in the state of New York?
    * How many people have lived in each state?
    * What are the top 10 birth years?

_Optionally write unit tests to confirm the above results_

### Questions

_Don't make any assumptions about what each of these tasks are doing!_

* What is mapping?
* What is aggregation?
* What is grouping?

## Data Manipulation With Streams

* What is an API?
    * API can mean more than one thing depending on the context
    * Developers often use to API to refer to web services (e.g. Google Maps)
    * API can generally mean a collection of methods that are all focused on solving a common problem
    * Focus more on the "Streams" part not the "API" part
* The Streams API in Java gives us a way to manipulate data by focusing primarily on the "what" (and less on the "how")
    * The Java Streams API offers types and methods for manipulating sequences of data in a declarative and functional way
    * The what is expressed as a lambda or built-in stream method
    * The how is a hidden implementation detail
* Declarative solutions
    * We can get access to the Streams API by calling `stream()` on any collection that implements the `Collection<T>` interface (https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html)
    * The `Arrays.stream()` creates a stream from an array
* Stream operations often require a lambda to be passed in
    * The lambda represents the specialization of the "what"
    * **For now, just think of lambdas as methods without names (i.e. anonymous methods). Focus on the input parameters and output return type.**
    * Later this afternoon or tomorrow morning we can optionally take a closer look at how Java provides support for lambdas

### Tasks

* [ ] Filter
    * Who has a last name that starts with the letter "a"?
    * Who was born after the year 1990?
    * Who has lived in the state of California?

* [ ] Sort
    * Order by last name, then first name
    * Order by age
    * Order by the number of states that each person has lived in

* [ ] Transform
    * Create a list of full names
    * Create a list of the unique birth years
    * Create a list of the unique states

* [ ] Aggregate
    * How many people have lived in the state of New York?
    * How many people have lived in each state?
    * What are the top 10 birth years?

```java
Stream<Person> personStream = people.stream();
personStream = personStream.filter(p -> p.getLastName().toLowerCase().startsWith("a"));
List<Person> people1 = personStream.collect(Collectors.toList());
for (Person p : people1) {
    System.out.println(p);
}

people.stream()
        .filter(p -> p.getLastName().toLowerCase().startsWith("a"))
        .forEach(System.out::println);

people.stream()
        .filter(p -> p.getStatesProvinces().stream().anyMatch(sp -> sp.getAbbreviation().equals("CA")))
        .forEach(System.out::println);

people.stream()
        .sorted(Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName))
        .forEach(System.out::println);

people.stream()
        .sorted(Comparator.comparingInt((Person p) -> p.getStatesProvinces().size()).reversed())
        .forEach(System.out::println);

Map<String, List<Person>> p1 = people.stream()
        .collect(Collectors.groupingBy(p -> p.getCurrentStateProvince().getAbbreviation()));
for (String stateAbbreviation : p1.keySet().stream().sorted().collect(Collectors.toList())) {
    System.out.println(stateAbbreviation);
}

Map<String, Long> p2 = people.stream()
        .collect(Collectors.groupingBy(p -> p.getCurrentStateProvince().getAbbreviation(), Collectors.counting()));
for (String stateAbbreviation : p2.keySet().stream().sorted().collect(Collectors.toList())) {
    System.out.printf("%s: %s%n", stateAbbreviation, p1.get(stateAbbreviation));
}
```

### Types of Operations

* Some stream operations return a new stream allowing you to chain multiple operations together
* Terminal operations don't return a new stream; instead they return a value or collection of values

#### `Stream<T>` Methods

https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html

_TODO_ List out the signature of what each of these methods expects

* Filtering
    * `filter`
    * `skip`
    * `limit`
    * `distinct`

* Sorting
    * `sorted`

* Transform
    * `map`
    * `flatMap`
    * and more!

* Aggregation
    * `count`
    * `max`
    * `min`
    * `findAny` - finds a single element in the stream (position is not guaranteed)
    * `findFirst` - finds the first occurrence of an element
    * `reduce`
    * and more!

_All of the above operations are terminal operations_

* Terminal
    * `collect`
    * `forEach`
    * `toArray`
    * `anyMatch`
    * `allMatch`
    * `noneMatch`
    * and more!

* Other
    * `peek`

**Streams don't do anything until a terminal operation is performed!**

### Collectors

https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/stream/Collectors.html

* `toList`
* `toCollection`
* `joining`
* `summingInt`
* `averagingInt`
* `groupingBy` - groups elements with optional aggregation
* `maxBy`
* `minBy`
* `summarizingInt`
* and more!

### `Comparator<T>`

https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html

Some Streams operations require a Comparator:

* `sorted`
* `max`
* `min`

#### `Comparator<T>` Methods

* `comparing`
* `comparingInt`
* `comparingDouble`
* `reversed`
* `thenComparing`

#### Custom Comparator

A Comparator compares two elements from a list.

```java
public interface Comparator<T> {
    int compare(T object1, T object2);
}
```

The `compare()` method compares two objects to each other and should:

* Return a negative value if `object1` is smaller than `object2`
* Return `0` (zero) if `object1` is equal to `object2`
* Return a positive value if `object1` is larger than `object2`

### `Optional<T>`

https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Optional.html

Some Stream operations return an `Optional<T>` type that may or may not have a value

* `max`
* `min`
* `findFirst`
* `reduce`
* and more!

#### `Optional<T>` Methods

An object which may or may not contain a non-null value. If a value is present, `isPresent()` returns `true`. If no value is present, the object is considered empty and `isPresent()` returns `false`.

* `isEmpty`
* `isPresent`
* `get`
* `orElse`
* `ifPresent`

## Lambdas

**Note: This is an advanced topic that's not necessary to know fully in order to use Streams API. If you get confused during this session, feel free to press pause and go back a step to using Streams with just a general understanding of lambdas.**

_TODO_

## CSV Output

```java
System.out.println("FirstName,LastName,BirthDate,CurrentStateProvince,StatesProvinces");

for (Person p : people) {
    System.out.printf("%s,%s,%s,%s,%s%n",
            p.getFirstName(), p.getLastName(), p.getBirthDate(), p.getCurrentStateProvince().getAbbreviation(),
            p.getStatesProvinces().stream().map(StateProvince::getAbbreviation).collect(Collectors.joining("-")));
}
```

## Resources

* http://tutorials.jenkov.com/java-functional-programming/streams.html
* http://tutorials.jenkov.com/java-functional-programming/functional-interfaces.html

## Questions from the Sept Cohort

### Streams API (Austin, Alec, Alexis, Alexander, Cecilia, Dennis, Charlie, Becky, Devon, Nicholas, Jamie, Noah)

* [ ] More Streams examples (Austin, Cecilia, Dennis)
* [x] IntelliJ Streams visualizer (Noah)
* [x] Thought process about how to solve problems using Streams (Alexander, Becky, Jamie)
    * The Streams API is large, nuanced, and chock-full of new generic and functional syntax
    * Break the problem into a sequence of steps
    * Each interesting stream problem is some ordering of filter, sort, transform, and aggregate
    * The trick is knowing which order to apply the steps
    * In general, it's best to filter early and sort late
    * An early filter reduces the number of elements we need to think about
    * Late sorting is a just-in-time presentation trick
* [ ] More examples of advanced usage
    * Higher level aggregating/sorting (Alec, Alexis, Charlie)
    * Streams within streams (Noah)
* [ ] `Collectors.toList()` vs `Collectors.toCollection(ArrayList::new)` (Devon)
* [ ] To what extent do you need to know Streams API? (Nicholas)

```java
// toList produces a List interface
List<Player> playersWithNoHero = getPlayers().stream()
        .filter(player -> player.getHeroes().size() == 0)
        .collect(Collectors.toList());

// for a concrete collection, use the toCollection method
ArrayList<Player> playersFromNigeria = getPlayers().stream()
        .filter(player -> player.getCountry().equals("Nigeria"))
        .collect(Collectors.toCollection(ArrayList::new));
```

Specific questions about exercises...

* [ ] Kristin: aggregation with `Collectors.summarizingInt`... why did it return a `double` not `long`?
    * `Collectors.summarizingInt` returns an `IntSummaryStatistics` object
    * The `getAverage()` method on that object returns a `double`
    * https://docs.oracle.com/javase/8/docs/api/java/util/IntSummaryStatistics.html

### Lambdas (Brian, Matt, Julia, Austin, Dennis, Devon, John, Logan, Nicholas, Noah)

* [x] What are lambdas?
    * **Lambdas are anonymous methods**
    * Behind the scenes the compiler is creating a type that implements a functional interface
* [x] How do you use lambdas?
* [x] Why were lambdas added to Java? (Noah)
    * To give developers the ability to leverage functional programming techniques
    * To support the addition of the Streams API to Java
* [x] Double colon operator (`::`)... what is it used for? (Devon, Logan, Nicholas)
    * Used to get a reference to an instance or static method
* [x] Can you create a lambda without parameters? (Matt)
    * `() -> 5`
* [x] More examples (Dennis)
* [x] Are there performance considerations? (Noah)
    * In my experience, developer performance usually is more important than application performance
    * Good analysis of the problem: https://www.beyondjava.net/performance-java-8-lambdas

```java
import java.util.function.BiFunction;

public class Main {
    @FunctionalInterface
    interface MathOp {
        int op(int number1, int number2);
    }

    public static void main(String[] args) {
        MathOp add = (n1, n2) -> n1 + n2;
        BiFunction<Integer, Integer, Integer> add2 = (n1, n2) -> n1 + n2;
        MathOp add3 = Main::add;

        System.out.println(add.op(1, 2));
        System.out.println(add.op(3, 4));
        System.out.println(add.op(5, 6));

        System.out.println(add2.apply(1, 2));
        System.out.println(add2.apply(3, 4));
        System.out.println(add2.apply(5, 6));

        System.out.println(add3.op(1, 2));
        System.out.println(add3.op(3, 4));
        System.out.println(add3.op(5, 6));

        MathOp subtract = (n1, n2) -> n1 - n2;
        BiFunction<Integer, Integer, Integer> subtract2 = (n1, n2) -> n1 - n2;
        MathOp subtract3 = Main::subtract;

        System.out.println(subtract.op(1, 2));
        System.out.println(subtract.op(3, 4));
        System.out.println(subtract.op(5, 6));

        System.out.println(subtract2.apply(1, 2));
        System.out.println(subtract2.apply(3, 4));
        System.out.println(subtract2.apply(5, 6));

        System.out.println(subtract3.op(1, 2));
        System.out.println(subtract3.op(3, 4));
        System.out.println(subtract3.op(5, 6));
    }

    private static int add(int number1, int number2) {
        return number1 + number2;
    }

    private static int subtract(int number1, int number2) {
        return number1 - number2;
    }
}
```