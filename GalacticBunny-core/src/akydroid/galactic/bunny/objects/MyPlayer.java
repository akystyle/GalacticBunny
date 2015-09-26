package akydroid.galactic.bunny.objects;

import akydroid.galactic.bunny.frameworkHelpers.MyAssetLoader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class MyPlayer {

	final String assetPath = "texture/characters/player.png";
	final int minX,minY,maxX,maxY;
	
	Vector2 myPosition;
	Texture myPic;
	
	public MyPlayer(float gameHeight, float gameWidth){
		myPic = MyAssetLoader.loadAssets(assetPath);
		minX = 0;
		minY = 0;
		maxX = 0;
		maxY = 0;
	}
	
	public void update(float delta){
		if(Gdx.input.getAccelerometerX() > 5)
			myPosition.x += 5 * delta;
		else if(Gdx.input.getAccelerometerX() < -5)
			myPosition.x += -5 * delta;
		else
			myPosition.x += Gdx.input.getAccelerometerX() * delta;
	}
	
	public Texture getMyPic(){
		return myPic;
	}
}
