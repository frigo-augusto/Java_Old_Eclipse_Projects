package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Player 
{
	
	public boolean up;

	public boolean down;
	
	public int x, y;

	public int width, height;
	
	public Player (int x, int y)
	{
		this.x = x;
		this.y = y;
		this.width = 30;
		this.height = 100;
	}
	
	public void tick()
	{
		if (up == true)
		{
			y--;
		}
		else if (down == true)
		{
			y++;
		}
	}
	
	public void render(Graphics g) 
	{
		g.setColor(Color.WHITE);
		g.fillRect(x, y,30, 100);
	}
	
	
	
	
}
