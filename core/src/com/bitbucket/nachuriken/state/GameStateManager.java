package com.bitbucket.nachuriken.state;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Stack;

/**
 * Ain't Nobody Got Time for That
 */
public class GameStateManager {

    private Stack<AbstractState> AbstractStates;

    public GameStateManager() {
        this.AbstractStates = new Stack<AbstractState>();
    }

    public void push(AbstractState AbstractState) {
        AbstractStates.push(AbstractState);
    }

    public void pop() {
        AbstractStates.pop();
    }

    public void set(AbstractState AbstractState) {
        AbstractStates.pop();
        AbstractStates.push(AbstractState);
    }

    public void update(float dt) {
        AbstractStates.peek().update(dt);
    }

    public void render(SpriteBatch sb) {
        AbstractStates.peek().render(sb);
    }
}
