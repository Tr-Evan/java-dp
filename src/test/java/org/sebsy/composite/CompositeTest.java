package org.sebsy.composite;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CompositeTest {

    @Test
    public void testCompositeSize() {
        FileLeaf f1 = new FileLeaf("a.txt", 10);
        FileLeaf f2 = new FileLeaf("b.txt", 20);
        DirectoryComposite dir = new DirectoryComposite("root");
        dir.add(f1);
        dir.add(f2);

        DirectoryComposite sub = new DirectoryComposite("sub");
        sub.add(new FileLeaf("c.txt", 5));
        dir.add(sub);

        assertEquals(35, dir.getSize());
        assertEquals(5, sub.getSize());
    }
}