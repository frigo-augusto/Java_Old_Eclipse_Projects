package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy {
	
	public double x,y;
	
	public int width, height;
	
	public Enemy(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.width = 30;
		this.height = 100;
	}

	public void tick()
	{
	    this.y += (Game.ball.y - this.y - 6.0D) * 0.3D;
		
		Rectangle rect1 = new Rectangle((int)x, (int)y, width, height);
		
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect((int)x, (int)y, width, height);
	}
	
}
