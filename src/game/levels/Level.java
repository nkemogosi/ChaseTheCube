package game.levels;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import game.Entity;
import game.Game;
import game.LinkedList;
import game.Screen;
import game.graphics.ui.Mouse;
import game.graphics.ui.UIManager;
import game.graphics.ui.UIPanel;
import game.graphics.ui.UIProgressBar;
import game.graphics.ui.Vector2i;
//import graphics.ui.UIProgressBar;
//import graphics.ui.Vector2i;

public class Level {
	protected int width;
	protected int height;
	LinkedList<Entity> entityList;
	private UIManager ui;
	UIProgressBar progressBar;

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		ui = Game.getUIManager();
		progressBar = new UIProgressBar(new Vector2i(10, 5), 100, 10);
		UIPanel panel = new UIPanel(new Vector2i(0, 0));
		ui.addPanel(panel);
		panel.addComponent(progressBar);
		generateLevel();

	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	protected void generateLevel() {
		// TODO Auto-generated method stub

	}

	public void update() {
		// TODO Auto-generated method stub
		for (int i = 0; i < entityList.size; i++) {
			entityList.get(i).value.update();
			if (entityList.get(i).value.intersectedBounds(Mouse.getX(),
					Mouse.getY())) {
				progressBar.addVal(entityList.get(i).value.getValue());
			}
		}

		System.out.println(Mouse.getX() + ", " + Mouse.getY());
	}

	public void render(Screen screen) {
		// TODO Auto-generated method stub
		for (int i = 0; i < entityList.size; i++) {
			entityList.get(i).value.render(screen);
		}
	}

}
