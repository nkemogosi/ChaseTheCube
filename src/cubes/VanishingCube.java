package cubes;

import game.Sprite;

public class VanishingCube extends Cube {
	Sprite vanishedSprite = new Sprite(width, height, 0xffffff);
	int maxSize;

	public VanishingCube(int x, int y, int points) {
		super(x, y, 16, points);
		this.maxSize = 16;

	}

	public VanishingCube(int x, int y, int maxSize, int points) {
		super(x, y, maxSize, points);
		this.maxSize = maxSize;
	}

	public void update() {
		hide();
		move(velocityX, velocityY);
		show();
	}

	public void hide() {
		vanishedSprite = sprite;
		sprite = new Sprite(width, height, 0x0);
		canCollide = false;
	}

	public void show() {
		sprite = new Sprite(width, height, 0x00ff00);
	}

}
