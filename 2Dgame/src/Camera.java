
public class Camera {
	
	private Handler handler;
	private int xOffset, yOffset;
	public final int CAMERA_SPEED = 8;
	
	public Camera(Handler handler, int xOffset, int yOffset){
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.handler = handler;
	}
	
	public void checkBoundary(){
		//x
		if(xOffset < 0 ) {
			xOffset = 0;
		}else if(xOffset > handler.getMap().getWidth()*Tile.TILE_WIDTH - handler.getWidth() ) {
			xOffset = handler.getMap().getWidth()*Tile.TILE_WIDTH - handler.getWidth();
		}
		//y
		if(yOffset < 0 ) {
			yOffset = 0;
		}else if(yOffset > handler.getMap().getHeight()*Tile.TILE_HEIGHT - handler.getHeight()) {
			yOffset = handler.getMap().getHeight()*Tile.TILE_HEIGHT - handler.getHeight();
		}
		
	}
	
	public void move(float x, float y){
		this.xOffset += x;
		this.yOffset += y;
		checkBoundary();
	}

	
	//Getters and Setters
	
	
	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(int xOffset) {
		this.xOffset = xOffset;
	}
	
	

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(int yOffset) {
		this.yOffset = yOffset;
	}

	
	
}
