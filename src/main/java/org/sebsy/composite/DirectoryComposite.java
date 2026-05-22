package org.sebsy.composite;

import java.util.ArrayList;
import java.util.List;

public class DirectoryComposite implements Component {
    private final String name;
    private final List<Component> children = new ArrayList<>();

    public DirectoryComposite(String name) {
        this.name = name;
    }

    public void add(Component c) {
        children.add(c);
    }

    public void remove(Component c) {
        children.remove(c);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return children.stream().mapToInt(Component::getSize).sum();
    }

    public List<Component> getChildren() {
        return new ArrayList<>(children);
    }
}