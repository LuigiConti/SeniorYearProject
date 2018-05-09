
public class GrassTile extends Tile {

	public GrassTile(int id) {
		super(AssetLoader.grass, id);
		
	}
	
	public boolean isSolid() {
		return false;
	}

}
