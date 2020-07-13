package game;
public class Screen {
	public int width, height;
	public int xOffset, yOffset;
	public int[] pixels;

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}

	public void renderSprite(int xPos, int yPos, Sprite sprite, boolean isFixed) {
		if (isFixed) {
			xPos -= xOffset;
			yPos -= yOffset;
		}

		for (int y = 0; y < sprite.getHeight(); y++) {
			int yAbsolute = y + yPos;
			for (int x = 0; x < sprite.getWidth(); x++) {
				int xAbsolute = x + xPos;
				if (xAbsolute < 0 || xAbsolute >= width || yAbsolute < 0
						|| yAbsolute >= height)
					continue;

				pixels[xAbsolute + yAbsolute * width] = sprite.pixels[x + y
						* sprite.getWidth()];// used to create transparency

			}
		}
	}

	public void clear() {

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}

	}
}
