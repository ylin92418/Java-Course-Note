//package _08_Excercise_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class MakeShards {
    private static final int SHARD_SIZE = 100;

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("Usage: MakeShards [input file] [output folder]");
            return;
        }

        Path input = Path.of(args[0]);
        try {
            Path outputFolder = Files.createDirectory(Path.of(args[1]));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }


        BufferedReader reader = Files.newBufferedReader(input, StandardCharsets.UTF_8);

        String line;
        int shardNum = 0;
        int count = 0;

        while ((line = reader.readLine()) != null) {
            String outputFileName = getOutputFileName(shardNum);
            BufferedWriter writer = Files.newBufferedWriter(Path.of(outputFileName), StandardCharsets.UTF_8);
            List<String> strings = new ArrayList<>();
            strings.add(line);
            for (int i = 0; i < SHARD_SIZE - 1; i++) {
                strings.add(reader.readLine());
            }
            System.out.println(strings);
            Collections.sort(strings);
            for (int i = 0; i < SHARD_SIZE; i++) {
                writer.write(strings.get(i) + "\n");
            }
            writer.flush();
            writer.close();
            shardNum++;
        }


        // TODO: Read the unsorted words from the "input" Path, line by line. Write the input words to
        //       many shard files. Each shard file should contain at most SHARD_SIZE words, in sorted
        //       order. All the words should be accounted for in the output shard files; you should not
        //       skip any words. Write the shard files in the newly created "outputFolder", using the
        //       getOutputFileName(int) method to name the individual shard files.
    }

    private static String getOutputFileName(int shardNum) {
        return String.format("shard%02d.txt", shardNum);
    }
}
