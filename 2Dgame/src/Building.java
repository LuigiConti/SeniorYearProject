import java.awt.Point;

public abstract class Building extends Entity {
	
	public static final int DEFAULT_HEALTH = 100;
	public static final float DEFAULT_SPEED = 0.0f;
	public static final int DEFAULT_BUILDING_WIDTH = 96,
							DEFAULT_BUILDING_HEIGHT = 96;
	
	public int health;
	public float speed;
	
	public BuildMenu buildMenu;
	public Point originTile;
	public int harvestLevel;
	
	public Building(Handler handler, int x, int y, int width, int height) {
		super(handler, x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		
		originTile = new Point();
		originTile.x = x + width/2;
		originTile.y = y + height/2;
		
	}
	
	public void runBehavior() {
		harvestResources(harvestLevel);
		if(this.state == "waitingForOrders") {
			
		}
		
		
		else if(this.state == "buildingUnit") {
			if(Main.energy >= 1000) {
				Main.energy -= 1000;
				handler.getEntityManager().addEntity(new Wizard(handler, this.x + this.width + 20, this.y + this.height/2));
				this.state = "finishedBuilding";
			}else{
				this.state = "waitingForOrders";
				System.out.println("Not enough energy!");
			}
		}
		
		
		else if(this.state == "finishedBuilding") {
			state = "waitingForOrders";
		}
		
		
	}
	
	public void harvestResources(int harvestLevel) {
		if(Main.ticks == 60) {	// If 1 second went by
			if(harvestLevel == 1) {
				Tile tile = handler.getMap().getTile(originTile.x/Tile.TILE_WIDTH, originTile.y/Tile.TILE_HEIGHT);
				harvestBasedOnResource(tile);
			}else if(harvestLevel == 2) {
				for(int x = 0; x < 5; x++) {
					Tile tile = null;
					if(x == 0) {
						tile = handler.getMap().getTile(originTile.x/Tile.TILE_WIDTH, originTile.y/Tile.TILE_HEIGHT);
					}else if(x == 1) {
						tile = handler.getMap().getTile((originTile.x/Tile.TILE_WIDTH) - 1, originTile.y/Tile.TILE_HEIGHT);
					}else if(x == 2) {
						tile = handler.getMap().getTile((originTile.x/Tile.TILE_WIDTH) + 1, originTile.y/Tile.TILE_HEIGHT);
					}else if(x == 3) {
						tile = handler.getMap().getTile(originTile.x/Tile.TILE_WIDTH, (originTile.y/Tile.TILE_HEIGHT) - 1);
					}else if(x == 4) {
						tile = handler.getMap().getTile(originTile.x/Tile.TILE_WIDTH, (originTile.y/Tile.TILE_HEIGHT) + 1);
					}
					harvestBasedOnResource(tile);
				}
			}else if(harvestLevel == 3) {
				for(int x = 0; x < 13; x++) {
					Tile tile = null;
					if(x == 0) {
						tile = handler.getMap().getTile(originTile.x/Tile.TILE_WIDTH, originTile.y/Tile.TILE_HEIGHT);
					}else if(x == 1) {
						tile = handler.getMap().getTile((originTile.x/Tile.TILE_WIDTH) - 1, originTile.y/Tile.TILE_HEIGHT);
					}else if(x == 2) {
						tile = handler.getMap().getTile((originTile.x/Tile.TILE_WIDTH) + 1, originTile.y/Tile.TILE_HEIGHT);
					}else if(x == 3) {
						tile = handler.getMap().getTile(originTile.x/Tile.TILE_WIDTH, (originTile.y/Tile.TILE_HEIGHT) - 1);
					}else if(x == 4) {
						tile = handler.getMap().getTile(originTile.x/Tile.TILE_WIDTH, (originTile.y/Tile.TILE_HEIGHT) + 1);
					}else if(x == 5) {
						tile = handler.getMap().getTile((originTile.x/Tile.TILE_WIDTH) - 2, (originTile.y/Tile.TILE_HEIGHT));
					}else if(x == 6) {
						tile = handler.getMap().getTile((originTile.x/Tile.TILE_WIDTH) - 1, (originTile.y/Tile.TILE_HEIGHT) - 1);
					}else if(x == 7) {
						tile = handler.getMap().getTile((originTile.x/Tile.TILE_WIDTH) + 2, (originTile.y/Tile.TILE_HEIGHT));
					}else if(x == 8) {
						tile = handler.getMap().getTile((originTile.x/Tile.TILE_WIDTH) + 1, (originTile.y/Tile.TILE_HEIGHT) + 1);
					}else if(x == 9) {
						tile = handler.getMap().getTile((originTile.x/Tile.TILE_WIDTH), (originTile.y/Tile.TILE_HEIGHT) - 2);
					}else if(x == 10) {
						tile = handler.getMap().getTile((originTile.x/Tile.TILE_WIDTH) - 1, (originTile.y/Tile.TILE_HEIGHT) + 1);
					}else if(x == 11) {
						tile = handler.getMap().getTile((originTile.x/Tile.TILE_WIDTH)+ 1, (originTile.y/Tile.TILE_HEIGHT) - 1);
					}else if(x == 12) {
						tile = handler.getMap().getTile((originTile.x/Tile.TILE_WIDTH), (originTile.y/Tile.TILE_HEIGHT) + 2);
					}
					harvestBasedOnResource(tile);
				}
			}
		}// 1 second goes by
		
	}
	
	public void harvestBasedOnResource(Tile tile) {
		if(tile.texture == AssetLoader.grass) {
			Main.energy += 1;
			System.out.println("Grass");
		} else if(tile.texture == AssetLoader.forest) {
			Main.energy += 5;
			System.out.println("Forest");
		} else if(tile.texture == AssetLoader.mushroom) {
			Main.energy += 10;
			System.out.println("Mushroom");
		}
	}
	
	//Getters and Setters
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	

}
