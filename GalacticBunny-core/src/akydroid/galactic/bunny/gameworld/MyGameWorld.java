package akydroid.galactic.bunny.gameworld;

import akydroid.galactic.bunny.objects.BoundaryFrame;
import akydroid.galactic.bunny.objects.MyBG;
import akydroid.galactic.bunny.objects.MyPlayer;

public class MyGameWorld {

	float screenHeight,screenWidth,gameHeight,gameWidth;
	float scaleX,scaleY;
	MyGameRenderer myGameRenderer;
	MyPlayer myPlayer;
	BoundaryFrame myFrame;
	MyBG myBG;
	
	final int BOUNDARYSCALER = 10;
	final int PLAYERSCALER = 5;
	
	public MyGameWorld(float screenHeight,float screenWidth,float gameHeight,float gameWidth,float scaleX, float scaleY){
		this.screenHeight = screenHeight;
		this.screenWidth = screenWidth;
		this.gameHeight = gameHeight;
		this.gameWidth = gameWidth;
		this.scaleX = scaleX;
		this.scaleY = scaleY;
		
		myBG = new MyBG(gameHeight,gameWidth);
		myFrame = new BoundaryFrame(gameHeight,gameWidth,gameHeight/BOUNDARYSCALER,gameWidth/BOUNDARYSCALER);
		myPlayer = new MyPlayer(gameHeight,gameWidth,(gameHeight * (BOUNDARYSCALER-1))/ BOUNDARYSCALER,PLAYERSCALER,gameWidth/BOUNDARYSCALER);
	}
	
	public void update(float delta) {
		myPlayer.update(delta);
	}
	
	public MyPlayer getPlayer(){
		return myPlayer;
	}
	
	public MyBG getMyBG(){
		return myBG;
	}
	
	public BoundaryFrame getBoundaryFrame(){
		return myFrame;
	}
	
	public MyGameRenderer getRenderer(){
		return myGameRenderer;
	}
	
	public void setRenderer(MyGameRenderer tempRenderer){
		myGameRenderer = tempRenderer;
	}

	public float getScreenHeight() {
		return screenHeight;
	}

	public void setScreenHeight(float screenHeight) {
		this.screenHeight = screenHeight;
	}

	public float getScreenWidth() {
		return screenWidth;
	}

	public void setScreenWidth(float screenWidth) {
		this.screenWidth = screenWidth;
	}

	public float getGameHeight() {
		return gameHeight;
	}

	public void setGameHeight(float gameHeight) {
		this.gameHeight = gameHeight;
	}

	public float getGameWidth() {
		return gameWidth;
	}

	public void setGameWidth(float gameWidth) {
		this.gameWidth = gameWidth;
	}
}
