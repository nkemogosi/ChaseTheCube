package game.graphics.ui;

import game.LinkedList;
import game.Screen;

public class UIPanel extends UIComponent {
	LinkedList<UIComponent> components = new LinkedList<UIComponent>();

	public UIPanel(Vector2i position) {
		super(position);
		// TODO Auto-generated constructor stub
	}

	public void addComponent(UIComponent panel) {
		components.add(panel);
	}

	public void render(Screen screen) {
		for (int x = 0; x < components.size; x++) {
			components.get(x).value.render(screen);
		}
	}

}
