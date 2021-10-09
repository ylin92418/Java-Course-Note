package _10_1_StaticProxy;

public class Tester implements ITester {
    public void test() {
        System.out.println("Tester starts testing ...");
        Logic.showSomeLogic(); // some target function you want to test
    }
}
