import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class Wizard extends Unit{
	
	
	public Wizard(Handler handler, int x, int y) {
		super(handler, x, y, Unit.DEFAULT_UNIT_WIDTH, Unit.DEFAULT_UNIT_HEIGHT);
		health = 20;
		speed = 2;
		highlighted = false;
		selected = false;
	}

	
	@Override
	public void update() {
		highlight();
		runBehavior();
		
	}
	
	

	@Override
	public void render(Graphics g) {
		g.drawImage(AssetLoader.wizard, (int)(x - handler.getCamera().getxOffset()), (int)(y - handler.getCamera().getyOffset()), width, height, null);
		this.drawBounds(g);
		
	}

	@Override
	public void setBehavior(MouseEvent arg0) {
		if(this.selected){
			this.moveTo(arg0.getX(), arg0.getY());
		}
	}
	
	
}
