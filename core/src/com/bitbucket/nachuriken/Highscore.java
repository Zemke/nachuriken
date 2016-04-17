package com.bitbucket.nachuriken;

import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * Ain't Nobody Got Time for That
 */
public class Highscore {

    private final BitmapFont text;
    private final float startingPosition;
    private float highscore;
    private Float overallHigh;

    public Highscore(float startingPosition) {
        this.startingPosition = startingPosition;
        highscore = calc(this.startingPosition);
        text = new BitmapFont();
        text.setColor(1.0f, 1.0f, 1.0f, 1.0f);
    }

    public void update(float newPosition) {
        if (newPosition > highscore) {
            highscore = newPosition;
        }
    }

    private float calc(float startingPosition) {
        // TODO This should calculate a more user-friendly number as the highscore i.e. one not starting on 504 and not counting up so quickly.
        return startingPosition;
    }

    public float getHighscore() {
        return highscore;
    }

    public BitmapFont getText() {
        return text;
    }

    public void startOver() {
        if (overallHigh == null || overallHigh.compareTo(highscore) < 0) {
            overallHigh = highscore;
        }
        highscore = calc(startingPosition);
    }

    public Float getOverallHigh() {
        return overallHigh;
    }
}
