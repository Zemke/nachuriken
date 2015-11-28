package com.bitbucket.nachuriken.sprite.ground;

import com.badlogic.gdx.utils.Array;
import com.bitbucket.nachuriken.Nachuriken;

/**
 * Ain't Nobody Got Time for That
 */
public class Ground {

    public static final int WIDTH = 336;
    public static final int HEIGHT = 112;
    private Array<GroundPart> groundParts;

    public Ground() {
        groundParts = new Array<GroundPart>();

        while (WIDTH * groundParts.size < Nachuriken.WIDTH) {
            groundParts.add(new GroundPart(WIDTH * groundParts.size));
        }
    }

    public Array<GroundPart> getGroundParts() {
        return groundParts;
    }
}
