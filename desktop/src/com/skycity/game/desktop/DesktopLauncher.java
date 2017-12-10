package com.skycity.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.skycity.game.SkyCity;
import com.skycity.game.ui.chat.OrthographicCameraExample;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width=600;
		config.height=600;
		new LwjglApplication(new SkyCity(), config);
//        new LwjglApplication(new OrthographicCameraExample(),config);
	}

}
