package joguinhos;

public class Game implements Runnable
{
	private boolean isRunning;
	private Thread thread;
	public static void main (String[] args)
	{
		Game game = new Game();
		game.start();
	}
	
	public synchronized void start()
	{
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void tick()
	{
		
	}
	
	public void render()
	{
		
	}

	@Override
	public void run() 
	{
		while (isRunning)
		{
			tick();
			render();
			
		}
	}

	public static void main(String[] args) {
		isRunning
	}
}
