package game.graphics.ui;

import game.Screen;

import java.awt.Color;

public class UIComponent {
	public Color colour;
	public Vector2i position;
	protected Vector2i offset;

	public UIComponent(Vector2i position) {
		this.position = position;
		offset = new Vector2i();
	}

	public void update() {

	}

	public void render(Screen screen) {

	}

	public void setOffset(Vector2i offset) {
		this.offset = offset;
	}

}
