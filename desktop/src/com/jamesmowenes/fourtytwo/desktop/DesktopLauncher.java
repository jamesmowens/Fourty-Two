package com.jamesmowenes.fourtytwo.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.jamesmowenes.fourtytwo.Constants;
import com.jamesmowenes.fourtytwo.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width= Constants.WIDTH;
		config.height=Constants.HEIGHT;
		new LwjglApplication(new Main(), config);
	}
}
