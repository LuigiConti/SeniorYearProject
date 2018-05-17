import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class Wizard extends Unit{
	
	
	public Wizard(Handler handler, int x, int y) {
		super(handler, x, y, Unit.DEFAULT_UNIT_WIDTH, Unit.DEFAULT_UNIT_HEIGHT);
		maxHealth = 500;
		currentHealth = maxHealth;
		speed = 2;
		highlighted = false;
		selected = false;
	}

	
	@Override
	public void update() {
		highlight();
		runBehavior();
		
		
		if(currentHealth>0) {
			currentHealth -= 1;
			
		}else {
			currentHealth = maxHealth;
		}
		
	}
	
	

	@Override
	public void render(Graphics g) {
		g.drawImage(AssetLoader.wizard, (int)(x - handler.getCamera().getxOffset()), (int)(y - handler.getCamera().getyOffset()), width, height, null);
		drawBounds(g);
		drawHealthBar(g);
		
	}

	@Override
	public void setBehavior(MouseEvent arg0) {
		if(this.selected){
			this.moveTo(arg0.getX(), arg0.getY());
		}
	}
	
	
}
