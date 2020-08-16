package primeirosgraficos;

import java.awt.Canvas;
import java.awt.Color;

import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;


public class game extends Canvas implements Runnable
{
	public static JFrame frame;
	private Thread thread;
	private boolean isRunning = true;
	private final int WIDTH = 160;
	private final int HEIGHT = 120;
	private final int SCALE = 3;
	
	private BufferedImage image;
	private BufferedImage[] player;
	
	private SpriteSheet sheet;
	private int frames;
	private int max_frames = 20;
	private int cur_animation = 0, max_animation = 2;
	
	public game()
	{
		sheet = new SpriteSheet("/boneco.png");
		player = new BufferedImage[2];
		player[0] = sheet.getSprite(0, 0, 16, 16);
		player[1] = sheet.getSprite(16, 0, 16, 16);
		this.setPreferredSize(new Dimension (WIDTH * SCALE, HEIGHT * SCALE));
		initFrame();
		image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
	}
	public void initFrame()
	{
		frame = new JFrame("Meu jogo");
		frame.add(this);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public synchronized void start()
	{
		thread = new Thread(this);
		isRunning = true;
		thread.start();
		
	}
	
	public synchronized void stop()
	{
		isRunning = false;
		try
		{
			thread.join();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String args[])
	{
		game game = new game();
		game.start();
	}
	
	public void tick()
	{
		frames++;
		if (frames > max_frames)
		{
			frames = 0;
			cur_animation++;
			if (cur_animation >= max_animation)
			{
				cur_animation = 0;
			}
		}
	}
	
	public void render()
	{
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = image.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		
		/* renderização*/
		
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(player[cur_animation], 20, 20, null);
		g.dispose();
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.setColor(Color.WHITE);
		g.drawString("Olá mundo!", 50, 50);
		g.setColor(Color.RED);
		g.draw3DRect(20, 50, 10, 10, true);
		g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, WIDTH*SCALE, HEIGHT*SCALE, null);
		bs.show();
	}
	
	public void run()
	{
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000/amountOfTicks;
		double delta = 0;
		int frames = 0;
		double timer = System.currentTimeMillis();
		while (isRunning)
		{
			long now = System.nanoTime();
			delta+= (now - lastTime)/ns;
			lastTime = now;
			if(delta >= 1)
			{
				tick();
				render();
				frames++;
				delta--;
			}
			if(System.currentTimeMillis() - timer >= 1000)
			{
				System.out.println("FPS: " + frames);
				frames = 0;
				timer = System.currentTimeMillis();
			}
		}
		stop();
		
	}
}
