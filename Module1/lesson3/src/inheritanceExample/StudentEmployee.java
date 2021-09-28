package inheritanceExample;

public class StudentEmployee extends Student {
    double rateOfPayPerHour;
    String employeeId;

    public StudentEmployee(String firstName, String lastName, String sId, String eId, double rateOfPayPerHour) {
        super(firstName, lastName, sId);
        this.employeeId = eId;
        this.rateOfPayPerHour = rateOfPayPerHour;
    }

    public String getEmployeeId() {
        return this.employeeId;
    }

    public double getRateOfPayPerHour() {
        return this.rateOfPayPerHour;
    }

    public void setRateOfPayPerHour(double r) {
        this.rateOfPayPerHour = r;
    }

    public void setEmployeeId(String id) {
        this.employeeId = id;
    }

    @Override
    public String toString() {
        return super.toString() + " employee ID: " + employeeId + " pay: " + String.valueOf(rateOfPayPerHour);
    }
}
