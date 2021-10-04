package _20_Jackson.home;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;

public final class Main {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage: Main [file path]");
            return;
        }

        UdacisearchClient client =
                new UdacisearchClient(
                        "CatFacts LLC",
                        17,
                        8000,
                        5,
                        Instant.now(),
                        Duration.ofDays(180),
                        ZoneId.of("America/Los_Angeles"),
                        "555 Meowmers Ln, Riverside, CA 92501");

        Path outputPath = Path.of(args[0]);

        ObjectMapper objectMapper = new ObjectMapper();
        JavaTimeModule module = new JavaTimeModule();
        objectMapper.registerModule(module);
        objectMapper.writeValue(Files.newBufferedWriter(outputPath), client);
        UdacisearchClient retrieved = objectMapper.readValue(Files.newBufferedReader(outputPath, StandardCharsets.UTF_8), UdacisearchClient.class);

        // TODO: Write the "client" variable to the "outputPath", using a
        //       com.fasterxml.jackson.databind.ObjectMapper to serialize it into JSON. You will have to
        //       register the com.fasterxml.jackson.datatype.jsr310.JavaTimeModule with the ObjectMapper
        //       in order for it to work with the java.time fields in UdacisearchClient.
        //
        //       Next, read the JSON back and deserialize it using a ObjectInputStream.
        System.out.println(retrieved);
    }
}
