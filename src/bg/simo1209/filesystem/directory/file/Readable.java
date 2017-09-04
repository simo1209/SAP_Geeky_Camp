package bg.simo1209.filesystem.directory.file;

public interface Readable {
    String read();

    void open() throws IllegalAccessException;

    void close() throws IllegalAccessException;
}
