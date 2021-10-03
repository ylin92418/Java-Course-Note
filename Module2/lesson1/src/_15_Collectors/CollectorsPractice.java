package _15_Collectors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectorsPractice {
    public static void main(String[] args) {
        /**
         * Collectors.toSet()
         */
        List<String> stringList = new ArrayList<>();
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        Set<String> s = stringList.stream().collect(Collectors.toSet());

        /**
         * Collectors.groupBy
         */

        HashMap<String, Long> map = stringList.stream().collect(
                Collectors.groupingBy(String::valueOf, Collectors.counting()));
    }

}
