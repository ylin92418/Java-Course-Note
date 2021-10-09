package _10_1_StaticProxy;

public class Client {
    public static void main(String[] args) {

        ITester tester = new Tester();
        ITester testerProxy = new TesterProxy(tester);

        testerProxy.test(); // call proxy tester's test function

    }
}
