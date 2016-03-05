package com.bitbucket.nachuriken;

import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * Ain't Nobody Got Time for That
 */
public class Highscore {

    private final BitmapFont text;
    private float highscore;
    private float overallHigh;

    public Highscore(float startingPosition) {
        highscore = calc(startingPosition);
        text = new BitmapFont();
        text.setColor(1.0f, 1.0f, 1.0f, 1.0f);
    }

    public void update(float newPosition) {
        if (calc(newPosition) > highscore) {
            highscore = calc(newPosition);
        }
    }

    private float calc(float startingPosition) {
        return (startingPosition - 502) / 11;
    }

    public float getHighscore() {
        return highscore;
    }

    public BitmapFont getText() {
        return text;
    }

    public void startOver() {
        overallHigh = highscore;
    }
}
