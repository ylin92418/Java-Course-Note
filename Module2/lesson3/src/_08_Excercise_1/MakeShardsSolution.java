//package _08_Excercise_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MakeShardsSolution {
    private static final int SHARD_SIZE = 100;


    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("Usage: MakeShards [input file] [output folder]");
            return;
        }
        Path outputFolder = null;
        Path input = Path.of(args[0]);
        try {
            outputFolder = Files.createDirectory(Path.of(args[1]));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }


        try (BufferedReader reader = Files.newBufferedReader(input, StandardCharsets.UTF_8)) {
            int shardNum = 0;
            String word = reader.readLine();
            while (word != null) {
                List<String> words = new ArrayList<>(SHARD_SIZE);
                while (words.size() < SHARD_SIZE) {
                    words.add(word);
                    word = reader.readLine();
                }
                words.sort(String::compareTo);
                Path output = Path.of(outputFolder.toString(), getOutputFileName(shardNum));
                try (BufferedWriter writer = Files.newBufferedWriter(output)) {
                    for (int i = 0; i < words.size(); i++) {
                        writer.write(words.get(i) + "\n");
                    }
                    writer.flush();
                    writer.close();
                }

                shardNum++;
            }
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
