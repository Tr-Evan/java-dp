package org.sebsy.state;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContextStateTest {

    @Test
    public void testStateTransitions() {
        ContextState ctx = new ContextState(new RedState());
        assertEquals("RED", ctx.getState().getName());

        ctx.request(); // Red -> Green
        assertEquals("GREEN", ctx.getState().getName());

        ctx.request(); // Green -> Yellow
        assertEquals("YELLOW", ctx.getState().getName());

        ctx.request(); // Yellow -> Red
        assertEquals("RED", ctx.getState().getName());
    }
}