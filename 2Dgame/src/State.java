import java.awt.Graphics;
public abstract class State {
	
	protected Handler handler;
	private static State currentState = null;
	
	public State(Handler handler){
		this.handler = handler;
	}
	
	public abstract void update();
	
	public abstract void render(Graphics g);
	
	
	//Getters and setters
	public static void setState(State state){
		currentState = state;
	}
	
	public static State getState(){
		return currentState;
	}
	
}
