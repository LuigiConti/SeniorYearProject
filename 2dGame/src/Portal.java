import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Portal extends Building{
	
	public ArrayList<Button> buttons;
	private Button buildWizard, buildTest;

	public Portal(Handler handler, int x, int y) {
		super(handler, x, y, Building.DEFAULT_BUILDING_WIDTH, Building.DEFAULT_BUILDING_HEIGHT);
		health = 200;
		highlighted = false;
		selected = false;
		state = "waitingForOrders";
		
		buttons = new ArrayList<>();
		buildWizard = new Button(handler, AssetLoader.slime, 0, 0, 42, 42);
		buildTest = new Button(handler, AssetLoader.wizard, 0, 0, 42, 42);
		buttons.add(buildWizard);
		buttons.add(buildTest);
		buildMenu = new BuildMenu(handler, Color.BLUE, buttons);
		
		harvestLevel = 3;
	}
	

	@Override
	public void update() {
		highlight();
		if(selected) {buildMenu.update();}
		runBehavior();
		//System.out.println(originTile.x /Tile.TILE_WIDTH+ "" + originTile.y/Tile.TILE_HEIGHT);
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(AssetLoader.portal, (int)(x - handler.getCamera().getxOffset()), (int)(y - handler.getCamera().getyOffset()), width, height, null);
		this.drawBounds(g);
		g.fillRect(originTile.x - (int)handler.getCamera().getxOffset(), originTile.y - (int)handler.getCamera().getyOffset(), 10, 10);
		
		if(selected) {
			buildMenu.render(g);
		}
		
	}

	@Override
	public void setBehavior(MouseEvent arg0) {
		if(this.selected){
			state = "buildingUnit";
		}		
	}	
	
	
}
