import java.awt.Point;

public abstract class Unit extends Entity {

	public static final int DEFAULT_HEALTH = 10;
	public static final int DEFAULT_SPEED = 2;
	public static final int DEFAULT_UNIT_WIDTH = 48,
							DEFAULT_UNIT_HEIGHT = 48;
	
	protected int speed;
	
	public Point waypoint;
	
	public Unit(Handler handler, int x, int y, int width, int height) {
		super(handler, x, y, width, height);
		speed = DEFAULT_SPEED;
		this.state = "waitingForOrders";
		waypoint = new Point();
		waypoint.setLocation(x,y);
		
		maxHealth = DEFAULT_HEALTH;
		currentHealth = maxHealth;
		
	}
	
	public void moveTo(int waypointX, int waypointY){
		waypoint.setLocation(waypointX - this.width/2 + handler.getCamera().getxOffset() , waypointY - this.height/2 + handler.getCamera().getyOffset() );
		this.state = "movingToWaypoint";
		
		//this.x = waypoint.x;
		//this.y = waypoint.y;
	}
	
	public void runBehavior(){
		if(this.state == "waitingForOrders") {
			
			
			
		}else if(this.state == "movingToWaypoint"){
			
			if(this.x != waypoint.x || this.y != waypoint.y) {
				Point distance = new Point();
				int time;
				
				//X
				distance.x = (waypoint.x - this.x);
				time = (int) Math.abs(Math.floor(distance.x/this.speed));
				
				if(distance.x < 0) { // If its going left
					//Collision detection
					int tileX = (int) (x - speed )/Tile.TILE_WIDTH;
					if(!tileCollision(tileX, this.y/Tile.TILE_HEIGHT) && !tileCollision(tileX, (this.y + bounds.height)/Tile.TILE_HEIGHT) ) {
						this.x = this.x - this.speed;
					}
					
				}else if(time > 0) {
					if (distance.x > 0) { // If its going right
						//Collision detection
						int tileX = (int) (x + speed + bounds.width)/Tile.TILE_WIDTH;
						if(!tileCollision(tileX, this.y/Tile.TILE_HEIGHT) && !tileCollision(tileX, (this.y + bounds.height)/Tile.TILE_HEIGHT) ) {
							this.x = this.x + this.speed;
						}
						 /*
						//Entity Collision 
						for(Entity e : handler.getEntityManager().entities) {
							if(this.getX() + handler.getCamera().getxOffset() < e.getX()) {
								this.x = this.x + this.speed;
							}
						} */
					}
				}else if(time == 0 && this.x != distance.x && distance.x > 0) {
					this.x = this.x + (waypoint.x - this.x);
				}else if(time == 0 && this.x != distance.x && distance.x < 0) {
					this.x = this.x - (waypoint.x - this.x);
				}
				
				//Y
				distance.y = (waypoint.y - this.y);
				time = (int) Math.abs(Math.floor(distance.y/this.speed));
				
				if(distance.y < 0) { //If its going up
					//Collision detection
					int tileY = (int) (y - speed)/Tile.TILE_HEIGHT;
					if(!tileCollision(this.x/Tile.TILE_WIDTH, tileY) && !tileCollision((this.x + bounds.width)/Tile.TILE_WIDTH, tileY ) ) {
						this.y = this.y - this.speed; // move
					}
				}else if(time > 0) {
					if (distance.y > 0) { // If its going down
						//Collision detection
						int tileY = (int) (y + speed + bounds.height)/Tile.TILE_HEIGHT;
						if(!tileCollision(this.x/Tile.TILE_WIDTH, tileY) && !tileCollision((this.x + bounds.width)/Tile.TILE_WIDTH, tileY ) ) {
							this.y = this.y + this.speed;// move
						}
					}
				}else if(time == 0 && this.y != distance.y) {
					this.y = this.y + (waypoint.y - this.y);
				}else if(time == 0 && this.y != distance.y && distance.y < 0) {
					this.y = this.y - (waypoint.y - this.y);
				}
				/*
				for(Entity e : handler.getEntityManager().entities) {
					if(this == e) {
						return;
					}else if(this.getX() + handler.getCamera().getxOffset() >= e.getX() 
							&& this.getY() + handler.getCamera().getyOffset() >= e.getY() 
							&& this.getX() + handler.getCamera().getxOffset() <= (e.getX() + e.getWidth()) 
							&& this.getY() + handler.getCamera().getyOffset() <= (e.getY() + e.getHeight()))
							{
								this.x += this.speed;
							}
					
				}
				*/
			}
			for(Entity e : handler.getEntityManager().entities) {
				
				if(this.getX() + handler.getCamera().getxOffset() >= e.getX() 
						&& this.getY() + handler.getCamera().getyOffset() >= e.getY() 
						&& this.getX() + handler.getCamera().getxOffset() <= (e.getX() + e.getWidth()) 
						&& this.getY() + handler.getCamera().getyOffset() <= (e.getY() + e.getHeight())) 
				{
					
				}
				
			}
			
			if(this.x == waypoint.x && this.y == waypoint.y) {
			this.state = "reachedWaypoint";
			}
			
		}else if(this.state == "reachedWaypoint") {
			System.out.println("REACHED WAYPOINT!!!!");
			this.selected = false;
			this.state = "waitingForOrders";
			
		}
		
	}
	
	
	public boolean tileCollision(int x, int y) {
		return handler.getMap().getTile(x, y).isSolid();
	}
	
	//Getters and Setters
	public float getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	
	
}
