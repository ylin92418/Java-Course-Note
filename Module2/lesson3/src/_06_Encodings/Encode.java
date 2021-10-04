package _06_Encodings;

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Encode {
    public static void main(String[] args) throws IOException {
        try (Writer writer = Files.newBufferedWriter(Path.of("test_utf8.txt"),
                StandardCharsets.UTF_8)) {
            writer.write("hello, world");
        }

        try (Writer writer = Files.newBufferedWriter(Path.of("test_utf16.txt"),
                StandardCharsets.UTF_16)) {
            writer.write("hello, world");
        }
    }
}
