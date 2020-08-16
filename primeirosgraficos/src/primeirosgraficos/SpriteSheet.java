package primeirosgraficos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	private BufferedImage boneco;
	
	public SpriteSheet (String path)
	{
		try {
			boneco = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public BufferedImage getSprite(int x, int y, int w, int h)
	{
		return boneco.getSubimage(x, y, w, h);
	}
}
