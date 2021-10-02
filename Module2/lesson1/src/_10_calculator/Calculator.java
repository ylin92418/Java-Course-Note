package _10_calculator;

import java.util.HashMap;
import java.util.function.BinaryOperator;

public final class Calculator {
    // TODO: Fill this class in.

    HashMap<String, BinaryOperator<Integer>> map;

    public Calculator() {
        map = new HashMap<>();
    }

    public void registerOperation(String symbol, BinaryOperator<Integer> operator) {
        map.put(symbol, operator);
    }

    public int calculate(int a, String symbol, int b) {
        BinaryOperator<Integer> operator = map.get(symbol);
        return operator.apply(a, b);
    }

}

