package game;

public class Sprite {
	int[] pixels;
	private int width;
	private int height;

	public Sprite(int width, int height, int colour) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		setColour(colour);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	/**
	 * @param colour
	 */
	private void setColour(int colour) {

		for (int i = 0; i < width * height; i++) {
			pixels[i] = colour;
		}

	}
}
