package genericsAndCollections;

import java.util.ArrayList;
import java.util.List;

public class GenericsExercise {

    public static <T> void displayClasName(T variable) {
        System.out.println(variable.getClass().getName());
    }

    public static void main(String[] args) {
        List<Object> variables = new ArrayList<Object>();

        Double doubleNumber = 1.5;
        String name = "Sally";
        Integer intNumber = 1;
        Character letter = 'a';

        variables.add(doubleNumber);
        variables.add(name);
        variables.add(intNumber);
        variables.add(letter);

        for (Object v : variables) {
            displayClasName(v);
        }
    }
}
