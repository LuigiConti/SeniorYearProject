
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener{
	
	private boolean leftPressed, rightPressed;
	public int mouseX, mouseY;
	private Handler handler;
	
	public MouseManager(Handler handler) {
		this.handler = handler;
	}
	
	
	//    ||| Mouse events |||
	
	@Override
	public void mousePressed(MouseEvent arg0) {
		
		if(arg0.getButton() == MouseEvent.BUTTON1){
			leftPressed = true;
			//System.out.println("LEFT PRESSED");
		}else if(arg0.getButton() == MouseEvent.BUTTON3){
			rightPressed = true;
			//System.out.println("RIGHT PRESSED");
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
		if(arg0.getButton() == MouseEvent.BUTTON1){
			leftPressed = false;
			//System.out.println("LEFT RELEASED");
		}else if(arg0.getButton() == MouseEvent.BUTTON3){
			rightPressed = false;
			//System.out.println("RIGHT RELEASED");
		}
		
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		//if clicked in menu
		if(State.getState() == Main.menuState) {
			if(clickedWithinBounds(MenuState.buttonStart, arg0)){
				System.out.println("GAME START!");
				State.setState(Main.gameState);
			}
			if(clickedWithinBounds(MenuState.buttonExit, arg0)){
				System.out.println("EXIT GAME!");
				System.exit(0);
			}
		}
		
		//if clicked in game
		if(State.getState() == Main.gameState) {
			
			if(arg0.getButton() == MouseEvent.BUTTON1) {//Left click
				
				//Check if within bounds of any button
					int tempB = -1;
				for(Building b : handler.getEntityManager().buildings) {
					tempB++;
					for(Button bt : b.buildMenu.buttons) {
						if(clickedWithinBounds(bt, arg0)) {
							handler.getEntityManager().buildings.get(tempB).setBehavior(arg0);
						}
					}
				}
				
				//Check if within bounds of any entity
				for(Entity e : handler.getEntityManager().entities) {
					if(clickedWithinBounds(e, arg0) && e.selected == false) {
						e.selected = true;
					}else if(clickedWithinBounds(e, arg0) && e.selected == true) {
						e.selected = false;
					}
				}
			}
			
			
			if(arg0.getButton() == MouseEvent.BUTTON3) {//Right click
				//Check for selected entities
				for(Unit u : handler.getEntityManager().units) {
					u.setBehavior(arg0);
				}
			}
			
		}//if clicked in game END
		
		
	}
	
	


	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		mouseX = arg0.getX();
		mouseY = arg0.getY();
		
	}
	
	private boolean clickedWithinBounds(Button button, MouseEvent arg) {
		
		if(arg.getX() + handler.getCamera().getxOffset() >= button.getX() 
				&& arg.getY() + handler.getCamera().getyOffset() >= button.getY() 
				&& arg.getX() + handler.getCamera().getxOffset() <= (button.getX() + button.getWidth()) 
				&& arg.getY() + handler.getCamera().getyOffset() <= (button.getY() + button.getHeight()))
				{
					System.out.println("CLICKED AT: " + button.getX() + " " + button.getY());
					return true;
				}
				return false;
		
	}
	
	private boolean clickedWithinBounds(Entity entity, MouseEvent arg){
		
		if(arg.getX() + handler.getCamera().getxOffset() >= entity.getX() 
		&& arg.getY() + handler.getCamera().getyOffset() >= entity.getY() 
		&& arg.getX() + handler.getCamera().getxOffset() <= (entity.getX() + entity.getWidth()) 
		&& arg.getY() + handler.getCamera().getyOffset() <= (entity.getY() + entity.getHeight()))
		{
			System.out.println("CLICKED AT: " + entity.x + " " + entity.y);
			return true;
		}
		return false;
		
	}
	
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
