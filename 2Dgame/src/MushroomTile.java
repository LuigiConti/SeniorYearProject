
public class MushroomTile extends Tile{

	public MushroomTile(int id){
		super(AssetLoader.mushroom, id);
		
	}
	
	public boolean isSolid() {
		return true;
	}
	
}
