package _06_functional_Interface;

public class Driver {
    public static void main(String[] args) {
        BinaryOperation add = (a, b) -> a + b;

        // Or you could use:
        //
        //  BinaryOperation add = Integer::sum;
        //
        // More on method references later!

        // Or use Java's built-in functional interface
        //
        // import java.util.function.BinaryOperator
        // BinaryOperator<Integer> add = (a, b) -> a + b;
        //
        // it does the same thing!

        assert 5 == add.apply(2, 3);
    }
}
