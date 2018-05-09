import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class BuildMenu {
	
	public Handler handler;
	public int x, y, width, height;
	public Color color;
	public ArrayList<Button> buttons;
	
	public BuildMenu( Handler handler, Color color, ArrayList<Button> buttons) {
		this.handler = handler;
		this.x = 0;
		this.y = 520;
		this.width = handler.getWidth();
		this.height = handler.getHeight() - y;
		this.color = color;
		this.buttons = buttons;
		
	}
	
	public void update() {
		int tempX1 = -30;
		for(Button b : buttons) {
			tempX1 += (int)b.getWidth()*2; 
			b.setX(x + tempX1 + handler.getCamera().getxOffset());
			b.setY(y + height/3 + handler.getCamera().getyOffset());
		}
	}
	
	public void render(Graphics g) {
		g.setColor(color);
		int tempX2 = -30;
		g.fillRect(x, y, width, height);
		for(Button b : buttons) {
			tempX2 += (int)b.getWidth()*2;
			g.drawImage(b.image, x + tempX2 , y + height/3 , b.getWidth(), b.getHeight(), null);
			//System.out.println("TESTTTTTTTTTTTTTTT");
		}
		
	}

}
