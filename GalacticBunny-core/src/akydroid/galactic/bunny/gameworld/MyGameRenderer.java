package akydroid.galactic.bunny.gameworld;

import akydroid.galactic.bunny.objects.EnemyBall;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;

public class MyGameRenderer {

	OrthographicCamera myCam;
	SpriteBatch myBatcher;
	ShapeRenderer myShapeRenderer;
	float scaleX, scaleY;

	MyGameWorld myGameWorld;

	float screenHeight, screenWidth, gameHeight;

	public MyGameRenderer(MyGameWorld tempWorld, float screenHeight,
			float screenWidth, float gameHeight) {

		this.screenHeight = screenHeight;
		this.screenWidth = screenWidth;

		myCam = new OrthographicCamera();
		myCam.setToOrtho(true, 272, gameHeight);

		myGameWorld = tempWorld;
		myBatcher = new SpriteBatch();
		myShapeRenderer = new ShapeRenderer();

		myBatcher.setProjectionMatrix(myCam.combined);
		myShapeRenderer.setProjectionMatrix(myCam.combined);

		scaleY = screenHeight / gameHeight;
	}

	public void render(float delta, float myRuntime) {

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		myBatcher.begin();
		myBatcher.disableBlending();

		// myBatcher.draw(myGameWorld.getMyBG().getMyPic(), 0,
		// 0,myGameWorld.getGameWidth(),myGameWorld.getGameHeight());

		drawBoundary();

		myBatcher.enableBlending();

		myShapeRenderer.begin(ShapeType.Filled);

		if(myGameWorld.getPlayer().getBullet() != null){
			Rectangle bulletRect = myGameWorld.getPlayer().getBullet().getMyBoundingRectangle();
			myShapeRenderer.rect(bulletRect.x, bulletRect.y, bulletRect.width, bulletRect.height);
		}
		for(EnemyBall i : myGameWorld.getEnemyBall()){
			myShapeRenderer.circle(i.getMyCircle().x, i.getMyCircle().y, i.getMyCircle().radius);
		}
		
		myBatcher.draw(myGameWorld.getPlayer().getMyPic(), myGameWorld
				.getPlayer().getPositionX(), myGameWorld.getPlayer()
				.getPositionY(), myGameWorld.getPlayer().getExpectedWidth(),
				myGameWorld.getPlayer().getExpectedHeight());
		myBatcher.end();
		myShapeRenderer.end();
	}

	private void drawBoundary() {

		for (int i = 0; i < myGameWorld.getBoundaryFrame().getWidthBlocks(); i++) {

			myBatcher.draw(myGameWorld.getBoundaryFrame().getMyPic(),
					myGameWorld.getBoundaryFrame().getUpperBoxPositionX(i),
					myGameWorld.getBoundaryFrame().getUpperBoxPositionY(i),
					myGameWorld.getBoundaryFrame().getExpectedWidth(),
					myGameWorld.getBoundaryFrame().getExpectedHeight());

			myBatcher.draw(myGameWorld.getBoundaryFrame().getMyPic(),
					myGameWorld.getBoundaryFrame().getLowerBoxPositionX(i),
					myGameWorld.getBoundaryFrame().getLowerBoxPositionY(i),
					myGameWorld.getBoundaryFrame().getExpectedWidth(),
					myGameWorld.getBoundaryFrame().getExpectedHeight());

		}

		for (int i = 0; i < myGameWorld.getBoundaryFrame().getHeightBlocks(); i++) {
			myBatcher.draw(myGameWorld.getBoundaryFrame().getMyPic(),
					myGameWorld.getBoundaryFrame().getLeftBoxPositionX(i),
					myGameWorld.getBoundaryFrame().getLeftBoxPositionY(i),
					myGameWorld.getBoundaryFrame().getExpectedWidth(),
					myGameWorld.getBoundaryFrame().getExpectedHeight());
			myBatcher.draw(myGameWorld.getBoundaryFrame().getMyPic(),
					myGameWorld.getBoundaryFrame().getRightBoxPositionX(i),
					myGameWorld.getBoundaryFrame().getRightBoxPositionY(i),
					myGameWorld.getBoundaryFrame().getExpectedWidth(),
					myGameWorld.getBoundaryFrame().getExpectedHeight());
		}
	}
}
