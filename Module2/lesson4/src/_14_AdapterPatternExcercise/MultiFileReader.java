//package _14_AdapterPatternExcercise;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class MultiFileReader implements Closeable {

    private final List<BufferedReader> readers;

    public MultiFileReader(List<Path> paths) throws IOException {
        // TODO: Build the List of BufferedReaders
        readers = new ArrayList<>();
        try {
            for (Path path : paths) {
                readers.add(Files.newBufferedReader(path, StandardCharsets.UTF_8));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            close();
        }
    }

    public List<BufferedReader> getReaders() {
        return Collections.unmodifiableList(readers);
    }

    @Override
    public void close() {
        for (BufferedReader reader : readers) {
            try {
                reader.close();
            } catch (Exception ignored) {
            }
        }
    }
}
