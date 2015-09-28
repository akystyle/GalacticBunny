package akydroid.galactic.bunny.gameworld;

import java.util.ArrayList;

import akydroid.galactic.bunny.objects.BoundaryFrame;
import akydroid.galactic.bunny.objects.EnemyBall;
import akydroid.galactic.bunny.objects.MyBG;
import akydroid.galactic.bunny.objects.MyPlayer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class MyGameWorld {

	final int INITIAL_BALL_SIZE = 8;

	float screenHeight, screenWidth, gameHeight, gameWidth;
	float scaleX, scaleY;
	MyGameRenderer myGameRenderer;
	static MyPlayer myPlayer;
	BoundaryFrame myFrame;
	MyBG myBG;
	ArrayList<EnemyBall> myEnemyBallArray;
	Rectangle circleLimits;

	final int BOUNDARYSCALER = 18;
	final int PLAYERSCALER = 9;

	public MyGameWorld(float screenHeight, float screenWidth, float gameHeight,
			float gameWidth, float scaleX, float scaleY) {
		this.screenHeight = screenHeight;
		this.screenWidth = screenWidth;
		this.gameHeight = gameHeight;
		this.gameWidth = gameWidth;
		this.scaleX = scaleX;
		this.scaleY = scaleY;

		circleLimits = new Rectangle(gameWidth / BOUNDARYSCALER, gameHeight/ BOUNDARYSCALER, gameWidth - (2 * gameWidth / BOUNDARYSCALER),gameHeight - (2 * gameHeight / BOUNDARYSCALER));
		
		myBG = new MyBG(gameHeight, gameWidth);
		myFrame = new BoundaryFrame(gameHeight, gameWidth, gameHeight / BOUNDARYSCALER, gameWidth / BOUNDARYSCALER);
		myPlayer = new MyPlayer(gameHeight, gameWidth,(gameHeight * (BOUNDARYSCALER - 1)) / BOUNDARYSCALER,	PLAYERSCALER, gameWidth / BOUNDARYSCALER, gameHeight / BOUNDARYSCALER);
		myEnemyBallArray = new ArrayList<EnemyBall>();
		myEnemyBallArray.add(0, new EnemyBall(0, INITIAL_BALL_SIZE,	new Vector2(gameWidth / 2, gameHeight / 2), new Vector2(1, 1),circleLimits,-1));
		myEnemyBallArray.add(1, new EnemyBall(1, INITIAL_BALL_SIZE,	new Vector2(gameWidth / 2, gameHeight / 2), new Vector2(1, 1),circleLimits,-1));
	}

	public void update(float delta) {
		myPlayer.update(delta);
		int killIt = -1;

		for (int i = 0; i < myEnemyBallArray.size(); i++) {
			myEnemyBallArray.get(i).update(delta);
			if (myPlayer.getBullet() != null) {
				if (Intersector.overlaps(myEnemyBallArray.get(i).getMyCircle(),
						myPlayer.getBullet().getMyBoundingRectangle())) {
					killIt = i;
				}
			}
		}
		if (killIt != -1) {
			IMKilled(killIt);
			killIt = -1;
		}
	}

	public void IMKilled(int killed) {

		if (myEnemyBallArray.get(killed).getMyCircle().radius > 2) {
			int newIndex = myEnemyBallArray.size();
			myEnemyBallArray.add(newIndex, new EnemyBall(newIndex, myEnemyBallArray.get(killed).getMyCircle().radius / 2, new Vector2(myEnemyBallArray.get(killed).getMyCircle().x,
							myEnemyBallArray.get(killed).getMyCircle().y),	new Vector2(1, 1), circleLimits,myEnemyBallArray.get(killed).getMoveDirection()));
			newIndex += 1;
			myEnemyBallArray.add(newIndex, new EnemyBall(newIndex, 	myEnemyBallArray.get(killed).getMyCircle().radius / 2,
					new Vector2(myEnemyBallArray.get(killed).getMyCircle().x, myEnemyBallArray.get(killed).getMyCircle().y),
					new Vector2(1, 1), circleLimits,calculateNewDirectionsOfNewEnemies(killed)));
		}
		myEnemyBallArray.remove(killed);
		myPlayer.setBullet(null);
	}

	private int calculateNewDirectionsOfNewEnemies(int killed) {
		int newDirection = myEnemyBallArray.get(killed).getMoveDirection();
		if (newDirection % 2 == 0)
			newDirection -= 1;
		else if (newDirection % 2 == 1)
			newDirection += 1;
		return newDirection;
	}

	public MyPlayer getPlayer() {
		return myPlayer;
	}

	public MyBG getMyBG() {
		return myBG;
	}

	public BoundaryFrame getBoundaryFrame() {
		return myFrame;
	}

	public MyGameRenderer getRenderer() {
		return myGameRenderer;
	}

	public void setRenderer(MyGameRenderer tempRenderer) {
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

	public ArrayList<EnemyBall> getEnemyBall() {
		return myEnemyBallArray;
	}
}
