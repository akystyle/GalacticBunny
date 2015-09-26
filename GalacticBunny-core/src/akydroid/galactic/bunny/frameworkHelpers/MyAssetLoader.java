package akydroid.galactic.bunny.frameworkHelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class MyAssetLoader {

	public static Texture akydroidLogo;
	
	//public static Sprite akydroidLogoSprite;
	
	public static void loadBasicsForStart(){
		//This method will load the required assets in the beginning
		akydroidLogo = new Texture(Gdx.files.internal("badlogic.jpg"));
	}
	
	public static Texture loadAssets(String assetPath){
		return new Texture(Gdx.files.internal(assetPath));
	}

	public static void dispose() {
		// TODO Auto-generated method stub
		akydroidLogo.dispose();
	}
	
}
