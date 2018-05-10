import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GameState extends State {
	
	private Map map;
	
	public GameState(Handler handler){
		super(handler);
		map = new Map(handler, "res/worlds/world1.txt");
		handler.setMap(map);
		
	}
	
	@Override
	public void update() {
		map.update();
		
	}

	@Override
	public void render(Graphics2D g) {
		map.render(g);
		 g.setColor(Color.cyan);
		 g.scale(2, 2);
		 g.drawString("Energy: "+Main.energy, 10, 20);
		 g.scale(1, 1);
		
	}

}
