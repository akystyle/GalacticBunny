package akydroid.galactic.bunny.objects;

import akydroid.galactic.bunny.frameworkHelpers.MyAssetLoader;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class MyPlayer {

	final String assetPath = "data/textures/characters/player.png";
	final int minX,minY,maxX,maxY;
	final int velocity = 10; 
	Vector2 myPosition;
	Texture myPicTex;
	TextureRegion myPic;
	
	public MyPlayer(float gameHeight, float gameWidth){
		myPicTex = MyAssetLoader.loadAssets(assetPath);
		myPic = new TextureRegion(myPicTex);
		myPic.flip(false, true);
		minX = 0;
		minY = 0;
		maxX = 0;
		maxY = 0;
		myPosition = new Vector2(gameWidth/2, gameHeight/2);
	}
	
	public void update(float delta){
		
		int acceleration = 0;
		
		if(Gdx.app.getType() == ApplicationType.Android || Gdx.app.getType() == ApplicationType.iOS){
			if(Gdx.input.getAccelerometerX() > 5)
				acceleration = 5;
			else if(Gdx.input.getAccelerometerX() < -5)
				acceleration = 5;
			else
				acceleration = (int) Gdx.input.getAccelerometerX();
		}
		else {
			if(Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT))
				acceleration = -3;
			else if(Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT))
				acceleration = 3;
		}
		myPosition.x += velocity * acceleration * delta;
	}
	
	public TextureRegion getMyPic(){
		return myPic;
	}
	
	public float getPositionX(){
		return myPosition.x;
	}
	
	public float getPositionY(){
		return myPosition.y;
	}
}
