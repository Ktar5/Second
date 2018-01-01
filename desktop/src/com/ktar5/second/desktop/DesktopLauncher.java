package com.ktar5.second.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ktar5.second.SecondGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Second Game";
		config.width = 1600;
		config.height = 800;
		config.vSyncEnabled = true;
		config.foregroundFPS = 0;
		config.backgroundFPS = 0;
		new LwjglApplication(new SecondGame(), config);
	}
}
