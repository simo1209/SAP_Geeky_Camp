package bg.simo1209.filesystem.directory;

import bg.simo1209.filesystem.directory.file.File;

import java.util.Collection;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class Directory extends HashMap<String, DirectoryNode> implements DirectoryNode {

    protected String name;

    public Directory(String name) {
        this.name = name;
    }

    public Directory() {
        this.name = "(new folder)";
    }

    public String getAbsolutePath(String fileName) {
        if (this.get(fileName) instanceof File) {
            return String.format("%s/%s.txt", this.name, fileName);
        }
        return String.format("%s/%s", this.name, fileName);
    }

    public String getAbsolutePath() {
        return String.format("%s/", this.name);
    }

    public String getName() {
        return name;
    }

    public void renameDir(String name) {
        this.name = name;
    }

    /**
     * Returns the number of files and subfolders in this directory.
     *
     * @return the number of files and subfolders in this directory
     */

    public int count() {
        return this.size();
    }

    /**
     * Returns the value to which the specified key is mapped,
     * or {@code null} if this directory contains no mapping for the key.
     * <p>
     * <p>More formally, if this directory contains a mapping from a key
     * {@code k} to a value {@code v} such that {@code (key==null ? k==null :
     * key.equals(k))}, then this method returns {@code v}; otherwise
     * it returns {@code null}.  (There can be at most one such mapping.)
     * <p>
     * <p>A return value of {@code null} does not <i>necessarily</i>
     * indicate that the directory contains no mapping for the key; it's also
     * possible that the directory explicitly maps the key to {@code null}.
     * The {@link #containsKey containsKey} operation may be used to
     * distinguish these two cases.
     *
     * @param key
     * @see #put(Object, Object)
     */

    public DirectoryNode selectNode(Object key) throws NoSuchElementException {
        if (this.get(key) == null) {
            throw new NoSuchElementException("no such file");
        }
        return this.get(key);
    }

    /**
     * Returns <tt>true</tt> if this directory contains a file or subfolder for the
     * specified key.
     *
     * @param key The key whose presence in this directory is to be tested
     * @return <tt>true</tt> if this directory contains a mapping for the specified
     * key.
     */

    public boolean hasNode(Object key) {
        return this.containsKey(key);
    }

    /**
     * Associates the specified value with the specified key in this directory.
     * If the directory previously contained a mapping for the key, the old
     * value is replaced.
     *
     * @param key   key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with <tt>key</tt>, or
     * <tt>null</tt> if there was no mapping for <tt>key</tt>.
     * (A <tt>null</tt> return can also indicate that the directory
     * previously associated <tt>null</tt> with <tt>key</tt>.)
     */
    public DirectoryNode addNode(String key, DirectoryNode value) {
        return this.put(key, value);
    }

    /**
     * Removes the mapping for the specified key from this directory if present.
     *
     * @param key key whose mapping is to be removed from the directory
     * @return the previous value associated with <tt>key</tt>, or
     * <tt>null</tt> if there was no mapping for <tt>key</tt>.
     * (A <tt>null</tt> return can also indicate that the directory
     * previously associated <tt>null</tt> with <tt>key</tt>.)
     */
    public void delete(Object key) {
        if (this.get(key) instanceof File) {
            this.remove(key);
        } else if (((Directory) this.get(key)).isEmpty()) {
            this.remove(key);

        } else {
            for (DirectoryNode node :
                    ((Directory) this.get(key)).nodes()) {
                delete(((Directory) node).getName());
            }
        }
    }


    /**
     * Returns a {@link Collection} view of the values contained in this directory.
     * The collection is backed by the directory, so changes to the directory are
     * reflected in the collection, and vice-versa.  If the directory is
     * modified while an iteration over the collection is in progress
     * (except through the iterator's own <tt>remove</tt> operation),
     * the results of the iteration are undefined.  The collection
     * supports element removal, which removes the corresponding
     * mapping from the directory, via the <tt>Iterator.remove</tt>,
     * <tt>Collection.remove</tt>, <tt>removeAll</tt>,
     * <tt>retainAll</tt> and <tt>clear</tt> operations.  It does not
     * support the <tt>add</tt> or <tt>addAll</tt> operations.
     *
     * @return a view of the values contained in this directory
     */
    public Collection<DirectoryNode> nodes() {
        return this.values();
    }

    /**
     * Returns a string representation of this directory.  The string representation
     * consists of a list of key-value mappings in the order returned by the
     * directory's <tt>entrySet</tt> view's iterator, enclosed in braces
     * (<tt>"{}"</tt>).  Adjacent mappings are separated by the characters
     * <tt>", "</tt> (comma and space).  Each key-value mapping is rendered as
     * the key followed by an equals sign (<tt>"="</tt>) followed by the
     * associated value.  Keys and values are converted to strings as by
     * {@link String#valueOf(Object)}.
     *
     * @return a string representation of this directory
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(name);
        this.forEach((s, node) -> {
            result.append(String.format("\t~%s\n", s));
        });
        return result.toString();
    }
}
