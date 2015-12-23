package com.bitbucket.nachuriken;

/**
 * Ain't Nobody Got Time for That
 */
public class Util {

    public static float flipX(boolean isFlipped, float x, float width) {
        return isFlipped ? x + width : x;
    }

    public static float flipY(boolean isFlipped, float width) {
        return isFlipped ? -width : width;
    }
}
