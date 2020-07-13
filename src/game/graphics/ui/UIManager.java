package game.graphics.ui;

import game.LinkedList;
import game.Screen;
import game.Sprite;

public class UIManager {
	LinkedList<UIPanel> panels = new LinkedList<UIPanel>();

	public UIManager() {

	}

	public void update() {

	}

	public void addPanel(UIPanel panel) {
		panels.add(panel);
	}

	public void render(Screen screen) {
		//screen.renderSprite(0, 0, new Sprite(screen.width, 30, 0xffffff), true);
		for (int x = 0; x < panels.size; x++) {
			panels.get(x).value.render(screen);
		}
	}
}
