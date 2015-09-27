package akydroid.galactic.bunny.objects;

import akydroid.galactic.bunny.frameworkHelpers.MyAssetLoader;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyBG {

	final String assetPath = "data/textures/backgrounds/Background-4.png";
	Texture myPicTex;
	TextureRegion myPic;
	
	public MyBG(float gameHeight,float gameWidth){
		
		//myPicTex = new Texture((int) gameWidth, (int) gameHeight,Format.RGB565);
		myPicTex = MyAssetLoader.loadAssets(assetPath);
		
		myPic = new TextureRegion(myPicTex);
		
		myPic.flip(false, true);
	}
	
	public TextureRegion getMyPic(){
		return myPic;
	}
}
