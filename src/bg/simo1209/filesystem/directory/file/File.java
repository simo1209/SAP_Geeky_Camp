package bg.simo1209.filesystem.directory.file;

import bg.simo1209.filesystem.directory.DirectoryNode;

public class File implements DirectoryNode, Readable, Writable {

    private StringBuilder content;
    private boolean isOpen = false;


    public File() {
        this.content = new StringBuilder();
        isOpen = false;
    }

    public File(String content) {
        this.content = new StringBuilder(content);
        isOpen = false;
    }

    public String getContent() {
        return content.toString();
    }

    public void setContent(String content) {
        this.content.append(content);
    }

    @Override
    public String read() {
        if (isOpen)
            return content.toString();
        else throw new IllegalStateException("open file first");
    }

    @Override
    public void write(String s) {
        if (isOpen)
            content.append(s);
        else throw new IllegalStateException("open file first");
    }

    public void open() throws IllegalAccessException {
        if (!isOpen)
            isOpen = true;
        else throw new IllegalAccessException("file is already open");
    }

    public void close() throws IllegalAccessException {
        if (isOpen)
            isOpen = false;
        else throw new IllegalAccessException("file is already closed");
    }

}
