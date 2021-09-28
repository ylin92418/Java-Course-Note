package collectionsExample;

public class Person implements Comparable<Person> {
    String name;
    Integer age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public int compareTo(Person p) {
        return this.age.compareTo(p.age);
    }
}
