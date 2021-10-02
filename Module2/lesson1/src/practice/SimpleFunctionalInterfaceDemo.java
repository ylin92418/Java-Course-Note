package practice;

public class SimpleFunctionalInterfaceDemo {
    public static void main(String[] args) {
        SimpleFunctionalInterfaceOperator sfio = new SimpleFunctionalInterfaceOperator();

        sfio.registerSomeOperators("+", (str) -> (str + "+"));
        sfio.registerSomeOperators("-", (str) -> (str + "-"));
        sfio.registerSomeOperators("h", (str) -> (str + "h"));

        System.out.println(sfio.operate("How are you?", "-"));
    }
}
