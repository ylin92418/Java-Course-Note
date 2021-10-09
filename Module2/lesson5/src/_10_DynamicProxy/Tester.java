package _10_DynamicProxy;

public class Tester implements ITester {
    public void test() {
        System.out.println("Test is running...");
    }

    public void testAString(String string) {
        System.out.println("Test a string is running... " + string);
    }
}
