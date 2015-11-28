package com.bitbucket.nachuriken.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.bitbucket.nachuriken.Nachuriken;

/**
 * Ain't Nobody Got Time for That
 */
public class DesktopLauncher {

    public static final String TITLE = "Nachuriken";

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = configure();
        new LwjglApplication(new Nachuriken(), config);
    }

    private static LwjglApplicationConfiguration configure() {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

        config.title = TITLE;
        config.width = Nachuriken.WIDTH;
        config.height = Nachuriken.HEIGHT;

        return config;
    }
}
