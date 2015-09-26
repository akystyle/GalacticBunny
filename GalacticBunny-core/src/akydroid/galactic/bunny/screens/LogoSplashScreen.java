package akydroid.galactic.bunny.screens;

import akydroid.galactic.bunny.GalacticBunnyMainGameClass;
import akydroid.galactic.bunny.frameworkHelpers.MyAssetLoader;
import akydroid.galactic.bunny.tweenaccessors.SpriteAccessor;
import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LogoSplashScreen implements Screen {
	TweenManager myTweenManager;
	Sprite akydroidLogoSprite;
	SpriteBatch myBatcher;
	GalacticBunnyMainGameClass myGame;
	float myRuntime = 0;
	float screenHeight,screenWidth;
	
	
	public LogoSplashScreen(GalacticBunnyMainGameClass myGame, float screenHeight,float screenWidth){
		this.screenHeight = screenHeight;
		this.screenWidth = screenWidth;
		this.myGame = myGame;
		myBatcher = new SpriteBatch();
		akydroidLogoSprite = new Sprite(MyAssetLoader.akydroidLogo);
		akydroidLogoSprite.setColor(1, 1, 1, 0);
		tweeningLogo();
	}
	
	public void tweeningLogo(){
		Tween.registerAccessor(Sprite.class, new SpriteAccessor());
		myTweenManager = new TweenManager();
		
		TweenCallback cb = new TweenCallback(){
			@Override
			public void onEvent(int type,BaseTween<?> source){
				myGame.setScreen(new GameScreen(screenHeight,screenWidth));
			}
		};
		
		Tween.to(akydroidLogoSprite, SpriteAccessor.ALPHA, .8f).target(1)
		.ease(TweenEquations.easeInOutQuad).repeatYoyo(1, .4f)
		.setCallback(cb).setCallbackTriggers(TweenCallback.COMPLETE)
		.start(myTweenManager);
	}
	@Override
	public void render(float delta) {
		myRuntime += delta;
		myTweenManager.update(delta);
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		myBatcher.begin();
		akydroidLogoSprite.draw(myBatcher);
		myBatcher.end();
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
