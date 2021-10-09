package _10_DynamicProxy;

public class Client {
    public static void main(String[] args) {
        ITester tester = new Tester();
        ProxyFactory proxyFactory = new ProxyFactory(tester);

        ITester instance = (ITester) proxyFactory.getNewInstance();
        System.out.println(instance);
        instance.test();
        instance.testAString("Hello");
    }
}
