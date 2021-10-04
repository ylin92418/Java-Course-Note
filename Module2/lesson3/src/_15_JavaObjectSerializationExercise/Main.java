package _15_JavaObjectSerializationExercise;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

        try (var out = new ObjectOutputStream(Files.newOutputStream(outputPath))) {
            out.writeObject(client);
        }

        try (var in = new ObjectInputStream(Files.newInputStream(outputPath))) {
            UdacisearchClient retrieved = (UdacisearchClient) in.readObject();
            System.out.println(retrieved);
        }

        // TODO: Write the "client" variable to the "outputPath", using a ObjectOutputStream. Then,
        //       read it back and deserialize it using a ObjectInputStream.
        UdacisearchClient deserialized = client;
        System.out.println(deserialized);
    }
}
