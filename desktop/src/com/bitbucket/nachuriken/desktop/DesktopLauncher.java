package com.bitbucket.nachuriken.desktop;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.bitbucket.nachuriken.OurGame;

public class DesktopLauncher {

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = configureApplication();
        new LwjglApplication(new OurGame(), config);

        Gdx.app.setLogLevel(Application.LOG_DEBUG);
    }

    private static LwjglApplicationConfiguration configureApplication() {
        LwjglApplicationConfiguration configuration = new LwjglApplicationConfiguration();

        configuration.title = OurGame.TITLE;
        configuration.width = OurGame.WIDTH;
        configuration.height = OurGame.HEIGHT;

        return configuration;
    }
}
