package bg.simo1209.filesystem;

import bg.simo1209.filesystem.directory.Directory;

public class Filesystem extends Directory {
    private static Filesystem ourInstance = new Filesystem();

    private Filesystem() {
        this.name = "/";
    }

    public static Filesystem getInstance() {
        return ourInstance;
    }
}
