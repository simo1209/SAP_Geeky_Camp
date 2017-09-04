package bg.simo1209.filesystem.directory.file;

import java.io.StringWriter;

public interface Writable extends Readable {
    void write(String s);
}
