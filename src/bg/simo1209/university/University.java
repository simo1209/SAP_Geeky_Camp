package bg.simo1209.university;

public class University {
    private static University ourInstance = new University();

    public static University getInstance() {
        return ourInstance;
    }

    private University() {
    }
}
