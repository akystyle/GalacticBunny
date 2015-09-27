package akydroid.galactic.bunny.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class MyGameRenderer {

	OrthographicCamera myCam;
	SpriteBatch myBatcher;
	ShapeRenderer myShapeRenderer;
	float scaleX,scaleY;

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
		
		scaleY = screenHeight/gameHeight; 
	}

	public void render(float delta, float myRuntime) {

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		myBatcher.begin();
		myBatcher.disableBlending();
		
		myBatcher.draw(myGameWorld.getMyBG().getMyPic(), 0, 0,myGameWorld.getGameWidth(),myGameWorld.getGameHeight());
		
		drawBoundary();
		
		myBatcher.enableBlending();
		
		myBatcher.draw(myGameWorld.getPlayer().getMyPic(), myGameWorld
				.getPlayer().getPositionX(), myGameWorld.getPlayer()
				.getPositionY(),myGameWorld.getPlayer().getExpectedWidth(),myGameWorld.getPlayer().getExpectedHeight());
		myBatcher.end();
	}

	private void drawBoundary() {

		for(int i = 0;i < myGameWorld.getBoundaryFrame().getWidthBlocks();i++){
			
		myBatcher.draw(myGameWorld.getBoundaryFrame().getMyPic(), myGameWorld
				.getBoundaryFrame().getUpperBoxPositionX(i), myGameWorld
				.getBoundaryFrame().getUpperBoxPositionY(i), myGameWorld
				.getBoundaryFrame().getExpectedWidth() , myGameWorld.getBoundaryFrame().getExpectedHeight());

		myBatcher.draw(myGameWorld.getBoundaryFrame().getMyPic(), myGameWorld
				.getBoundaryFrame().getLowerBoxPositionX(i), myGameWorld
				.getBoundaryFrame().getLowerBoxPositionY(i), myGameWorld
				.getBoundaryFrame().getExpectedWidth() , myGameWorld.getBoundaryFrame().getExpectedHeight());
		
		}
	}
}
