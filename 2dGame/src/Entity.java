import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public abstract class Entity {
	
	protected int x, y;
	protected int width, height;
	public boolean highlighted, selected;
	public Rectangle bounds;
	public String state;
	protected Handler handler;
	
	public Entity(Handler handler, int x, int y, int width, int height){
		
		
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		bounds = new Rectangle();
		//Bounds are an extra layer thick
		bounds.x = (int) (x - 1);
		bounds.y = (int) (y - 1);
		bounds.width = this.width + 1;
		bounds.height = this.height + 1;
	}
	
	public void highlight() {
		if(handler.getMouseManager().mouseX + handler.getCamera().getxOffset() >= this.getX() 
			&& handler.getMouseManager().mouseY + handler.getCamera().getyOffset() >= this.getY() 
			&& handler.getMouseManager().mouseX + handler.getCamera().getxOffset() <= (this.getX() + this.getWidth()) 
			&& handler.getMouseManager().mouseY + handler.getCamera().getyOffset() <= (this.getY() + this.getHeight()))
			{
				this.highlighted = true;
			}else
			this.highlighted = false;
	}
	
	public void drawBounds(Graphics g) {
		if(this.highlighted) {
			bounds.setLocation((int)this.x, (int)this.y);
			g.setColor(Color.cyan);
			g.drawRect((int)(bounds.x - handler.getCamera().getxOffset()), (int)(bounds.y - handler.getCamera().getyOffset()), bounds.width, bounds.height);
		}
		
		if(this.selected) {
			bounds.setLocation((int)this.x, (int)this.y);
			g.setColor(Color.blue);
			g.drawRect((int)(bounds.x - handler.getCamera().getxOffset()), (int)(bounds.y - handler.getCamera().getyOffset()), bounds.width, bounds.height);
		}
	}
	
	public abstract void setBehavior(MouseEvent arg0);
	
	public abstract void update();
	
	public abstract void render(Graphics g);
	
	//Getters and Setters
	public float getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(int y) {
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
