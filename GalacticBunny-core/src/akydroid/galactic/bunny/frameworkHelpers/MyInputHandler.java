package akydroid.galactic.bunny.frameworkHelpers;

import akydroid.galactic.bunny.gameworld.MyGameWorld;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

public class MyInputHandler implements InputProcessor{

	final int GAMEWIDTH;
	
	float scaleX,scaleY;
	MyGameWorld myGameWorld;
	
	
	public MyInputHandler(MyGameWorld tempWorld,int gameWidth,float scaleX,float scaleY){
		GAMEWIDTH = gameWidth;
		myGameWorld = tempWorld;
		this.scaleX = scaleX;
		this.scaleY = scaleY;
	}

	@Override
	public boolean keyDown(int keycode) {
		
		switch(keycode){
		case Keys.SPACE:
			myGameWorld.getPlayer().setShooting(true);
		}
		
		return false;
	}


	@Override
	public boolean keyUp(int keycode) {

		return false;
	}


	@Override
	public boolean keyTyped(char character) {
		return false;
	}


	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {

		screenX = scaleX(screenX);
		screenY = scaleY(screenY);
		
		if(screenX > (GAMEWIDTH/2))
			myGameWorld.getPlayer().setShooting(true);
		
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

	private int scaleX(int screenX){
		return (int) (screenX/scaleX);
	}
	
	private int scaleY(int screenY){
		return (int) (screenY/scaleY);
	}
	
}
