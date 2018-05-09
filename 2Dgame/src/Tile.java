import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	public static Tile[] tiles = new Tile[256];
	public static Tile grass = new GrassTile(0);
	public static Tile forest = new ForestTile(1);
	public static Tile mushroom = new MushroomTile(2);
	
	
	public static final int TILE_WIDTH = 70,
							TILE_HEIGHT = 70;
	
	protected BufferedImage texture;
	protected final int id;

	public Tile(BufferedImage texture, int id){
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void update(){
		
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
	}
	
	public boolean isSolid(){
		return false;
	}
	
	public int gteId(){
		return id;
	}
	
}