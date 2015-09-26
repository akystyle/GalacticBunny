package akydroid.galactic.bunny.gameworld;

import akydroid.galactic.bunny.objects.BoundaryFrame;
import akydroid.galactic.bunny.objects.MyPlayer;

public class MyGameWorld {

	float screenHeight,screenWidth,gameHeight,gameWidth;
	float scaleX,scaleY;
	MyGameRenderer myGameRenderer;
	MyPlayer myPlayer;
	BoundaryFrame myFrame;
	
	public MyGameWorld(float screenHeight,float screenWidth,float gameHeight,float gameWidth,float scaleX, float scaleY){
		this.screenHeight = screenHeight;
		this.screenWidth = screenWidth;
		this.gameHeight = gameHeight;
		this.gameWidth = gameWidth;
		this.scaleX = scaleX;
		this.scaleY = scaleY;
		
		myPlayer = new MyPlayer(gameHeight,gameWidth);
		myFrame = new BoundaryFrame(gameHeight,gameWidth);
	}
	
	public void update(float delta) {
		myPlayer.update(delta);
	}
	
	public MyPlayer getPlayer(){
		return myPlayer;
	}
	
	public MyGameRenderer getRenderer(){
		return myGameRenderer;
	}
	
	public void setRenderer(MyGameRenderer tempRenderer){
		myGameRenderer = tempRenderer;
	}
}
