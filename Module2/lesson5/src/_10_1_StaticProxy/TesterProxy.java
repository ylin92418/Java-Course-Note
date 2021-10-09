package _10_1_StaticProxy;


public class TesterProxy implements ITester {

    private final ITester tester;

    public TesterProxy(ITester tester) {
        this.tester = tester;
    }

    public void test() {

        System.out.println("Before the test, do something...");

        tester.test();

        System.out.println("After the test, clean it up...");

    }

}
