package akydroid.galactic.bunny.objects;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class EnemyBall {

	Circle myCircle;
	int moveDirection;
	Vector2 initialPosition,ballSpeed;
	Rectangle myBoundRect;
	int myIndex;
	
	public EnemyBall(int myIndex,float radius, Vector2 initialPosition,Vector2 ballSpeed, Rectangle myBoundingRect, int moveDirection){
		
		myBoundRect = myBoundingRect;
		myCircle = new Circle(initialPosition,radius);
		this.initialPosition = new Vector2(initialPosition);
		this.ballSpeed = new Vector2(ballSpeed);
		this.myIndex = myIndex;
		this.moveDirection = moveDirection;
	}
	
	public void update(float delta){
		if(moveDirection == -1){
			
			Random startWithLeft = new Random();
			if(startWithLeft.nextBoolean())
					moveDirection = 3;
			else
				moveDirection = 4;
			initialPosition.set(0, 0);
		}else{
			switch(moveDirection){
			case 1:
				moveLeftup();
				break;
			case 2:
				moveRightUp();
				break;
			case 3:
				moveLeftDown();
				break;
			case 4:
				moveRightDown();
				break;
			}
			if(myCircle.x + myCircle.radius >= myBoundRect.getX() + myBoundRect.getWidth()){
				if(moveDirection == 2)
					moveDirection = 1;
				else if(moveDirection == 4)
					moveDirection = 3;
				else
					Gdx.app.log("EnemyBall Update", "Calculations Gone wrong (Circle Touched on Right wall) ");
			} else if(myCircle.x - myCircle.radius <= myBoundRect.getX()){
				if(moveDirection == 1)
					moveDirection = 2;
				else if(moveDirection == 3)
					moveDirection = 4;
				else
					Gdx.app.log("EnemyBall Update", "Calculations Gone wrong (Circle Touched on Left wall) ");
			} else if(myCircle.y - myCircle.radius <= myBoundRect.getY()){
				if(moveDirection == 1)
					moveDirection = 3;
				else if(moveDirection == 2)
					moveDirection = 4;
				else
					Gdx.app.log("EnemyBall Update", "Calculations Gone wrong (Circle Touched on Upper wall) ");
			} else if(myCircle.y + myCircle.radius >= myBoundRect.getY() + myBoundRect.getHeight()){
				if(moveDirection == 3)
					moveDirection = 1;
				else if(moveDirection == 4)
					moveDirection = 2;
				else
					Gdx.app.log("EnemyBall Update", "Calculations Gone wrong (Circle Touched on Lower wall) ");
			}
			
		}
	}

	private void moveRightDown(){
		myCircle.set(myCircle.x + ballSpeed.x, myCircle.y + ballSpeed.y,myCircle.radius);
	}
	
	private void moveRightUp(){
		myCircle.set(myCircle.x + ballSpeed.x, myCircle.y - ballSpeed.y,myCircle.radius);
	}
	
	private void moveLeftDown(){
		myCircle.set(myCircle.x - ballSpeed.x, myCircle.y + ballSpeed.y,myCircle.radius);
	}
	
	private void moveLeftup(){
		myCircle.set(myCircle.x - ballSpeed.x, myCircle.y - ballSpeed.y,myCircle.radius);
	}
	
	public Vector2 getInitialPosition() {
		return initialPosition;
	}

	public void setInitialPosition(Vector2 initialPosition) {
		this.initialPosition = initialPosition;
	}

	public Circle getMyCircle() {
		return myCircle;
	}

	public int getMoveDirection() {
		return moveDirection;
	}

	public Rectangle getMyBoundRect() {
		return myBoundRect;
	}
	
	public void setMoveDirection(int newDirection){
		moveDirection = newDirection;
	}
}
