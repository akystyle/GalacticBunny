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
		
		myGameRenderer = new MyGameRenderer(myGameWorld, screenHeight,screenWidth, gameHeight);
		myGameWorld = new MyGameWorld(screenHeight,screenWidth,gameHeight,gameWidth,scaleFactorX,scaleFactorY);
		myGameWorld.setRenderer(myGameRenderer);
		
		Gdx.input.setInputProcessor(new MyInputHandler(myGameWorld));
	}

	@Override
	public void render(float delta) {
		myRuntime += delta;
	
		myGameWorld.update(delta);
		myGameRenderer.render(delta,myRuntime);
		
		
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
