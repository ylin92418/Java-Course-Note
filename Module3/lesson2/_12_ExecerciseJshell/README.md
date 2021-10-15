# Exercise objectives:

- SWBAT use `var` keyword in Java from JShell.
- SWBAT import and use external libraries to JShell

# Part 1
 
Let's explore a bit the `var` keyword. It was introduced in Java 10, within a new feature called 
_local variable type inference_, which basically means that the compiler guesses the type of the variables based on
the surrounding context allowing the programmers to not declare the type explicitly.

If you already have Java 10 or higher installed on your environment you should be able to run JShell, just type `jshell`
on a terminal and the read-eval-printl loop will start. If you are using IntelliJ another way to start a JShell session 
 is by clicking on `Tools` and then `JShell console`. 

1. From a JShell session type:

    `var x`

    What happens?

2. Let's now give a value to the `x` variable:

    `var x = "'Hello World!' string"`

    and then:

    `System.out.println(x.getClass().getName())`

    What class is `x`?

3. Let's try a different context, type:

    `var y = List.of(1,2,3)`

    and then, let's check if it's a list: 

    `System.out.println(y instanceof List)`

    What happens if we try to cast it to an `ArrayList`? Why?

    `var arrayList = ((ArrayList) y)`




You can close the JShell session with the command `/exit`.


# Part 2

To use different classes on a JShell session those should be added to the classpath, one way of doing it is by using 
the `--class-path` option.

In this folder you can find a file called `validator.jar` this file contains the compiled classes that are on the same 
folder. Use the `jar` we packaged on previous exercise to start a JShell session:

`jshell --class-path /path/to/validator.jar` 

Start a new JShell session. Import the classes from that `jar` by typing:

```
import com.udacity.domain.*

import com.udacity.validator.strategies.*

``` 

Try using the custom classes from the `jar`:

```
new PhoneCheck().validateUser(new User("user@validemail.com", "123123123"))
```

Since `ValidationStrategy` has just one method it can be used as a `FunctionalInterface`, declare a new one passing 
a lambda, as follows:

```
ValidationStrategy customStrategy = u -> !u.getEmail().contains("invaliddomain.com") 
```

And then test it by passing a new user:

```
customStrategy.validateUser(new User("user@invaliddomain.com", null))
```

1. What's the output?

2. Try creating a different strategy and passing different users



