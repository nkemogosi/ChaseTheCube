package cubes;

public class Cube extends Box {

	public Cube(int x, int y, int size, int points) {
		super(x, y, size, size, points);
		velocityX = 1;
		velocityY = 2;
	}

	public Cube(int x, int y, int points) {
		super(x, y, points);
		this.x = x;
		this.y = y;
		velocityX = 1;
		velocityY = 1;
	}

	public void update() {
		move(velocityX, velocityY);

	}

}
