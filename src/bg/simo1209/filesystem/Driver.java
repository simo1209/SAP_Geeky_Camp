package bg.simo1209.filesystem;


import bg.simo1209.filesystem.directory.Directory;
import bg.simo1209.filesystem.directory.DirectoryNode;
import bg.simo1209.filesystem.directory.file.File;
import bg.simo1209.filesystem.directory.file.Readable;
import bg.simo1209.filesystem.directory.file.Writable;

import java.util.NoSuchElementException;


public class Driver {
    public static void main(String[] args) {// throws NoSuchFieldException, IllegalAccessException {
        Filesystem f = Filesystem.getInstance();
        f.addNode("config", new File("user=simo09"));
        Directory home = new Directory("home");
        Directory pictures = new Directory("pictures");


        pictures.addNode("photo", (DirectoryNode) new File());

        Writable photoWritable = (File) pictures.selectNode("photo");
        try {
            photoWritable.open();
            photoWritable.write("hello world");
            photoWritable.close();
        } catch (IllegalAccessException e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        photoWritable = null;


        Readable photoReadable = (File) pictures.selectNode("photo");
        try {
            photoReadable.open();
            System.out.println(photoReadable.read());
            photoReadable.close();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        photoReadable = null;

        try {
            pictures.delete("photo");
            File file = (File) pictures.selectNode("photo");
        } catch (NoSuchElementException e) {

        }


        home.addNode(pictures.getName(), pictures);
        f.addNode(home.getName(), home);

        f.delete("home");
//        System.out.println(f.toString());
    }
}
