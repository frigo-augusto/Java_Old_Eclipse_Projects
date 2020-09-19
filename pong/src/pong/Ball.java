package pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;
import java.awt.Rectangle;

public class Ball {
	public double x,y;
	public static int pointEnemy, pointPlayer;
	public double dx, dy;
	public double speed = 10;
	
	public int width, height;
	
	public Ball(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.width = 10;
		this.height = 10;
		
		int angle = new Random().nextInt(120 - 45)+45;
		dx = Math.cos(Math.toRadians(angle));
		dy = Math.sin(Math.toRadians(angle));
		
	}

	public void tick()
	{
		if(y + (dy * speed) + height >= Game.HEIGHT * Game.SCALE) // <<<<
		{
			dy*= -1;
		}
		else if (y + (dy* speed) < 0)
		{
			dy*= -1;
		}
		
		if (x >= Game.WIDTH * Game.SCALE)
		{
			pointPlayer += 50;
			new Game();
			return;
		}
		else if (x <= 0)
		{
			pointEnemy += 50;
			new Game();
			return;
		}
		
		Rectangle bounds = new Rectangle((int)(x+(dx*speed)), (int)(y+(dy*speed)), width, height);
		
		Rectangle boundsPlayer = new Rectangle(Game.player.x, Game.player.y, Game.player.width, Game.player.height);
		Rectangle boundsEnemy = new Rectangle((int)Game.enemy.x, (int)Game.enemy.y, Game.enemy.width, Game.enemy.height);
		
		if (bounds.intersects(boundsPlayer))
		{
			dx*= -1;
		}
		else if(bounds.intersects(boundsEnemy))
		{
			dx*=-1;
		}
		
		x += dx* speed;
		y += dy * speed;
	}
	
	public void render(Graphics g)
	{
		String pontoJogador1 = String.valueOf(pointPlayer);
		String pontoInimigo1 = String.valueOf(pointEnemy);
		g.setColor(Color.WHITE);
		g.fillRect((int)x, (int)y, width, height);
		g.setFont(new Font("Comic Sans", Font.BOLD, 20));
		g.setColor(Color.WHITE);
		g.drawString(pontoJogador1, 50, 50);
		g.drawString(pontoInimigo1, 600, 50);
	}
	

}
