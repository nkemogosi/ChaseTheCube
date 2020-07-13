package cubes;

import game.Sprite;

public class ShrinkingCube extends Cube {
	int maxSize;
	int millseconds;
	int seconds;
	int shrinkOrGrow = 0;

	public ShrinkingCube(int x, int y, int points) {
		super(x, y, 16, points);
		this.maxSize = 16;

	}

	public ShrinkingCube(int x, int y, int maxSize, int points) {
		super(x, y, maxSize, points);
		this.maxSize = maxSize;
	}

	public void update() {

		millseconds = ++millseconds % 60;
		move(velocityX, velocityY);
		if (millseconds == 0) {
			seconds += 1;
			// System.out.println(seconds);
			if (seconds % 1 == 0)
				if (seconds % 10 == 0) {
					shrinkOrGrow = (shrinkOrGrow + 1) % 2;
				}
			if (shrinkOrGrow == 0) {
				shrink();
			} else {
				grow();
			}

		}

	}

	private void shrink() {

		if ((width <= maxSize || height <= maxSize) && width != 1) {
			width -= 1;
			height -= 1;
			sprite = new Sprite(width, height, 0x00ff00);
		}

	}

	private void grow() {
		if ((width <= 1 || height <= 1) && width <= maxSize
				|| height <= maxSize) {
			width += 1;
			height += 1;
			sprite = new Sprite(width, height, 0x00ff00);
		}
	}

}
