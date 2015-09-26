package akydroid.galactic.bunny;

import akydroid.galactic.bunny.frameworkHelpers.MyAssetLoader;
import akydroid.galactic.bunny.screens.LogoSplashScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class GalacticBunnyMainGameClass extends Game {

	float screenHeight,screenWidth;
	
	@Override
	public void create () {
		screenHeight = Gdx.graphics .getHeight();
		screenWidth = Gdx.graphics.getWidth();
		MyAssetLoader.loadBasicsForStart();
		setScreen(new LogoSplashScreen(screenHeight,screenWidth));
	}

	public void dispose() {
		
	}
}
