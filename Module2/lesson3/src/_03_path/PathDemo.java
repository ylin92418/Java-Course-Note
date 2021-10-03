package _03_path;

import java.nio.file.Path;

public class PathDemo {
    public static void main(String[] args) {
        Path p = Path.of("."); // current directory
        System.out.println(p);
        System.out.println("Path: " + p.toAbsolutePath());
        System.out.println("Normalize: " + p.toAbsolutePath().normalize());
        System.out.println("Resolve: " + p.toAbsolutePath().resolve(".."));
        System.out.println("Resolve + Normalize: " + p.toAbsolutePath().resolve("..").normalize());
        System.out.println("Get uri: " + p.toAbsolutePath().resolve("..").normalize().toUri());
    }
}
