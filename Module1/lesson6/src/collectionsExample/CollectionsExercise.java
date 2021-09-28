package collectionsExample;

import java.util.LinkedList;
import java.util.List;

public class CollectionsExercise {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("Mike");
        list.add("Bob");
        list.add("Alice");

        for (String str : list) {
            System.out.println(str);
        }
    }
}
