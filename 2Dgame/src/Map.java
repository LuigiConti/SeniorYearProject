import java.awt.Graphics;
import java.awt.Point;

public class Map {

	private int width, height; // Width and height of map in terms of tiles
	public int spawnX, spawnY;
	private int[][] tiles;
	private Handler handler;
	
	//Entities
	public EntityManager entityManager;
	
	public Map(Handler handler, String path){
		this.handler = handler;
		
		//Entities
		entityManager = new EntityManager(handler);
		entityManager.addEntity(new Wizard(handler, 2*Tile.TILE_WIDTH, 2*Tile.TILE_HEIGHT));
		entityManager.addEntity(new Wizard(handler, 3*Tile.TILE_WIDTH, 2*Tile.TILE_HEIGHT));
		entityManager.addEntity(new Wizard(handler, 4*Tile.TILE_WIDTH, 2*Tile.TILE_HEIGHT));
		entityManager.addEntity(new Wizard(handler, 5*Tile.TILE_WIDTH, 2*Tile.TILE_HEIGHT));
		entityManager.addEntity(new Portal(handler, 2*Tile.TILE_WIDTH, 4*Tile.TILE_HEIGHT));
		//entityManager.addEntity(new Portal(handler, 6*Tile.TILE_WIDTH, 4*Tile.TILE_HEIGHT));
		//entityManager.addEntity(new Portal(handler, 2*Tile.TILE_WIDTH, 6*Tile.TILE_HEIGHT));
		
		//
		loadMap(path);
		
		
	}
	
	public void update(){
		
		if(handler.getKeyboardManager().cameraDown){
			handler.getCamera().move(0, handler.getCamera().CAMERA_SPEED);
		}else if(handler.getKeyboardManager().cameraUp){
			handler.getCamera().move(0, -handler.getCamera().CAMERA_SPEED);
		}else if(handler.getKeyboardManager().cameraLeft){
			handler.getCamera().move(-handler.getCamera().CAMERA_SPEED, 0);
		}else if(handler.getKeyboardManager().cameraRight){
			handler.getCamera().move(handler.getCamera().CAMERA_SPEED, 0);
		}else{
			handler.getCamera().move(0, 0);
		}
		
		//Updates all the Entities
		entityManager.update();
	}
	
	public void render(Graphics g){
		int xStart = (int)Math.max(0, handler.getCamera().getxOffset() / Tile.TILE_WIDTH);
		int xEnd = (int)Math.min(width, (handler.getCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1);
		int yStart = (int)Math.max(0, handler.getCamera().getyOffset() / Tile.TILE_HEIGHT);
		int yEnd = (int)Math.min(height, (handler.getCamera().getyOffset() + handler.getHeight()) / Tile.TILE_HEIGHT + 1);
		
		for(int y = yStart; y < yEnd; y++){
			for(int x = xStart; x < xEnd; x++){
				getTile(x, y).render(g, (int) (x * Tile.TILE_WIDTH - handler.getCamera().getxOffset()), (int) (y*Tile.TILE_HEIGHT - handler.getCamera().getyOffset()));
			}
		}
		
		//Renders all the Entities
		entityManager.render(g);
	}
	
	public Tile getTile(int x, int y){
		if(x < 0 || y < 0 || x >= width || y>= height) {
			return Tile.grass;
		}
		
		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null){
			return Tile.grass;
		}
		return t;
	}
	
	private void loadMap(String path){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4 ]);
			}
		}
		
	}
	
	
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	
	
}
