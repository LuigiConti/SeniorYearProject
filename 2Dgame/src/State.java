import java.awt.Graphics;
import java.awt.Graphics2D;
public abstract class State {
	
	protected Handler handler;
	private static State currentState = null;
	
	public State(Handler handler){
		this.handler = handler;
	}
	
	public abstract void update();
	
	public abstract void render(Graphics2D g);
	
	
	//Getters and setters
	public static void setState(State state){
		currentState = state;
	}
	
	public static State getState(){
		return currentState;
	}
	
}
