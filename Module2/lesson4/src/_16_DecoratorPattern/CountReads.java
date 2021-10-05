import java.io.*;
import java.util.Objects;

public final class CountReads {

    public static final class CountingReader extends Reader {
        private int count = 0;

        private final Reader delegate;

        CountingReader(Reader delegate) {
            this.delegate = Objects.requireNonNull(delegate);
        }

        public int getCount() {
            return count;
        }

        @Override
        public int read(char[] cbuf, int off, int len) throws IOException {
            System.out.println(delegate.getClass().getName() + " is called");
            count++;
            return delegate.read(cbuf, off, len);
        }

        @Override
        public void close() throws IOException {
            delegate.close();

        }
    }

    public static void main(String[] args) throws Exception {
        try (FileReader reader = new FileReader(new File("randomtext.txt"))) {
            CountingReader unbufferedReads = new CountingReader(reader);
            CountingReader bufferedReads = new CountingReader(new BufferedReader(unbufferedReads));

            char[] data = new char[100];
            while (bufferedReads.read(data) != -1) ;

            System.out.println("Calls to BufferedReader.read(): " + bufferedReads.getCount());
            System.out.println("Calls to FileReader.read(): " + unbufferedReads.getCount());
        }
    }
}
