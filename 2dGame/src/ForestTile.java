
public class ForestTile extends Tile{

	public ForestTile(int id) {
		super(AssetLoader.forest, id);
		
	}
	
	public boolean isSolid() {
		return true;
	}

}
