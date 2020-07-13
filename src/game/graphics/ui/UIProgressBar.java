package game.graphics.ui;

import game.Screen;
import game.Sprite;

import java.awt.Color;
import java.awt.Graphics;

import org.w3c.dom.ranges.RangeException;

public class UIProgressBar extends UIComponent {
	private int progress;
	private Vector2i size;
	private int maxVal = 100;
	private Color fColour;

	public UIProgressBar(Vector2i position, int width, int height) {
		super(position);
		size = new Vector2i(width, height);

	}

	public void setProgress(int progress) {
		if (progress < 0 || progress > 100) {
			// throw new RangeException(RangeException.BAD_BOUNDARYPOINTS_ERR,
			// "C");
		} else {
			this.progress = progress;
		}

	}

	public int getProgress() {
		return progress;
	}

	public void increase() {
		setProgress(progress + 1);
	}

	public void decrease() {
		setProgress(progress - 1);
	}

	public void addVal(int val) {
		setProgress(progress + val);
	}

	public void update() {

	}

	public void render(Graphics g) {
		g.setColor(fColour);
		g.fillRect(position.getX(), position.getY(), progress, size.getY());

	}

	public void render(Screen screen) {
		screen.renderSprite(position.getX(), position.getY(),
				new Sprite(size.getX(), size.getY(), 0xF0F0F0), true);
		screen.renderSprite(position.getX(), position.getY(), new Sprite(
				progress, size.getY(), 0x00ff00), true);

	}
}
