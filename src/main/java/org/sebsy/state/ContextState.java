package org.sebsy.state;

public class ContextState {
    private State state;

    public ContextState(State initial) {
        this.state = initial;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void request() {
        state.handle(this);
    }
}