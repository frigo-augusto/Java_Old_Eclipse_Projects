package teste;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class teste implements KeyListener {
	
	
	public static void main (String args[])
	{
		
	}
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			System.out.println("banana");
		}
			else if (e.getKeyCode() == KeyEvent.VK_DOWN)
			{
				System.out.println("banana");
			}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
