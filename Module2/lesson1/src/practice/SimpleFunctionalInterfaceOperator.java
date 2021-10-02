package practice;

import java.util.HashMap;

public class SimpleFunctionalInterfaceOperator {

    HashMap<String, SimpleFunctionalInterface<String>> map = new HashMap<>();

    public void registerSomeOperators(String symbol, SimpleFunctionalInterface<String> operator) {
        map.put(symbol, operator);
    }

    public String operate(String input, String symbol) {
        SimpleFunctionalInterface sfi = map.get(symbol);
        return (String) sfi.simpleFunctionalMethod(input);
    }
}
