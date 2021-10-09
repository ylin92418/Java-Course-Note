package _10_ParallelStreams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class ParallelStreams {
    public static class Student {
        private String name;
        private int graduationYear;

        public Student(String name, int graduationYear) {
            this.name = name;
            this.graduationYear = graduationYear;
        }

        public int getGraduationYear() {
            return graduationYear;
        }

        public String getName() {
            return name;
        }
    }


    public static void main(String[] args) {
        // create a map for demo
        List<Student> students = new ArrayList<>();
        students.add(new Student("Tom", 20));
        students.add(new Student("Helly", 21));
        students.add(new Student("Ken", 22));
        students.add(new Student("Mosbii", 22));
        students.add(new Student("Ewan", 22));
        students.add(new Student("Terrisa", 25));
        students.add(new Student("Terry", 25));
        students.add(new Student("Tim", 27));
        students.add(new Student("Den", 27));


        // Non-concurrent method
        Map<Integer, Long> graduatingClassSizes = students
                .stream()
                .collect(Collectors.groupingBy(
                        Student::getGraduationYear, Collectors.counting()
                ));

        // Parallel method
        Map<Integer, Long> streamedGraduatingClassSizes = students
                .parallelStream()
                .collect(Collectors.groupingBy(
                        Student::getGraduationYear, Collectors.counting()
                ));

        // ForkJoinPool
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Future<Map<Integer, Long>> futureGraduatingSizes = forkJoinPool.submit(() ->
                students.parallelStream()
                        .collect(Collectors.groupingBy(
                                Student::getGraduationYear, Collectors.counting()
                        ))
        );
    }

}
