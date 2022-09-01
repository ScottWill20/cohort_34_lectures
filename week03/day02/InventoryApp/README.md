# Improvements to the inventory app

## TO DOs

* [ ] Create Custom Exception that prevents us from adding inventory when the count is 0 or less
* [ ] throw this exception if a user tries to add inventory or update inventory with a count that is less than 0
* [ ] Create Enums for Cookie Flavor Types
* [ ] Rebuild the methods inside of the cookie pop up
* [ ] build a method that sets the cookie type to an enum
* [ ] Build a ReadWriteHelper class to read and write our inventory to a data file
* [ ] create a data folder to store the inventory file
* [ ] add read / write instructions to the main menu in the controller class

## Exceptions

### Types of Exceptions

**Checked**

Exceptions that we as developers should anticipate and handle properly. For example, if we are reading data from a file - what if the file doesn’t exist? Good developers would anticipate and handle this error rather than having the program terminate, we could display a message to the user saying “hey that file doesn’t exist”. The java complier enforces us to handle these errors. That’s why they are called checked exceptions because they get checked at compile time.

Exceptions that we should anticipate and recover from. They are called checked exceptions because they are checked at compile time.

**Unchecked**

Run time exceptions. They are not checked by the compiler at compile time - they are programming errors. null pointer exception is an example of this. Our goal here is not to send the user friendly messages when these errors happen but to prevent these errors from happening in the first place. We can do this by following good coding practices and testing our code.

**Error**

This indicates an error external to our application. An example of this would be stackoverflow error or memory error. Just like runtime exceptions we should let the application crash rather than display a friendly message to the user.

We should try to identify the source of these errors. These errors can be programming errors like an infinite loop but they can also happen outside of our application like a problem in the java virtual machine itself.

**Handling Exceptions**
- **Try/ Catch**

  Helps you handle exceptions (errors).

  Syntax:
```java
    try{
         // code you want to run 
    }catch(/*type of exception goes here*/){
    // if your code doesn't run, you can catch the exception and run another block of code here
    }
```
- Finally

  Keyword you put after a try/catch block.

    - Each `try` block must include at least one `catch`
    - They can be followed by an optional `finally` block
    - Code inside the `finally` block always runs, regardless of success or failure
    - It's most often used for managing resources that must be cleaned up regardless of the outcome

**Try with resources statement**

  The `try`-with-resources statement is a `try` statement that declares one or more resources. A *resource* is an object that must be closed after the program is finished with it. The `try`-with-resources statement ensures that each resource is closed at the end of the statement.

```java
    try(/*resource to try*/){

    }catch(){

    }
```
### Throwing Exceptions

`throw` keyword is used to create a custom error. It is used with an exception type.

Part of data validation - this should happen only when we are receiving input from a user or from external applications.

This technique is called defensive programming. We validate an argument an throw an exception if that argument is not acceptable. Our code is immediately giving us an error rather than storing the value and causing an error in the future.

Example

```java
public class Account{
// we will want to validate this data and make sure the value is not equal to or less than zero.
	public void deposit(float value) throws IOException{ // here we are saying that this method COULD throw an exception - we don't want to handle the exception in this method - we want to handle the exception when we call the method.
		// validating our data here
		if(value <= 0){
			// the type of exception we want to throw if this is true
			throw new IOException(); 
		}

	}
}
```
### Re-throwing Exceptions

we can `throw e` inside of a catch block to rethrow an error. This is because we may want to store then exception and then rethrow it later to handle it. You would do this by adding the exception to the method signature and then when the method is called you would handle the exception.

### Creating Custom Exceptions

This is particularly useful if you are building a library or a framework for others to use.

We always use the Exception suffix to name our exception classes.

We need to decided if this is going to be checked or unchecked. If it is a checked exception it needs to `extends Exception` class otherwise we should have it `extends RuntimeException` class. That’s all we need to do to create an exception.

Optionally we could create a constructor that takes a message.

## Enums
An `enum` is a Java data type that defines restricted named values. Each value is explicit. There's never a range so there's never a need to validate values that fall outside the range. If a value can only ever be one of three, then we can use an `enum`
to define those three values. If a value can only ever be one of seven, then we can use an `enum` to define those values. An `enum` further restricts possibilities, which makes our programs even safer and easier to think about.

An `enum` is a second way to create a custom type along with `class`. It shares a few class conventions:

- Enum names are UPPERCASE.
- A `public` enum must be stored alone in a *.java* source file with the same name as the enum.
- It may use access modifiers.
- It has a code block.

Enums are types, but they are types with pre-defined values. The values are resolved at compile-time.

Enums differ from classes:

- The first thing inside an enum’s code block must be one or more comma-separated values terminated by a semicolon. These are the only values an enum may have.
- value naming conventions are uppercase because they represent a constant.

```java
public enum Move {
    ROCK, PAPER, SCISSORS; // these are called enumeration constants
}
```

To declare an enum variable and assign it a value:

```java
EnumName VALUE = EnumName.VALUE;
```

Enums are never instantiated with the `new` keyword because their values are instantiated as part of the enum definition. The values inside the enum definition are the only enum instances that can ever exist.

It's safe to compare enum values using the `==` operator because all equal values are the same reference. With enums, value equality and reference equality are the same thing.

### Create an Enum from input

All enums have a static valueOf method that can be used to derive enum values from a string. The string argument passed to valueOf must match the name of an enum value exactly or the operation will fail with an `IllegalArgumentException`

```java
Scanner console = new Scanner(System.in);

System.out.print("Player 1, choose Rock, Paper, or Scissors: ");
// since values are UPPER_CASE, make the input upper case
String input = console.nextLine().toUpperCase();
Move p1Move = Move.valueOf(input);
System.out.println("Player 1, your move is: " + p1Move);

System.out.print("Player 2, choose Rock, Paper, or Scissors: ");
input = console.nextLine().toUpperCase();
Move p2Move = Move.valueOf(input);
System.out.println("Player 2, your move is: " + p2Move);
```

To make this process error-proof you would need to implement a try catch to handle the exception error if it occurs and the re-prompt the user

```java
public static void main(String[] args) {
    Move p1Move = chooseMove("Player 1");
    Move p2Move = chooseMove("Player 2");
    System.out.printf("Player 1 chose: %s. Player 2 chose: %s.%n", p1Move, p2Move);
}

static Move chooseMove(String playerName) {

    Scanner console = new Scanner(System.in);
    Move result = Move.ROCK;
    boolean isValid = false;

    do {
        System.out.printf("%s, choose your move [Rock/Paper/Scissors]: ", playerName);
        try {
            result = Move.valueOf(console.nextLine().toUpperCase());
            isValid = true;
        } catch (IllegalArgumentException ex) {
            System.out.println("Invalid move.");
        }
    } while (!isValid);

    return result;
}
```

### Enums with State and Behaviour

Enums are like classes. They can contain fields and methods. One way to think about enums is as classes whose objects are constructed at compile-time versus run-time. Enum instantiation occurs immediately within the enum definition itself.

There's never a need (or possibility) to instantiate an enum. The values are pre-instantiated.

### When to Use Enums

If data can change, it should not be represented with an enum. It should be a class.

## File IO 
Java **file I/O** (input and output) provides a more meaningful interaction with a computer. Once we can change a file, we can change the behavior of an individual program, many programs, or even the entire computer.

### Packages

The standard library has two packages dedicated to working with directories and files.

[java.io](http://java.io) - contains classes for exploring the file system, reading from files, and writing to files. Each class is designed for a specific purpose. Some read and write binary data, some read and write text, and all have different strategies for managing file system assets. The `java.io`
package uses inheritance heavily. A `FileReader` extends `InputStreamReader` which extends `Reader`.

java.nio.file - Its classes contain static convenience methods that make it easy to perform complicated file I/O in a single operation.

### Streams, Readers, and Writers

Stream - A stream is an abstraction for a potentially infinite sequence of bytes. They have a direction. An **input** stream is an infinite sequence of bytes that we can read. An **output**  stream is an infinite sequence of bytes to which we can write. Some streams support both input and output.

`System.in` is the standard input stream, `System.out` is the standard output stream. Bytes read from and written to files are streams.

Reader - A reader is a set of structured operations for reading bytes from an input stream. Some operations are text-based. Others are byte-based. A `Scanner` is a reader, even though it doesn't extend any Java I/O class. It provides line-based methods, methods for reading specific data types, and methods for reading everything all at once. Each reader has its own strategies.

Writer - A writer is a set of structured operations for writing bytes to an output stream. Some operations are text-based. Others are byte-based. Depending on its purpose, a writer may write lines of text, write specific data types, or write a big chunk of data all at once. The `print`, `println`, and `printf` methods are writer methods.

### Creating a File

Before we can read from or write to a new file, we must create one. The `File` class is a general-purpose class for confirming that a file exists, checking its properties, and creating files.

```java
// required imports
import java.io.File;
import java.io.IOException;
// "colors.txt" is a relative path.
// The file will be created in the project root.
File file = new File("colors.txt");
try {
    if (file.createNewFile()) {
        System.out.println("colors.txt created.");
    } else {
        System.out.println("colors.txt already exists.");
    }
} catch (IOException ex) {
    ex.printStackTrace();
}
```

### Absolute and Relative Paths

An **absolute path** specifies where a file or directory lives in full detail, starting with the root directory/drive and including all directories along with way.

In general, absolute paths should be avoided. Each operating system, computer, and user should have the flexibility to run our programs without worrying about a rigid absolute path. My root directory may not be the same as yours. If an absolute path is required, it should be configurable so that it may be changed per user and machine.

A **relative path** specifies where a file or directory lives relative to the [working directory](https://en.wikipedia.org/wiki/Working_directory). For now, our working directory is the project directory. That will change in different environments, but for now, it's safe to assume that a relative path is relative to the project.

## Stand Up Questions 
* I was having trouble following the try-with-resources statement on File I/O lesson. How does it differ from the try/catch? I see on the try-with-resources example, it still has the catch keyword which confused me.
  * The try-with-resources statement is a try statement that declares one or more resources. A resource is an object that must be closed after the program is finished with it. The try-with-resources statement ensures that each resource is closed at the end of the statement.
  * it's like using a finally 
* I wanted to ask about what it means to need to close resources in file I/O - for example closing a writer. Is that a security measure?
  * When you open a file for reading, it is good practice to close the file because it is a resource your program is using such as memory it no longer needs.
* The lesson said that we should generally avoid writing any try/catch blocks unless it's a really specific scenario but then in the following I/O lesson there was a way to catch any exceptions in a lot of the examples. When should we use them and how?
  * try-catch statements are used in Java to handle unwanted errors during the execution of a program.
    Try: The block of code to be tested for errors while the program is being executed is written in the try block.
    Catch: The block of code that is executed when an error occurs in the try block is written in the catch block.
  * Try-catch block is used to handle the exception. In a try block, we write the code which may throw an exception and in catch block we write code to handle that exception. Throw keyword is used to explicitly throw an exception.
  * A checked exception is caught at compile time whereas a runtime or unchecked exception is, as it states, at runtime. A checked exception must be handled either by re-throwing or with a try catch block, whereas an unchecked isn't required to be handled.
* My question is are there going to be times when I should use an enum when values do change? Or only when the values are standard and never going to change.
  * We do not use enums if the value will change later - we would only use them for fixed constant values 

