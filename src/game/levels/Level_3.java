package game.levels;

import game.Entity;
import game.LinkedList;
import cubes.LargeCube;
import cubes.VanishingCube;

public class Level_3 extends Level {

	public Level_3(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}
	protected void generateLevel() {
		entityList = new LinkedList<Entity>();
		entityList.add(new VanishingCube(150, 10, 1));
		int size = entityList.size;
		for (int i = 0; i < size; i++) {
			entityList.get(i).value.init(this);
		}
	}

}
