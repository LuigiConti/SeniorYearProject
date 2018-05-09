import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardManager implements KeyListener {

	private boolean[] keys;
	public boolean cameraUp, cameraDown, cameraLeft, cameraRight;
	
	public KeyboardManager(){
		keys = new boolean[256];
		
	}
	
	public void update(){
		cameraUp = keys[38];
		cameraDown = keys[40];
		cameraLeft = keys[37];
		cameraRight = keys[39];
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		keys[arg0.getKeyCode()] = true; //Set a certain index in the array corresponding to the certain keyCode to TRUE
		System.out.println("KeyCode: " + arg0.getKeyCode());
		update();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		keys[arg0.getKeyCode()] = false;
		update();
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
		
	}

}
