package org.sebsy.state;

public class RedState implements State {

    @Override
    public void handle(ContextState context) {
        // transition to Green
        context.setState(new GreenState());
    }

    @Override
    public String getName() {
        return "RED";
    }
}