package cubes;

import game.Entity;

public class Shape extends Entity {
	int velocityX;
	int velocityY;

	public Shape(int x, int y, int width, int height, int points) {
		this.value = points;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

	}

	public Shape(int x, int y, int points) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}

}
