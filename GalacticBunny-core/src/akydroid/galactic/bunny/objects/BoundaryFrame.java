package akydroid.galactic.bunny.objects;

import akydroid.galactic.bunny.frameworkHelpers.MyAssetLoader;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class BoundaryFrame {

	final String assetPath = "data/textures/boundaryTerrain/grass.png";
	Texture myPic;
	Vector2[] upperBox,lowerBox;

	
	public BoundaryFrame(float gameHeight, float gameWidth){
		myPic = MyAssetLoader.loadAssets(assetPath);
		
		int heightBlocks = (int) gameHeight / myPic.getHeight();
		int widthBlocks = (int) gameWidth / myPic.getWidth();
		
		upperBox = new Vector2[widthBlocks];
		lowerBox = new Vector2[widthBlocks];		
		
		for(int i = 0;i < widthBlocks; i++){
			upperBox[i] = new Vector2(i * myPic.getWidth(),0);
			lowerBox[i] = new Vector2(i * myPic.getWidth(),(heightBlocks - 1) * myPic.getHeight());			
		}
	}	
}
