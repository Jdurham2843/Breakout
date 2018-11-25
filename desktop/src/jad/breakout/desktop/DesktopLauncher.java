package jad.breakout.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import jad.breakout.BreakoutApplication;

public class DesktopLauncher {
	private static final int WIDTH = 800;

	private static final int HEIGHT = 480;

	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Breakout";
		config.width = WIDTH;
		config.height = HEIGHT;

		new LwjglApplication(new BreakoutApplication(), config);
	}
}
