package exceptionExample;

public class Phone {
    String phoneType;
    String phoneNumber;

    public Phone(String t, String n) {
        if (t == null || n == null) {
            throw new IllegalArgumentException("The type and number cannot be null");
        }
        this.phoneType = t;
        this.phoneNumber = n;
    }

    public String getPhoneType() {
        return this.phoneType;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneType(String str) {
        this.phoneType = str;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    @Override
    public String toString() {
        return "Type: " + phoneType + " Number: " + phoneNumber;
    }
}
