//package _04_inputAndOupputStreams;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class InputAndOutputs {
    public static void main(String[] args) throws IOException {
        /**
         * 1. use Files.copy()
         */

        //Files.copy(Path.of(args[0]), Path.of(args[1]));

        /**
         *  2. use stream copy
         */

        InputStream in = Files.newInputStream(Path.of(args[0]));
        OutputStream out = Files.newOutputStream(Path.of(args[1]));

        byte[] data = new byte[10];
        while (in.read(data) != -1) {
            for (byte b : data) {
                // java uses ASCII text
                System.out.println(Integer.toHexString(b));
            }
            out.write(data);
        }

        in.close();
        out.close();

        /**
         *  3. use transferTo()
         */

        //InputStream in = Files.newInputStream(Path.of(args[0]));
        //OutputStream out = Files.newOutputStream(Path.of(args[1]));
        //in.transferTo(out);
        //in.close();
        //out.close();
    }
}
