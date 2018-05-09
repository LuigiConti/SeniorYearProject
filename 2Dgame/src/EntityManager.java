import java.awt.Graphics;
import java.util.ArrayList;

public class EntityManager {
	
	private Handler handler;
	public ArrayList<Unit> units;
	public ArrayList<Building>  buildings;
	public ArrayList<Entity> entities;
	
	public EntityManager(Handler handler) {
		this.handler = handler;
		units = new ArrayList<Unit>(); 
		buildings = new ArrayList<Building>(); 
		entities = new ArrayList<Entity>();
		
	}
	
	public void update() {
		for(int i = 0; i < units.size(); i++ ) {
			Unit u = units.get(i);
			u.update();
		}
		
		for(int i = 0; i < buildings.size(); i++ ) {
			Building b = buildings.get(i);
			b.update();
		}
		
	}
	
	public void render(Graphics g) {
		
		for(int i = 0; i < units.size(); i++ ) {
			Unit u = units.get(i);
			u.render(g);
		}
		
		for(int i = 0; i < buildings.size(); i++ ) {
			Building b = buildings.get(i);
			b.render(g);
		}
		
	}
	
	public void addEntity(Unit u) {
		units.add(u);
		entities.add(u);
	}
	
	public void addEntity(Building b) {
		buildings.add(b);
		entities.add(b);
	}
	
	
}
