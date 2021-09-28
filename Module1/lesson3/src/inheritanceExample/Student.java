package inheritanceExample;

public class Student extends Person {
    String studentId;

    public Student(String firstName, String lastName, String id) {
        super(firstName, lastName);
        this.studentId = id;
    }

    public String getStudentId() {
        return this.studentId;
    }

    public void setStudentId(String id) {
        this.studentId = id;
    }

    @Override
    public String toString() {
        return super.toString() + " id: " + studentId;
    }

}
