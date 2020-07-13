package cubes;

import game.Screen;
import game.Sprite;

public class Box extends Shape {

	public Box(int x, int y, int width, int height, int points) {
		super( x, y,  width,  height, points);
		sprite = new Sprite(width, height, 0x00ff00);
	}

	public Box(int x, int y, int points) {
		super(x,  y, points);

	}

	public void render(Screen screen) {
		int xx = x;// - 16;
		int yy = y;// - 16;
		screen.renderSprite(xx, yy, sprite, false);
	}

	@Override
	public int[] collision() {
		if (x + width >= level.getWidth() || x <= 0) {
			velocityX *= -1;
		}

		if (y + height >= level.getHeight() || y <= 0)
			velocityY *= -1;
		// super.collision();
		int[] collision = { velocityX, velocityY };
		return collision;
	}
}
