package org.sebsy.state;

public class YellowState implements State {

    @Override
    public void handle(ContextState context) {
        // transition to Red
        context.setState(new RedState());
    }

    @Override
    public String getName() {
        return "YELLOW";
    }
}