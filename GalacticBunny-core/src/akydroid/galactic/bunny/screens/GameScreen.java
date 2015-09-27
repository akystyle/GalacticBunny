package akydroid.galactic.bunny.screens;

import akydroid.galactic.bunny.frameworkHelpers.MyInputHandler;
import akydroid.galactic.bunny.gameworld.MyGameRenderer;
import akydroid.galactic.bunny.gameworld.MyGameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class GameScreen implements Screen{

	MyGameWorld myGameWorld;
	MyGameRenderer myGameRenderer;
	float myRuntime = 0;
	float screenHeight,screenWidth;
	
	public GameScreen(float screenHeight,float screenWidth){
		this.screenHeight = screenHeight;
		this.screenWidth = screenWidth;
		float gameWidth = 272;
		float gameHeight = screenHeight / (screenWidth / gameWidth);
		
		float scaleFactorX = screenWidth / gameWidth;
		float scaleFactorY = screenHeight / gameHeight;
		
		//logStats(gameWidth,gameHeight,scaleFactorX,scaleFactorY);
		
		myGameWorld = new MyGameWorld(screenHeight,screenWidth,gameHeight,gameWidth,scaleFactorX,scaleFactorY);
		myGameRenderer = new MyGameRenderer(myGameWorld, screenHeight,screenWidth, gameHeight);
		
		myGameWorld.setRenderer(myGameRenderer);
		
		Gdx.input.setInputProcessor(new MyInputHandler(myGameWorld));
	}

	public void render(float delta) {
		myRuntime += delta;
		
		myGameWorld.update(delta);
		myGameRenderer.render(delta,myRuntime);
	}

	
	@SuppressWarnings("unused")
	private void logStats(float gameWidth, float gameHeight, float scaleFactorX, float scaleFactorY){
		Gdx.app.log("Game Screen", "ScreenWidth: " + screenWidth);
		Gdx.app.log("Game Screen", "ScreenHeight: " + screenHeight);
		Gdx.app.log("Game Screen", "GameWidth: " + gameWidth);
		Gdx.app.log("Game Screen", "GameHeight: " + gameHeight);
		Gdx.app.log("Game Screen", "ScaleX: " + scaleFactorX);
		Gdx.app.log("Game Screen", "ScaleY: " + scaleFactorY);
	}
	
	@Override
	public void show() {
	}
	@Override
	public void resize(int width, int height) {
	}
	@Override
	public void pause() {
	}
	@Override
	public void resume() {
	}
	@Override
	public void hide() {
	}
	@Override
	public void dispose() {
	}
}
