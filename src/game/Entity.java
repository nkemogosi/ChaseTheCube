package game;

import game.levels.Level;

import java.awt.Rectangle;
import java.util.Random;

public class Entity {
	public int x, y;
	public int width, height;
	private boolean removed;
	protected Level level;
	protected final Random random = new Random();
	protected int dir = 0;
	protected boolean moving = false;
	protected boolean canCollide = true;
	protected int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	protected Sprite sprite;

	public void update() {

	}

	public void render(Screen screen) {

	}

	public void move(int xa, int ya) {

		int[] collision = collision();
		x += collision[0];
		y += collision[1];

	}

	public int[] collision() {
		return null;

	}

	public void remove() {
		removed = true;
	}

	public boolean isRemoved() {
		return removed;
	}

	public void init(Level level) {
		this.level = level;
	}

	public boolean intersectedBounds(int mx, int my) {
		if (canCollide){
		Rectangle entity = new Rectangle(x, y, width, height);
		if (entity.intersects(new Rectangle(mx, my, 1, 1))) {
			return true;
		}
		}
		return false;
	}
	 public boolean isCollideable(){
		 return canCollide;
	 }
}
