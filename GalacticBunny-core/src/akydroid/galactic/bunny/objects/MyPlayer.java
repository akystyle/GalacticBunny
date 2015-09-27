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
	float expectedHeight,expectedWidth,boundaryBlockWidth,gameWidth;
	Vector2 myPosition;
	Texture myPicTex;
	TextureRegion myPic;
	
	public MyPlayer(float gameHeight, float gameWidth,float initialY, float scaler, float BoundaryBlockWidth){
		myPicTex = MyAssetLoader.loadAssets(assetPath);
		myPic = new TextureRegion(myPicTex);
		myPic.flip(false, true);
		expectedHeight = gameHeight / scaler;
		expectedWidth = gameWidth / scaler;
		this.gameWidth = gameWidth;
		minX = 0;
		minY = 0;
		maxX = 0;
		maxY = 0;
		myPosition = new Vector2(gameWidth/2, initialY- expectedHeight);
		boundaryBlockWidth = BoundaryBlockWidth;
	}
	
	public void update(float delta){
		
		int acceleration = 0;
		
		if(Gdx.app.getType() == ApplicationType.Android || Gdx.app.getType() == ApplicationType.iOS){
			if(Gdx.input.getAccelerometerY() > 9)
				acceleration = 9;
			else if(Gdx.input.getAccelerometerY() < -9)
				acceleration = -9;
			else
				acceleration = (int) Gdx.input.getAccelerometerY();
		}
		else {
			if(Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT))
				acceleration = -9;
			else if(Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT))
				acceleration = 9;
		}
		
		if( (myPosition.x + (velocity * acceleration * delta)) < boundaryBlockWidth){
		}
		else if((myPosition.x + (velocity * acceleration * delta)) >  (gameWidth - (3*boundaryBlockWidth))){
		}
		else
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

	public float getExpectedHeight() {
		return expectedHeight;
	}

	public void setExpectedHeight(float expectedHeight) {
		this.expectedHeight = expectedHeight;
	}

	public float getExpectedWidth() {
		return expectedWidth;
	}

	public void setExpectedWidth(float expectedWidth) {
		this.expectedWidth = expectedWidth;
	}

	public float getBoundaryBlockWidth() {
		return boundaryBlockWidth;
	}

	public void setBoundaryBlockWidth(float boundaryBlockWidth) {
		this.boundaryBlockWidth = boundaryBlockWidth;
	}
}
