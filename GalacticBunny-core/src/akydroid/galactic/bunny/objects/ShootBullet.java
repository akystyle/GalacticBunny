package akydroid.galactic.bunny.objects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class ShootBullet {

	Vector2 initialPosition,currentPosition,shootMatrix;
	float minHeight;
	Rectangle myBoundingRect;
	
	public ShootBullet(){
		initialPosition = new Vector2(0,0);
		shootMatrix = new Vector2(0,0);
		currentPosition = new Vector2(0,0);
		myBoundingRect = new Rectangle(0,0,0,0);
				
		minHeight = 0;
	}
	public ShootBullet(Vector2 initialPosition,Vector2 shootMatrix, float minHeight){
		this.initialPosition = initialPosition;
		this.shootMatrix = shootMatrix;
		currentPosition = new Vector2(initialPosition.x,initialPosition.y);
		this.minHeight = minHeight;
		myBoundingRect = new Rectangle(initialPosition.x, initialPosition.y, (float) 1.5, 0);
	}
	
	public void update(float delta){
		if(currentPosition.y - shootMatrix.y > minHeight){
			currentPosition.set(currentPosition.x + shootMatrix.x,currentPosition.y - shootMatrix.y);
			myBoundingRect.set(currentPosition.x, currentPosition.y, (float) 1.5, myBoundingRect.height + shootMatrix.y);
		}
	}

	public Vector2 getInitialPosition() {
		return initialPosition;
	}

	public void setInitialPosition(Vector2 initialPosition) {
		this.initialPosition = initialPosition;
	}

	public Vector2 getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(Vector2 currentPosition) {
		this.currentPosition = currentPosition;
	}

	public Vector2 getShootMatrix() {
		return shootMatrix;
	}

	public void setShootMatrix(Vector2 shootMatrix) {
		this.shootMatrix = shootMatrix;
	}
	
	public Rectangle getMyBoundingRectangle(){
		return myBoundingRect;
	}
}