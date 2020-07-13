package game.levels;

import game.Entity;
import game.LinkedList;
import game.Screen;
import cubes.*;

public class Level_2 extends Level {
	public Level_2(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	protected void generateLevel() {
		entityList = new LinkedList<Entity>();
		entityList.add(new ShrinkingCube(100, 50, 1));
		int size = entityList.size;
		for (int i = 0; i < size; i++) {
			entityList.get(i).value.init(this);
		}
		System.out.println(entityList.length());
	}

}
