package org.sebsy.state;

public class GreenState implements State {

    @Override
    public void handle(ContextState context) {
        // transition to Yellow
        context.setState(new YellowState());
    }

    @Override
    public String getName() {
        return "GREEN";
    }
}