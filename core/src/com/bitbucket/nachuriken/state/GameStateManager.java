package com.bitbucket.nachuriken.state;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Stack;

/**
 * Ain't Nobody Got Time for That
 */
public class GameStateManager {

    private Stack<AbstractState> states;

    public GameStateManager() {
        this.states = new Stack<AbstractState>();
    }

    public void push(AbstractState AbstractState) {
        states.push(AbstractState);
    }

    public void pop() {
        states.pop();
    }

    public void set(AbstractState AbstractState) {
        states.pop();
        states.push(AbstractState);
    }

    public void update(float dt) {
        states.peek().update(dt);
    }

    public void render(SpriteBatch sb) {
        states.peek().render(sb);
    }
}
