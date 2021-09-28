package collectionsExample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingExample {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Tim", 5));
        people.add(new Person("Angela", 2));
        people.add(new Person("Bobby", 58));
        people.add(new Person("Timmy", 20));
        people.add(new Person("Ewan", 18));

        Collections.sort(people);

        for (Person person : people) {
            System.out.println(person.name + " ," + person.age);
        }
    }
}
