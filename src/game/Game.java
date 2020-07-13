package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
//import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
//import java.awt.image.Raster;




import javax.swing.JFrame;

import game.graphics.ui.Mouse;
import game.graphics.ui.UIManager;
import game.levels.Level;
import game.levels.Level_1;
import game.levels.Level_2;
import game.levels.Level_3;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	public static int width = 300;
	public static int height = width -(width/4);/// 16 * 8;
	public static int scale = 3;
	public static String title = "Chase";
	private Thread gameThread;
	private boolean running = false;
	private JFrame gameFrame;
	// private KeyBoard key;
	private Screen screen;
	private BufferedImage image = new BufferedImage(width, height,
			BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer())
			.getData();

	private Level level;

	// private Player player;
	private static UIManager uiManager = new UIManager();

	public Game() {

		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		screen = new Screen(width, height);
		gameFrame = new JFrame();
		// key = new KeyBoard();
		level = new Level_3(width, height);
		// if (level == null) {
		// level = new RandomLevel(64, 64);
		// }
		// uiManager = new UIManager();
		// player = new Player(playerSpawn.x(), playerSpawn.y(), key);
		// player.init(level);
		// addKeyListener(key);
		Mouse mouse = new Mouse();
		 addMouseListener(mouse);
		 addMouseMotionListener(mouse);

		
	}

	public static UIManager getUIManager() {
		return uiManager;

	}

	public synchronized void start() {

		running = true;
		gameThread = new Thread(this, "Game");
		gameThread.start();

	}

	public synchronized void stop() {

		running = false;
		try {
			gameThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	// @Override
	public void run() {

		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		while (running) {
			// System.out.println("Running...");
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				// System.out.println("FPS: " + frames + "," + "Updates: " +
				// updates);
				gameFrame.setTitle(title + " | " + "FPS: " + frames + ","
						+ "Updates: " + updates);
				updates = 0;
				frames = 0;
			}
		}

	}

	public void update() {
		// key.update();
		// player.update();
		level.update();
		uiManager.update();

	}

	public void render() {

		BufferStrategy bStrategy = getBufferStrategy();
		if (bStrategy == null) {
			createBufferStrategy(3);
			return;
		}
		screen.clear();
		uiManager.render(screen);
		level.render(screen);

		// to
		// render level
		// Sprite sprite = new Sprite(50, 8, 0x00FF00);
		// Sprite sprite1 = new Sprite(50, 10, 0x00000);
		// screen.renderSprite(3, 4, sprite1, false);
		// screen.renderSprite(30, 30, new Sprite(16, 16, 0xff0000), false);

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}
		Graphics g = bStrategy.getDrawGraphics();
		// This is where the graphics go
		g.setColor(Color.red);
		// g.setFont(new Font("Veranda",0,50));

		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		// g.drawString("X: " + " ,Y: ", 250, 50);
		// g.fillRect(10, 10, 16, 16);
		g.dispose();
		bStrategy.show();

	}

	public static void main(String[] args) {

		Game game = new Game();
		game.gameFrame.setResizable(false);
		game.gameFrame.setTitle(Game.title);
		game.gameFrame.setUndecorated(false);
		game.gameFrame.add(game);
		game.gameFrame.pack();
		game.gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.gameFrame.setLocationRelativeTo(null);
		game.gameFrame.setVisible(true);

		game.start();
	//	System.out.println("Created Window");
	}

}
