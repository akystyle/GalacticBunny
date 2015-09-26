package akydroid.galactic.bunny.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import akydroid.galactic.bunny.GalacticBunnyMainGameClass;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "AkyDroid's app";
		config.height = 320;
		config.width = 480;
		new LwjglApplication(new GalacticBunnyMainGameClass(), config);
	}
}
