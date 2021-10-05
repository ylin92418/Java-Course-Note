package _03_CreationalPatterns;


import java.util.Objects;

/**
 * Set as final to prevent the class from being extended
 */
public final class Database {
    private static Database database;

    private Database() {
    }

    private static Database getInstance() {
        // lazy initialization, it may cause problem in multithreading programs
        if (database == null) {
            database = new Database();
            database.connect("/usr/local/data/users.db");
        }
        return database;
    }

    private void connect(String url) {
        Objects.requireNonNull(url);
    }

    public static void main(String[] args) {
        Database db1 = Database.getInstance();
        Database db2 = Database.getInstance();
        System.out.println(db1 == db2);
    }
}
