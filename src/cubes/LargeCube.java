package cubes;

public class LargeCube extends Cube {
	int velocityX = 1;
	int velocityY = 1;

	public LargeCube(int x, int y, int size, int points) {
		super(x, y, size, points);
	}

	public LargeCube(int x, int y, int points) {
		super(x, y, 32, points);
	}

}
