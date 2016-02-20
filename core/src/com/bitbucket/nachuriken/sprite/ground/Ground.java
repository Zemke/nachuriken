package com.bitbucket.nachuriken.sprite.ground;

import java.util.ArrayDeque;

/**
 * Ain't Nobody Got Time for That
 */
public class Ground {

    public static final int WIDTH = 336;
    public static final int HEIGHT = 112;
    public static final int NUMBER_OF_GROUNDS = 6;

    private ArrayDeque<GroundPart> groundParts;

    public Ground() {
        groundParts = new ArrayDeque<GroundPart>(NUMBER_OF_GROUNDS);

        int groundAlternator = 1;

        for (int i = 0; i < NUMBER_OF_GROUNDS; i++) {
            if (groundAlternator > 3) {
                groundAlternator = 1;
            }

            groundParts.add(new GroundPart(WIDTH * i, groundAlternator));

            groundAlternator++;
        }
    }

    public ArrayDeque<GroundPart> getGroundParts() {
        return groundParts;
    }
}
