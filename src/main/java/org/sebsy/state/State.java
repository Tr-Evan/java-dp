package org.sebsy.state;

public interface State {
    void handle(ContextState context);
    String getName();
}