package game.levels;

import game.Entity;
import game.LinkedList;
import game.Screen;
import cubes.*;

public class Level_1 extends Level {

	public Level_1(int width, int height) {
		super(width, height);
		progressBar.setProgress(0);
		// TODO Auto-generated constructor stub
	}

	protected void generateLevel() {
		entityList = new LinkedList<Entity>();
		entityList.add(new LargeCube(150, 10, 1));
		int size = entityList.size;
		for (int i = 0; i < size; i++) {
			entityList.get(i).value.init(this);
		}
	}

}
