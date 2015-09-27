package akydroid.galactic.bunny.objects;

import akydroid.galactic.bunny.frameworkHelpers.MyAssetLoader;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class BoundaryFrame {

	final String assetPath = "data/textures/boundaryTerrain/ground.png";
	Texture myPic;
	Vector2[] upperBox,lowerBox;
	int widthBlocks,heightBlocks;
	float expectedHeight,expectedWidth;
	//Sprite myPic;
	
	public BoundaryFrame(float gameHeight, float gameWidth, float expectedHeight, float expectedWidth){
		myPic= MyAssetLoader.loadAssets(assetPath);
		
		this.expectedHeight = expectedHeight;
		this.expectedWidth = expectedWidth;
		
		heightBlocks = (int) ((int) gameHeight / expectedHeight);
		widthBlocks = (int) ((int) gameWidth / expectedWidth);
		
		upperBox = new Vector2[widthBlocks];
		lowerBox = new Vector2[widthBlocks];		
		
		for(int i = 0;i < widthBlocks; i++){
			upperBox[i] = new Vector2(i * expectedWidth,0);
			lowerBox[i] = new Vector2(i * expectedWidth,heightBlocks * expectedHeight);			
		}
	}
	
	public Texture getMyPic() {
		return myPic;
	}

	public float getUpperBoxPositionX(int i) {
		return upperBox[i].x;
	}
	
	public float getUpperBoxPositionY(int i) {
		return upperBox[i].y;
	}

	public void setUpperBox(Vector2[] upperBox) {
		this.upperBox = upperBox;
	}

	public float getLowerBoxPositionX(int i) {
		return lowerBox[i].x;
	}
	
	public float getLowerBoxPositionY(int i) {
		return lowerBox[i].y;
	}

	public void setLowerBox(Vector2[] lowerBox) {
		this.lowerBox = lowerBox;
	}
	
	public int getWidthBlocks(){
		return widthBlocks;
	}
	
	public int getHeightBlocks(){
		return heightBlocks;
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
}
