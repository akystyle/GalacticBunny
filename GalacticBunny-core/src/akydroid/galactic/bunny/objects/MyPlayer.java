package akydroid.galactic.bunny.objects;

import akydroid.galactic.bunny.frameworkHelpers.MyAssetLoader;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class MyPlayer {

	final String assetPath = "data/textures/characters/player.png";
	final int velocity = 13; 
	float expectedHeight,expectedWidth,boundaryBlockWidth,gameWidth,boundaryBlockHeight,gameHeight;
	Vector2 myPosition;
	Texture myPicTex;
	TextureRegion myPic;
	boolean shooting;
	ShootBullet myBullet;
	
	public MyPlayer(float gameHeight, float gameWidth,float initialY, float scaler, float BoundaryBlockWidth, float BoundaryBlockHeight){
		myPicTex = MyAssetLoader.loadAssets(assetPath);
		myPicTex.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		myPic = new TextureRegion(myPicTex);
		myPic.flip(false, true);
		expectedHeight = gameHeight / scaler;
		expectedWidth = gameWidth / (scaler * 2);
		this.gameWidth = gameWidth;
		this.gameHeight = gameHeight;
		shooting = false;
		myBullet = new ShootBullet();
		myPosition = new Vector2(gameWidth/2, initialY- expectedHeight);
		boundaryBlockWidth = BoundaryBlockWidth;
		boundaryBlockHeight = BoundaryBlockHeight;
	}
	
	public void update(float delta){
		
		int acceleration = 0;
		
		if(Gdx.app.getType() == ApplicationType.Android || Gdx.app.getType() == ApplicationType.iOS){
			if(Gdx.input.getAccelerometerY() > 0.75 && Gdx.input.getAccelerometerY() < 4)
				acceleration = 4 * 2;
			else if(Gdx.input.getAccelerometerY() < -0.75 && Gdx.input.getAccelerometerY() > -4)
				acceleration = -4 * 2;
			else if(Gdx.input.getAccelerometerY() > -0.75 && Gdx.input.getAccelerometerY() < 0.75)
				acceleration = 0;
			else
				acceleration = (int) Gdx.input.getAccelerometerY() * 2;
		}
		else {
			if(Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT))
				acceleration = -9;
			else if(Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT))
				acceleration = 9;
		}
		
		if( (myPosition.x + (velocity * acceleration * delta)) < boundaryBlockWidth){
		}
		else if((myPosition.x + (velocity * acceleration * delta)) >  (gameWidth - (boundaryBlockWidth + expectedWidth))){
		}
		else
		myPosition.x += velocity * acceleration * delta;
		
		if(shooting == true){
			shoot();
			shooting = false;
		}
		if(myBullet != null)
			myBullet.update(delta);
	}

	public void shoot(){
		
		Vector2 shootPosition = new Vector2(myPosition.x + (expectedWidth/2), myPosition.y + expectedHeight);
		Vector2 shootMatrix = new Vector2(0,1);
		myBullet = new ShootBullet(shootPosition,shootMatrix,boundaryBlockHeight);
	}
	
	public ShootBullet getBullet(){
		return myBullet;
	}

	public void setBullet(ShootBullet bullet){
		myBullet = bullet;
	}
	
	public boolean isShooting(){
		return shooting;
	}
	
	public void setShooting(boolean shooting){
		this.shooting = shooting;
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
