import java.awt.Graphics;
import java.awt.image.BufferedImage;
public class Button{

	public BufferedImage image;
	private Handler handler;
	private float x, y;
	private int width, height;
	
	public Button(Handler handler,BufferedImage image, float x, float y, int width, int height) {
		this.handler = handler;
		this.image = image;
		this.setX(x);
		this.setY(y);
		this.width = width;
		this.height = height;
	}

	public void render(Graphics g) {
		g.drawImage(image ,(int) getX() ,(int) getY(), width, height, null);
		
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}

}
