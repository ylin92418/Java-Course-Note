package inheritanceExample;

public class Person {
    String firstName;
    String lastName;

    public Person(String f, String l) {
        firstName = f;
        lastName = l;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setFirstName(String f) {
        this.firstName = f;
    }

    public void setLastName(String l) {
        this.lastName = l;
    }

    @Override
    public String toString() {
        return "Name: " + this.firstName + " " + this.lastName;
    }
}
