package org.sebsy.composite;

public class FileLeaf implements Component {
    private final String name;
    private final int size;

    public FileLeaf(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }
}